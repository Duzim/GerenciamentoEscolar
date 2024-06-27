package Modelos;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class PessoaJSON {
    private String nome;
    private String sobrenome;
    private int idade;

    public PessoaJSON(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String toJson() {
        JSONObject json = new JSONObject();
        json.put("nome", nome);
        json.put("sobrenome", sobrenome);
        return json.toString();
    }

    public static void JSONAlunos(List<Pessoa> alunos, String nomeArquivo) {
        JSONArray jsonArray = new JSONArray();
        for (Pessoa aluno : alunos) {
            jsonArray.put(new JSONObject(aluno.json()));
        }

        try (OutputStream outputStream = new FileOutputStream(nomeArquivo)) {
            byte[] bytes = jsonArray.toString().getBytes();
            outputStream.write(bytes);
            System.out.println("Arquivo salvo com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
