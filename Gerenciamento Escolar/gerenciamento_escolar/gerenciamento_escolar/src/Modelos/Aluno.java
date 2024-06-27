package Modelos;

public class Aluno extends Pessoa {
    private int matricula;
    private Integer codigoSalaDeAula;

    public Aluno(int i, String nome, String sobrenome, int matricula) {
        super(nome, sobrenome);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Integer getCodigoSalaDeAula() {
        return codigoSalaDeAula;
    }

    public void setCodigoSalaDeAula(Integer codigoSalaDeAula) {
        this.codigoSalaDeAula = codigoSalaDeAula;
    }
}