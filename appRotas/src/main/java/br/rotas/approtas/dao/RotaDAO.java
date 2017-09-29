package br.rotas.approtas.dao;

import br.rotas.approtas.model.Cidade;
import br.rotas.approtas.model.Cliente;
import br.rotas.approtas.model.Rota;
import br.rotas.approtas.model.Rua;
import ch.qos.logback.core.CoreConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
 *
 * @author alencarmachado
 *
  ﻿create table rota( 
    id_rota serial, 
    nome_rota varchar(40) not null,
    id_cidade_rota integer references cidade(id_cidade), 
    img_rota varchar(20),
  	primary key(id_rota) ) 
  
﻿﻿insert into rota (nome_rota, id_cidade_rota,  img_rota) values ('Rota 1',1,'markerPink');
insert into rota (nome_rota, id_cidade_rota,  img_rota) values ('Rota 2',1,'markerAzure');
insert into rota (nome_rota, id_cidade_rota,  img_rota) values ('Rota 3',1,'markerVerde');
insert into rota (nome_rota, id_cidade_rota,  img_rota) values ('Rota 4',1,'markerSolidBack');;  *
 
 
  
 */

/*
﻿create table rotacliente (
    id_rota integer references rota (id_rota),
    id_cliente integer references cliente(id_cliente),
    seq integer,
    primary key (id_rota, id_cliente)
)
*/

public class RotaDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet res;

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

    public ArrayList<Rota> getRotasCidade(int idCidade) throws Exception {
        ArrayList<Rota> rotas = new ArrayList<>();
        conn = ConectaBDPostgres.getConexao();

        try {
            stmt = conn.prepareStatement("select * from rota where id_cidade_rota = '" + idCidade + "' order by rota.nome_rota");
            //stmt.setInt(1, idCidade);
            res = stmt.executeQuery();

            while (res.next()) {
                Rota rota = new Rota();
                rota.setId(res.getInt("id_rota"));
                rota.setNome(res.getString("nome_rota"));
                rota.setCidade(new Cidade(res.getInt("id_cidade_rota")));
                rota.setImg(res.getString("img_rota"));
                rotas.add(rota);
            }

            fecharConexoes();
            return rotas;
        } finally {
            System.out.println("getRotasCidade ... vamos fechar a conexao antes de propaga-la");
            fecharConexoes();
        }
    }

    public boolean incluirClientesRota(Rota rota) throws Exception {
        try {

            conn = ConectaBDPostgres.getConexao();

            System.out.println("Serão incluidos os clientes abaixo na rota " + rota.getId());
            for (Cliente c : rota.getClientes()) {
                stmt = conn.prepareStatement("insert into rotacliente (id_rota, id_cliente, seq) values (?,?,?)");
                stmt.setInt(1, rota.getId());
                stmt.setInt(2, c.getId());
                stmt.setInt(3, -1);
                System.out.println("sql:"+stmt.toString());
                if(stmt.executeUpdate() > 0){
                    
                    stmt = conn.prepareStatement("UPDATE cliente set id_rota_cliente = ? where id_cliente = ?");
                    stmt.setInt(1, rota.getId());
                    stmt.setInt(2, c.getId());
                    System.out.println(stmt.toString());
                    stmt.executeUpdate();
                }
   
                
            }
            fecharConexoes();
            return true;
        } finally {
            System.out.println("incluirClientesRota ... vamos fechar a conexao antes de propaga-la");
            fecharConexoes();
        }
    }
    
    public boolean alterarClientesRota(Rota rota) throws Exception {
        try {
                
            conn = ConectaBDPostgres.getConexao();

            System.out.println("Serão Alterados os clientes abaixo na rota " + rota.getId());
            for (Cliente c : rota.getClientes()) {
                stmt = conn.prepareStatement("UPDATE rotacliente set id_rota = ? where id_cliente = ?");
                stmt.setInt(1, rota.getId());
                stmt.setInt(2, c.getId());
                
                System.out.println("sql:"+stmt.toString());
                if(stmt.executeUpdate() > 0){
                    
                    stmt = conn.prepareStatement("UPDATE cliente set id_rota_cliente = ? where id_cliente = ?");
                    stmt.setInt(1, rota.getId());
                    stmt.setInt(2, c.getId());
                    System.out.println(stmt.toString());
                    stmt.executeUpdate();
                }
   
                
            }
            fecharConexoes();
            return true;
        } finally {
            System.out.println("alterarClientesRota ... vamos fechar a conexao antes de propaga-la");
            fecharConexoes();
        }
    }

}
