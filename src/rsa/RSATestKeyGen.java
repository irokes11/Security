package rsa;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class RSATestKeyGen {

	private static final int KEYSIZE = 512;
	
	 public static void main(String[] args) 
		      throws IOException, GeneralSecurityException, ClassNotFoundException
		   {
	
		 
		 
		 KeyPairGenerator pairgen = KeyPairGenerator.getInstance("RSA");
         SecureRandom random = new SecureRandom();
         pairgen.initialize(KEYSIZE, random);
         KeyPair keyPair = pairgen.generateKeyPair();
        
         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("publicKey1.txt")))
         {
            out.writeObject(keyPair.getPublic());
         }
         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("privateKey1.txt")))
         {
            out.writeObject(keyPair.getPrivate());
         }
		 
		   }
}