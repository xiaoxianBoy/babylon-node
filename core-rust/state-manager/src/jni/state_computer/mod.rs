/* Copyright 2021 Radix Publishing Ltd incorporated in Jersey (Channel Islands).
 *
 * Licensed under the Radix License, Version 1.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at:
 *
 * radixfoundation.org/licenses/LICENSE-v1
 *
 * The Licensor hereby grants permission for the Canonical version of the Work to be
 * published, distributed and used under or by reference to the Licensor’s trademark
 * Radix ® and use of any unregistered trade names, logos or get-up.
 *
 * The Licensor provides the Work (and each Contributor provides its Contributions) on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * including, without limitation, any warranties or conditions of TITLE, NON-INFRINGEMENT,
 * MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Whilst the Work is capable of being deployed, used and adopted (instantiated) to create
 * a distributed ledger it is your responsibility to test and validate the code, together
 * with all logic and performance of that code under all foreseeable scenarios.
 *
 * The Licensor does not make or purport to make and hereby excludes liability for all
 * and any representation, warranty or undertaking in any form whatsoever, whether express
 * or implied, to any entity or person, including any representation, warranty or
 * undertaking, as to the functionality security use, value or other characteristics of
 * any distributed ledger nor in respect the functioning or value of any tokens which may
 * be created stored or transferred using the Work. The Licensor does not warrant that the
 * Work or any use of the Work complies with any law or regulation in any territory where
 * it may be implemented or used or that it will be appropriate for any specific purpose.
 *
 * Neither the licensor nor any current or former employees, officers, directors, partners,
 * trustees, representatives, agents, advisors, contractors, or volunteers of the Licensor
 * shall be liable for any direct or indirect, special, incidental, consequential or other
 * losses of any kind, in tort, contract or otherwise (including but not limited to loss
 * of revenue, income or profits, or loss of use or data, or loss of reputation, or loss
 * of any economic or other opportunity of whatsoever nature or howsoever arising), arising
 * out of or in connection with (without limitation of any use, misuse, of any ledger system
 * or use made or its functionality or any performance or operation of any code or protocol
 * caused by bugs or programming or logic errors or otherwise);
 *
 * A. any offer, purchase, holding, use, sale, exchange or transmission of any
 * cryptographic keys, tokens or assets created, exchanged, stored or arising from any
 * interaction with the Work;
 *
 * B. any failure in a transmission or loss of any token or assets keys or other digital
 * artefacts due to errors in transmission;
 *
 * C. bugs, hacks, logic errors or faults in the Work or any communication;
 *
 * D. system software or apparatus including but not limited to losses caused by errors
 * in holding or transmitting tokens by any third-party;
 *
 * E. breaches or failure of security including hacker attacks, loss or disclosure of
 * password, loss of private key, unauthorised use or misuse of such passwords or keys;
 *
 * F. any losses including loss of anticipated savings or other benefits resulting from
 * use of the Work or any changes to the Work (however implemented).
 *
 * You are solely responsible for; testing, validating and evaluation of all operation
 * logic, functionality, security and appropriateness of using the Work for any commercial
 * or non-commercial purpose and for any reproduction or redistribution by You of the
 * Work. You assume all risks associated with Your use of the Work and the exercise of
 * permissions under this License.
 */

use crate::jni::dtos::JavaStructure;
use crate::TransactionPrepareResult;
use jni::objects::{JClass, JObject};
use jni::sys::jbyteArray;
use jni::JNIEnv;
use scrypto::prelude::*;

use crate::jni::state_manager::JNIStateManager;
use crate::jni::utils::*;
use crate::result::StateManagerResult;
use crate::types::{CommitRequest, PrepareRequest, PrepareResult};

use super::mempool::JavaRawTransaction;

//
// JNI Interface
//

#[no_mangle]
extern "system" fn Java_com_radixdlt_statecomputer_RustStateComputer_verify(
    env: JNIEnv,
    _class: JClass,
    j_state_manager: JObject,
    request_payload: jbyteArray,
) -> jbyteArray {
    let ret = do_verify(&env, j_state_manager, request_payload).to_java();
    jni_slice_to_jbytearray(&env, &ret)
}

fn do_verify(
    env: &JNIEnv,
    j_state_manager: JObject,
    request_payload: jbyteArray,
) -> StateManagerResult<Result<(), String>> {
    let state_manager = JNIStateManager::get_state_manager(env, j_state_manager);
    let request_payload: Vec<u8> = jni_jbytearray_to_vector(env, request_payload)?;
    let transaction = JavaRawTransaction::from_java(&request_payload)?;

    let state_manager = state_manager
        .lock()
        .expect("Can't acquire a state manager mutex lock");

    let result = state_manager.validate_transaction_slice(&transaction.payload);

    let ret = match result {
        Ok(..) => Ok(()),
        Err(err) => Err(format!("{:?}", err)),
    };
    Ok(ret)
}

#[no_mangle]
extern "system" fn Java_com_radixdlt_statecomputer_RustStateComputer_saveVertexStore(
    env: JNIEnv,
    _class: JClass,
    j_state_manager: JObject,
    request_payload: jbyteArray,
) -> jbyteArray {
    let ret = do_save_vertex_store(&env, j_state_manager, request_payload).to_java();
    jni_slice_to_jbytearray(&env, &ret)
}

