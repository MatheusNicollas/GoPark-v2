package modelo;

public class Funcionario {

    @Override
    public String toString() {
        return "<td>" + id + "</td><td>" + cpf + "</td><td>" + nome + "</td><td>" +
                login + "</td><td>" + senha + "</td><td>" + cargo.getNome() + "</td>";
    }

    public Funcionario(int id, String cpf, String nome, String login, String senha, Cargo cargo) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;
    }
    private int id;
    private String cpf;    
    private String nome;    
    private String login;
    private String senha;
    private Cargo cargo;

    Funcionario() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
