package com.savl.ripple.core;

import com.savl.ripple.core.coretypes.AccountID;
import com.savl.ripple.crypto.ecdsa.IKeyPair;
import com.savl.ripple.crypto.ecdsa.Seed;
import com.savl.ripple.encodings.base58.EncodingFormatException;
import org.junit.Test;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AccountIDTest {

    private String randomXqvWyhPcWjBE7nawXLTKH5YLNmSc = "randomXqvWyhPcWjBE7nawXLTKH5YLNmSc";

    @Test
    public void testAddress() {
        AccountID account = AccountID.fromSeedString(TestFixtures.master_seed);
        assertEquals(TestFixtures.master_seed_address, account.address);
    }

    @Test
    public void testBlackHoleAddy() {
        AccountID.fromAddress(randomXqvWyhPcWjBE7nawXLTKH5YLNmSc);
    }

    @Test(expected = EncodingFormatException.class)
    public void testBlackHoleAddyCheckSumFail() {
        AccountID.fromAddress("R" + randomXqvWyhPcWjBE7nawXLTKH5YLNmSc.substring(1));
    }

    @Test
    public void testHashCode() {
        AccountID a1 = AccountID.fromAddress(randomXqvWyhPcWjBE7nawXLTKH5YLNmSc);
        AccountID a2 = AccountID.fromAddress(randomXqvWyhPcWjBE7nawXLTKH5YLNmSc);
        assertEquals(a1.hashCode(), a2.hashCode());
    }
}
