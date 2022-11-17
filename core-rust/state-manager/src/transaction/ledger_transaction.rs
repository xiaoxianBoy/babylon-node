use radix_engine::types::{scrypto_decode, scrypto_encode};
use sbor::{Decode, DecodeError, Encode, TypeId};

use crate::transaction::validator_transaction::ValidatorTransaction;
use crate::LedgerPayloadHash;
use transaction::model::NotarizedTransaction;

use super::PreparedValidatorTransaction;

#[allow(clippy::large_enum_variant)]
#[derive(Debug, Clone, TypeId, Encode, Decode, PartialEq, Eq)]
pub enum LedgerTransaction {
    User(NotarizedTransaction),
    Validator(ValidatorTransaction),
}

impl LedgerTransaction {
    pub fn from_slice(slice: &[u8]) -> Result<Self, DecodeError> {
        scrypto_decode(slice)
    }

    pub fn get_hash(&self) -> LedgerPayloadHash {
        LedgerPayloadHash::for_transaction(self)
    }

    pub fn create_payload(&self) -> Vec<u8> {
        scrypto_encode(self)
    }

    pub fn user(&self) -> Option<&NotarizedTransaction> {
        match self {
            LedgerTransaction::User(tx) => Some(tx),
            LedgerTransaction::Validator(_) => None,
        }
    }

    pub fn prepare(&self) -> PreparedLedgerTransaction {
        match self {
            LedgerTransaction::User(notarized_transaction) => {
                PreparedLedgerTransaction::User(notarized_transaction)
            }
            LedgerTransaction::Validator(validator_transaction) => {
                PreparedLedgerTransaction::Validator(validator_transaction.prepare())
            }
        }
    }
}

#[allow(clippy::large_enum_variant)]
#[derive(Debug, Clone, TypeId, PartialEq, Eq)]
pub enum PreparedLedgerTransaction<'a> {
    User(&'a NotarizedTransaction),
    Validator(PreparedValidatorTransaction),
}