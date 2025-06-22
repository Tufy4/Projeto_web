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

import br.edu.ifsp.arq.model.Usuario;

public class UsuarioDAO {
    private static UsuarioDAO instance;

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }

    public boolean adicionarUsuarios(Usuario t) {
        Gson gson = new Gson();
        try (FileWriter fw = new FileWriter("/home/miguel/Downloads/saidaUsuario.json", StandardCharsets.UTF_8, true);
             PrintWriter pw = new PrintWriter(fw)) {
            String json = gson.toJson(t);
            pw.println(json);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<Usuario> getUsuarios() {
        File f = new File("/home/miguel/Downloads/saidaUsuario.json");
        ArrayList<Usuario> lista = new ArrayList<>();
        try (Scanner sc = new Scanner(new FileReader(f))) {
            Gson gson = new Gson();
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                Usuario t = gson.fromJson(linha, Usuario.class);
                if (t != null) {
                    lista.add(t);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return lista; // Retorna lista vazia em caso de erro
        }
        return lista;
    }


    public int FazerLogin(Usuario newUser) {
        int situacao = -1;
        ArrayList<Usuario> usuarios = getUsuarios();
        if (usuarios.isEmpty()) {
            situacao = 0;
        } else {
            for (Usuario user : usuarios) {
                if (user.getUsuario().equals(newUser.getUsuario()) && user.getSenha().equals(newUser.getSenha())) {
                    situacao = 1;
                    break;
                }
            }
        }
        return situacao;
    }

    public boolean ExisteUsuario(String user, String password) {
        for (Usuario u : getUsuarios()) {
            if (u != null && u.getUsuario().equals(user) && u.getSenha().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
