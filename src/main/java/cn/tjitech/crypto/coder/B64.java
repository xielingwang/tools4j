package cn.tjitech.crypto.coder;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public abstract class B64 {
    abstract Base64.Encoder encoder();
    abstract Base64.Decoder decoder();

    private String encoding = "utf-8";

    protected String getEncoding() {
        return this.encoding;
    }

    public B64 setEncoding(String encoding) {
        if (null == encoding) {
            encoding = "utf-8";
        }
        this.encoding = encoding;
        return this;
    }

    public String encodeAsStr(String val) {
        try {
            return encoder().encodeToString(val.getBytes(getEncoding()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encoder().encodeToString(val.getBytes());
    }

    public String decodeAsStr(String val) {
        try {
            return new String(decoder().decode(val), getEncoding());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new String(decoder().decode(val));
    }


    public String encodeAsStr(byte[] data) {
        return encoder().encodeToString(data);
    }

    public byte[] decodeAsBytes(String data) {
        return decoder().decode(data);
    }
}
