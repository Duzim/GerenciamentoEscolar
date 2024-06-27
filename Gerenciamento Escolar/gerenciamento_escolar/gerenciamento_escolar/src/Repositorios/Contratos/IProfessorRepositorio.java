package Repositorios.Contratos;

import Modelos.Professor;

import java.util.ArrayList;

public interface IProfessorRepositorio {
    void inserirProfessor(Professor professor) throws Exception;
    void editarProfessor(Professor professor) throws Exception;
    void excluirProfessor(int codigo) throws Exception;
    ArrayList<Professor> encontrarTodosProfessores() throws Exception;
    Professor encontrarProfessorPorCodigo(int codigo) throws Exception;
    ArrayList<Professor> encontrarProfessorPorNome(String nome) throws Exception;
    ArrayList<Professor> encontrarProfessorPorSobrenome(String sobrenome) throws Exception;
    Professor encontrarProfessorPorNomeCompleto(String nomeCompleto) throws Exception;
}