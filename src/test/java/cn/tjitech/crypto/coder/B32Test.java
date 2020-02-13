package cn.tjitech.crypto.coder;

import cn.tjitech.crypto.Coder;
import cn.tjitech.transform.Hex;
import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class B32Test {
    static final Map<String, String> utf8 = new HashMap<>();
    static final Map<String, String> gbk = new HashMap<>();

    static {
        utf8.put("中华人民共和国", "4S4K3ZMNR3SLVOXGWCI6LBNR4WJIZZM3XU");
        utf8.put("Base32编码是使用32个可打印字符", "IJQXGZJTGLT3ZFXHUCA6NGFP4S637Z4UVAZTFZFYVLSY7L7GRGJ6LDNQ4WWZPZ5MUY");

        gbk.put("中华人民共和国", "23ILXKWIZPB7DONSXLG3T6Q");
        gbk.put("Base32编码是使用32个可打印字符", "IJQXGZJTGKY6BQXLZLD4VOOTYMZTFOHWX7E3J4WTUHL5NN73");
    }

    @Test
    public void testEncodeString() {
        // encode(string), 默认 utf-8
        for (String orig : utf8.keySet()) {
            Assert.assertEquals(utf8.get(orig), Coder.b32().encodeAsStr(orig));
        }
        // encode(string), gbk
        for (String orig : gbk.keySet()) {
            Assert.assertEquals(gbk.get(orig), Coder.b32("gbk").encodeAsStr(orig));
        }
        // encoding 不一致, base32不一致
        for (String orig : gbk.keySet()) {
            Assert.assertNotEquals(utf8.get(orig), Coder.b32("gbk").encodeAsStr(orig));
        }
    }

    @Test
    public void testDecodeString() {
        // encode(string), 默认 utf-8
        for (String orig : utf8.keySet()) {
            Assert.assertEquals(orig, Coder.b32().decodeAsStr(utf8.get(orig)));
        }
        // encode(string), gbk
        for (String orig : gbk.keySet()) {
            Assert.assertEquals(orig, Coder.b32("gbk").decodeAsStr(gbk.get(orig)));
        }
    }

    @Test
    public void testEncodeBytes() throws UnsupportedEncodingException {
        // encode(bytes), encode
        for (String orig : utf8.keySet()) {
            Assert.assertEquals(
                    utf8.get(orig)
                    , Coder.b32().encodeAsStr(orig.getBytes("utf-8"))
            );
        }
        // encode(bytes), gbk
        for (String orig : gbk.keySet()) {
            Assert.assertEquals(
                    gbk.get(orig)
                    , Coder.b32("gbk").encodeAsStr(orig.getBytes("gbk"))
            );
        }
    }

    @Test
    public void testDecodeBytes() throws UnsupportedEncodingException {
        // encode(bytes), encode
        for (String orig : utf8.keySet()) {
            Assert.assertEquals(
                    Hex.format(orig.getBytes())
                    , Hex.format(Coder.b32().decodeAsBytes(utf8.get(orig)))
            );
        }
        // encode(bytes), gbk
        for (String orig : gbk.keySet()) {
            Assert.assertEquals(
                    Hex.format(orig.getBytes("gbk"))
                    , Hex.format(Coder.b32().decodeAsBytes(gbk.get(orig)))
            );
        }
    }
}
