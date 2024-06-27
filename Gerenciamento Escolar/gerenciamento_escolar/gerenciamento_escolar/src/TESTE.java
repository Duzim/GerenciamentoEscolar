import Modelos.PessoaJSON;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TESTE {
    public static void main(String[] args) {
        List<PessoaJSON> alunos = new ArrayList<>();
        alunos.add(new PessoaJSON("João", 20));
        alunos.add(new PessoaJSON("Maria", 22));
        alunos.add(new PessoaJSON("Pedro", 19));

        salvarListaAlunos(alunos, "alunos.json");

        List<PessoaJSON> alunosLidos = lerListaAlunos("alunos.json");
        for (PessoaJSON aluno : alunosLidos) {
            System.out.println("Nome: " + aluno.getNome() + ", Sobrenome: " + aluno.getSobrenome());
        }
    }

    public static void salvarListaAlunos(List<PessoaJSON> alunos, String nomeArquivo) {
        JSONArray jsonArray = new JSONArray();
        for (PessoaJSON aluno : alunos) {
            jsonArray.put(new JSONObject(aluno.toJson()));
        }

        try (OutputStream outputStream = new FileOutputStream(nomeArquivo)) {
            byte[] bytes = jsonArray.toString().getBytes();
            outputStream.write(bytes);
            System.out.println("Arquivo salvo com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PessoaJSON> lerListaAlunos(String nomeArquivo) {
        List<PessoaJSON> alunosLidos = new ArrayList<>();

        try (InputStream inputStream = new FileInputStream(nomeArquivo)) {
            byte[] bytes = inputStream.readAllBytes();
            String jsonString = new String(bytes, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String nome = jsonObject.getString("nome");
                String sobrenome = jsonObject.getInt("sobrenome");
                PessoaJSON aluno = new PessoaJSON(nome, sobrenome);
                alunosLidos.add(aluno);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return alunosLidos;
    }
}