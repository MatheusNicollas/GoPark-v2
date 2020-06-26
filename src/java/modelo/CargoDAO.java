package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargoDAO extends DatabaseAccessObject {
    public void inserir(Cargo cargo) throws SQLException {
        conectar();
        
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO cargo(nome, descricao) VALUES(?,?)");
        
        pstmt.setString(1, cargo.getNome());
        pstmt.setString(2, cargo.getDescricao());
        
        pstmt.execute();
        
        desconectar();
    }
    
    public void alterar (Cargo cargo) throws SQLException {
        conectar();
        
        PreparedStatement pstmt = conn.prepareStatement("UPDATE cargo SET nome=?, descricao=? WHERE id=?)");
        
        pstmt.setInt(3, cargo.getId());
        pstmt.setString(1, cargo.getNome());
        pstmt.setString(2, cargo.getDescricao());
        
        pstmt.execute();
        
        desconectar();
    }
    
    public void excluirPorId (int id) throws SQLException {
        conectar();
        
        conn.createStatement().execute("DELETE FROM cargo WHERE id=" + id);
        
        desconectar();
    }
    
    public Cargo buscarPorId (int id) throws SQLException {
        conectar();

        ResultSet rset = conn.createStatement().executeQuery("SELECT * FROM cargo WHERE id=" + id);
        Cargo cargo = null;
        
        if (rset.next())
        {   
            cargo = new Cargo();
            
            cargo.setId(rset.getInt("id")); 
            cargo.setNome(rset.getString("nome"));
            cargo.setDescricao(rset.getString("descricao"));
        }
                
        desconectar();
        
        return cargo; 
    }
    
    public List<Cargo> listar () throws SQLException {
        conectar();
        
        List<Cargo> lista = new ArrayList<>();
        
        ResultSet rset = conn.createStatement().executeQuery("SELECT * FROM cargo");
        
        while (rset.next())
        {   
            Cargo cargo = new Cargo();
            
            cargo.setId(rset.getInt("id")); 
            cargo.setNome(rset.getString("nome"));
            cargo.setDescricao(rset.getString("descricao"));
            
            lista.add(cargo);
        }
                
        desconectar();
        
        return lista;
    }
}
