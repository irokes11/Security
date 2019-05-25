package rsa;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class RSATestKeyEncryption {

	 private static final int KEYSIZE = 512;
	 
	 public static void main(String[] args) 
		      throws IOException, GeneralSecurityException, ClassNotFoundException
		   {
		 
		 String keypublicfile="publicKey1.txt";
		 String fileinput="input.txt";
		 String encryptedRSAfile= "encryptedRSAfile.txt";
		   
		 KeyGenerator keygen = KeyGenerator.getInstance("AES");
         SecureRandom random = new SecureRandom();
         keygen.init(random);
         SecretKey key = keygen.generateKey();
         
         
     try (ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(keypublicfile));
             DataOutputStream out = new DataOutputStream(new FileOutputStream(encryptedRSAfile));
             InputStream in = new FileInputStream(fileinput) )
          {
             Key publicKey = (Key) keyIn.readObject();
             Cipher cipher = Cipher.getInstance("RSA");
             cipher.init(Cipher.WRAP_MODE, publicKey);
             byte[] wrappedKey = cipher.wrap(key);
             out.writeInt(wrappedKey.length);
             out.write(wrappedKey);
          
             cipher = Cipher.getInstance("AES");
             cipher.init(Cipher.ENCRYPT_MODE, key);
             Util.crypt(in, out, cipher);            
          }         
     
     
}
	 }
