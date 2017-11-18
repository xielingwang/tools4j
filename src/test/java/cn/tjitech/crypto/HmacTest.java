package cn.tjitech.crypto;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

public class HmacTest {
    static final String utf8 = "utf-8";
    static final String gbk = "gbk";

    static final String oriVal = "0123456中国人";
    static final String key = "qwer1234";
    static final String keyBase64 = "cXdlcjEyMzQ="; // base64 of string 'qwer1234'

    @Test
    public void testHmacMd2() throws UnsupportedEncodingException {
        assertEquals("6cd2f4ed298a58dc98819c8a49d54fb2", Hmac.md2(oriVal, key));
        assertEquals("6cd2f4ed298a58dc98819c8a49d54fb2", Hmac.md2(oriVal.getBytes(utf8), key));

        assertEquals("b9ef1eb1ce1edb49590f500233609d79", Hmac.md2().enc(gbk).hash(oriVal, key));
        assertEquals("b9ef1eb1ce1edb49590f500233609d79", Hmac.md2(oriVal.getBytes(gbk), key));

        assertEquals("6cd2f4ed298a58dc98819c8a49d54fb2", Hmac.md2(oriVal, Coder.b64().decodeAsBytes(keyBase64)));
    }

    @Test
    public void testHmacMd4() throws UnsupportedEncodingException {
        assertEquals("5e64c099b1fb399fd73c3a7a493013d0", Hmac.md4(oriVal, key));
        assertEquals("5e64c099b1fb399fd73c3a7a493013d0", Hmac.md4(oriVal.getBytes(utf8), key));

        assertEquals("3dd851c3ee063f4b4b641444bce75014", Hmac.md4().enc(gbk).hash(oriVal, key));
        assertEquals("3dd851c3ee063f4b4b641444bce75014", Hmac.md4(oriVal.getBytes(gbk), key));

        assertEquals("5e64c099b1fb399fd73c3a7a493013d0", Hmac.md4(oriVal, Coder.b64().decodeAsBytes(keyBase64)));
    }

    @Test
    public void testHmacMd5() throws UnsupportedEncodingException {
        assertEquals("f2911ba771ff9d46a5ad1aa814c43298", Hmac.md5(oriVal, key));
        assertEquals("f2911ba771ff9d46a5ad1aa814c43298", Hmac.md5(oriVal.getBytes(utf8), key));

        assertEquals("30fff9e53a29ae65acf0044f3ceadbb7", Hmac.md5().enc(gbk).hash(oriVal, key));
        assertEquals("30fff9e53a29ae65acf0044f3ceadbb7", Hmac.md5(oriVal.getBytes(gbk), key));

        assertEquals("f2911ba771ff9d46a5ad1aa814c43298", Hmac.md5(oriVal, Coder.b64().decodeAsBytes(keyBase64)));
    }

    @Test
    public void testHmacSha1() throws UnsupportedEncodingException {
        assertEquals("ba4d14b4357284e52ff3c2828dc85c75b905b1a2", Hmac.sha1(oriVal, key));
        assertEquals("ba4d14b4357284e52ff3c2828dc85c75b905b1a2", Hmac.sha1(oriVal.getBytes(utf8), key));

        assertEquals("1e9753f17f797b8040df6e4fd4550eeb71d3919a", Hmac.sha1().enc(gbk).hash(oriVal, key));
        assertEquals("1e9753f17f797b8040df6e4fd4550eeb71d3919a", Hmac.sha1(oriVal.getBytes(gbk), key));

        assertEquals("ba4d14b4357284e52ff3c2828dc85c75b905b1a2", Hmac.sha1(oriVal, key));
    }

    @Test
    public void testHmacSha224() throws UnsupportedEncodingException {
        assertEquals("540896508306df9779e8fe55983da2453dfb71ff740e3e1845852b5f", Hmac.sha224(oriVal.getBytes(utf8), key));
        assertEquals("540896508306df9779e8fe55983da2453dfb71ff740e3e1845852b5f", Hmac.sha224(oriVal, key));

        assertEquals("e53d0aa84cbb876e82efde004ab6c66cfafeb8a991eecac0e10b3160", Hmac.sha224().enc(gbk).hash(oriVal, key));
        assertEquals("e53d0aa84cbb876e82efde004ab6c66cfafeb8a991eecac0e10b3160", Hmac.sha224(oriVal.getBytes(gbk), key));

        assertEquals("540896508306df9779e8fe55983da2453dfb71ff740e3e1845852b5f", Hmac.sha224(oriVal.getBytes(utf8), key));
    }

    @Test
    public void testHmacSha256() throws UnsupportedEncodingException {
        assertEquals("a1019c6198821f7b706197537814938679a38432a8fda954b1080d70c076f27f", Hmac.sha256(oriVal.getBytes(utf8), key));
        assertEquals("a1019c6198821f7b706197537814938679a38432a8fda954b1080d70c076f27f", Hmac.sha256(oriVal, key));

        assertEquals("62cd896da324a9773d0a35ec202e61c2473719f557076ea4e78b094e33752a19", Hmac.sha256().enc(gbk).hash(oriVal, key));
        assertEquals("62cd896da324a9773d0a35ec202e61c2473719f557076ea4e78b094e33752a19", Hmac.sha256(oriVal.getBytes(gbk), key));

        assertEquals("a1019c6198821f7b706197537814938679a38432a8fda954b1080d70c076f27f", Hmac.sha256(oriVal.getBytes(utf8), Coder.b64().decodeAsBytes(keyBase64)));
    }

