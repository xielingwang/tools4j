package cn.tjitech.crypto;

import cn.tjitech.crypto.coder.B64;
import cn.tjitech.crypto.coder.B64Common;

public abstract class Coder {
    public static B64 b64(String encoding) {
        return new B64Common().setEncoding(encoding);
    }

    public static B64 b64() {
        return b64(null);
    }
}
