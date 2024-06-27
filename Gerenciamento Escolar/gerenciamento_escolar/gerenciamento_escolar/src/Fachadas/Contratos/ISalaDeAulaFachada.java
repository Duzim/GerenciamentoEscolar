package Fachadas.Contratos;

import Modelos.Aluno;

import java.util.ArrayList;

public interface ISalaDeAulaFachada {
    int gerarSalaDeAula() throws Exception;

    void excluirSalaDeAula(int codigo) throws Exception;

    void editarProfessorDaSala(int codigoSala, int codigoNovoProfessor) throws Exception;

    void inserirAluno(int codigoSala, int matricula) throws Exception;

    void removerAlunos(ArrayList<Integer> matriculas) throws Exception;

    ArrayList<Aluno> encontrarAlunosDaSala(int codigoSala, boolean isOrdenarPorOrdemAlfabetica) throws Exception;
}