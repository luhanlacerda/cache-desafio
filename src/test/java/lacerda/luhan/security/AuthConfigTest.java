package lacerda.luhan.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AuthConfigTest {

    @Autowired
    private AuthConfig authConfig;

    @Test
    public void encryptionRSATest() {

        String plain = "nome;email";

        // Initialization of key pair for encryption and decryption.
        KeyPair keyPair = authConfig.getKeyPair();

        try {
            // Get public key from the key pair.
            PublicKey pubKey = keyPair.getPublic();

            // Get private key from the key pair.
            PrivateKey privKey = keyPair.getPrivate();

            // Try to encode public key as a string.
            String pubKeyStr = authConfig.encodeKey(pubKey);
            // Assertion of 'pubKey' and the public key decoded by 'pubKeyStr'.
            assertEquals(pubKey, authConfig.decodePublicKey(pubKeyStr));

            // Try to encode private key as a string.
            String privKeyStr = authConfig.encodeKey(privKey);
            // Assertion of 'privKey' and the private key decoded by 'privKeyStr'.
            assertEquals(privKey, authConfig.decodePrivateKey(privKeyStr));

            // Encrypt plain as a cipher.
            String cipherContent = authConfig.encrypt(plain, pubKey);
            // Decrypt cipher to original plain.
            String decryptResult = authConfig.decrypt(cipherContent, privKey);
            // Assertion of 'plain' and 'decryptResult'.
            assertEquals(plain, decryptResult);
        } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BadPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
