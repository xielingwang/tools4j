package cn.tjitech.crypto;

import cn.tjitech.transform.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;

public class SHAX {
    private static String ALGO_SHA1 = "SHA-1";
    private static String ALGO_SHA224 = "SHA-224";
    private static String ALGO_SHA256 = "SHA-256";
    private static String ALGO_SHA384 = "SHA-384";
    private static String ALGO_SHA512 = "SHA-512";

    public static class Hasher {
        private String algorithm = ALGO_SHA1;
        private String encoding = "utf-8";
        private boolean islowercase = true;
        private Object data = null;

        private <T> byte[] bytelize(T data) {
            byte[] result = null;
            if (data instanceof byte[]) {
                result = (byte[]) data;
            } else if (data instanceof String) {
                try {
                    result = ((String) data).getBytes(encoding);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    result = ((String) data).getBytes();
                }
            }
            return result;
        }

        public Hasher algorithm(String val) {
            this.algorithm = val;
            return this;
        }

        public Hasher enc(String enc) {
            this.encoding = enc;
            return this;
        }

        public Hasher letterCase(boolean val) {
            this.islowercase = val;
            return this;
        }

        public String hash() {
            String result = SHAX.hash(algorithm, bytelize(data));
            return islowercase ? result.toLowerCase() : result.toUpperCase();
        }

        public <T> String hash(T data) {
            this.data = data;
            return hash();
        }

        public <T> String sha1(T data) {
            this.algorithm = ALGO_SHA1;
            return hash(data);
        }

        public <T> String sha224(T data) {
            this.algorithm = ALGO_SHA224;
            return hash(data);
        }

        public <T> String sha256(T data) {
            this.algorithm = ALGO_SHA256;
            return hash(data);
        }

        public <T> String sha384(T data) {
            this.algorithm = ALGO_SHA384;
            return hash(data);
        }

        public <T> String sha512(T data) {
            this.algorithm = ALGO_SHA512;
            return hash(data);
        }

        @Override
        public String toString() {
            return hash();
        }
    }

    private static String hash(String algorithm, byte[] bytes) {
        if (ALGO_SHA224.equalsIgnoreCase(algorithm)) {
            Provider bcProvider = Security.getProvider("BC");
            if (bcProvider == null) {
                Security.addProvider(new BouncyCastleProvider());
            }
        }

        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            return Hex.format(digest.digest(bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Hasher hasher() {
        return new Hasher();
    }

    public static Hasher sha1() {
        return hasher().algorithm(ALGO_SHA1);
    }
    public static Hasher sha224() {
        return hasher().algorithm(ALGO_SHA224);
    }
    public static Hasher sha256() {
        return hasher().algorithm(ALGO_SHA256);
    }
    public static Hasher sha384() {
        return hasher().algorithm(ALGO_SHA384);
    }
    public static Hasher sha512() {
        return hasher().algorithm(ALGO_SHA512);
    }

    public static <T> String sha1(T data) {
        return sha1().hash(data);
    }
    public static <T> String sha224(T data) {
        return sha224().hash(data);
    }
    public static <T> String sha256(T data) {
        return sha256().hash(data);
    }
    public static <T> String sha384(T data) {
        return sha384().hash(data);
    }
    public static <T> String sha512(T data) {
        return sha512().hash(data);
    }
}
