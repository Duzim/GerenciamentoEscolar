package Fachadas;

import Controladores.Contratos.IProfessorControlador;
import Controladores.ProfessorControlador;
import Fachadas.Contratos.IProfessorFachada;
import Modelos.Professor;

import java.util.ArrayList;

public class ProfessorFachada implements IProfessorFachada {
    private IProfessorControlador _professorControlador;

    public ProfessorFachada() {
        this._professorControlador = new ProfessorControlador();
    }

    @Override
    public void inserirProfessor(Professor professor) throws Exception {
        this._professorControlador.inserirProfessor(professor);
    }

    @Override
    public void editarProfessor(Professor professor) throws Exception {
        this._professorControlador.editarProfessor(professor);
    }

    @Override
    public void excluirProfessor(int codigo) throws Exception {
        this._professorControlador.excluirProfessor(codigo);
    }

    @Override
    public ArrayList<Professor> encontrarTodosProfessores() throws Exception {
        return this._professorControlador.encontrarTodosProfessores();
    }

    @Override
    public Professor encontrarProfessorPorCodigo(int codigo) throws Exception {
        return this._professorControlador.encontrarProfessorPorCodigo(codigo);
    }

    @Override
    public ArrayList<Professor> encontrarProfessorPorNome(String nome) throws Exception {
        return this._professorControlador.encontrarProfessorPorNome(nome);
    }

    @Override
    public ArrayList<Professor> encontrarProfessorPorSobrenome(String sobrenome) throws Exception {
        return this._professorControlador.encontrarProfessorPorSobrenome(sobrenome);
    }

    @Override
    public Professor encontrarProfessorPorNomeCompleto(String nomeCompleto) throws Exception {
        return this._professorControlador.encontrarProfessorPorNomeCompleto(nomeCompleto);
    }
}