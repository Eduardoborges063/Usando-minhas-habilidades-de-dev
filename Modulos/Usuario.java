package Modulos;

public class Usuario {
    protected String nome;
    protected String email;
    private String senha;

    Personagem personagem;
     
    public Usuario(String nome, String email, String senha, Personagem personagem) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.personagem = personagem;
    }
    
    
    public void menuUsuario(Usuario usuario){
        System.out.println("Nome: \n" + usuario.nome);
        System.out.println("Email: \n" + usuario.email);
        System.out.println("Personagem: \n" + usuario.personagem);

    }
}
 class Personagem {
    protected String nome;
    protected String classe;
    protected int nivel;
    protected int vida;
    protected int mana;

    public void personagem(String nome, String classe, int nivel, int vida, int mana){
        this.nome = nome;
        this.classe = classe;
        this.nivel = nivel;
        this.vida = vida;
        this.mana = mana;
    }
}