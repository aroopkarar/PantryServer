package com.pantryadmin.Utils;

import com.pantryadmin.Constants.ApplicationConstant;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class StringEncryptDecryptUtil {

    private static final String ALGORITHM = ApplicationConstant.ENCRYPTION_ALGORITHM;
    private static byte[] keyValue = ApplicationConstant.ENCRYPTION_SALT.getBytes();

    public static void updateKeyValue(String value) {
        keyValue = value.getBytes();
    }

    public static String encrypt(String valueToEnc) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encValue = c.doFinal(valueToEnc.getBytes());
        return new String(Base64.encodeBase64(encValue));
    }

    public static String decrypt(String encryptedValue) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = Base64.decodeBase64(encryptedValue.getBytes());
        byte[] decValue = c.doFinal(decordedValue);
        return new String(decValue);
    }

    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    }

    public static void main(String[] arg) throws Exception {
        String uidPwd = "C123456||Pass@123";
        String encryptedValue = StringEncryptDecryptUtil.encrypt(uidPwd);
        String decryptedValue = StringEncryptDecryptUtil.decrypt(encryptedValue);
        System.out.println("uidPwd : " + uidPwd);
        System.out.println("encryptedValue : " + encryptedValue);
        System.out.println("decryptedValue : " + decryptedValue);
    }
}
