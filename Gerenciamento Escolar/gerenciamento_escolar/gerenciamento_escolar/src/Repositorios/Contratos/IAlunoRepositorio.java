package Repositorios.Contratos;

import Modelos.Aluno;

import java.util.ArrayList;

public interface IAlunoRepositorio {
    void inserirAluno(Aluno aluno) throws Exception;

    void editarAluno(Aluno aluno) throws Exception;

    void excluirAluno(int matricula) throws Exception;

    ArrayList<Aluno> encontrarTodosAlunos() throws Exception;;
    Aluno encontrarAlunoPorMatricula(int matricula) throws Exception;
}