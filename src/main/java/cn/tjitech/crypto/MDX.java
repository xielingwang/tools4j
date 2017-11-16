package cn.tjitech.crypto;

import cn.tjitech.transform.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;

public abstract class MDX {
    private static String ALGO_MD5 = "MD5";
    private static String ALGO_MD4 = "MD4";
    private static String ALGO_MD2 = "MD2";

    public static class Digester {
        private String algorithm = ALGO_MD5;
        private String encoding = "utf-8";
        private boolean islowercase = false;
        private boolean isbit16 = false;
        private Object data = null;

        private <T> byte[] bytelize(T data) {
            byte[] result = null;
            if (data instanceof byte[]) {
                result = (byte[]) data;
            }
            else if (data instanceof String) {
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

        public Digester letterCase(boolean val) {
            this.islowercase = val;
            return this;
        }

        public Digester bit16(boolean val) {
            this.isbit16 = val;
            return this;
        }

        public String digest() {
            String result = MDX.digest(algorithm, bytelize(data));
            result = islowercase ? result.toLowerCase() : result.toUpperCase();
            return isbit16 ? result.substring(8, 24) : result;
        }

        public <T> String digest(T data) {
            this.data = data;
            return digest();
        }

        public <T> String md2(T data) {
            this.algorithm = ALGO_MD2;
            return digest(data);
        }
        public <T> String md4(T data) {
            this.algorithm = ALGO_MD4;
            return digest(data);
        }
        public <T> String md5(T data) {
            this.algorithm = ALGO_MD5;
            return digest(data);
        }

        @Override
        public String toString() {
            return digest();
        }
    }

    private static String digest(String algorithm, byte[] bytes) {
        if (ALGO_MD4.equalsIgnoreCase(algorithm)) {
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

    public static Digester digester() {
        return new Digester();
    }

    public static Digester md2() {
        return digester().algorithm(ALGO_MD2);
    }
    public static Digester md4() {
        return digester().algorithm(ALGO_MD4);
    }
    public static Digester md5() {
        return digester().algorithm(ALGO_MD5);
    }

    public static <T> String md2(T data) {
        return md2().digest(data);
    }
    public static <T> String md4(T data) {
        return md4().digest(data);
    }
    public static <T> String md5(T data) {
        return md5().digest(data);
    }
}
