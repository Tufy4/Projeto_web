package br.edu.ifsp.arq.dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

import br.edu.ifsp.arq.model.Avaliacao;
import br.edu.ifsp.arq.model.Receita;

public class AvaliacaoDAO {
    private static ArrayList<Avaliacao> listaDeAvaliacoes;
    private static AvaliacaoDAO instance;

    
    private AvaliacaoDAO() {
    	listaDeAvaliacoes = new ArrayList<Avaliacao>();
    }

    public static AvaliacaoDAO getInstance() {
        if (instance == null) {
            instance = new AvaliacaoDAO();
        }
        return instance;
    }
    
    
    
    private String getCaminhoArquivo() {
        String userHome = System.getProperty("user.home");
        return userHome + File.separator + "Downloads" + File.separator + "saidaAvaliacoes.json";
    }

    public boolean adicionarAvaliacao(Avaliacao a) {
        Gson gson = new Gson();

        try (FileWriter fw = new FileWriter(getCaminhoArquivo(), StandardCharsets.UTF_8, true);
             PrintWriter pw = new PrintWriter(fw)) {
            String json = gson.toJson(a);
            pw.println(json);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public ArrayList<Avaliacao> getListaAvaliacoes() {
        File f = new File(getCaminhoArquivo());
        Gson gson = new Gson();
        ArrayList<Avaliacao> lista = new ArrayList<>();

        if (!f.exists()) {
            return lista;
        }

        try (FileReader fr = new FileReader(f);
             Scanner sc = new Scanner(fr)) {

            while (sc.hasNextLine()) {
                String linha = sc.nextLine().trim();

                if (linha.isEmpty()) continue;

                try {
                    Avaliacao a = gson.fromJson(linha, Avaliacao.class);
                    if (a != null) {
                        lista.add(a);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public ArrayList<Avaliacao> buscarPorReceita(int receitaId) {
        ArrayList<Avaliacao> resultado = new ArrayList<>();
        for (Avaliacao a : getListaAvaliacoes()) {
            if (a.getReceitaId() == receitaId) {
                resultado.add(a);
            }
        }
        return resultado;
    }

    public boolean salvarListaAvaliacoes(ArrayList<Avaliacao> lista) {
        Gson gson = new Gson();

        try (FileWriter fw = new FileWriter(getCaminhoArquivo(), StandardCharsets.UTF_8);
             PrintWriter pw = new PrintWriter(fw)) {
            for (Avaliacao a : lista) {
                String json = gson.toJson(a);
                pw.println(json);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean atualizarAvaliacao(Avaliacao avaliacaoAtualizada) {
        ArrayList<Avaliacao> lista = getListaAvaliacoes();
        boolean atualizado = false;

        for (int i = 0; i < lista.size(); i++) {
            Avaliacao a = lista.get(i);
            if (a.getId() == avaliacaoAtualizada.getId()) {
                lista.set(i, avaliacaoAtualizada);
                atualizado = true;
                break;
            }
        }

        if (atualizado) {
            return salvarListaAvaliacoes(lista);
        }

        return false;
    }

    public void removerAvaliacaoPorId(int id) {
        ArrayList<Avaliacao> lista = getListaAvaliacoes();

        Avaliacao avaliacaoParaRemover = null;
        for (Avaliacao a : lista) {
            if (a != null && a.getId() == id) {
                avaliacaoParaRemover = a;
                break;
            }
        }

        if (avaliacaoParaRemover != null) {
            lista.remove(avaliacaoParaRemover);
            salvarListaAvaliacoes(lista);
        }
    }

    public int lastId() {
        ArrayList<Avaliacao> avaliacoes = getListaAvaliacoes();
        if (!avaliacoes.isEmpty()) {
            return avaliacoes.get(avaliacoes.size() - 1).getId() + 1;
        } else {
            return 1;
        }
    }
}
