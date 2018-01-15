package cn.tjitech.crypto;

import cn.tjitech.crypto.coder.B64;
import cn.tjitech.crypto.coder.B64Common;

import java.io.UnsupportedEncodingException;

public abstract class Coder {
    public static B64 b64(String encoding) {
        return new B64Common().setEncoding(encoding);
    }

    public static B64 b64() {
        return b64(null);
    }

    public static String mdx_16(String mdstr) {
        return mdstr.substring(8, 24);
    }

    public static <T> byte[] bytelize(T data) {
        return bytelize(data, "utf-8");
    }

    public static <T> byte[] bytelize(T data, String enc) {
        byte[] result = null;
        if (data instanceof byte[]) {
            result = (byte[]) data;
        } else if (data instanceof String) {
            try {
                result = ((String) data).getBytes(enc);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                result = ((String) data).getBytes();
            }
        }
        return result;
    }
}
