package io.digibyte.presenter.activities.models;

import io.digibyte.tools.util.BytesUtil;

public class FinanceUTXO {

    private String txid;
    private long index;
    private long value;
    private byte[] script;

    public FinanceUTXO(String txid, long index, long value, byte[] script) {
        this.txid = txid;
        this.index = index;
        this.value = value;
        this.script = script;
    }

    public String getTxid() {
        return txid;
    }

    public Vout getVout() {
        return new Vout(value, index, new ScriptPubKey(BytesUtil.bytesToHex(script).toLowerCase()));
    }

    static class Vout {
        long value;
        long n;
        ScriptPubKey scriptPubKey;

        Vout(long value, long n, ScriptPubKey scriptPubKey) {
            this.value = value;
            this.n = n;
            this.scriptPubKey = scriptPubKey;

        }
    }

    public static class ScriptPubKey {
        String hex;

        ScriptPubKey(String hex) {
            this.hex = hex;
        }
    }
}