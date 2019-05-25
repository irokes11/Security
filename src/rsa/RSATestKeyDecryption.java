package rsa;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class RSATestKeyDecryption {


	 private static final int KEYSIZE = 512;
	 
	 public static void main(String[] args) 
		      throws IOException, GeneralSecurityException, ClassNotFoundException
		   {
		 
		 String privatekeyfile="privateKey1.txt";
		 String fileoutput="outputRSA.txt";
		 String encryptedRSAfile= "encryptedRSAfile.txt";
		   
		
        
        
         try (DataInputStream in = new DataInputStream(new FileInputStream(encryptedRSAfile));
                 ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(privatekeyfile));
                 OutputStream out = new FileOutputStream(fileoutput))
              {
                 int length = in.readInt();
                 byte[] wrappedKey = new byte[length];
                 in.read(wrappedKey, 0, length);

                 // unwrap with RSA private key
                 Key privateKey = (Key) keyIn.readObject();
        
                 Cipher cipher = Cipher.getInstance("RSA");
                 cipher.init(Cipher.UNWRAP_MODE, privateKey);
                 Key key = cipher.unwrap(wrappedKey, "AES", Cipher.SECRET_KEY);
        
                 cipher = Cipher.getInstance("AES");
                 cipher.init(Cipher.DECRYPT_MODE, key);
        
                 Util.crypt(in, out, cipher);
    
    
    
    
}
}
}
	
	

