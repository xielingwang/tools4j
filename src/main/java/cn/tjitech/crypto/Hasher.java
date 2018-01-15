package cn.tjitech.crypto;

import cn.tjitech.transform.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.Arrays;
import java.util.List;

public class Hasher {
    private static final String ALGO_MD5 = "MD5";
    private static final String ALGO_MD4 = "MD4";
    private static final String ALGO_MD2 = "MD2";

    private static final String ALGO_SHA1 = "SHA-1";
    private static final String ALGO_SHA224 = "SHA-224";
    private static final String ALGO_SHA256 = "SHA-256";
    private static final String ALGO_SHA384 = "SHA-384";
    private static final String ALGO_SHA512 = "SHA-512";

    private static final List<String> BCAlgorithms = Arrays.asList(ALGO_MD4, ALGO_SHA224);

    private static String hash(String algorithm, boolean islowercase, byte[] body) {
        if (BCAlgorithms.contains(algorithm)) {
            Provider bcProvider = Security.getProvider("BC");
            if (bcProvider == null) {
                Security.addProvider(new BouncyCastleProvider());
            }
        }

        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            return Hex.format(digest.digest(body), islowercase);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Digester hasher() {
        return new Digester();
    }

    public static Digester md2() {
        return hasher().algorithm(ALGO_MD2);
    }
    public static Digester md4() {
        return hasher().algorithm(ALGO_MD4);
    }
    public static Digester md5() {
        return hasher().algorithm(ALGO_MD5);
    }
    public static Digester sha1() {
        return hasher().algorithm(ALGO_SHA1);
    }
    public static Digester sha224() {
        return hasher().algorithm(ALGO_SHA224);
    }
    public static Digester sha256() {
        return hasher().algorithm(ALGO_SHA256);
    }
    public static Digester sha384() {
        return hasher().algorithm(ALGO_SHA384);
    }
    public static Digester sha512() {
        return hasher().algorithm(ALGO_SHA512);
    }

    public static <T> String md2(T data) {
        return md2().hash(data);
    }
    public static <T> String md4(T data) {
        return md4().hash(data);
    }
    public static <T> String md5(T data) {
        return md5().hash(data);
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

    /**
     * Digester
     */
    protected static class Digester {
        private String algorithm = ALGO_MD5;
        private String encoding = "utf-8";
        private boolean islowercase = true;
        private Object data = null;

        public Digester algorithm(String val) {
            this.algorithm = val;
            return this;
        }

        public Digester enc(String enc) {
            this.encoding = enc;
            return this;
        }

        public Digester letterCase(boolean val) {
            this.islowercase = val;
            return this;
        }

        public String hash() {
            return Hasher.hash(algorithm, islowercase, Coder.bytelize(data, encoding));
        }

        public <T> String hash(T data) {
            this.data = data;
            return hash();
        }

        public <T> String md2(T data) {
            return algorithm(ALGO_MD2).hash(data);
        }
        public <T> String md4(T data) {
            return algorithm(ALGO_MD4).hash(data);
        }
        public <T> String md5(T data) {
            return algorithm(ALGO_MD5).hash(data);
        }
        public <T> String sha1(T data) {
            return algorithm(ALGO_SHA1).hash(data);
        }
        public <T> String sha224(T data) {
            return algorithm(ALGO_SHA224).hash(data);
        }
        public <T> String sha256(T data) {
            return algorithm(ALGO_SHA256).hash(data);
        }
        public <T> String sha384(T data) {
            return algorithm(ALGO_SHA384).hash(data);
        }
        public <T> String sha512(T data) {
            return algorithm(ALGO_SHA512).hash(data);
        }
    }
}
