package Modelos;

public class Professor extends Pessoa {
    private int codigo;
    private String disciplina;

    public Professor(String nome, String sobrenome, String disciplina) {
        super(nome, sobrenome);
        this.disciplina = disciplina;
    }

    public Professor(int codigo, String nome, String sobrenome, String disciplina) {
        super(nome, sobrenome);
        this.codigo = codigo;
        this.disciplina = disciplina;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}