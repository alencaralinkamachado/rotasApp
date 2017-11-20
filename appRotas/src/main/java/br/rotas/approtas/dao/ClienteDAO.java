/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rotas.approtas.dao;

import br.rotas.approtas.model.Cidade;
import br.rotas.approtas.model.Cliente;
import br.rotas.approtas.model.Rota;
import br.rotas.approtas.model.Rua;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author alencarmachado
 *
 * ﻿create table cliente( id_cliente serial, nome_cliente varchar(50) not null,
 * cpf_cliente varchar(30), ondedeixar_cliente varchar(100), email_cliente
 * varchar(50), id_rua_cli integer references rua(idrua), id_cidade_cli integer
 * references cidade(id_cidade), numero_cliente varchar(7), complemento_cliente
 * varchar(40), codcorreio integer, latitude_cliente varchar(30),
 * longitude_cliente varchar(30), telefone1_cliente varchar(15),
 * telefone2_cliente varchar(15), telefone3_cliente varchar(15), primary
 * key(id_cliente))
 *
 * ﻿insert into cliente (nome_cliente, ondedeixar_cliente, id_rua_cli,
 * id_cidade_cli, numero_cliente, codcorreio, latitude_cliente,
 * longitude_cliente) values('Zelda MAR', 'Patio identif c/saco plast', 12, 1,
 * 109, 1234638, '-30.339561', '-54.327688' )
 *
 ******* adicionar na tabela telefone, email, complemento do endereco *******
 *
 * ALTER TABLE cliente ADD complemento_cliente varchar(40) ALTER TABLE cliente
 * ADD email_cliente varchar(50) ALTER TABLE cliente ADD telefone1_cliente
 * varchar(15) ALTER TABLE cliente ADD telefone2_cliente varchar(15) ALTER TABLE
 * cliente ADD telefone3_cliente varchar(15)
 
  
 ﻿ALTER TABLE cliente
ADD id_rota_clinete integer references rota(id_rota) 
  
  ALTER TABLE cliente
ADD ativo boolean  
  
  ﻿ALTER TABLE cliente ADD movimentacao timestamp 
 *
 */
