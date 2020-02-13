package cn.tjitech.crypto.coder;

public interface ICoder {
    String getEncoding();

    ICoder setEncoding(String encoding);

    String encodeAsStr(String val);

    String decodeAsStr(String val);

    String encodeAsStr(byte[] data);

    byte[] decodeAsBytes(String data);
}
