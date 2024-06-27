package Servicos.Contratos;

import Modelos.Aluno;

import java.util.ArrayList;

public interface IAlunoServico {
    void inserirAluno(Aluno aluno) throws Exception;

    void editarAluno(Aluno aluno) throws Exception;

    void excluirAluno(int matricula) throws Exception;

    ArrayList<Aluno> encontrarTodosAlunos() throws Exception;;
    Aluno encontrarAlunoPorMatricula(int matricula) throws Exception;
}