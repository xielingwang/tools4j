package cn.tjitech.crypto;

import cn.tjitech.transform.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Arrays;
import java.util.List;

public class Hmac {
    private static final String ALGO_HmacMD2 = "HmacMD2";
    private static final String ALGO_HmacMD4 = "HmacMD4";
    private static final String ALGO_HmacMD5 = "HmacMD5";
    private static final String ALGO_HmacSHA1 = "HmacSHA1";
    private static final String ALGO_HmacSHA224 = "HmacSHA224";
    private static final String ALGO_HmacSHA256 = "HmacSHA256";
    private static final String ALGO_HmacSHA384 = "HmacSHA384";
    private static final String ALGO_HmacSHA512 = "HmacSHA512";

    private static final List<String> BCAlgorithms = Arrays.asList(ALGO_HmacMD2, ALGO_HmacMD4, ALGO_HmacSHA224);

    private static String hash(String algorithm, boolean islowercase, byte[] body, byte[] key) {
        if (BCAlgorithms.contains(algorithm)) {
            Provider bcProvider = Security.getProvider("BC");
            if (bcProvider == null) {
                Security.addProvider(new BouncyCastleProvider());
            }
        }
        try {
            SecretKey secretKey = new SecretKeySpec(key, algorithm);
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            return Hex.format(mac.doFinal(body), islowercase);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Digester hasher() {
        return new Digester();
    }

    public static Digester md2() {
        return hasher().algorithm(ALGO_HmacMD2);
    }
    public static Digester md4() {
        return hasher().algorithm(ALGO_HmacMD4);
    }
    public static Digester md5() {
        return hasher().algorithm(ALGO_HmacMD5);
    }
    public static Digester sha1() {
        return hasher().algorithm(ALGO_HmacSHA1);
    }
    public static Digester sha224() {
        return hasher().algorithm(ALGO_HmacSHA224);
    }
    public static Digester sha256() {
        return hasher().algorithm(ALGO_HmacSHA256);
    }
    public static Digester sha384() {
        return hasher().algorithm(ALGO_HmacSHA384);
    }
    public static Digester sha512() {
        return hasher().algorithm(ALGO_HmacSHA512);
    }

    public static <T, S> String md2(T data, S secrect) {
        return md2().hash(data, secrect);
    }
    public static <T, S> String md4(T data, S secrect) {
        return md4().hash(data, secrect);
    }
    public static <T, S> String md5(T data, S secrect) {
        return md5().hash(data, secrect);
    }
    public static <T, S> String sha1(T data, S secrect) {
        return sha1().hash(data, secrect);
    }
    public static <T, S> String sha224(T data, S secrect) {
        return sha224().hash(data, secrect);
    }
    public static <T, S> String sha256(T data, S secrect) {
        return sha256().hash(data, secrect);
    }
    public static <T, S> String sha384(T data, S secrect) {
        return sha384().hash(data, secrect);
    }
    public static <T, S> String sha512(T data, S secrect) {
        return sha512().hash(data, secrect);
    }

    /**
     * Digester
     */
    protected static class Digester {
        private String algorithm = ALGO_HmacSHA1;
        private String encoding = "utf-8";
        private boolean islowercase = true;
        private Object data = null;
        private Object secrect = null;

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

        public Digester algorithm(String val) {
            this.algorithm = val;
            return this;
        }

        public Digester enc(String enc) {
            this.encoding = enc;
            return this;
        }

        public Digester lowercase(boolean val) {
            this.islowercase = val;
            return this;
        }

        public String hash() {
            return Hmac.hash(algorithm, islowercase, bytelize(data), bytelize(secrect));
        }

        public <T, S> String hash(T data, S secrect) {
            this.data = data;
            this.secrect = secrect;
            return hash();
        }

        public <T, S> String md2(T data, S secrect) {
            return algorithm(ALGO_HmacMD2).hash(data, secrect);
        }
        public <T, S> String md4(T data, S secrect) {
            return algorithm(ALGO_HmacMD4).hash(data, secrect);
        }
        public <T, S> String md5(T data, S secrect) {
            return algorithm(ALGO_HmacMD5).hash(data, secrect);
        }
        public <T, S> String sha1(T data, S secrect) {
            return algorithm(ALGO_HmacSHA1).hash(data, secrect);
        }
        public <T, S> String sha224(T data, S secrect) {
            return algorithm(ALGO_HmacSHA224).hash(data, secrect);
        }
        public <T, S> String sha256(T data, S secrect) {
            return algorithm(ALGO_HmacSHA256).hash(data, secrect);
        }
        public <T, S> String sha384(T data, S secrect) {
            return algorithm(ALGO_HmacSHA384).hash(data, secrect);
        }
        public <T, S> String sha512(T data, S secrect) {
            return algorithm(ALGO_HmacSHA512).hash(data, secrect);
        }
    }
}
