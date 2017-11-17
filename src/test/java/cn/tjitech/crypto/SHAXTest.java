package cn.tjitech.crypto;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;

public class SHAXTest {
    @Test
    public void testSha1() throws UnsupportedEncodingException {
        assertEquals("fb07fd4e2044b87fedb421b3befd5908ee00d47b", SHAX.sha1("0123456中国人".getBytes()));
        assertEquals("fb07fd4e2044b87fedb421b3befd5908ee00d47b", SHAX.sha1("0123456中国人"));

        assertEquals("52748700a0eaac95718134ed07eb69d14b09ce0a", SHAX.sha1().enc("gbk").hash("0123456中国人"));
        assertEquals("52748700a0eaac95718134ed07eb69d14b09ce0a", SHAX.sha1("0123456中国人".getBytes("gbk")));
    }

    @Test
    public void testSha224() throws UnsupportedEncodingException {
        assertEquals("56ef3998d1624c2dca322ad4d38debbcaedc4e2f08f8d8ab822f5b3d", SHAX.sha224("0123456中国人"));
        assertEquals("56ef3998d1624c2dca322ad4d38debbcaedc4e2f08f8d8ab822f5b3d", SHAX.sha224("0123456中国人".getBytes()));

        assertEquals("f295bd3438d3b42e626294eb28eee1e8d10e3abe122dfca4957222bc", SHAX.sha224().enc("gbk").hash("0123456中国人"));
        assertEquals("f295bd3438d3b42e626294eb28eee1e8d10e3abe122dfca4957222bc", SHAX.sha224("0123456中国人".getBytes("gbk")));
    }

    @Test
    public void testSha256() throws UnsupportedEncodingException {
        assertEquals("00257ce186cd79a401f4e892865e17929fb7e005ab42262567c533c721055ba0", SHAX.sha256("0123456中国人"));
        assertEquals("00257ce186cd79a401f4e892865e17929fb7e005ab42262567c533c721055ba0", SHAX.sha256("0123456中国人".getBytes()));

        assertEquals("8da0ff652154e00c942e82aa3572925c4f7e7896720ccc6e978b9cdf62db1ecf", SHAX.sha256().enc("gbk").hash("0123456中国人"));
        assertEquals("8da0ff652154e00c942e82aa3572925c4f7e7896720ccc6e978b9cdf62db1ecf", SHAX.sha256("0123456中国人".getBytes("gbk")));
    }

    @Test
    public void testSha384() throws UnsupportedEncodingException {
        assertEquals("5d235af24f00859fff63db5cee1a2ce14a91c68503bcdfa1df4a27a5c4c2a97d28363d9fb5b34557314dda78dd4c5d78", SHAX.sha384("0123456中国人"));
        assertEquals("5d235af24f00859fff63db5cee1a2ce14a91c68503bcdfa1df4a27a5c4c2a97d28363d9fb5b34557314dda78dd4c5d78", SHAX.sha384("0123456中国人".getBytes()));

        assertEquals("3d9a4f5971767d018c9614d7d07164a682adcf44b1163ff6fe38186c1e9092260ac84aa80245999969ad228b52f1d0ea", SHAX.sha384().enc("gbk").hash("0123456中国人"));
        assertEquals("3d9a4f5971767d018c9614d7d07164a682adcf44b1163ff6fe38186c1e9092260ac84aa80245999969ad228b52f1d0ea", SHAX.sha384("0123456中国人".getBytes("gbk")));
    }

    @Test
    public void testSha512() throws UnsupportedEncodingException {
        assertEquals("20f2950005948c40b7aed5b1ecc0638e3aa8c41abaa39bff8eba756f7b082344e86eba6c1c539103ab5b8a985e9b5a1da316d9866b257273f2a55a0dde7ede37", SHAX.sha512("0123456中国人"));
        assertEquals("20f2950005948c40b7aed5b1ecc0638e3aa8c41abaa39bff8eba756f7b082344e86eba6c1c539103ab5b8a985e9b5a1da316d9866b257273f2a55a0dde7ede37", SHAX.sha512("0123456中国人".getBytes()));

        assertEquals("327aba1555246ca53602830e721b9eb0f01475b2fd95cbb35bd04ff691ce9a81a3d5404280bea0c3c906d9e9afe1241e0a13d855dab07fa83e22d8b3dd5b05f5", SHAX.sha512().enc("gbk").hash("0123456中国人"));
        assertEquals("327aba1555246ca53602830e721b9eb0f01475b2fd95cbb35bd04ff691ce9a81a3d5404280bea0c3c906d9e9afe1241e0a13d855dab07fa83e22d8b3dd5b05f5", SHAX.sha512("0123456中国人".getBytes("gbk")));
    }
}
