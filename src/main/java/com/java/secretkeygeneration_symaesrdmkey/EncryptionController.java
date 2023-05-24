package com.java.secretkeygeneration_symaesrdmkey;//package com.java.secretkeygeneration_symaesrdmkey;
//
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//import java.security.InvalidKeyException;
//import java.security.Key;
//import java.security.NoSuchAlgorithmException;
//import java.security.SecureRandom;
//import java.util.Base64;
//
//import javax.crypto.*;
//import javax.crypto.spec.SecretKeySpec;
//@RestController
//public class EncryptController {
//    Key key = generateRandomKey();
//
//    @PostMapping("/encrypt")
//    public String encrypt(@RequestBody String data) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
//        // Generate a random secret key.
//        SecureRandom secureRandom = new SecureRandom();
////        SecretKey key = secureRandom.generateKey(128);
//
//        // Encrypt the data using the secret key.
//        Cipher cipher = Cipher.getInstance("AES");
//        cipher.init(Cipher.ENCRYPT_MODE, key);
//        byte[] encryptedData = cipher.doFinal(data.getBytes());
//
//        // Return the encrypted data.
//        return Base64.getEncoder().encodeToString(encryptedData);
//    }
//
//    @PostMapping("/decrypt")
//    public String decrypt(@RequestBody String data) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
//        // Decode the encrypted data.
//        byte[] encryptedData = Base64.getDecoder().decode(data);
//
//        // Generate the same secret key that was used to encrypt the data.
////        SecretKey key = new SecureRandom().generateKey(128);
//
//        // Decrypt the data using the secret key.
//        Cipher cipher = Cipher.getInstance("AES");
//        cipher.init(Cipher.DECRYPT_MODE, key);
//        String decryptedData = new String(cipher.doFinal(encryptedData));
//
//        // Return the decrypted data.
//        return decryptedData;
//    }
//    public static Key generateRandomKey() {
//        SecureRandom secureRandom = new SecureRandom();
//        byte[] bytes = new byte[16];
//        secureRandom.nextBytes(bytes);
//        return new SecretKeySpec(bytes, "AES");
//    }
//
////    public static void main(String[] args) throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException
////        EncryptController controller = new EncryptController();
////        PrintWriter writer = new PrintWriter(System.out);
////
////        // Encrypt some data.
////        String data = "This is a secret message.";
////        String encryptedData = controller.encrypt(data);
////        writer.println("Encrypted data: " + encryptedData);
////
////        // Decrypt the data.
////        String decryptedData = controller.decrypt(encryptedData);
////        writer.println("Decrypted data: " + decryptedData);
////
////        writer.close();
////
//}


import com.java.secretkeygeneration_symaesrdmkey.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncryptionController {

    @Autowired
    private EncryptionService encryptionService;

    @PostMapping("/encrypt")
    public String encrypt(@RequestParam("data") String data) {
        return encryptionService.encrypt(data);
    }

    @PostMapping("/decrypt")
    public String decrypt(@RequestParam("data") String data) {
        return encryptionService.decrypt(data);
    }

}