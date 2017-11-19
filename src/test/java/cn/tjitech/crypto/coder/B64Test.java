package cn.tjitech.crypto.coder;

import cn.tjitech.crypto.Coder;
import cn.tjitech.transform.Hex;
import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class B64Test {
    static final Map<String, String> utf8 = new HashMap<>();
    static final Map<String, String> gbk = new HashMap<>();

    static {
        utf8.put("中华人民共和国", "5Lit5Y2O5Lq65rCR5YWx5ZKM5Zu9");
        utf8.put("国和共民人华中Encode to Base64 format", "5Zu95ZKM5YWx5rCR5Lq65Y2O5LitRW5jb2RlIHRvIEJhc2U2NCBmb3JtYXQ=");

        gbk.put("中华人民共和国", "1tC7qsjLw/G5srrNufo=");
        gbk.put("国和共民人华中Encode to Base64 format", "ufq6zbmyw/HIy7uq1tBFbmNvZGUgdG8gQmFzZTY0IGZvcm1hdA==");
    }

    @Test
    public void testEncodeString() throws UnsupportedEncodingException {
        // encode(string), 默认 utf-8
        for (String orig : utf8.keySet()) {
            Assert.assertEquals(utf8.get(orig), Coder.b64().encodeAsStr(orig));
        }
        // encode(string), gbk
        for (String orig : gbk.keySet()) {
            Assert.assertEquals(gbk.get(orig), Coder.b64("gbk").encodeAsStr(orig));
        }
        // encoding 不一致, base64不一致
        for (String orig : gbk.keySet()) {
            Assert.assertNotEquals(utf8.get(orig), Coder.b64("gbk").encodeAsStr(orig));
        }
    }

    @Test
    public void testDecodeString() throws UnsupportedEncodingException {
        // encode(string), 默认 utf-8
        for (String orig : utf8.keySet()) {
            Assert.assertEquals(orig, Coder.b64().decodeAsStr(utf8.get(orig)));
        }
        // encode(string), gbk
        for (String orig : gbk.keySet()) {
            Assert.assertEquals(orig, Coder.b64("gbk").decodeAsStr(gbk.get(orig)));
        }
    }

    @Test
    public void testEncodeBytes() throws UnsupportedEncodingException {
        // encode(bytes), encode
        for (String orig : utf8.keySet()) {
            Assert.assertEquals(
                    utf8.get(orig)
                    , Coder.b64().encodeAsStr(orig.getBytes("utf-8"))
            );
        }
        // encode(bytes), gbk
        for (String orig : gbk.keySet()) {
            Assert.assertEquals(
                    gbk.get(orig)
                    , Coder.b64("gbk").encodeAsStr(orig.getBytes("gbk"))
            );
        }
    }

    @Test
    public void testDecodeBytes() throws UnsupportedEncodingException {
        // encode(bytes), encode
        for (String orig : utf8.keySet()) {
            Assert.assertEquals(
                    Hex.format(orig.getBytes())
                    , Hex.format(Coder.b64().decodeAsBytes(utf8.get(orig)))
            );
        }
        // encode(bytes), gbk
        for (String orig : gbk.keySet()) {
            Assert.assertEquals(
                    Hex.format(orig.getBytes("gbk"))
                    , Hex.format(Coder.b64().decodeAsBytes(gbk.get(orig)))
            );
        }
    }
}
