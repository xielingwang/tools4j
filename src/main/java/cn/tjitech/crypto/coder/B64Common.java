package cn.tjitech.crypto.coder;

import java.util.Base64;

public class B64Common extends B64 {
    @Override
    Base64.Encoder encoder() {
        return Base64.getEncoder();
    }

    @Override
    Base64.Decoder decoder() {
        return Base64.getDecoder();
    }
}
