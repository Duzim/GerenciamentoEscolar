package ConfiguracaoBancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String _connectionString = "jdbc:postgresql://localhost:5432/gerenciamento_escolar";
    private static final String _databaseUser = "postgres";
    private static final String _databsePassword = "123456789";

    public static Connection criarConexaoComBancoDeDados() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(_connectionString, _databaseUser, _databsePassword);

            return connection;
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao conectar com banco de dados" + ex.getMessage());
        }
    }
}