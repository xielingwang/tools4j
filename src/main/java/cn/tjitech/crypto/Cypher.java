package cn.tjitech.crypto;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.HashMap;
import java.util.Map;

public class Cypher {
    private static Map<String, String> cypherInstances = new HashMap<>();

    private static String DES = "DES";
    private static String DESede = "DESede";
    private static String AES = "AES";
    private static String IDEA = "IDEA";
    private static String PBE = "PBE";
    static {
        cypherInstances.put(DES, DES + "/ECB/PKCS5Padding");
        cypherInstances.put(DESede, DESede + "/ECB/PKCS5Padding");
        cypherInstances.put(AES, AES + "/ECB/PKCS5Padding");
        cypherInstances.put(IDEA, IDEA + "/ECB/PKCS5Padding");
        cypherInstances.put(PBE, PBE + "WITHMD5andDES");
    }

    public static byte[] rpad(byte[] data, int len) {
        if (data != null && data.length == len) {
            return data;
        }
        byte[] res = new byte[len];
        for (int i = 0; i < res.length; i++) {
            if (data != null && i < data.length) {
                res[i] = data[i];
            }
            else {
                res[i] = '\0';
            }
        }
        return res;
    }

    private static  <T> byte[] docrypt(boolean isEncrypt, String algorithm, T data, byte[] byteskey) {
        if (DESede.equalsIgnoreCase(algorithm)) {
            byteskey = rpad(byteskey, byteskey.length <= 16 ? 16 : 24);
        }
        else if (AES.equalsIgnoreCase(algorithm)) {
            byteskey = rpad(byteskey, byteskey.length <= 16 ? 16 : 32);
        }

        try {
            Cipher cipher = Cipher.getInstance(cypherInstances.get(algorithm));
            if (AES.equalsIgnoreCase(algorithm)) {
                SecretKey skSepc = new SecretKeySpec(byteskey, algorithm);
                cipher.init(isEncrypt ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE, skSepc);
            }
            else {
                SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithm);
                KeySpec keySpec = new SecretKeySpec(byteskey, algorithm);
                SecretKey convertedSecretKey = keyFactory.generateSecret(keySpec);
                cipher.init(isEncrypt ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE, convertedSecretKey);
            }
            return cipher.doFinal(Coder.bytelize(data));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    private static <T> byte[] encrypt(String algorithm, T data, byte[] byteskey) {
            return docrypt(true, algorithm, data, byteskey);
    }
    private static <T> byte[] decrypt(String algorithm, T data, byte[] byteskey) {
        return docrypt(false, algorithm, data, byteskey);
    }

    private static <T> String encryptAsB64(String algorithm, T data, byte[] byteskey) {
        return Coder.b64().encodeAsStr(encrypt(algorithm, data, byteskey));
    }
    private static <T> String decryptAsB64(String algorithm, T data, byte[] byteskey) {
        return Coder.b64().encodeAsStr(decrypt(algorithm, data, byteskey));
    }

    private static String decryptAsString(String algorithm, byte[] data, byte[] byteskey) {
        return new String(decrypt(algorithm, data, byteskey));
    }

    /***************************************************************************
     * DES
     **************************************************************************/
    public static String DESEncryptAsBase64(byte[] data, String key) {
        return encryptAsB64(DES, data, key.getBytes());
    }
    public static String DESDecryptAsString(byte[] data, String key) {
        return decryptAsString(DES, data, key.getBytes());
    }

    public static String DESEncryptAsBase64(byte[] data, byte[] byteskey) {
        return encryptAsB64(DES, data, byteskey);
    }
    public static String DESDecryptAsString(byte[] data, byte[] byteskey) {
        return decryptAsString(DES, data, byteskey);
    }

    /***************************************************************************
     * DESede
     **************************************************************************/
    public static String DESedeEncryptAsBase64(byte[] data, String key) {
        return encryptAsB64(DESede, data, key.getBytes());
    }
    public static String DESedeDecryptAsString(byte[] data, String key) {
        return decryptAsString(DESede, data, key.getBytes());
    }

    public static String DESedeEncryptAsBase64(byte[] data, byte[] byteskey) {
        return encryptAsB64(DESede, data, byteskey);
    }
    public static String DESedeDecryptAsString(byte[] data, byte[] byteskey) {
        return decryptAsString(DESede, data, byteskey);
    }

    /***************************************************************************
     * AES
     **************************************************************************/
    public static String AESEncryptAsBase64(byte[] data, String key) {
        return encryptAsB64(AES, data, key.getBytes());
    }
    public static String AESDecryptAsString(byte[] data, String key) {
        return decryptAsString(AES, data, key.getBytes());
    }

    public static String AESEncryptAsBase64(byte[] data, byte[] byteskey) {
        return encryptAsB64(AES, data, byteskey);
    }
    public static String AESDecryptAsString(byte[] data, byte[] byteskey) {
        return decryptAsString(AES, data, byteskey);
    }

    /***************************************************************************
     * IDEA
     **************************************************************************/
    public static String IDEAEncryptAsBase64(byte[] data, String key) {
        return encryptAsB64(IDEA, data, key.getBytes());
    }
    public static String IDEADecryptAsString(byte[] data, String key) {
        return decryptAsString(IDEA, data, key.getBytes());
    }

    public static String IDEAEncryptAsBase64(byte[] data, byte[] byteskey) {
        return encryptAsB64(IDEA, data, byteskey);
    }
    public static String IDEADecryptAsString(byte[] data, byte[] byteskey) {
        return decryptAsString(IDEA, data, byteskey);
    }

    /***************************************************************************
     * PBE
     **************************************************************************/
    public static String PBEEncryptAsBase64(byte[] data, String key) {
        return encryptAsB64(PBE, data, key.getBytes());
    }
    public static String PBEDecryptAsString(byte[] data, String key) {
        return decryptAsString(PBE, data, key.getBytes());
    }

    public static String PBEEncryptAsBase64(byte[] data, byte[] byteskey) {
        return encryptAsB64(PBE, data, byteskey);
    }
    public static String PBEDecryptAsString(byte[] data, byte[] byteskey) {
        return decryptAsString(PBE, data, byteskey);
    }
}
