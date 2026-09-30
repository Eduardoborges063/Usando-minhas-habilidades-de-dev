package Modulos;

public class Menu{

    public void iniciar(Usuario usuario){
        System.out.println("Bem vindo ao jogo");
        System.out.println("1 - Cadastrar usuario");
        System.out.println("2 - Logar usuario");
        System.out.println("3 - Sair");
    }

    public void criaUsuario() {
        System.out.println("Digite seu nome: ");
        String nome = new java.util.Scanner(System.in).nextLine();
        
        System.out.println("Digite seu email: ");
        String email = new java.util.Scanner(System.in).nextLine();
        
        System.out.println("Digite sua senha: ");
        String senha = new java.util.Scanner(System.in).nextLine();

        System.out.println("Usuario criado com sucesso");
    }

}