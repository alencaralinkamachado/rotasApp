package br.rotas.approtas.dao;

import br.rotas.approtas.model.Cidade;
import br.rotas.approtas.model.Cliente;
import br.rotas.approtas.model.Rota;
import br.rotas.approtas.model.Rua;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author alencarmachado
 
 ﻿create table rota(
id_rota serial,
    nome_rota varchar(40) not null,
    id_cidade_rota integer references cliente(id_cliente),
    img_rota varchar(20),
    primary key(id_rota)
) 
 ﻿insert into rota (nome_rota, id_cidade_rota, img_rota) values ('Rota C',1,'markerPink'); 
  
 */
public class RotaDAO {

    
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

    
    public ArrayList<Rota> getRotasCidade(int idCidade) throws Exception{
        ArrayList<Rota> rotas = new ArrayList<>();
        
        	
		conn = ConectaBDPostgres.getConexao();
		stmt = conn.prepareStatement("select * from rota where id_cidade_rota = '"+idCidade+"' order by rota.nome_rota");
                //stmt.setInt(1, idCidade);
		res = stmt.executeQuery();		
                
                
		
		while(res.next()){
			Rota rota = new Rota();
                        rota.setId(res.getInt("id_rota"));
                        rota.setNome(res.getString("nome_rota"));                        
                        rota.setCidade(new Cidade(res.getInt("id_cidade_rota")));
                        rota.setImg(res.getString("img_rota"));
                        rotas.add(rota);                        
		}
                
        fecharConexoes();
        return rotas;
    }
    
}
