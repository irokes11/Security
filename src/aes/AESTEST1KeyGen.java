package aes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AESTEST1KeyGen {
	
	 public static void main(String[] args) 
		      throws IOException, GeneralSecurityException, ClassNotFoundException
		   {
		   
		   
		         KeyGenerator keygen = KeyGenerator.getInstance("AES");
		         SecureRandom random = new SecureRandom();
		         keygen.init(random);
		         SecretKey key = keygen.generateKey();
		         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("irek"))) //
		         {
		            out.writeObject(key);
		         }
		      
		   }
}

