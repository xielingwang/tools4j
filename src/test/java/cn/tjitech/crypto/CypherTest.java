package cn.tjitech.crypto;

import org.junit.Test;

import static org.junit.Assert.*;

public class CypherTest {
    public static final String ORIGINAL = "五千年的风和雨呀藏了多少梦Showtime";
    public static final String KEY = "0123456789abcdefghijl";

    public static final String DES_EXPECT = "h00cC/tsqKVbK06F6ZQNsBGqAvc3Xzs81MLGqXcVGz8WU/QV1MgTDor8e2i+B/zC";
    public static final String DES3_EXPECT = "DnpNy5EqvkP+kj2qQVeIcfX4JFMMn2FF3CPw19I7e62XVV1d5EnDrgnPVid5JO1C";
    public static final String AES_EXPECT = "RqlLTbsoaloc36VmhVwN3cDUO+szrSxwSOIBkT0v5Zz2PGPveRT6b5MHWHss5OGk";

    @Test
    public void testDES() {
        String result = null;
        result = Cypher.DESEncryptAsBase64(ORIGINAL.getBytes(), KEY);

        assertEquals("解密应与原来一致", ORIGINAL, Cypher.DESDecryptAsString(Coder.b64().decodeAsBytes(result), KEY));

        assertEquals("加密后与工具结果一致", DES_EXPECT, result);
    }

    @Test
    public void testDES3() {
        String result = null;
        result = Cypher.DESedeEncryptAsBase64(ORIGINAL.getBytes(), KEY);

        assertEquals("解密应与原来一致", ORIGINAL, Cypher.DESedeDecryptAsString(Coder.b64().decodeAsBytes(result), KEY));

        assertEquals("加密后与工具结果一致", DES3_EXPECT, result);
    }

    @Test
    public void testAES() {
        String result = null;

        StringBuffer sb = new StringBuffer().append(ORIGINAL);
        for (int i = 0; i < 100; i++) {
            result = Cypher.AESEncryptAsBase64(sb.toString().getBytes(), KEY);
            assertEquals("解密应与原来一致", sb.toString(), Cypher.AESDecryptAsString(Coder.b64().decodeAsBytes(result), KEY));
            sb.append(ORIGINAL);
        }
    }
}