fn do_save_vertex_store(
    env: &JNIEnv,
    j_state_manager: JObject,
    request_payload: jbyteArray,
) -> StateManagerResult<()> {
    let state_manager = JNIStateManager::get_state_manager(env, j_state_manager);
    let request_payload: Vec<u8> = jni_jbytearray_to_vector(env, request_payload)?;
    let vertex_store: Vec<u8> = Vec::from_java(&request_payload)?;

    state_manager
        .lock()
        .expect("Can't acquire a state manager mutex lock")
        .save_vertex_store(vertex_store);
    Ok(())
}

#[no_mangle]
extern "system" fn Java_com_radixdlt_statecomputer_RustStateComputer_prepare(
    env: JNIEnv,
    _class: JClass,
    j_state_manager: JObject,
    request_payload: jbyteArray,
) -> jbyteArray {
    let ret = do_prepare(&env, j_state_manager, request_payload).to_java();
    jni_slice_to_jbytearray(&env, &ret)
}

fn do_prepare(
    env: &JNIEnv,
    j_state_manager: JObject,
    request_payload: jbyteArray,
) -> StateManagerResult<JavaPrepareResult> {
    let state_manager = JNIStateManager::get_state_manager(env, j_state_manager);
    let request_payload: Vec<u8> = jni_jbytearray_to_vector(env, request_payload)?;
    let prepare_request = JavaPrepareRequest::from_java(&request_payload)?;

    let result = state_manager
        .lock()
        .expect("Can't acquire a state manager mutex lock")
        .prepare(prepare_request.into());
    Ok(result.into())
}

#[no_mangle]
extern "system" fn Java_com_radixdlt_statecomputer_RustStateComputer_commit(
    env: JNIEnv,
    _class: JClass,
    j_state_manager: JObject,
    request_payload: jbyteArray,
) -> jbyteArray {
    let ret = do_commit(&env, j_state_manager, request_payload).to_java();
    jni_slice_to_jbytearray(&env, &ret)
}

fn do_commit(
    env: &JNIEnv,
    j_state_manager: JObject,
    request_payload: jbyteArray,
) -> StateManagerResult<()> {
    let state_manager = JNIStateManager::get_state_manager(env, j_state_manager);
    let request_payload: Vec<u8> = jni_jbytearray_to_vector(env, request_payload)?;
    let commit_request = JavaCommitRequest::from_java(&request_payload)?;

    state_manager
        .lock()
        .expect("Can't acquire a state manager mutex lock")
        .commit(commit_request.into());
    Ok(())
}

#[no_mangle]
extern "system" fn Java_com_radixdlt_statecomputer_RustStateComputer_componentXrdAmount(
    env: JNIEnv,
    _class: JClass,
    j_state_manager: JObject,
    request_payload: jbyteArray,
) -> jbyteArray {
    let ret = get_component_xrd(&env, j_state_manager, request_payload).to_java();
    jni_slice_to_jbytearray(&env, &ret)
}

fn get_component_xrd(
    env: &JNIEnv,
    j_state_manager: JObject,
    request_payload: jbyteArray,
) -> StateManagerResult<Decimal> {
    let state_manager = JNIStateManager::get_state_manager(env, j_state_manager);
    let request_payload = jni_jbytearray_to_vector(env, request_payload)?;
    let component_address = ComponentAddress::from_java(&request_payload)?;
    let resources = state_manager
        .lock()
        .expect("Can't acquire a state manager mutex lock")
        .get_component_resources(component_address);
    let amount = resources
        .map(|r| r.get(&RADIX_TOKEN).cloned().unwrap_or_else(Decimal::zero))
        .unwrap_or_else(Decimal::zero);
    Ok(amount)
}

pub fn export_extern_functions() {}

#[derive(Debug, Decode, Encode, TypeId)]
pub struct JavaCommitRequest {
    pub transactions: Vec<JavaRawTransaction>,
    pub state_version: u64,
    pub proof: Vec<u8>,
    pub vertex_store: Option<Vec<u8>>,
}

impl From<JavaCommitRequest> for CommitRequest {
    fn from(commit_request: JavaCommitRequest) -> Self {
        CommitRequest {
            transaction_payloads: commit_request
                .transactions
                .into_iter()
                .map(|t| t.payload)
                .collect(),
            state_version: commit_request.state_version,
            proof: commit_request.proof,
            vertex_store: commit_request.vertex_store,
        }
    }
}

#[derive(Debug, Decode, Encode, TypeId)]
pub struct JavaPrepareRequest {
    pub already_prepared: Vec<JavaRawTransaction>,
    pub proposed: Vec<JavaRawTransaction>,
    pub round_number: u64,
}

impl From<JavaPrepareRequest> for PrepareRequest {
    fn from(prepare_request: JavaPrepareRequest) -> Self {
        PrepareRequest {
            already_prepared_payloads: prepare_request
                .already_prepared
                .into_iter()
                .map(|t| t.payload)
                .collect(),
            proposed_payloads: prepare_request
                .proposed
                .into_iter()
                .map(|t| t.payload)
                .collect(),
            round_number: prepare_request.round_number,
        }
    }
}

#[derive(Debug, Decode, Encode, TypeId)]
pub struct JavaPrepareResult {
    pub transaction_results: Vec<(Vec<u8>, TransactionPrepareResult)>,
}

impl From<PrepareResult> for JavaPrepareResult {
    fn from(prepare_results: PrepareResult) -> Self {
        JavaPrepareResult {
            transaction_results: prepare_results
                .transaction_results
                .into_iter()
                .map(|r| (r.0, r.1))
                .collect(),
        }
    }
}
