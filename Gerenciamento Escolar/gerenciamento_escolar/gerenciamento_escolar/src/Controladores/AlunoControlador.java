package Controladores;

import Controladores.Contratos.IAlunoControlador;
import Modelos.Aluno;
import Servicos.AlunoServico;
import Servicos.Contratos.IAlunoServico;

import java.util.ArrayList;

public class AlunoControlador implements IAlunoControlador {
    private IAlunoServico _alunoServico;

    public AlunoControlador() {
        this._alunoServico = new AlunoServico();
    }

    @Override
    public void inserirAluno(Aluno aluno) throws Exception {
        this._alunoServico.inserirAluno(aluno);
    }

    @Override
    public void editarAluno(Aluno aluno) throws Exception {
        this._alunoServico.editarAluno(aluno);
    }

    @Override
    public void excluirAluno(int matricula) throws Exception {
        this._alunoServico.excluirAluno(matricula);
    }

    @Override
    public ArrayList<Aluno> encontrarTodosAlunos() throws Exception {
        return this._alunoServico.encontrarTodosAlunos();
    }

    @Override
    public Aluno encontrarAlunoPorMatricula(int matricula) throws Exception {
        return this._alunoServico.encontrarAlunoPorMatricula(matricula);
    }
}