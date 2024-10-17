/*package br.com.fiap.web.senhas;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class TestePBKDF2 {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String senha = "123456";
        //Gerar o salt aleatório
        byte[] salt = PasswordPBKDF2.generateSalt();
        String senhaHash = PasswordPBKDF2.hashPassword(senha, salt);
        System.out.println(senha);
        System.out.println(senhaHash);
        boolean senhaValida = PasswordPBKDF2.verificarSenha(senha,senhaHash,salt);
        System.out.println("A senha é válida : " + senhaValida);
    }
}