    @Test
    public void testHmacSha384() throws UnsupportedEncodingException {
        assertEquals("c8568ea88d0626dd2577b50038d3b3b70b8735847e564f7a862569203908dc92df077e9806123e7853de4c8fd2684e7c", Hmac.sha384(oriVal.getBytes(utf8), key));
        assertEquals("c8568ea88d0626dd2577b50038d3b3b70b8735847e564f7a862569203908dc92df077e9806123e7853de4c8fd2684e7c", Hmac.sha384(oriVal, key));

        assertEquals("58d35b2041701d274fb9f6c6081e67cdf174b1c6bf74a440a1382f76912ce7b31c076dc3111ef4e1d81a82131eedf22b", Hmac.sha384().enc(gbk).hash(oriVal, key));
        assertEquals("58d35b2041701d274fb9f6c6081e67cdf174b1c6bf74a440a1382f76912ce7b31c076dc3111ef4e1d81a82131eedf22b", Hmac.sha384(oriVal.getBytes(gbk), key));

        assertEquals("c8568ea88d0626dd2577b50038d3b3b70b8735847e564f7a862569203908dc92df077e9806123e7853de4c8fd2684e7c", Hmac.sha384(oriVal.getBytes(utf8), Coder.b64().decodeAsBytes(keyBase64)));
    }

    @Test
    public void testHmacSha512() throws UnsupportedEncodingException {
        assertEquals("d2652afb671eaf5293a05f670c87d83898318b95f47fc3ccfd7d5e0014a4353f3dfa8cb652ba840b961a79a4db53a35c86175aa0c9fe9a2fa1495b4a11ee49a3", Hmac.sha512(oriVal.getBytes(utf8), key));
        assertEquals("d2652afb671eaf5293a05f670c87d83898318b95f47fc3ccfd7d5e0014a4353f3dfa8cb652ba840b961a79a4db53a35c86175aa0c9fe9a2fa1495b4a11ee49a3", Hmac.sha512(oriVal, key));

        assertEquals("a50cee3c2dc4463fd08b5dc0c9004cb7382b1f3a144932857fd21daec8bfac0a58c320344a6c0ad7a1da112c44bf3fe417d409dbc96e5b60b25bd1713688f50f", Hmac.sha512().enc(gbk).hash(oriVal, key));
        assertEquals("a50cee3c2dc4463fd08b5dc0c9004cb7382b1f3a144932857fd21daec8bfac0a58c320344a6c0ad7a1da112c44bf3fe417d409dbc96e5b60b25bd1713688f50f", Hmac.sha512(oriVal.getBytes(gbk), key));

        assertEquals("d2652afb671eaf5293a05f670c87d83898318b95f47fc3ccfd7d5e0014a4353f3dfa8cb652ba840b961a79a4db53a35c86175aa0c9fe9a2fa1495b4a11ee49a3", Hmac.sha512(oriVal.getBytes(utf8), Coder.b64().decodeAsBytes(keyBase64)));
    }

    @Test
    public void testHmachasher() throws UnsupportedEncodingException {
        assertEquals("6cd2f4ed298a58dc98819c8a49d54fb2", Hmac.hasher().md2(oriVal, key));
        assertEquals("5e64c099b1fb399fd73c3a7a493013d0", Hmac.hasher().md4(oriVal, key));
        assertEquals("f2911ba771ff9d46a5ad1aa814c43298", Hmac.hasher().md5(oriVal, key));
        assertEquals("ba4d14b4357284e52ff3c2828dc85c75b905b1a2", Hmac.hasher().sha1(oriVal, key));
        assertEquals("540896508306df9779e8fe55983da2453dfb71ff740e3e1845852b5f", Hmac.hasher().sha224(oriVal.getBytes(utf8), key));
        assertEquals("a1019c6198821f7b706197537814938679a38432a8fda954b1080d70c076f27f", Hmac.hasher().sha256(oriVal.getBytes(utf8), key));
        assertEquals("c8568ea88d0626dd2577b50038d3b3b70b8735847e564f7a862569203908dc92df077e9806123e7853de4c8fd2684e7c", Hmac.hasher().sha384(oriVal.getBytes(utf8), key));
        assertEquals("d2652afb671eaf5293a05f670c87d83898318b95f47fc3ccfd7d5e0014a4353f3dfa8cb652ba840b961a79a4db53a35c86175aa0c9fe9a2fa1495b4a11ee49a3", Hmac.hasher().sha512(oriVal.getBytes(utf8), key));

        // upper case
        assertEquals("6CD2F4ED298A58DC98819C8A49D54FB2", Hmac.hasher().lowercase(false).md2(oriVal, key));
    }
}
