package Repositorios;

import ConfiguracaoBancoDeDados.Conexao;
import Modelos.Aluno;
import Repositorios.Contratos.IAlunoRepositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AlunoRepositorio implements IAlunoRepositorio {
    @Override
    public void inserirAluno(Aluno aluno) throws Exception {
        String sql = "INSERT INTO ALUNO(MATRICULA, NOME, SOBRENOME, CODIGOSALADEAULA) VALUES (?, ?, ?, NULL);";

        Connection connection = Conexao.criarConexaoComBancoDeDados();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, aluno.getMatricula());
        ps.setString(2, aluno.getNome());
        ps.setString(3, aluno.getSobrenome());

        ps.executeUpdate();

        ps.close();
        connection.close();
    }

    @Override
    public void editarAluno(Aluno aluno) throws Exception {
        String sql = "UPDATE ALUNO SET NOME = ?, SOBRENOME = ? WHERE MATRICULA = ?";

        Connection connection = Conexao.criarConexaoComBancoDeDados();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, aluno.getNome());
        ps.setString(2, aluno.getSobrenome());
        ps.setInt(3, aluno.getMatricula());

        ps.executeUpdate();

        ps.close();
        connection.close();
    }

    @Override
    public void excluirAluno(int matricula) throws Exception {
        String sql = "DELETE FROM ALUNO WHERE MATRICULA = ?";

        Connection connection = Conexao.criarConexaoComBancoDeDados();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, matricula);

        ps.executeUpdate();

        ps.close();
        connection.close();
    }

    @Override
    public ArrayList<Aluno> encontrarTodosAlunos() throws Exception {
        String sql = "SELECT MATRICULA, NOME, SOBRENOME, CODIGOSALADEAULA FROM ALUNO";

        Connection connection = Conexao.criarConexaoComBancoDeDados();

        Statement statement = connection.createStatement();

        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        ResultSet result = statement.executeQuery(sql);
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
        statement.close();
        connection.close();

        return alunos;
    }

    @Override
    public Aluno encontrarAlunoPorMatricula(int matricula) throws Exception {
        String sql = "SELECT MATRICULA, NOME, SOBRENOME, CODIGOSALADEAULA FROM ALUNO WHERE MATRICULA = ?";

        Connection connection = Conexao.criarConexaoComBancoDeDados();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, matricula);

        Aluno aluno = null;
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            String nome = result.getString("NOME");
            String sobreNome = result.getString("SOBRENOME");
            Integer codigoSalaDeAula = result.getInt("USTELEFONE");
            if (result.wasNull()) {
                codigoSalaDeAula = null;
            }

            aluno = new Aluno(matricula, nome, sobreNome, codigoSalaDeAula);
        }

        result.close();
        ps.close();
        connection.close();

        return aluno;
    }
}