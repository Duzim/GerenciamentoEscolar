package Fachadas;

import Controladores.AlunoControlador;
import Controladores.Contratos.IAlunoControlador;
import Fachadas.Contratos.IAlunoFachada;
import Modelos.Aluno;

import java.util.ArrayList;

public class AlunoFachada implements IAlunoFachada {
    private IAlunoControlador _alunoControlador;

    public AlunoFachada() {
        this._alunoControlador = new AlunoControlador();
    }

    @Override
    public void inserirAluno(Aluno aluno) throws Exception {
        this._alunoControlador.inserirAluno(aluno);
    }

    @Override
    public void editarAluno(Aluno aluno) throws Exception {
        this._alunoControlador.editarAluno(aluno);
    }

    @Override
    public void excluirAluno(int matricula) throws Exception {
        this._alunoControlador.excluirAluno(matricula);
    }

    @Override
    public ArrayList<Aluno> encontrarTodosAlunos() throws Exception {
        return this._alunoControlador.encontrarTodosAlunos();
    }

    @Override
    public Aluno encontrarAlunoPorMatricula(int matricula) throws Exception {
        return this._alunoControlador.encontrarAlunoPorMatricula(matricula);
    }
}