package com.savl.ripple.core;

import com.savl.ripple.Wallet;
import org.junit.Assert;
import org.junit.Test;

public class WalletTest {

    @Test
    public void testWalletCreation() {
        String mnemonic = "jungle ancient improve candy adult tourist claim devote input brave dinner taxi";

        Wallet wallet = new Wallet(mnemonic, "");
        Assert.assertEquals("rrspt5GTsZmYpka4CcoYvqKH423jGn6ztC", wallet.getAccountID().address);
        Assert.assertEquals("spxB4mx9YCZ9bHynpD1dN55WUPYgi", wallet.getPrivateKey());
    }
}
