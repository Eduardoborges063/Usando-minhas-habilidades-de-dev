package Modulos;

import java.util.Scanner;
import java.util.function.Function;

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
    public boolean verificarSenha(String senha) {
     return this.senha.equals(senha);
    }

    public class CadastroUsuario {
 
    private static final int MAX_TENTATIVAS = 3;
    private static final Scanner scanner = new Scanner(System.in);
 
    // ---------- Validadores: retornam a mensagem de erro, ou null se válido ----------
 
    private static String validarNome(String nome) {
        if (nome.isEmpty()) {
            return "Nome não pode ser vazio.";
        }
        if (nome.length() < 3) {
            return "Nome muito curto. Use pelo menos 3 caracteres.";
        }
        if (nome.length() > 50) {
            return "Nome muito longo. Use no máximo 50 caracteres.";
        }
        return null;
    }
 
    private static String validarEmail(String email) {
        if (email.isEmpty()) {
            return "Email não pode ser vazio.";
        }
        if (!email.matches("^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$")) {
            return "Email inválido.";
        }
        return null;
    }
 
    private static String validarSenha(String senha) {
        if (senha.length() < 6) {
            return "Senha muito curta. Use pelo menos 6 caracteres.";
        }
        if (senha.length() > 50) {
            return "Senha muito longa. Use no máximo 50 caracteres.";
        }
        if (!senha.matches(".*[A-Z].*")) {
            return "Senha deve conter pelo menos uma letra maiúscula.";
        }
        if (!senha.matches(".*[a-z].*")) {
            return "Senha deve conter pelo menos uma letra minúscula.";
        }
        if (!senha.matches(".*\\d.*")) {
            return "Senha deve conter pelo menos um número.";
        }
        if (!senha.matches(".*[!@#$%^&*()].*")) {
            return "Senha deve conter pelo menos um caractere especial (!@#$%^&*()).";
        }
        return null;
    }
 
    // ---------- Leitura com novas tentativas ----------
 
    /**
     * Pede o campo ao usuário e valida. Repete até MAX_TENTATIVAS vezes.
     * Retorna o valor válido, ou null se esgotar as tentativas.
     *
     * @param aparar se true, remove espaços do início/fim 
     */
    private static String lerCampo(String prompt, Function<String, String> validador, boolean aparar) {
        for (int tentativa = 1; tentativa <= MAX_TENTATIVAS; tentativa++) {
            System.out.print(prompt);
            String valor = scanner.nextLine();
            if (aparar) {
                valor = valor.trim();
            }
 
            String erro = validador.apply(valor);
            if (erro == null) {
                return valor;
            }
 
            System.out.println(erro);
            int restantes = MAX_TENTATIVAS - tentativa;
            if (restantes > 0) {
                System.out.println("Tente novamente (" + restantes + " tentativa(s) restante(s)).");
            }
        }
        return null;
    }
 
    // ---------- Cadastro ----------
 
    public static String cadastrar() {
        System.out.println("Olá usuário, vamos te cadastrar!");
 
        String nome = lerCampo("Digite seu nome: ", CadastroUsuario::validarNome, true);
        if (nome == null) {
            return "Falha ao criar usuário: número máximo de tentativas no nome.";
        }
 
        String email = lerCampo("Digite seu email: ", CadastroUsuario::validarEmail, true);
        if (email == null) {
            return "Falha ao criar usuário: número máximo de tentativas no email.";
        }
 
        String senha = lerCampo("Digite sua senha: ", CadastroUsuario::validarSenha, false);
        if (senha == null) {
            return "Falha ao criar usuário: número máximo de tentativas na senha.";
        }

        Personagem personagem = new Personagem();
        personagem.criarPersonagem();
        personagem.menuPersonagem();
 
        // Aqui você criaria o objeto Usuario / salvaria no banco
        return "Usuário " + nome + " criado com sucesso!";
    }
 
    public static void main(String[] args) {
        System.out.println(cadastrar());
    }
}

    public boolean logarUsuario(Scanner scanner) {
        System.out.println("Email: ");
        String emailDigitado = scanner.nextLine();
        System.out.println("Senha: ");
        String senhaDigitada = scanner.nextLine();

        if (emailDigitado.equals(this.email) && senhaDigitada.equals(this.senha)) {
            System.out.println("Login realizado com sucesso!");
            return true;
        }
        System.out.println("Email ou senha incorretos.");
        return false;
    }
    
    public void menuUsuario(Usuario usuario){
        System.out.println("Nome: \n" + usuario.nome);
        System.out.println("Email: \n" + usuario.email);
        System.out.println("Personagem: \n" + usuario.personagem);

    }
}
 
