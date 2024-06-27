package Repositorios;

import ConfiguracaoBancoDeDados.Conexao;
import Modelos.Professor;
import Repositorios.Contratos.IProfessorRepositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProfessorRepositorio implements IProfessorRepositorio {
    @Override
    public void inserirProfessor(Professor professor) throws Exception {
        String sql = "INSERT INTO PROFESSOR(NOME, SOBRENOME, DISCIPLINA) VALUES (?, ?, ?);";

        Connection connection = Conexao.criarConexaoComBancoDeDados();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, professor.getNome());
        ps.setString(2, professor.getSobrenome());
        ps.setString(3, professor.getDisciplina());

        ps.executeUpdate();

        ps.close();
        connection.close();
    }

    @Override
    public void editarProfessor(Professor professor) throws Exception {
        String sql = "UPDATE PROFESSOR SET NOME = ?, SOBRENOME = ?, DISCIPLINA = ?" +
                "WHERE CODIGOPROFESSOR = ?";

        Connection connection = Conexao.criarConexaoComBancoDeDados();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, professor.getNome());
        ps.setString(2, professor.getSobrenome());
        ps.setString(3, professor.getDisciplina());
        ps.setInt(4, professor.getCodigo());

        ps.executeUpdate();

        ps.close();
        connection.close();
    }

    @Override
    public void excluirProfessor(int codigo) throws Exception {
        String sql = "DELETE FROM PROFESSOR WHERE CODIGOPROFESSOR = ?";

        Connection connection = Conexao.criarConexaoComBancoDeDados();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, codigo);

        ps.executeUpdate();

        ps.close();
        connection.close();
    }

    @Override
    public ArrayList<Professor> encontrarTodosProfessores() throws Exception {
        String sql = "SELECT CODIGOPROFESSOR, NOME, SOBRENOME, DISCIPLINA FROM PROFESSOR";

        Connection connection = Conexao.criarConexaoComBancoDeDados();

        Statement statement = connection.createStatement();

        ArrayList<Professor> professores = new ArrayList<Professor>();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            int codigo = result.getInt("CODIGO");
            String nome = result.getString("NOME");
            String sobreNome = result.getString("SOBRENOME");
            String disciplina = result.getString("DISCIPLINA");

            Professor professor = new Professor(codigo, nome, sobreNome, disciplina);
            professores.add(professor);
        }

        result.close();
        statement.close();
        connection.close();

        return professores;
    }

    @Override
    public Professor encontrarProfessorPorCodigo(int codigo) throws Exception {
        String sql = "SELECT CODIGOPROFESSOR, NOME, SOBRENOME, DISCIPLINA FROM PROFESSOR WHERE CODIGOPROFESSOR = ?";

        Connection connection = Conexao.criarConexaoComBancoDeDados();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, codigo);

        Professor professor = null;
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            String nome = result.getString("NOME");
            String sobreNome = result.getString("SOBRENOME");
            String disciplina = result.getString("DISCIPLINA");

            professor = new Professor(codigo, nome, sobreNome, disciplina);
        }

        result.close();
        ps.close();
        connection.close();

        return professor;
    }

    @Override
    public ArrayList<Professor> encontrarProfessorPorNome(String nomeFiltro) throws Exception {
        String sql = "SELECT CODIGOPROFESSOR, NOME, SOBRENOME, DISCIPLINA FROM PROFESSOR WHERE NOME LIKE ?";

        Connection connection = Conexao.criarConexaoComBancoDeDados();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "%" + nomeFiltro + "%");

        ArrayList<Professor> professores = null;
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            Integer codigo = result.getInt("CODIGOPROFESSOR");
            String nome = result.getString("NOME");
            String sobreNome = result.getString("SOBRENOME");
            String disciplina = result.getString("DISCIPLINA");

            professores.add(new Professor(codigo, nome, sobreNome, disciplina));
        }

        result.close();
        ps.close();
        connection.close();

        return professores;
    }

    @Override
    public ArrayList<Professor> encontrarProfessorPorSobrenome(String sobrenomeFiltro) throws Exception {
        String sql = "SELECT CODIGOPROFESSOR, NOME, SOBRENOME, DISCIPLINA FROM PROFESSOR WHERE SOBRENOME LIKE ?";

        Connection connection = Conexao.criarConexaoComBancoDeDados();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "%" + sobrenomeFiltro + "%");

        ArrayList<Professor> professores = new ArrayList<>();
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            Integer codigo = result.getInt("CODIGOPROFESSOR");
            String nome = result.getString("NOME");
            String sobreNome = result.getString("SOBRENOME");
            String disciplina = result.getString("DISCIPLINA");

            professores.add(new Professor(codigo, nome, sobreNome, disciplina));
        }

        result.close();
        ps.close();
        connection.close();

        return professores;
    }

    @Override
    public Professor encontrarProfessorPorNomeCompleto(String nomeCompleto) throws Exception {
        String sql = "SELECT CODIGOPROFESSOR, NOME, SOBRENOME, DISCIPLINA FROM PROFESSOR WHERE CONCAT(NOME, SOBRENOME) LIKE ?";

        Connection connection = Conexao.criarConexaoComBancoDeDados();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "%" + nomeCompleto + "%");

        Professor professor = null;
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            Integer codigo = result.getInt("CODIGOPROFESSOR");
            String nome = result.getString("NOME");
            String sobreNome = result.getString("SOBRENOME");
            String disciplina = result.getString("DISCIPLINA");

            professor = new Professor(codigo, nome, sobreNome, disciplina);
        }

        result.close();
        ps.close();
        connection.close();

        return professor;
    }
}