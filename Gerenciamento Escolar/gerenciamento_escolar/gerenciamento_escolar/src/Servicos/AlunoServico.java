package Servicos;

import Modelos.Aluno;
import Repositorios.AlunoRepositorio;
import Repositorios.Contratos.IAlunoRepositorio;
import Servicos.Contratos.IAlunoServico;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class AlunoServico implements IAlunoServico {
    private IAlunoRepositorio _alunoRepositorio;

    public AlunoServico() {
        this._alunoRepositorio = new AlunoRepositorio();
    }

    @Override
    public void inserirAluno(Aluno aluno) throws Exception {
        validarMatriculaAluno(aluno.getMatricula());

        Aluno alunoExistente = this._alunoRepositorio.encontrarAlunoPorMatricula(aluno.getMatricula());
        if (alunoExistente != null) {
            throw new Exception("Registro existente! Um aluno com esta matrícula já está cadastrado.");
        }

        validarNomeDoAluno(aluno.getNome());
        validarSobrenomeDoAluno(aluno.getSobrenome());

        this._alunoRepositorio.inserirAluno(aluno);
    }

    @Override
    public void editarAluno(Aluno aluno) throws Exception {
        validarMatriculaAluno(aluno.getMatricula());

        Aluno alunoExistente = this._alunoRepositorio.encontrarAlunoPorMatricula(aluno.getMatricula());
        if (alunoExistente == null) {
            throw new NoSuchElementException("Registro inexistente! Não foi encontrado nenhum aluno com essa matrícula.");
        }

        validarNomeDoAluno(aluno.getNome());
        validarSobrenomeDoAluno(aluno.getSobrenome());

        this._alunoRepositorio.editarAluno(aluno);
    }

    @Override
    public void excluirAluno(int matricula) throws Exception {
        validarMatriculaAluno(matricula);

        Aluno alunoExistente = this._alunoRepositorio.encontrarAlunoPorMatricula(matricula);
        if (alunoExistente == null) {
            throw new NoSuchElementException("Registro inexistente! Não foi encontrado nenhum aluno com essa matrícula.");
        }

        this._alunoRepositorio.excluirAluno(matricula);
    }

    @Override
    public ArrayList<Aluno> encontrarTodosAlunos() throws Exception {
        return this._alunoRepositorio.encontrarTodosAlunos();
    }

    @Override
    public Aluno encontrarAlunoPorMatricula(int matricula) throws Exception {
        validarMatriculaAluno(matricula);

        Aluno aluno = this._alunoRepositorio.encontrarAlunoPorMatricula(matricula);
        if (aluno == null) {
            throw new NoSuchElementException("Registro inexistente! Não foi encontrado nenhum aluno com essa matrícula.");
        }

        return aluno;
    }

    private void validarMatriculaAluno(int matricula) {
        if (matricula == 0 || matricula < 0) {
            throw new IllegalArgumentException("A matrícula deve ser um número inteiro e positivo.");
        }
    }

    private void validarNomeDoAluno(String nome) {
        if (nome == null || nome.equals("") || nome.equals(" ")) {
            throw new IllegalArgumentException("O nome do aluno deve estar preenchido.");
        }

        if (nome.length() < 3 || nome.length() > 30) {
            throw new IllegalArgumentException("O nome do aluno deve possuir no mínimo 3 caracteres e no máximo 30.");
        }
    }

    private void validarSobrenomeDoAluno(String nome) {
        if (nome == null || nome.equals("") || nome.equals(" ")) {
            throw new IllegalArgumentException("O sobrenome do aluno deve estar preenchido.");
        }

        if (nome.length() < 3 || nome.length() > 30) {
            throw new IllegalArgumentException("O sobrenome do aluno deve possuir no mínimo 3 caracteres e no máximo 70.");
        }
    }
}