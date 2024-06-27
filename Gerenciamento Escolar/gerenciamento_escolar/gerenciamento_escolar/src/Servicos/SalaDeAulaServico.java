package Servicos;

import Modelos.Aluno;
import Servicos.Contratos.ISalaDeAulaServico;

import java.util.ArrayList;

public class SalaDeAulaServico implements ISalaDeAulaServico {
    @Override
    public int gerarSalaDeAula() throws Exception {
        return 0;
    }

    @Override
    public void excluirSalaDeAula(int codigo) throws Exception {

    }

    @Override
    public void editarProfessorDaSala(int codigoSala, int codigoNovoProfessor) throws Exception {

    }

    @Override
    public void inserirAluno(int codigoSala, int matricula) throws Exception {

    }

    @Override
    public void removerAlunos(ArrayList<Integer> matriculas) throws Exception {

    }

    @Override
    public ArrayList<Aluno> encontrarAlunosDaSala(int codigoSala, boolean isOrdenarPorOrdemAlfabetica) throws Exception {
        return null;
    }
}
