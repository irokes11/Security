package aes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AESTEST2Encryption {

	

		 public static void main(String[] args) 
			 
				 throws IOException, GeneralSecurityException, ClassNotFoundException
		   {
		 
			 String InputStream = "input.txt";
			 String OutputStream = "irekEncrypted.txt";
			 String Keyfile = "irek";
 		     int mode;
		     
 		     
 		     mode = Cipher.ENCRYPT_MODE;
		        
		     
		      

		         try (ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(Keyfile)); //dekrypcja , wczytanie pliku
		            InputStream in = new FileInputStream(InputStream);
		            OutputStream out = new FileOutputStream(OutputStream))
		         {
		            Key key = (Key) keyIn.readObject();
		            Cipher cipher = Cipher.getInstance("AES");
		            cipher.init(mode, key);
		            Util.crypt(in, out, cipher);
		         }
		      }
		   }
	

