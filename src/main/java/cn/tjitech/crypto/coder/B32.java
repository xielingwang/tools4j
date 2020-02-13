package cn.tjitech.crypto.coder;

import java.io.UnsupportedEncodingException;

public class B32 implements ICoder{
    private String encoding = "utf-8";

    @Override
    public String getEncoding() {
        return encoding;
    }

    @Override
    public ICoder setEncoding(String encoding) {
        this.encoding = encoding;
        return this;
    }

    @Override
    public String encodeAsStr(String val) {
        try {
            return encodeAsStr(val.getBytes(encoding));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String decodeAsStr(String val) {
        try {
            return new String(decodeAsBytes(val), encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String encodeAsStr(byte[] data) {
        return Base32Impl.encode(data);
    }

    @Override
    public byte[] decodeAsBytes(String data) {
        return Base32Impl.decode(data);
    }
}
