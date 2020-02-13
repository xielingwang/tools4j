package cn.tjitech.crypto;

import cn.tjitech.transform.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;

public class HasherTest {
    static final String oriVal = "0123456中国人0123456中国人0123456中国人0123456中国人0123456中国人0123456中国人0123456中国人0123456中国人0123456中国人0123456中国人0123456中国人0123456中国人0123456中国人0123456中国人0123456中国人0123456中国人0123456中国人0123456中国人0123456中国人0123456中国人123456中国人";
    static final String oriValForBC = "0123456中国人";
    
    @Test
    public void testMD2() throws UnsupportedEncodingException {
        assertEquals(DigestUtils.md2Hex(oriVal), Hasher.md2(oriVal));
        assertEquals(DigestUtils.md2Hex(oriVal), Hasher.md2(oriVal.getBytes()));

        assertEquals(DigestUtils.md2Hex(oriVal.getBytes("gbk")), Hasher.md2().enc("gbk").hash(oriVal));
        assertEquals(DigestUtils.md2Hex(oriVal.getBytes("gbk")), Hasher.md2(oriVal.getBytes("gbk")));
    }

    @Test
    public void testMD5() throws UnsupportedEncodingException {
        assertEquals(DigestUtils.md5Hex(oriVal), Hasher.md5(oriVal));
        assertEquals(DigestUtils.md5Hex(oriVal), Hasher.md5(oriVal.getBytes()));

        assertEquals(DigestUtils.md5Hex(oriVal.getBytes("gbk")), Hasher.md5().enc("gbk").hash(oriVal));
        assertEquals(DigestUtils.md5Hex(oriVal.getBytes("gbk")), Hasher.md5(oriVal.getBytes("gbk")));

        assertEquals(DigestUtils.md5Hex(oriVal.getBytes("gbk")), Hex.format(Hasher.md5AsBytes(oriVal.getBytes("gbk")), true));
    }

    @Test
    public void testSha1() throws UnsupportedEncodingException {
        assertEquals(DigestUtils.sha1Hex(oriVal), Hasher.sha1(oriVal.getBytes()));
        assertEquals(DigestUtils.sha1Hex(oriVal), Hasher.sha1(oriVal));

        assertEquals(DigestUtils.sha1Hex(oriVal.getBytes("gbk")), Hasher.sha1().enc("gbk").hash(oriVal));
        assertEquals(DigestUtils.sha1Hex(oriVal.getBytes("gbk")), Hasher.sha1(oriVal.getBytes("gbk")));
    }

    @Test
    public void testSha256() throws UnsupportedEncodingException {
        assertEquals(DigestUtils.sha256Hex(oriVal), Hasher.sha256(oriVal));
        assertEquals(DigestUtils.sha256Hex(oriVal), Hasher.sha256(oriVal.getBytes()));

        assertEquals(DigestUtils.sha256Hex(oriVal.getBytes("gbk")), Hasher.sha256().enc("gbk").hash(oriVal));
        assertEquals(DigestUtils.sha256Hex(oriVal.getBytes("gbk")), Hasher.sha256(oriVal.getBytes("gbk")));
    }

    @Test
    public void testSha384() throws UnsupportedEncodingException {
        assertEquals(DigestUtils.sha384Hex(oriVal), Hasher.sha384(oriVal));
        assertEquals(DigestUtils.sha384Hex(oriVal), Hasher.sha384(oriVal.getBytes()));

        assertEquals(DigestUtils.sha384Hex(oriVal.getBytes("gbk")), Hasher.sha384().enc("gbk").hash(oriVal));
        assertEquals(DigestUtils.sha384Hex(oriVal.getBytes("gbk")), Hasher.sha384(oriVal.getBytes("gbk")));
    }

    @Test
    public void testSha512() throws UnsupportedEncodingException {
        assertEquals(DigestUtils.sha512Hex(oriVal), Hasher.sha512(oriVal));
        assertEquals(DigestUtils.sha512Hex(oriVal), Hasher.sha512(oriVal.getBytes()));

        assertEquals(DigestUtils.sha512Hex(oriVal.getBytes("gbk")), Hasher.sha512().enc("gbk").hash(oriVal));
        assertEquals(DigestUtils.sha512Hex(oriVal.getBytes("gbk")), Hasher.sha512(oriVal.getBytes("gbk")));
    }


    @Test
    public void testMD4() throws UnsupportedEncodingException {
        assertEquals("cf166fb81de9792e1639d042188647e4", Hasher.md4(oriValForBC));
        assertEquals("cf166fb81de9792e1639d042188647e4", Hasher.md4(oriValForBC.getBytes()));

        assertEquals("953958de55024f6ed09abbbd0ef6160b", Hasher.md4().enc("gbk").hash(oriValForBC));
        assertEquals("953958de55024f6ed09abbbd0ef6160b", Hasher.md4(oriValForBC.getBytes("gbk")));
    }

    @Test
    public void testSha224() throws UnsupportedEncodingException {
        assertEquals("56ef3998d1624c2dca322ad4d38debbcaedc4e2f08f8d8ab822f5b3d", Hasher.sha224(oriValForBC));
        assertEquals("56ef3998d1624c2dca322ad4d38debbcaedc4e2f08f8d8ab822f5b3d", Hasher.sha224(oriValForBC.getBytes()));

        assertEquals("f295bd3438d3b42e626294eb28eee1e8d10e3abe122dfca4957222bc", Hasher.sha224().enc("gbk").hash(oriValForBC));
        assertEquals("f295bd3438d3b42e626294eb28eee1e8d10e3abe122dfca4957222bc", Hasher.sha224(oriValForBC.getBytes("gbk")));
    }
}
