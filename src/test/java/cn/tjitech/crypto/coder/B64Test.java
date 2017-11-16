package cn.tjitech.crypto.coder;

import cn.tjitech.crypto.Coder;
import cn.tjitech.transform.Hex;
import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class B64Test {

    @Test
    public void testEncodeString() throws UnsupportedEncodingException {
        // encode(string), 默认 utf-8
        Assert.assertEquals("5Lit5Y2O5Lq65rCR5YWx5ZKM5Zu9", Coder.b64().encodeAsStr("中华人民共和国"));
        Assert.assertEquals("5Zu95ZKM5YWx5rCR5Lq65Y2O5LitRW5jb2RlIHRvIEJhc2U2NCBmb3JtYXQ=", Coder.b64().encodeAsStr("国和共民人华中Encode to Base64 format"));

        // encode(string), gbk
        Assert.assertEquals("1tC7qsjLw/G5srrNufo=", Coder.b64("gbk").encodeAsStr("中华人民共和国"));
        Assert.assertEquals("ufq6zbmyw/HIy7uq1tBFbmNvZGUgdG8gQmFzZTY0IGZvcm1hdA==", Coder.b64("gbk").encodeAsStr("国和共民人华中Encode to Base64 format"));

        // encoding 不一致, base64不一致
        Assert.assertNotEquals("5Lit5Y2O5Lq65rCR5YWx5ZKM5Zu9", Coder.b64("gbk").encodeAsStr("中华人民共和国"));
        Assert.assertNotEquals("5Zu95ZKM5YWx5rCR5Lq65Y2O5LitRW5jb2RlIHRvIEJhc2U2NCBmb3JtYXQ=", Coder.b64("gbk").encodeAsStr("国和共民人华中Encode to Base64 format"));
    }

    @Test
    public void testDecodeString() throws UnsupportedEncodingException {
        // decode(string), 默认 utf-8
        Assert.assertEquals("中华人民共和国", Coder.b64().decodeAsStr("5Lit5Y2O5Lq65rCR5YWx5ZKM5Zu9"));
        Assert.assertEquals("国和共民人华中Encode to Base64 format", Coder.b64().decodeAsStr("5Zu95ZKM5YWx5rCR5Lq65Y2O5LitRW5jb2RlIHRvIEJhc2U2NCBmb3JtYXQ="));

        // decode(string), gbk
        Assert.assertEquals("中华人民共和国", Coder.b64("gbk").decodeAsStr("1tC7qsjLw/G5srrNufo="));
        Assert.assertEquals("国和共民人华中Encode to Base64 format", Coder.b64("gbk").decodeAsStr("ufq6zbmyw/HIy7uq1tBFbmNvZGUgdG8gQmFzZTY0IGZvcm1hdA=="));
    }

    @Test
    public void testEncodeBytes() throws UnsupportedEncodingException {
        // encode(bytes), encode
        Assert.assertEquals(
                "5Lit5Y2O5Lq65rCR5YWx5ZKM5Zu9"
                , Coder.b64().encodeAsStr("中华人民共和国".getBytes("utf-8"))
        );
        // encode(bytes), gbk
        Assert.assertEquals(
                "1tC7qsjLw/G5srrNufo="
                , Coder.b64("gbk").encodeAsStr("中华人民共和国".getBytes("gbk"))
        );
    }

    @Test
    public void testDecodeBytes() throws UnsupportedEncodingException {
        Assert.assertEquals(
                Hex.format("中华人民共和国".getBytes())
                , Hex.format(Coder.b64().decodeAsBytes("5Lit5Y2O5Lq65rCR5YWx5ZKM5Zu9"))
        );
        Assert.assertEquals(
                Hex.format("中华人民共和国".getBytes("gbk"))
                , Hex.format(Coder.b64().decodeAsBytes("1tC7qsjLw/G5srrNufo="))
        );
    }
}
