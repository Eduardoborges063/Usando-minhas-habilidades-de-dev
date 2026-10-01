package Modulos;

import java.util.Scanner;

import Modulos.Usuario.CadastroUsuario;

public class Menu {
    
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao menu!");
        System.out.println("Escolha uma opção:");
        System.out.println("1. Criar usuário");
        System.out.println("2. Logar em um usuário");
        System.out.println("3. Sair");
        
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
               String resultado = CadastroUsuario.cadastrar();
                    System.out.println(resultado);
                break;
            case 2:
                break;
            case 3:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
        
        scanner.close();
    }
}
