package Servicos;

import Modelos.Professor;
import Repositorios.Contratos.IProfessorRepositorio;
import Repositorios.ProfessorRepositorio;
import Servicos.Contratos.IProfessorServico;

import java.util.ArrayList;

public class ProfessorServico implements IProfessorServico {

    private IProfessorRepositorio _professorRepositorio;

    public ProfessorServico() {
        _professorRepositorio = new ProfessorRepositorio();
    }

    @Override
    public void inserirProfessor(Professor professor) throws Exception {
        validarNomeDoProfessor(professor.getNome());
        validarSobrenomeDoProfessor(professor.getSobrenome());
        validarDisciplina(professor.getDisciplina());

        Professor professorExistente = this._professorRepositorio.encontrarProfessorPorNomeCompleto(professor.getNome() + " " + professor.getSobrenome());
        if (professorExistente != null) {
            throw new Exception("Registro existente! Um professor com este nome já está cadastrado.");
        }

        this._professorRepositorio.inserirProfessor(professor);
    }

    @Override
    public void editarProfessor(Professor professor) throws Exception {
        validarCodigoDoProfessor(professor.getCodigo());

        Professor professorExistente = this._professorRepositorio.encontrarProfessorPorCodigo(professor.getCodigo());
        if (professorExistente == null) {
            throw new Exception("Registro inexistente! Não foi encontrado nenhum professor com este código.");
        }

        validarNomeDoProfessor(professor.getNome());
        validarSobrenomeDoProfessor(professor.getSobrenome());
        validarDisciplina(professor.getDisciplina());

        this._professorRepositorio.editarProfessor(professor);
    }

    @Override
    public void excluirProfessor(int codigo) throws Exception {
        validarCodigoDoProfessor(codigo);

        Professor professorExistente = this._professorRepositorio.encontrarProfessorPorCodigo(codigo);
        if (professorExistente == null) {
            throw new Exception("Registro inexistente! Não foi encontrado nenhum professor com este código.");
        }

        this._professorRepositorio.excluirProfessor(codigo);
    }

    @Override
    public ArrayList<Professor> encontrarTodosProfessores() throws Exception {
        return this._professorRepositorio.encontrarTodosProfessores();
    }

    @Override
    public Professor encontrarProfessorPorCodigo(int codigo) throws Exception {
        validarCodigoDoProfessor(codigo);

        Professor professor = this._professorRepositorio.encontrarProfessorPorCodigo(codigo);
        if (professor == null) {
            throw new Exception("Registro inexistente! Não foi encontrado nenhum professor com este código.");
        }

        return professor;
    }

    @Override //MUDAR RETORNO PARA LISTA
    public ArrayList<Professor> encontrarProfessorPorNome(String nome) throws Exception {
        validarNomeDoProfessor(nome);

        ArrayList<Professor> professores = this._professorRepositorio.encontrarProfessorPorNome(nome);
        if (professores == null || professores.size() == 0) {
            throw new Exception("Registro inexistente! Não foi encontrado nenhum professor com este nome.");
        }

        return professores;
    }

    @Override //MUDAR RETORNO PARA LISTA
    public ArrayList<Professor> encontrarProfessorPorSobrenome(String sobrenome) throws Exception {
        validarSobrenomeDoProfessor(sobrenome);

        ArrayList<Professor> professores = this._professorRepositorio.encontrarProfessorPorSobrenome(sobrenome);
        if (professores == null || professores.size() == 0) {
            throw new Exception("Registro inexistente! Não foi encontrado nenhum professor com este sobrenome.");
        }

        return professores;
    }

    @Override
    public Professor encontrarProfessorPorNomeCompleto(String nomeCompleto) throws Exception {
        validarNomeCompleto(nomeCompleto);

        Professor professor = this._professorRepositorio.encontrarProfessorPorNomeCompleto(nomeCompleto);
        if (professor == null) {
            throw new Exception("Registro inexistente! Não foi encontrado nenhum professor com este nome completo.");
        }

        return professor;
    }

    private void validarCodigoDoProfessor(int codigo) {
        if (codigo == 0 || codigo < 0) {
            throw new IllegalArgumentException("O código deve ser um número inteiro e positivo.");
        }
    }

    private void validarNomeDoProfessor(String nome) {
        if (nome == null || nome.equals("") || nome.equals(" ")) {
            throw new IllegalArgumentException("O nome do professor deve estar preenchido.");
        }

        if (nome.length() < 3 || nome.length() > 30) {
            throw new IllegalArgumentException("O nome do professor deve possuir no mínimo 3 caracteres e no máximo 30.");
        }
    }

    private void validarSobrenomeDoProfessor(String nome) {
        if (nome == null || nome.equals("") || nome.equals(" ")) {
            throw new IllegalArgumentException("O sobrenome do professor deve estar preenchido.");
        }

        if (nome.length() < 3 || nome.length() > 30) {
            throw new IllegalArgumentException("O sobrenome do professor deve possuir no mínimo 3 caracteres e no máximo 70.");
        }
    }

    private void validarNomeCompleto(String nomeCompleto) {
        if (nomeCompleto == null || nomeCompleto.equals("") || nomeCompleto.equals(" ")) {
            throw new IllegalArgumentException("O nome completo do professor deve estar preenchido.");
        }

        if (nomeCompleto.length() < 3 || nomeCompleto.length() > 100) {
            throw new IllegalArgumentException("O nome completo do professor deve possuir no mínimo 3 caracteres e no máximo 100.");
        }
    }

    private void validarDisciplina(String disciplina) {
        if (disciplina == null || disciplina.equals("") || disciplina.equals(" ")) {
            throw new IllegalArgumentException("A disciplina deve estar preenchida.");
        }

        if (disciplina.length() < 10 || disciplina.length() > 100) {
            throw new IllegalArgumentException("A disciplina deve possuir no mínimo 10 caracteres e no máximo 100.");
        }
    }
}