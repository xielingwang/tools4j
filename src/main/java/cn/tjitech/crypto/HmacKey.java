package cn.tjitech.crypto;

import cn.tjitech.transform.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.Arrays;
import java.util.List;

public class HmacKey {
    public static final String ALGO_HmacMD2 = "HmacMD2";
    public static final String ALGO_HmacMD4 = "HmacMD4";
    public static final String ALGO_HmacMD5 = "HmacMD5";
    public static final String ALGO_HmacSHA1 = "HmacSHA1";
    public static final String ALGO_HmacSHA224 = "HmacSHA224";
    public static final String ALGO_HmacSHA256 = "HmacSHA256";
    public static final String ALGO_HmacSHA384 = "HmacSHA384";
    public static final String ALGO_HmacSHA512 = "HmacSHA512";

    private static final List<String> BCAlgorithms = Arrays.asList(HmacKey.ALGO_HmacMD2, HmacKey.ALGO_HmacMD4, HmacKey.ALGO_HmacSHA224);

    private static byte[] keygen(String algorithm) {

        if (BCAlgorithms.contains(algorithm)) {
            Provider bcProvider = Security.getProvider("BC");
            if (bcProvider == null) {
                Security.addProvider(new BouncyCastleProvider());
            }
        }

        try {
            KeyGenerator generator = null;
            generator = KeyGenerator.getInstance(algorithm);
            return generator.generateKey().getEncoded();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] md2() {
        return keygen(ALGO_HmacMD2);
    }
    public static byte[] md4() {
        return keygen(ALGO_HmacMD4);
    }
    public static byte[] md5() {
        return keygen(ALGO_HmacMD5);
    }
    public static byte[] sha1() {
        return keygen(ALGO_HmacSHA1);
    }
    public static byte[] sha224() {
        return keygen(ALGO_HmacSHA224);
    }
    public static byte[] sha256() {
        return keygen(ALGO_HmacSHA256);
    }
    public static byte[] sha384() {
        return keygen(ALGO_HmacSHA384);
    }
    public static byte[] sha512() {
        return keygen(ALGO_HmacSHA512);
    }

    public static String md2AsHex() {
        return Hex.format(md2());
    }
    public static String md4AsHex() {
        return Hex.format(md4());
    }
    public static String md5AsHex() {
        return Hex.format(md5());
    }
    public static String sha1AsHex() {
        return Hex.format(sha1());
    }
    public static String sha224AsHex() {
        return Hex.format(sha224());
    }
    public static String sha256AsHex() {
        return Hex.format(sha256());
    }
    public static String sha384AsHex() {
        return Hex.format(sha384());
    }
    public static String sha512AsHex() {
        return Hex.format(sha512());
    }

    public static String md2AsB64() {
        return Coder.b64().encodeAsStr(md2());
    }
    public static String md4AsB64() {
        return Coder.b64().encodeAsStr(md4());
    }
    public static String md5AsB64() {
        return Coder.b64().encodeAsStr(md5());
    }
    public static String sha1AsB64() {
        return Coder.b64().encodeAsStr(sha1());
    }
    public static String sha224AsB64() {
        return Coder.b64().encodeAsStr(sha224());
    }
    public static String sha256AsB64() {
        return Coder.b64().encodeAsStr(sha256());
    }
    public static String sha384AsB64() {
        return Coder.b64().encodeAsStr(sha384());
    }
    public static String sha512AsB64() {
        return Coder.b64().encodeAsStr(sha512());
    }
}
