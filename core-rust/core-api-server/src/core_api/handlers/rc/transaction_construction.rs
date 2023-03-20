use crate::core_api::*;
use radix_engine::system::node_substates::PersistedSubstate;
use radix_engine::types::{EpochManagerOffset, SubstateOffset, EPOCH_MANAGER};
use radix_engine_interface::api::types::{NodeModuleId, RENodeId};
use state_manager::jni::state_manager::ActualStateManager;

#[tracing::instrument(skip(state), err(Debug))]
pub(crate) async fn handle_rc_transaction_construction(
    state: State<CoreApiState>,
    request: Json<models::RcTransactionConstructionRequest>,
) -> Result<Json<models::RcTransactionConstructionResponse>, ResponseError<()>> {
    core_api_read_handler(state, request, handle_rc_transaction_construction_internal)
}

fn handle_rc_transaction_construction_internal(
    state_manager: &ActualStateManager,
    request: models::RcTransactionConstructionRequest,
) -> Result<models::RcTransactionConstructionResponse, ResponseError<()>> {
    assert_matching_network(&request.network, &state_manager.network)?;
    let mapping_context = MappingContext::new(&state_manager.network);

    let epoch_manager_substate = {
        let substate_offset = SubstateOffset::EpochManager(EpochManagerOffset::EpochManager);
        let loaded_substate = read_mandatory_substate(
            state_manager,
            RENodeId::GlobalObject(EPOCH_MANAGER.into()),
            NodeModuleId::SELF,
            &substate_offset,
        )?;
        let PersistedSubstate::EpochManager(substate) = loaded_substate else {
            return Err(wrong_substate_type(substate_offset));
        };
        substate
    };

    Ok(models::RcTransactionConstructionResponse {
        epoch: to_api_epoch(&mapping_context, epoch_manager_substate.epoch)?,
    })
}
