package com.savl.ripple.core;

import com.savl.ripple.crypto.ecdsa.IKeyPair;
import com.savl.ripple.crypto.ecdsa.K256KeyPair;
import com.savl.ripple.crypto.ecdsa.SECP256K1;
import com.savl.ripple.crypto.ecdsa.Seed;
import com.savl.ripple.encodings.common.B16;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.signers.HMacDSAKCalculator;
import org.bouncycastle.util.encoders.Hex;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class K256KeyPairTest {
    K256KeyPair keyPair = (K256KeyPair) Seed.createKeyPair(
                    TestFixtures.master_seed_bytes, 0);

    @Test
    public void testVerify() {
        assertTrue(keyPair.verifyHash(TestFixtures.master_seed_bytes,
                Hex.decode(TestFixtures.singed_master_seed_bytes)));
    }

    @Test
    public void sanityTestSignAndVerify() {
        byte[] sigBytes = keyPair.signHash(TestFixtures.master_seed_bytes);
        String actualHex = B16.toString(sigBytes);
        String expectedDeterministic = "304402203B72E92DFA98C9DE326B987690785EA390BE80BFD0D0B3A4E3273BC035A8AAAF02207406ABF0AB4649F4C63B9E1AD134D7FEF346FAF5E0FDA91146175C8835529421";
        assertEquals(expectedDeterministic, actualHex);
        assertTrue(keyPair.verifyHash(TestFixtures.master_seed_bytes, sigBytes));
    }

    String fixtures = "{"+
            "  \"rfc6979\": ["+
            "    {"+
            "      \"message\": \"test data\","+
            "      \"d\": \"fee0a1f7afebf9d2a5a80c0c98a31c709681cce195cbcd06342b517970c0be1e\","+
            "      \"k0\": \"fcce1de7a9bcd6b2d3defade6afa1913fb9229e3b7ddf4749b55c4848b2a196e\","+
            "      \"k1\": \"727fbcb59eb48b1d7d46f95a04991fc512eb9dbf9105628e3aec87428df28fd8\","+
            "      \"k15\": \"398f0e2c9f79728f7b3d84d447ac3a86d8b2083c8f234a0ffa9c4043d68bd258\""+
            "    },"+
            "    {"+
            "      \"message\": \"Everything should be made as simple as possible, but not simpler.\","+
            "      \"d\": \"0000000000000000000000000000000000000000000000000000000000000001\","+
            "      \"k0\": \"ec633bd56a5774a0940cb97e27a9e4e51dc94af737596a0c5cbb3d30332d92a5\","+
            "      \"k1\": \"df55b6d1b5c48184622b0ead41a0e02bfa5ac3ebdb4c34701454e80aabf36f56\","+
            "      \"k15\": \"def007a9a3c2f7c769c75da9d47f2af84075af95cadd1407393dc1e26086ef87\""+
            "    },"+
            "    {"+
            "      \"message\": \"Satoshi Nakamoto\","+
            "      \"d\": \"0000000000000000000000000000000000000000000000000000000000000002\","+
            "      \"k0\": \"d3edc1b8224e953f6ee05c8bbf7ae228f461030e47caf97cde91430b4607405e\","+
            "      \"k1\": \"f86d8e43c09a6a83953f0ab6d0af59fb7446b4660119902e9967067596b58374\","+
            "      \"k15\": \"241d1f57d6cfd2f73b1ada7907b199951f95ef5ad362b13aed84009656e0254a\""+
            "    },"+
            "    {"+
            "      \"message\": \"Diffie Hellman\","+
            "      \"d\": \"7f7f7f7f7f7f7f7f7f7f7f7f7f7f7f7f7f7f7f7f7f7f7f7f7f7f7f7f7f7f7f7f\","+
            "      \"k0\": \"c378a41cb17dce12340788dd3503635f54f894c306d52f6e9bc4b8f18d27afcc\","+
            "      \"k1\": \"90756c96fef41152ac9abe08819c4e95f16da2af472880192c69a2b7bac29114\","+
            "      \"k15\": \"7b3f53300ab0ccd0f698f4d67db87c44cf3e9e513d9df61137256652b2e94e7c\""+
            "    },"+
            "    {"+
            "      \"message\": \"Japan\","+
            "      \"d\": \"8080808080808080808080808080808080808080808080808080808080808080\","+
            "      \"k0\": \"f471e61b51d2d8db78f3dae19d973616f57cdc54caaa81c269394b8c34edcf59\","+
            "      \"k1\": \"6819d85b9730acc876fdf59e162bf309e9f63dd35550edf20869d23c2f3e6d17\","+
            "      \"k15\": \"d8e8bae3ee330a198d1f5e00ad7c5f9ed7c24c357c0a004322abca5d9cd17847\""+
            "    },"+
            "    {"+
            "      \"message\": \"Bitcoin\","+
            "      \"d\": \"fffffffffffffffffffffffffffffffebaaedce6af48a03bbfd25e8cd0364140\","+
            "      \"k0\": \"36c848ffb2cbecc5422c33a994955b807665317c1ce2a0f59c689321aaa631cc\","+
            "      \"k1\": \"4ed8de1ec952a4f5b3bd79d1ff96446bcd45cabb00fc6ca127183e14671bcb85\","+
            "      \"k15\": \"56b6f47babc1662c011d3b1f93aa51a6e9b5f6512e9f2e16821a238d450a31f8\""+
            "    },"+
            "    {"+
            "      \"message\": \"i2FLPP8WEus5WPjpoHwheXOMSobUJVaZM1JPMQZq\","+
            "      \"d\": \"fffffffffffffffffffffffffffffffebaaedce6af48a03bbfd25e8cd0364140\","+
            "      \"k0\": \"6e9b434fcc6bbb081a0463c094356b47d62d7efae7da9c518ed7bac23f4e2ed6\","+
            "      \"k1\": \"ae5323ae338d6117ce8520a43b92eacd2ea1312ae514d53d8e34010154c593bb\","+
            "      \"k15\": \"3eaa1b61d1b8ab2f1ca71219c399f2b8b3defa624719f1e96fe3957628c2c4ea\""+
            "    },"+
            "    {"+
            "      \"message\": \"lEE55EJNP7aLrMtjkeJKKux4Yg0E8E1SAJnWTCEh\","+
            "      \"d\": \"3881e5286abc580bb6139fe8e83d7c8271c6fe5e5c2d640c1f0ed0e1ee37edc9\","+
            "      \"k0\": \"5b606665a16da29cc1c5411d744ab554640479dd8abd3c04ff23bd6b302e7034\","+
            "      \"k1\": \"f8b25263152c042807c992eacd2ac2cc5790d1e9957c394f77ea368e3d9923bd\","+
            "      \"k15\": \"ea624578f7e7964ac1d84adb5b5087dd14f0ee78b49072aa19051cc15dab6f33\""+
            "    },"+
            "    {"+
            "      \"message\": \"2SaVPvhxkAPrayIVKcsoQO5DKA8Uv5X/esZFlf+y\","+
            "      \"d\": \"7259dff07922de7f9c4c5720d68c9745e230b32508c497dd24cb95ef18856631\","+
            "      \"k0\": \"3ab6c19ab5d3aea6aa0c6da37516b1d6e28e3985019b3adb388714e8f536686b\","+
            "      \"k1\": \"19af21b05004b0ce9cdca82458a371a9d2cf0dc35a813108c557b551c08eb52e\","+
            "      \"k15\": \"117a32665fca1b7137a91c4739ac5719fec0cf2e146f40f8e7c21b45a07ebc6a\""+
            "    },"+
            "    {"+
            "      \"message\": \"00A0OwO2THi7j5Z/jp0FmN6nn7N/DQd6eBnCS+/b\","+
            "      \"d\": \"0d6ea45d62b334777d6995052965c795a4f8506044b4fd7dc59c15656a28f7aa\","+
            "      \"k0\": \"79487de0c8799158294d94c0eb92ee4b567e4dc7ca18addc86e49d31ce1d2db6\","+
            "      \"k1\": \"9561d2401164a48a8f600882753b3105ebdd35e2358f4f808c4f549c91490009\","+
            "      \"k15\": \"b0d273634129ff4dbdf0df317d4062a1dbc58818f88878ffdb4ec511c77976c0\""+
            "    }"+
            "  ]"+
            "};";

    // @Test
    public void testRFC6979() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        JSONObject fixtures = new JSONObject(this.fixtures);
        JSONArray rfc6979 = fixtures.getJSONArray("rfc6979");
        for (int i = 0; i < rfc6979.length(); i++) {
            JSONObject test = rfc6979.getJSONObject(i);
            byte[] message = test.getString("message").getBytes("utf-8");
            byte[] messageHash = MessageDigest.getInstance("SHA-256").digest(message);
            final BigInteger[] specialKArray = new BigInteger[16];
            HMacDSAKCalculator calc = new HMacDSAKCalculator(new SHA256Digest()) {
                int ptr = 0;
                public boolean isValid(BigInteger k) {
                    specialKArray[ptr++] = k;
                    return ptr == 16;
                }
            };
            BigInteger d = new BigInteger(test.getString("d"), 16);
            calc.init(SECP256K1.order(), d, messageHash);
            calc.nextK();

            for (int j = 0; j < 16; j++) {
                BigInteger bigInteger = specialKArray[j];
                String key = "k" + j;
                if (test.has(key)) {
                    assertEquals(test.getString(key), bigInteger.toString(16));
                }
            }
        }
    }

    @Test
    public void testDerivationFromSeedBytes() {
        assertEquals("0330E7FC9D56BB25D6893BA3F317AE5BCF33B3291BD63DB32654A313222F7FD020", keyPair.canonicalPubHex());
        assertEquals("1ACAAEDECE405B2A958212629E16F2EB46B153EEE94CDD350FDEFF52795525B7", keyPair.privHex());
    }

    @Test
    public void testDerivationFromString() {
        IKeyPair keyPairFromSeed = Seed.getKeyPair(TestFixtures.master_seed);
        assertEquals("0330E7FC9D56BB25D6893BA3F317AE5BCF33B3291BD63DB32654A313222F7FD020", keyPairFromSeed.canonicalPubHex());
        assertEquals("1ACAAEDECE405B2A958212629E16F2EB46B153EEE94CDD350FDEFF52795525B7", keyPairFromSeed.privHex());
    }
}
