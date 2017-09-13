/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rotas.approtas.dao;

import br.rotas.approtas.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author alencarmachado
 * 
  ﻿create table rua(
    idrua serial, 
    nome_rua varchar(100),
    id_cidade integer references cidade(id_cidade),
    primary key(idrua)
)
 * 
 * 
 */
public class RuaDAO {
    
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet res;
    
    private void fecharConexoes() throws Exception{
		if(res!= null){
			res.close();
			stmt.close();
			conn.close();
		}else{
			stmt.close();
			conn.close();
		}
	}
	
    public boolean inserir(Rua rua) throws Exception{
        conn = ConectaBDPostgres.getConexao();
		boolean retorno=false;
		
			String sql = "insert into rua(nome_rua, id_cidade) "
					+ "values (?,?)";
			stmt = conn.prepareStatement(sql);
                        stmt.setString(1, rua.getNome());
                        stmt.setInt(2, rua.getCidade().getId());
				
                        stmt.executeUpdate();
		
		fecharConexoes();
		return retorno;
    }
    
    public ArrayList<Rua> getRuas() throws Exception{
        ArrayList<Rua> ruas = new ArrayList<>();
        
        	
		conn = ConectaBDPostgres.getConexao();
		stmt = conn.prepareStatement("select * from rua r, cidade c where r.id_cidade = c.id_cidade");
		res = stmt.executeQuery();		
                
                
		//id_unidade, id_material, id_origem, ent_validade, ent_qtd, ent_data
		while(res.next()){
			Rua rua = new Rua();
                        rua.setId(res.getInt("idrua"));
                        rua.setNome(res.getString("nome_rua"));                        
                        rua.setCidade(new Cidade(res.getInt("id_cidade"),
                                res.getString("nome_cidade"), 
                                res.getString("latitude_cidade"),
                                res.getString("longitude_cidade")));
                        ruas.add(rua);                        
		}
        
        return ruas;
    }
    
    public ArrayList<Rua> getRuasTemp() throws Exception{
        ArrayList<Rua> ruasTemp = new ArrayList<>();
        
        	
		conn = ConectaBDPostgres.getConexao();
		stmt = conn.prepareStatement("select nome from ruatemp group by nome order by nome");
		res = stmt.executeQuery();
		System.out.println("vai trazer as entradasTemp ...");
                Cidade cidade = new Cidade();
                cidade.setId(1);
		//id_unidade, id_material, id_origem, ent_validade, ent_qtd, ent_data
		while(res.next()){
			Rua rua = new Rua();
                        rua.setNome(res.getString("nome"));                        
                        rua.setCidade(cidade);
                        ruasTemp.add(rua);                        
		}
        
        return ruasTemp;
    }
    
	public boolean inserirTemp(String nomeRua) throws Exception{
		//System.out.println("id unidade: "+c.getUnidade().getId());
                //System.out.println("nomeRua: -----> "+nomeRua);
		conn = ConectaBDPostgres.getConexao();
		boolean retorno=false;
		
			String sql = "insert into ruatemp(nome) "
					+ "values (?)";
			stmt = conn.prepareStatement(sql);
                        stmt.setString(1, nomeRua);
				
                        stmt.executeUpdate();
		
		fecharConexoes();
		return retorno;
	}
	
    
}
