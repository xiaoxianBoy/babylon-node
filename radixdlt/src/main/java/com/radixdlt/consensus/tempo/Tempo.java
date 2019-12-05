package com.radixdlt.consensus.tempo;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;
import com.radixdlt.common.AID;
import com.radixdlt.consensus.Consensus;
import com.radixdlt.consensus.ConsensusObservation;
import com.radixdlt.delivery.LazyRequestDeliverer;
import com.radixdlt.discovery.AtomDiscoverer;
import org.radix.logging.Logger;
import org.radix.logging.Logging;
import org.radix.network2.addressbook.Peer;

import java.io.Closeable;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The Tempo implementation of a ledger.
 */
public final class Tempo implements Consensus, Closeable {
	private static final Logger log = Logging.getLogger("tempo");
	private static final int INBOUND_QUEUE_CAPACITY = 16384;

	private final LazyRequestDeliverer requestDeliverer;

	private final BlockingQueue<ConsensusObservation> consensusObservations;

	@Inject
	public Tempo(
		Set<AtomDiscoverer> atomDiscoverers,
		LazyRequestDeliverer requestDeliverer
	) {
		Objects.requireNonNull(atomDiscoverers);
		this.requestDeliverer = Objects.requireNonNull(requestDeliverer);

		this.consensusObservations = new LinkedBlockingQueue<>(INBOUND_QUEUE_CAPACITY);

		// hook up components
		for (AtomDiscoverer atomDiscoverer : atomDiscoverers) {
			atomDiscoverer.addListener(this::onDiscovered);
		}
	}

	@Override
	public ConsensusObservation observe() throws InterruptedException {
		return this.consensusObservations.take();
	}

	private void onDiscovered(Set<AID> aids, Peer peer) {
		requestDeliverer.deliver(aids, ImmutableSet.of(peer)).forEach((aid, future) -> future.thenAccept(result -> {
			if (result.isSuccess()) {
				injectObservation(ConsensusObservation.commit(result.getLedgerEntry()));
			}
		}));
	}

	private void injectObservation(ConsensusObservation observation) {
		if (!this.consensusObservations.add(observation)) {
			// TODO more graceful queue full handling
			log.error("Atom observations queue full");
		}
	}

	@Override
	public void close() {
		this.requestDeliverer.close();
	}
}
