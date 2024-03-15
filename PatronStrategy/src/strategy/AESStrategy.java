package strategy;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESStrategy implements EncryptionStrategy {
	 private static final String AES_ALGORITHM = "AES";
	    private static final String AES_TRANSFORMATION = "AES/CBC/PKCS5Padding";

	    private byte[] key;
	    private byte[] iv;

	    public AESStrategy(byte[] key, byte[] iv) {
	        this.key = key;
	        this.iv = iv;
	    }
 @Override
 public void init() {
 	this.key = "0123456789abcdef".getBytes(); // 128-bit key
     this.iv = "0123456789abcdef".getBytes();  // 128-bit IV
 }

 @Override
 public byte[] encrypt(byte[] data) {
 	try {
         SecretKeySpec secretKey = new SecretKeySpec(key, AES_ALGORITHM);
         IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
         Cipher cipher = Cipher.getInstance(AES_TRANSFORMATION);
         cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
         return cipher.doFinal(data);
     } catch (Exception e) {
         e.printStackTrace();
         return null;
     }
 }

 @Override
 public String decrypt(byte[] data) {
 	try {
         SecretKeySpec secretKey = new SecretKeySpec(key, AES_ALGORITHM);
         IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
         Cipher cipher = Cipher.getInstance(AES_TRANSFORMATION);
         cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
         return new String(cipher.doFinal(data));
     } catch (Exception e) {
         e.printStackTrace();
         return null;
     }
 }
}
