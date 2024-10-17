package br.com.fiap.web.senhas;

//Gera um hash usando o algoritmo PBKDF2WithmacSHA512

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class PasswordPBKDF2 {

    //Parâmetros: tamanho do salt, n. interações, comprimento da chave (bits)
    private static final int SALT = 16;
    private static final int ITERATIONS = 65536;
    private static final int KEY = 512;

    public static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT];
        random.nextBytes(salt);
        return salt;
    }
    //Metodo cria o hash
    public static String hashPassword(String senha, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(senha.toCharArray(), salt, ITERATIONS, KEY);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        byte[] hash = factory.generateSecret(spec).getEncoded();

        return Base64.getEncoder().encodeToString(hash);
    }

    public static boolean verificarSenha(String senha, String hash, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String newHash = hashPassword(senha, salt);
        return newHash.equals(hash);
    }
}
