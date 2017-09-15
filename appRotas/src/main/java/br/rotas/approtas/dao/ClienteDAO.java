/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rotas.approtas.dao;

import br.rotas.approtas.model.Cidade;
import br.rotas.approtas.model.Cliente;
import br.rotas.approtas.model.Rua;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author alencarmachado
 
﻿create table cliente(
id_cliente serial,
nome_cliente varchar(50) not null,
cpf_cliente varchar(30),
ondedeixar_cliente varchar(100),
id_rua_cli integer references rua(idrua),
id_cidade_cli integer references cidade(id_cidade),
numero_cliente varchar(7),
codcorreio integer,
latitude_cliente varchar(30),
longitude_cliente varchar(30),
    primary key(id_cliente))
    
﻿insert into cliente (nome_cliente, ondedeixar_cliente, id_rua_cli, id_cidade_cli, numero_cliente, codcorreio, latitude_cliente, longitude_cliente)
values('Zelda MAR', 'Patio identif c/saco plast', 12, 1, 109, 1234638, '-30.339561', '-54.327688' )
    
  
  
 */
public class ClienteDAO {
    
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
    
    public ArrayList<Cliente> getClientes() throws Exception{
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        conn = ConectaBDPostgres.getConexao();
        
        stmt = conn.prepareStatement("select * from cliente");
	res = stmt.executeQuery();
	while(res.next()){
        Cliente c = new Cliente();
            c.setNome(res.getString("nome_cliente"));
            c.setOndeDeixar(res.getString("ondedeixar_cliente"));
            c.setRua(new Rua(res.getInt("id_rua_cli")));
            c.setCidade(new Cidade(res.getInt("id_cidade_cli")));
            c.setNumero(res.getInt("numero_cliente"));
            c.setCodCorreio(res.getInt("codcorreio"));
            c.setLatitude(res.getString("latitude_cliente"));
            c.setLongitude(res.getString("longitude_cliente")); 
            clientes.add(c);
        }
        fecharConexoes();
        return clientes;
    }
    
    public boolean inserir(Cliente cliente) throws Exception{
        conn = ConectaBDPostgres.getConexao();
		boolean retorno=false;
		
			String sql = "insert into cliente (nome_cliente, ondedeixar_cliente, id_rua_cli, id_cidade_cli, numero_cliente, codcorreio, latitude_cliente, longitude_cliente) "
					+ " values(?, ?, ?, ?, ?, ?, ?, ?) ";
			stmt = conn.prepareStatement(sql);
                        stmt.setString(1, cliente.getNome());
                        stmt.setString(2, cliente.getOndeDeixar());
                        stmt.setInt(3, cliente.getRua().getId());
                        stmt.setInt(4, cliente.getCidade().getId());
                        stmt.setInt(5, cliente.getNumero());
                        stmt.setInt(6, cliente.getCodCorreio());
                        stmt.setString(7, cliente.getLatitude());
                        stmt.setString(8, cliente.getLongitude());
                        
                        stmt.executeUpdate();
		
		fecharConexoes();
		return retorno;
    }
    
}
