package Controladores;

import Controladores.Contratos.IProfessorControlador;
import Modelos.Professor;
import Servicos.Contratos.IProfessorServico;
import Servicos.ProfessorServico;

import java.util.ArrayList;

public class ProfessorControlador implements IProfessorControlador {
    private IProfessorServico _professorServico;

    public ProfessorControlador() {
        _professorServico = new ProfessorServico();
    }

    @Override
    public void inserirProfessor(Professor professor) throws Exception {
        this._professorServico.inserirProfessor(professor);
    }

    @Override
    public void editarProfessor(Professor professor) throws Exception {
        this._professorServico.editarProfessor(professor);
    }

    @Override
    public void excluirProfessor(int codigo) throws Exception {
        this._professorServico.excluirProfessor(codigo);
    }

    @Override
    public ArrayList<Professor> encontrarTodosProfessores() throws Exception {
        return this._professorServico.encontrarTodosProfessores();
    }

    @Override
    public Professor encontrarProfessorPorCodigo(int codigo) throws Exception {
        return this.encontrarProfessorPorCodigo(codigo);
    }

    @Override
    public ArrayList<Professor> encontrarProfessorPorNome(String nome) throws Exception {
        return this._professorServico.encontrarProfessorPorNome(nome);
    }

    @Override
    public ArrayList<Professor> encontrarProfessorPorSobrenome(String sobrenome) throws Exception {
        return this._professorServico.encontrarProfessorPorSobrenome(sobrenome);
    }

    @Override
    public Professor encontrarProfessorPorNomeCompleto(String nomeCompleto) throws Exception {
        return this._professorServico.encontrarProfessorPorNomeCompleto(nomeCompleto);
    }
}