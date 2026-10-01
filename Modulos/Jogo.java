package Modulos;

public class Jogo {
    public Jogo() {
        // Construtor da classe Jogo
    }
    public void jogo(){

    }
    public void iniciarJogo(Usuario usuario, Personagem personagem) {

        System.out.println("Bem-vindo ao jogo!");
        System.out.println("Personagem: " + personagem.getNomePersonagem());
        System.out.println("Classe: " + personagem.getClasse());

        
    }
}
