package cn.tjitech.transform;

public class Hex {
    private final static char[] HEX_CHAR = "0123456789ABCDEF".toCharArray();
    public static String format(byte b) {
        char[] chars = new char[2];
        chars[0] = HEX_CHAR[(b & 0xFF) >>> 4];
        chars[1] = HEX_CHAR[b & 0x0F];
        return new String(chars);
    }

    public static String format(byte[] data) {
        char[] chars = new char[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            byte b = data[i];
            chars[2 * i] = HEX_CHAR[(b & 0xFF) >>> 4];
            chars[2 * i + 1] = HEX_CHAR[b & 0x0F];
        }
        return new String(chars);
    }

    public static String format(byte[] data, boolean isLowerCase) {
        return isLowerCase ? format(data).toLowerCase() : format(data);
    }

    public static String format(byte data, boolean isLowerCase) {
        return isLowerCase ? format(data).toLowerCase() : format(data);
    }

    public static byte parseByte(String hex){
        if (hex == null || hex.length() <= 0) {
            return 0x00;
        }
        return (byte) Integer.parseInt(hex,16);
    }

    public static byte[] parseBytes(String hex){
        if (hex == null && hex.length() <= 0) {
            return new byte[] {};
        }

        if (hex.length() % 2 == 1) {
            hex = "0" + hex;
        }

        byte[] ret = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length(); i += 2) {
            ret[i / 2] = parseByte(hex.substring(i, i + 2));
        }

        return ret;
    }
}
