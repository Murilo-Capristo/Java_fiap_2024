package br.com.fiap.web.senhas;

public class TesteBCrypt {
    public static void main(String[] args) {
        String senha = "123456";
        String senhaHash = PasswordHash.hashPassword(senha);
        System.out.println(senhaHash);
        //Verificacao
        boolean senhaValida = PasswordHash.verificaSenha(senha, senhaHash);
        System.out.println("A senha é válida: " + senhaValida);




    }
}
