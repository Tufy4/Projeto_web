package br.edu.ifsp.arq.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

import br.edu.ifsp.arq.model.Receita;
import br.edu.ifsp.arq.model.Usuario;

public class ReceitasDAO {
	private static ReceitasDAO instance;
	private static ArrayList<Receita> listaDeReceitas;
	
	private ReceitasDAO() {
		listaDeReceitas = new ArrayList<Receita>();
		
		
	}
	
	public static ReceitasDAO getInstance() {
		if(instance==null) {
			instance = new ReceitasDAO();
		}
		return instance;
	}
	
	
	public boolean adicionarReceitas(Receita t) {
		Gson gson = new Gson();
		
		try {
			FileWriter fw = new FileWriter("/home/aluno/Downloads/saidaReceita.json", StandardCharsets.UTF_8, true);
			PrintWriter pw = new PrintWriter(fw);
			String json = gson.toJson(t);
			pw.println(json);
			pw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;	
		
		
	}
	
	
	
	public Receita getReceita(String id) {
		Receita ReceitaBusca=null;
		
		int ID = Integer.parseInt(id);
		for(Receita RECEITA: getListaReceitas()) {
			if(ID== RECEITA.getId()) {
				ReceitaBusca = RECEITA;
			}
		}
		
		
		return ReceitaBusca;
	}
	
	
	
	
	public ArrayList<Receita> getListaReceitas() {
	    File f = new File("/home/aluno/Downloads/saidaReceita.json");
	    Gson gson = new Gson();
	    ArrayList<Receita> lista = new ArrayList<>();

	    if (!f.exists()) {
	        return lista; 
	    }

	    try {
	        FileReader fr = new FileReader(f);
	        Scanner sc = new Scanner(fr);

	        while (sc.hasNextLine()) {
	            String linha = sc.nextLine().trim();

	            if (linha.isEmpty()) continue;

	            try {
	                Receita t = gson.fromJson(linha, Receita.class);
	                if (t != null) {
	                    lista.add(t);
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        sc.close();
	        fr.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return lista;
	}
	
	
	
	public boolean atualizarReceita(Receita receitaAtualizada) {
	    ArrayList<Receita> lista = getListaReceitas(); 
	    boolean atualizado = false;

	  
	    for (int i = 0; i < lista.size(); i++) {
	        Receita receita = lista.get(i);
	        if (receita.getId() == receitaAtualizada.getId()) {
	            lista.set(i, receitaAtualizada); 
	            atualizado = true;
	            break;
	        }
	    }

	    if (atualizado) {
	        return salvarListaReceitas(lista);
	    }

	    return false;
	}


	
	
	
	public void removerReceitaPorId(String id) {
	    int idInt = Integer.parseInt(id);
	    ArrayList<Receita> lista = getListaReceitas();
	    
	    Receita receitaParaRemover = null;
	    for (Receita receita : lista) {
	        if (receita != null && receita.getId() == idInt) {
	            receitaParaRemover = receita;
	            break;
	        }
	    }
	    
	    if (receitaParaRemover != null) {
	        lista.remove(receitaParaRemover);
	        salvarListaReceitas(lista);
	    }
	}

	
	
	
	
	public boolean salvarListaReceitas(ArrayList<Receita> lista) {
	    Gson gson = new Gson();
	    try (FileWriter fw = new FileWriter("/home/aluno/Downloads/saidaReceita.json", StandardCharsets.UTF_8);
	         PrintWriter pw = new PrintWriter(fw)) {
	        for (Receita r : lista) {
	            String json = gson.toJson(r);
	            pw.println(json);
	        }
	        return true;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	
}
