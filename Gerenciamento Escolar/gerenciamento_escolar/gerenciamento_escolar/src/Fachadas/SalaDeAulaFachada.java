package Fachadas;

import Controladores.Contratos.ISalaDeAulaControlador;
import Controladores.SalaDeAulaControlador;
import Fachadas.Contratos.ISalaDeAulaFachada;
import Modelos.Aluno;

import java.util.ArrayList;

public class SalaDeAulaFachada implements ISalaDeAulaFachada {
    private ISalaDeAulaControlador _salaDeAulaControlador;

    public SalaDeAulaFachada() {
        this._salaDeAulaControlador = new SalaDeAulaControlador();
    }

    @Override
    public int gerarSalaDeAula() throws Exception {
        return this._salaDeAulaControlador.gerarSalaDeAula();
    }

    @Override
    public void excluirSalaDeAula(int codigo) throws Exception {
        this.excluirSalaDeAula(codigo);
    }

    @Override
    public void editarProfessorDaSala(int codigoSala, int codigoNovoProfessor) throws Exception {
        this._salaDeAulaControlador.editarProfessorDaSala(codigoSala, codigoNovoProfessor);
    }

    @Override
    public void inserirAluno(int codigoSala, int matricula) throws Exception {
        this._salaDeAulaControlador.inserirAluno(codigoSala, matricula);
    }

    @Override
    public void removerAlunos(ArrayList<Integer> matriculas) throws Exception {
        this._salaDeAulaControlador.removerAlunos(matriculas);
    }

    @Override
    public ArrayList<Aluno> encontrarAlunosDaSala(int codigoSala, boolean isOrdenarPorOrdemAlfabetica) throws Exception {
        return this._salaDeAulaControlador.encontrarAlunosDaSala(codigoSala, isOrdenarPorOrdemAlfabetica);
    }
}