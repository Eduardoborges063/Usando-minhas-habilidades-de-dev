package Modulos;

import java.util.Scanner;

public class Personagem {
    // Atributos do personagem
    protected String nomePersonagem;
    protected String classe;

    // Atributos de status
    protected int nivel = 0;
    protected static final int MAX_NIVEL = 100;

    protected int vida = 100;
    protected static final int MAX_VIDA = 500;

    protected double mana = 0.0;
    protected static final double MAX_MANA = 1000.0;

    // Atributos de ataque
    protected int ataqueBasico;
    protected int habilidadeEspecial;

    //classe secreta ----
    private String classeSecreta;
    private int abilidadeSecreta;
   

    private static final Scanner scanner = new Scanner(System.in);

    public Personagem() {
    }

    public Personagem(String nomePersonagem, String classePersonagem) {
        this.nomePersonagem = nomePersonagem;
        this.classe = classePersonagem;
    }

    public String criarPersonagem() {
        System.out.println("Digite o nome do personagem: ");
        this.nomePersonagem = scanner.nextLine().trim();

        System.out.println("Escolha a classe do personagem:");
        System.out.println("1 - Guerreiro");
        System.out.println("2 - Mago");
        System.out.println("3 - Arqueiro");

        int opcao;
        try {
            opcao = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            opcao = 0;
        }

        switch (opcao) {
            case 1:
                this.classe = "Guerreiro";
                break;
            case 2:
                this.classe = "Mago";
                break;
            case 3:
                this.classe = "Arqueiro";
                break;
            case 64:
                System.out.println("Você descobriu a classe secreta: Assassino!");
                System.out.println("O SEU CAMINHO SERÁ SOMBRIO, MAS PODEROSO!");
                // Definindo atributos especiais para a classe secreta
                this.classe = "Monarca";
                nivel = 50;
                vida = 300;
                mana = 200;
                ataqueBasico = 50;

                System.out.println("Assassino - Agora voce é um monarca!");
                System.out.println("Nível: " + nivel);
                System.out.println("Vida: " + vida);
                System.out.println("Mana: " + mana);
                break;
            default:
                System.out.println("Opção inválida. Classe padrão será 'Guerreiro'.");
                this.classe = "Guerreiro";
                break;
        }

        System.out.println("Agora você tem um personagem!");
        menuPersonagem();

        return "Personagem criado com sucesso!";
    }

    public int subirNivel() {
        int bonusVida;
        int bonusMana;

        switch (classe) {
            case "Guerreiro":
                bonusVida = 30;
                bonusMana = 6;
                break;
            case "Mago":
                bonusVida = 6;
                bonusMana = 30;
                break;
            case "Arqueiro":
                bonusVida = 15;
                bonusMana = 15;
                break;
            default:
                bonusVida = 20;
                bonusMana = 10;
                break;
        }

        nivel++;
        vida += bonusVida;
        mana += bonusMana;

        System.out.println("Parabéns! " + nomePersonagem + " subiu para o nível " + nivel + "!");
        System.out.println("Como " + classe + ", você ganhou +" + bonusVida
                + " de vida e +" + bonusMana + " de mana!");
        return nivel;
    }

    public int habilidade(Personagem personagem) {
        
        int danoAbilidadeEspecial;
        String habilidades = personagem.getClasse();
        String nomeHabilidadeEspecial ="";

        switch (habilidades) {
            case "Guerreiro":
                nomeHabilidadeEspecial = "Corte do Rei";
                mana = 15;
                if (personagem.getNivel() >= 15) {
                    danoAbilidadeEspecial = 90;
                } else {
                    danoAbilidadeEspecial = 20;
                }
                break;
            case "Mago":
                nomeHabilidadeEspecial = "Bola de Fogo";
                mana = 20;
                if (personagem.getNivel() >= 10) {
                    danoAbilidadeEspecial = 60;
                } else {
                    danoAbilidadeEspecial = 25;
                }
                break;
            case "Arqueiro":
                nomeHabilidadeEspecial = "Tiro Certeiro";
                mana = 10;
                if (personagem.getNivel() >= 5) {
                    danoAbilidadeEspecial = 35;
                } else {
                    danoAbilidadeEspecial = 15;
                }
                break;
            default:
                nomeHabilidadeEspecial = "Habilidade Desconhecida";
                break;
        }

        return danoAbilidadeEspecial = habilidadeEspecial;
    }

    public int ataqueBasico(Personagem personagem) {
        int danoBase;
        String Pclasse = personagem.getClasse();

        switch (Pclasse = personagem.getClasse()) {
            case "Guerreiro":
                danoBase = 20;
                System.out.println(personagem.getNomePersonagem() + " usou Golpe de Espada e causou " + danoBase + " de dano!");
                break;
            case "Mago":
                danoBase = 25;
                System.out.println(personagem.getNomePersonagem() + " usou Bola de Fogo e causou " + danoBase + " de dano!");
                break;
            case "Arqueiro":
                danoBase = 15;
                System.out.println(personagem.getNomePersonagem() + " usou Tiro Certeiro e causou " + danoBase + " de dano!");
                break;
            default:
                System.out.println("Classe desconhecida. Nenhuma habilidade foi usada.");
                break;
        }
         return danoBase = ataqueBasico;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }
    public String getClasse() {
        return classe;
    }
    public int getNivel() {
        return nivel;
    }
    public int getVida() {
        return vida;
    }
    public double getMana() {
        return mana;
    }

    public void menuPersonagem() {
        System.out.println("Nome: " + nomePersonagem);
        System.out.println("Classe: " + classe);
        System.out.println("Nível: " + nivel);
        System.out.println("Vida: " + vida);
        System.out.println("Mana: " + mana);

    }
}