package Controladores;

import Controladores.Contratos.ISalaDeAulaControlador;
import Modelos.Aluno;
import Servicos.Contratos.ISalaDeAulaServico;
import Servicos.SalaDeAulaServico;

import java.util.ArrayList;

public class SalaDeAulaControlador implements ISalaDeAulaControlador {
    private ISalaDeAulaServico _salaDeAulaServico;

    public SalaDeAulaControlador() {
        this._salaDeAulaServico = new SalaDeAulaServico();
    }

    @Override
    public int gerarSalaDeAula() throws Exception {
        return this._salaDeAulaServico.gerarSalaDeAula();
    }

    @Override
    public void excluirSalaDeAula(int codigo) throws Exception {
        this.excluirSalaDeAula(codigo);
    }

    @Override
    public void editarProfessorDaSala(int codigoSala, int codigoNovoProfessor) throws Exception {
        this.editarProfessorDaSala(codigoSala, codigoNovoProfessor);
    }

    @Override
    public void inserirAluno(int codigoSala, int matricula) throws Exception {
        this.inserirAluno(codigoSala, matricula);
    }

    @Override
    public void removerAlunos(ArrayList<Integer> matriculas) throws Exception {
        this.removerAlunos(matriculas);
    }

    @Override
    public ArrayList<Aluno> encontrarAlunosDaSala(int codigoSala, boolean isOrdenarPorOrdemAlfabetica) throws Exception {
        return this.encontrarAlunosDaSala(codigoSala, isOrdenarPorOrdemAlfabetica);
    }
}