public class ClienteDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet res;
    private Calendar calendar = Calendar.getInstance();
    
      public ClienteDAO(){
       
      }
    
    private void fecharConexoes() throws Exception {
        if (res != null) {
            res.close();
            stmt.close();
            conn.close();
        } else {
            stmt.close();
            conn.close();
        }
    }

    public boolean autalizaCoordenadasRota(Cliente c) throws Exception {
        
        conn = ConectaBDPostgres.getConexao();
        try {
            String sql = "UPDATE cliente SET latitude_cliente = ?, longitude_cliente = ?, id_rota_cliente =?, movimentacao =? WHERE id_cliente = " + c.getId();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getLatitude());
            stmt.setString(2, c.getLongitude());            
            stmt.setInt(3, c.getRota().getId());
            calendar.setTime(new Date());
            stmt.setTimestamp(4, new java.sql.Timestamp(calendar.getTimeInMillis()));
            System.out.println(stmt.toString());
            if (stmt.executeUpdate() > 0) {
                
                stmt = conn.prepareStatement("UPDATE rotacliente set id_rota = ? where id_cliente = ?");
                //﻿update rotacliente set id_rota = 2 where id_cliente = 272
                stmt.setInt(1, c.getRota().getId());
                stmt.setInt(2, c.getId());
                System.out.println(stmt.toString());
                stmt.executeUpdate();                
                fecharConexoes();
                return true;
            }

            fecharConexoes();
            return false;
        } finally {
            System.out.println(" autalizaCoordenadasRota ... vamos fechar a conexao antes de propaga-la");
            fecharConexoes();
        }
    }
    
    public Cliente getCliente(int id) throws Exception{
        Cliente c = new Cliente();
        
        conn = ConectaBDPostgres.getConexao();
        try{
            stmt = conn.prepareStatement("SELECT * FROM cliente c, rua r, rota ro WHERE c.id_rua_cli = r.idrua and ro.id_rota = c.id_rota_cliente and c.id_cliente = ?");
            stmt.setInt(1, id);
            
            res = stmt.executeQuery();
            while(res.next()){
                
                c.setId(res.getInt("id_cliente"));
                c.setNome(res.getString("nome_cliente"));
                c.setOndeDeixar(res.getString("ondedeixar_cliente"));
                c.setRua(new Rua(res.getInt("id_rua_cli"), res.getString("nome_rua")));
                c.setCidade(new Cidade(res.getInt("id_cidade_cli")));
                c.setCpf(res.getString("cpf_cliente"));
                c.setNumero(res.getInt("numero_cliente"));
                c.setCodCorreio(res.getInt("codcorreio"));
                c.setLatitude(res.getString("latitude_cliente"));
                c.setLongitude(res.getString("longitude_cliente"));
                c.setEmail(res.getString("email_cliente"));
                c.setComplemento(res.getString("complemento_cliente"));
                c.setTelefone1(res.getString("telefone1_cliente"));
                c.setTelefone2(res.getString("telefone2_cliente"));
                c.setTelefone3(res.getString("telefone3_cliente"));
                c.setAtivo(res.getBoolean("ativo"));
                c.setCidade(new Cidade(1, "São Gabriel", "null", "null"));
                c.setFoto(res.getString("foto"));
                c.setRota(new Rota(res.getInt("id_rota_cliente"), res.getString("nome_rota"), res.getString("img_rota")));
                
            }
        }finally{
             System.out.println("getCliente ... vamos fechar a conexao antes de propaga-la");
            fecharConexoes();
        }
        System.out.println("get cliente nome: "+c.getNome()+" cpf: "+c.getCpf());
        return c;
    }

    public ArrayList<Cliente> getClientesPorRota(int rota) throws Exception{
        ArrayList<Cliente> clientes = new ArrayList<>();
        conn = ConectaBDPostgres.getConexao();
        try{
            stmt = conn.prepareStatement("SELECT * FROM cliente c, rua r WHERE c.id_rua_cli = r.idrua and id_rota_cliente =? order by r.nome_rua");
            stmt.setInt(1, rota);
            
            res = stmt.executeQuery();
            while(res.next()){
                Cliente c = new Cliente();
                c.setId(res.getInt("id_cliente"));
                c.setNome(res.getString("nome_cliente"));
                c.setOndeDeixar(res.getString("ondedeixar_cliente"));
                c.setRua(new Rua(res.getInt("id_rua_cli"), res.getString("nome_rua")));
                //c.setCidade(new Cidade(res.getInt("id_cidade_cli")));
                c.setNumero(res.getInt("numero_cliente"));
                //c.setCodCorreio(res.getInt("codcorreio"));
                //c.setLatitude(res.getString("latitude_cliente"));
                //c.setLongitude(res.getString("longitude_cliente"));
                //c.setEmail(res.getString("email_cliente"));
                c.setComplemento(res.getString("complemento_cliente"));
                c.setTelefone1(res.getString("telefone1_cliente"));
                c.setTelefone2(res.getString("telefone2_cliente"));
                c.setTelefone3(res.getString("telefone3_cliente"));
                //c.setRota(new Rota(res.getInt("id_rota_cliente"), res.getString("nome_rota"), res.getString("img_rota")));
                clientes.add(c);
            }
        }finally{
             System.out.println("getClientesPorRota ... vamos fechar a conexao antes de propaga-la");
            fecharConexoes();
        }
        return clientes;
    }
    
    
    public ArrayList<Cliente> getClientesMobile() throws Exception {
        System.out.println("Carregando clientes ...... getClientes da DAO");
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        conn = ConectaBDPostgres.getConexao();
        try {
            stmt = conn.prepareStatement("SELECT * FROM cliente c, rua r, rota ro WHERE c.id_rua_cli = r.idrua and ro.id_rota = c.id_rota_cliente order by c.nome_cliente");
            res = stmt.executeQuery();
            while (res.next()) {
                Cliente c = new Cliente();
                c.setId(res.getInt("id_cliente"));
                c.setNome(res.getString("nome_cliente"));
                c.setOndeDeixar(res.getString("ondedeixar_cliente"));
                c.setRua(new Rua(res.getInt("id_rua_cli"), res.getString("nome_rua")));
                //c.setCidade(new Cidade(res.getInt("id_cidade_cli")));
                c.setNumero(res.getInt("numero_cliente"));
                //c.setCodCorreio(res.getInt("codcorreio"));
                c.setLatitude(res.getString("latitude_cliente"));
                c.setLongitude(res.getString("longitude_cliente"));
                //c.setEmail(res.getString("email_cliente"));
                c.setComplemento(res.getString("complemento_cliente"));
                //c.setTelefone1(res.getString("telefone1_cliente"));
                //c.setTelefone2(res.getString("telefone2_cliente"));
               // c.setTelefone3(res.getString("telefone3_cliente"));
               // c.setCpf(res.getString("cpf_cliente"));
                c.setAtivo(res.getBoolean("ativo"));
                //c.setFoto(res.getString("foto"));
                //c.setRota(new Rota(res.getInt("id_rota_cliente"), res.getString("nome_rota"), res.getString("img_rota")));
                clientes.add(c);
            }
            fecharConexoes();
            return clientes;
        } finally {
            System.out.println("getClientes ... vamos fechar a conexao antes de propaga-la");
            fecharConexoes();
        }
    }
    
    
    public ArrayList<Cliente> getClientes() throws Exception {
        System.out.println("Carregando clientes ...... getClientes da DAO");
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        conn = ConectaBDPostgres.getConexao();
        try {
            stmt = conn.prepareStatement("SELECT * FROM cliente c, rua r, rota ro WHERE c.id_rua_cli = r.idrua and ro.id_rota = c.id_rota_cliente order by c.nome_cliente");
            res = stmt.executeQuery();
            while (res.next()) {
                Cliente c = new Cliente();
                c.setId(res.getInt("id_cliente"));
                c.setNome(res.getString("nome_cliente"));
                c.setOndeDeixar(res.getString("ondedeixar_cliente"));
                c.setRua(new Rua(res.getInt("id_rua_cli"), res.getString("nome_rua")));
                c.setCidade(new Cidade(res.getInt("id_cidade_cli")));
                c.setNumero(res.getInt("numero_cliente"));
                c.setCodCorreio(res.getInt("codcorreio"));
                c.setLatitude(res.getString("latitude_cliente"));
                c.setLongitude(res.getString("longitude_cliente"));
                c.setEmail(res.getString("email_cliente"));
                c.setComplemento(res.getString("complemento_cliente"));
                c.setTelefone1(res.getString("telefone1_cliente"));
                c.setTelefone2(res.getString("telefone2_cliente"));
                c.setTelefone3(res.getString("telefone3_cliente"));
                c.setCpf(res.getString("cpf_cliente"));
                c.setAtivo(res.getBoolean("ativo"));
                //c.setFoto(res.getString("foto"));
                c.setRota(new Rota(res.getInt("id_rota_cliente"), res.getString("nome_rota"), res.getString("img_rota")));
                clientes.add(c);
            }
            fecharConexoes();
            return clientes;
        } finally {
            System.out.println("getClientes ... vamos fechar a conexao antes de propaga-la");
            fecharConexoes();
        }
    }

    public boolean update(Cliente cliente) throws Exception{
        conn = ConectaBDPostgres.getConexao();
        try{
           String sql = "UPDATE cliente set nome_cliente =?, "
                   + " ondedeixar_cliente =?,"
                   + " id_rua_cli = ?, "
                   + " id_cidade_cli = ?, "
                   + " numero_cliente = ?, "
                   + " codcorreio = ?, "
                   + " latitude_cliente = ?, "
                   + " longitude_cliente = ?, "
                   + " complemento_cliente = ?, "
                   + " id_rota_cliente =?, "
                   + " cpf_cliente = ?, "
                   + " email_cliente =?, "
                   + " telefone1_cliente =?, "
                   + " telefone2_cliente =?, "
                   + " telefone3_cliente= ?,"
                   + " ativo = ?,"
                   + " movimentacao = ?, "
                   + " foto = ? "
                   + " WHERE id_cliente = ? ";
                
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getOndeDeixar());
            stmt.setInt(3, cliente.getRua().getId());
            stmt.setInt(4, cliente.getCidade().getId());
            stmt.setInt(5, cliente.getNumero());
            stmt.setInt(6, cliente.getCodCorreio());
            stmt.setString(7, cliente.getLatitude());
            stmt.setString(8, cliente.getLongitude());
            stmt.setString(9, cliente.getComplemento());
            stmt.setInt(10, cliente.getRota().getId());
            stmt.setString(11, cliente.getCpf());
            stmt.setString(12, cliente.getEmail());
            stmt.setString(13, cliente.getTelefone1());
            stmt.setString(14, cliente.getTelefone2());
            stmt.setString(15, cliente.getTelefone3());
            stmt.setBoolean(16, cliente.isAtivo());        
            calendar.setTime(new Date());
            stmt.setTimestamp(17, new java.sql.Timestamp(calendar.getTimeInMillis()));
            stmt.setString(18, cliente.getFoto());
            stmt.setInt(19, cliente.getId());
            //﻿SELECT * FROM cliente WHERE movimentacao >= '2017-09-29 21:57:00'
            System.out.println("sql: "+stmt.toString());
            if (stmt.executeUpdate() > 0) {
                fecharConexoes();
                return true;
            }
             
          fecharConexoes();
          return false;
        } finally {
            System.out.println("update ciente ... vamos fechar a conexao antes de propaga-la");
            fecharConexoes();
        }
    }

    
  
    public boolean updateMobile(Cliente cliente) throws Exception{
        conn = ConectaBDPostgres.getConexao();
        try{
           String sql = "UPDATE cliente set "
                   + " latitude_cliente = ?, "
                   + " longitude_cliente = ?, "
                   + " movimentacao = ?, "
                   + " foto = ? "
                   + " WHERE id_cliente = ? ";
                
            stmt = conn.prepareStatement(sql);
            //stmt.setString(1, cliente.getNome());
            //stmt.setString(2, cliente.getOndeDeixar());
            //stmt.setInt(3, cliente.getRua().getId());
            //stmt.setInt(4, cliente.getCidade().getId());
            //stmt.setInt(5, cliente.getNumero());
            //stmt.setInt(6, cliente.getCodCorreio());
            stmt.setString(1, cliente.getLatitude());
            stmt.setString(2, cliente.getLongitude());
            //stmt.setString(9, cliente.getComplemento());
            //stmt.setInt(10, cliente.getRota().getId());
            //stmt.setString(11, cliente.getCpf());
           // stmt.setString(12, cliente.getEmail());
            //stmt.setString(13, cliente.getTelefone1());
            //stmt.setString(14, cliente.getTelefone2());
            //stmt.setString(15, cliente.getTelefone3());
            //stmt.setBoolean(16, cliente.isAtivo());        
            calendar.setTime(new Date());
            stmt.setTimestamp(3, new java.sql.Timestamp(calendar.getTimeInMillis()));
            stmt.setString(4, cliente.getFoto());
            stmt.setInt(5, cliente.getId());
            //﻿SELECT * FROM cliente WHERE movimentacao >= '2017-09-29 21:57:00'
            System.out.println("sql: "+stmt.toString());
            if (stmt.executeUpdate() > 0) {
                fecharConexoes();
                 System.out.println("vai retornar true");
                return true;
            }
             System.out.println("vai retornar falso");
          fecharConexoes();
          return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally {
            System.out.println("updateMobile ciente ... vamos fechar a conexao antes de propaga-la");
            fecharConexoes();
        }
    }
    
    public boolean inserir(Cliente cliente) throws Exception {
        conn = ConectaBDPostgres.getConexao();
        System.out.println("cpf cliente "+cliente.getCpf());
        System.out.println("email "+cliente.getEmail());
        System.out.println("tel 1."+cliente.getTelefone1());
        System.out.println("tel 2."+cliente.getTelefone2());
        System.out.println("tel 3."+cliente.getTelefone3());
        try {
            String sql = "insert into cliente (nome_cliente, ondedeixar_cliente, id_rua_cli, id_cidade_cli, numero_cliente, codcorreio, latitude_cliente, longitude_cliente, complemento_cliente, id_rota_cliente, "
                    + " cpf_cliente, email_cliente, telefone1_cliente, telefone2_cliente, telefone3_cliente, ativo, movimentacao) "
                    + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome().trim());
            stmt.setString(2, cliente.getOndeDeixar());
            stmt.setInt(3, cliente.getRua().getId());
            stmt.setInt(4, cliente.getCidade().getId());
            stmt.setInt(5, cliente.getNumero());
            stmt.setInt(6, cliente.getCodCorreio());
            stmt.setString(7, cliente.getLatitude());
            stmt.setString(8, cliente.getLongitude());
            stmt.setString(9, cliente.getComplemento());
            stmt.setInt(10, cliente.getRota().getId());
            stmt.setString(11, cliente.getCpf());
            stmt.setString(12, cliente.getEmail());
            stmt.setString(13, cliente.getTelefone1());
            stmt.setString(14, cliente.getTelefone2());
            stmt.setString(15, cliente.getTelefone3());
            stmt.setBoolean(16, cliente.isAtivo());
            calendar.setTime(new Date());
            stmt.setTimestamp(17, new java.sql.Timestamp(calendar.getTimeInMillis()));
            System.out.println(stmt.toString());
            if (stmt.executeUpdate() > 0) {
                fecharConexoes();
                return true;
            }

            fecharConexoes();
            return false;
        } finally {
            System.out.println("inserir cliente ... vamos fechar a conexao antes de propaga-la");
            fecharConexoes();
        }
    }

}
