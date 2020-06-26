/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose
 */
public class FuncionarioDAO extends DatabaseAccessObject {

    public void inserir(Funcionario funcionario) throws SQLException {
        conectar();
        
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO funcionario(cpf, nome, login, senha, cargo_id) VALUES(?,?,?,?,?)");

        pstmt.setInt(5, funcionario.getCargo().getId());
        pstmt.setString(1, funcionario.getCpf());
        pstmt.setString(2, funcionario.getNome());
        pstmt.setString(3, funcionario.getLogin());
        pstmt.setString(4, funcionario.getSenha());
        
        pstmt.execute();
        
        desconectar();
    }
    
    public void alterar (Funcionario funcionario) throws SQLException {
        conectar();
        
        PreparedStatement pstmt = conn.prepareStatement("UPDATE funcionario SET cpf=?, nome=?, login=?, senha=?, cargo_id=? WHERE id=?");
        
        pstmt.setInt(6,    funcionario.getId());
        pstmt.setString(1, funcionario.getCpf());
        pstmt.setString(2, funcionario.getNome());
        pstmt.setString(3, funcionario.getLogin());
        pstmt.setString(4, funcionario.getSenha());
        pstmt.setInt(5,    funcionario.getCargo().getId());
        
        pstmt.execute();
        
        desconectar();
    }
    
    public void excluirPorId (int id) throws SQLException {
        conectar();

        conn.createStatement().execute("DELETE FROM funcionario WHERE id=" + id);
        
        desconectar();
    }
    
    public Funcionario buscarPorId(int id) throws SQLException {
        conectar();

        ResultSet rset = conn.createStatement().executeQuery("SELECT * FROM funcionario WHERE id=" + id);

        Funcionario funcionario = null;
        
        if (rset.next())
        {   
            funcionario = new Funcionario();
            
            funcionario.setId(rset.getInt("id")); 
            funcionario.setCpf(rset.getString("cpf"));
            funcionario.setNome(rset.getString("nome"));            
            funcionario.setLogin(rset.getString("login"));
            funcionario.setSenha(rset.getString("senha"));            
            funcionario.setCargo(new CargoDAO().buscarPorId(rset.getInt("cargo_id")));      
        }
                
        desconectar();
        
        return funcionario; 
    }
    
    public  List<Funcionario> listar () throws SQLException {
        conectar();

        List<Funcionario> lista = new ArrayList<>();
        
        ResultSet rset = conn.createStatement().executeQuery("SELECT * FROM funcionario");
        
        while (rset.next())   { 
            
            Funcionario funcionario = new Funcionario();
            
            funcionario.setId(rset.getInt("id")); 
            funcionario.setCpf(rset.getString("cpf"));
            funcionario.setNome(rset.getString("nome"));            
            funcionario.setLogin(rset.getString("login"));
            funcionario.setSenha(rset.getString("senha"));            
            funcionario.setCargo(new CargoDAO().buscarPorId(rset.getInt("cargo_id")));      
            
            
            lista.add( funcionario );
        }
                
        desconectar();
        
        return lista;
    } 

    public Funcionario buscarPorLogin(String login) throws SQLException {
        conectar();

        ResultSet rset = conn.createStatement().executeQuery("SELECT * FROM funcionario WHERE login='" + login + "'");

        Funcionario funcionario = null;
        
        if (rset.next())
        {   
            funcionario = new Funcionario();
            
            funcionario.setId(rset.getInt("id"));            
            funcionario.setCpf(rset.getString("cpf"));
            funcionario.setNome(rset.getString("nome"));            
            funcionario.setLogin(rset.getString("login"));
            funcionario.setSenha(rset.getString("senha"));            
            funcionario.setCargo(new CargoDAO().buscarPorId(rset.getInt("cargo_id")));      
        }
                
        desconectar();
        
        return funcionario; 
    }
}
