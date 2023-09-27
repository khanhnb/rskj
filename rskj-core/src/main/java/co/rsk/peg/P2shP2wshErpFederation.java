/*
package co.rsk.peg;

import co.rsk.bitcoinj.core.BtcECKey;
import co.rsk.bitcoinj.core.NetworkParameters;
import co.rsk.bitcoinj.script.P2shP2wshErpFederationRedeemScriptParser;
import co.rsk.bitcoinj.script.Script;
import co.rsk.bitcoinj.script.ScriptBuilder;
import org.ethereum.config.blockchain.upgrades.ActivationConfig;
import org.ethereum.config.blockchain.upgrades.ConsensusRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.List;

public class P2shP2wshErpFederation extends ErpFederation {
        private static final Logger logger = LoggerFactory.getLogger(co.rsk.peg.P2shP2wshErpFederation.class);

        public P2shP2wshErpFederation(
            List<FederationMember> members,
            Instant creationTime,
            long creationBlockNumber,
            NetworkParameters btcParams,
            List<BtcECKey> erpPubKeys,
            long activationDelay,
            ActivationConfig.ForBlock activations
        ) {
            super(members, creationTime, creationBlockNumber, btcParams, erpPubKeys, activationDelay, activations);
        }

        @Override
        public final Script getRedeemScript() {
            // not sure if i should add this here or not. I think not but just in case
            if (!activations.isActive(ConsensusRule.RSKIP284) &&
                btcParams.getId().equals(NetworkParameters.ID_TESTNET)) {
                logger.debug("[getRedeemScript] Returning hardcoded redeem script");
                return new Script(ERP_TESTNET_REDEEM_SCRIPT_BYTES);
            }

            if (redeemScript == null) {
                logger.debug("[getRedeemScript] Creating the redeem script from the keys");
                redeemScript = P2shP2wshErpFederationRedeemScriptParser.createP2shP2wshErpRedeemScript(
                    ScriptBuilder.createRedeemScript(getNumberOfSignaturesRequired(), getBtcPublicKeys()),
                    ScriptBuilder.createRedeemScript(erpPubKeys.size() / 2 + 1, erpPubKeys),
                    activationDelay
                );
            }

            return redeemScript;
        }

        @Override
        public final Script getStandardRedeemScript() {
            if (standardRedeemScript == null) {
                standardRedeemScript = P2shP2wshErpFederationRedeemScriptParser.extractStandardRedeemScript(
                    getRedeemScript().getChunks()
                );
            }
            return standardRedeemScript;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }

            if (other == null || this.getClass() != other.getClass()) {
                return false;
            }

            P2shP2wshErpFederation otherP2shErpFederation = (P2shP2wshErpFederation) other;

            return this.getNumberOfSignaturesRequired() == otherP2shErpFederation.getNumberOfSignaturesRequired() &&
                this.getSize() == otherP2shErpFederation.getSize() &&
                this.getCreationTime().equals(otherP2shErpFederation.getCreationTime()) &&
                this.creationBlockNumber == otherP2shErpFederation.creationBlockNumber &&
                this.btcParams.equals(otherP2shErpFederation.btcParams) &&
                this.members.equals(otherP2shErpFederation.members) &&
                this.getRedeemScript().equals(otherP2shErpFederation.getRedeemScript()) &&
                this.erpPubKeys.equals(otherP2shErpFederation.erpPubKeys) &&
                this.activationDelay == otherP2shErpFederation.activationDelay;
        }
    }
*/
