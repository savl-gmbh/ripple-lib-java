package com.savl.ripple;

import com.savl.ripple.core.coretypes.AccountID;
import com.savl.ripple.crypto.ecdsa.IKeyPair;
import com.savl.ripple.crypto.ecdsa.Seed;

public class Wallet {
    private final IKeyPair keyPair;
    private final AccountID accountID;
    private final String privateKey;

    public Wallet(String mnemonic, String passphrase) {
        byte[] entropy = Seed.getEntropy(mnemonic, passphrase);
        privateKey = new Seed(entropy).toString();
        keyPair = Seed.createKeyPair(entropy);
        accountID = AccountID.fromKeyPair(getKeyPair());
    }

    public IKeyPair getKeyPair() {
        return keyPair;
    }

    public AccountID getAccountID() {
        return accountID;
    }

    public String getPrivateKey() {
        return privateKey;
    }
}
