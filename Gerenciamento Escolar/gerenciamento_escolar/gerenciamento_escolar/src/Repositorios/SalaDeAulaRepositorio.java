package Repositorios;

import ConfiguracaoBancoDeDados.Conexao;
import Modelos.Aluno;
import Repositorios.Contratos.ISalaDeAulaRepositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class SalaDeAulaRepositorio implements ISalaDeAulaRepositorio {
    @Override
    public int gerarSalaDeAula() throws Exception {
        String sql = "INSERT INTO SALADEAULA (CODIGOSALADEAULA) VALUES (DEFAULT) RETURNING CODIGOSALADEAULA";

        Connection connection = Conexao.criarConexaoComBancoDeDados();

        Statement statement = connection.createStatement();

        int codigoSalaGerada = 0; //o campo serial no postgres gera numeros >= 1, então se o retorno for zero, significa que nada foi inserido
        ResultSet result = statement.executeQuery(sql);
        if (result.next()) {
            codigoSalaGerada = result.getInt("CODIGOSALADEAULA");
        }

        result.close();
        statement.close();
        connection.close();

        return codigoSalaGerada;
    }

    @Override
    public void excluirSalaDeAula(int codigo) throws Exception {
        String sql = "DELETE FROM SALADEAULA WHERE CODIGOSALADEAULA = ?";

        Connection connection = Conexao.criarConexaoComBancoDeDados();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, codigo);

        ps.executeUpdate();

        ps.close();
        connection.close();
    }

    @Override
    public void editarProfessorDaSala(int codigoSala, int codigoNovoProfessor) throws Exception {
        String sql = "UPDATE PROFESSOR_SALADEAULA SET CODIGOPROFESSOR = ? WHERE CODIGOSALADEAULA = ?";

        Connection connection = Conexao.criarConexaoComBancoDeDados();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, codigoNovoProfessor);
        ps.setInt(2, codigoSala);

        ps.executeUpdate();

        ps.close();
        connection.close();
    }

    @Override
    public void inserirAluno(int codigoSala, int matricula) throws Exception {
        String sql = "UPDATE ALUNO SET CODIGOSALADEAULA = ? WHERE MATRICULA = ?";

        Connection connection = Conexao.criarConexaoComBancoDeDados();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, codigoSala);
        ps.setInt(2, matricula);

        ps.executeUpdate();

        ps.close();
        connection.close();
    }

    @Override
    public void removerAlunos(ArrayList<Integer> matriculas) throws Exception {
        String sql = "UPDATE ALUNO SET CODIGOSALADEAULA = NULL WHERE MATRICULA IN (?)";

        Connection connection = Conexao.criarConexaoComBancoDeDados();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, String.join(",", matriculas.stream().map(String::valueOf).collect(Collectors.joining(","))));

        ps.executeUpdate();

        ps.close();
        connection.close();
    }

    @Override
    public ArrayList<Aluno> encontrarAlunosDaSala(int codigoSala) throws Exception {
        String sql = "SELECT MATRICULA, NOME, SOBRENOME, CODIGOSALADEAULA FROM ALUNO WHERE CODIGOSALADEAULA = ?";

        Connection connection = Conexao.criarConexaoComBancoDeDados();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, codigoSala);

        ArrayList<Aluno> alunos = new ArrayList<>();
        ResultSet result = ps.executeQuery(sql);
        while (result.next()) {
            int matricula = result.getInt("MATRICULA");
            String nome = result.getString("NOME");
            String sobreNome = result.getString("SOBRENOME");
            Integer codigoSalaDeAula = result.getInt("USTELEFONE");
            if (result.wasNull()) {
                codigoSalaDeAula = null;
            }

            Aluno aluno = new Aluno(matricula, nome, sobreNome, codigoSalaDeAula);
            alunos.add(aluno);
        }

        result.close();
        ps.close();
        connection.close();

        return alunos;
    }
}