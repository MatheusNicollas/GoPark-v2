package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SetorDAO extends DatabaseAccessObject {
    public void inserir(Setor setor) throws SQLException {
        conectar();
        
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO setor(andar, descricao, prefixo,  estacionamento_id) VALUES(?, ?, ?, ?)");
        
        pstmt.setString(1, setor.getAndar());
        pstmt.setString(2, setor.getDescricao());
        pstmt.setString(3, setor.getPrefixo());
        pstmt.setInt(4, setor.getEstacionamento().getId());
        
        pstmt.execute();
        
        desconectar();
    }
    
    public void alterar (Setor setor) throws SQLException {
        conectar();

        PreparedStatement pstmt = conn.prepareStatement("UPDATE setor SET andar=?, descricao=?, prefixo=? WHERE id=?");
        
        pstmt.setInt(4, setor.getId());
        pstmt.setString(1, setor.getAndar());
        pstmt.setString(2, setor.getDescricao());
        pstmt.setString(3, setor.getPrefixo());
        
        pstmt.execute();
        
        desconectar();
    }
    
    public void excluirPorId (int id) throws SQLException {
        conectar();

        conn.createStatement().execute("DELETE FROM setor WHERE id=" + id);
        
        desconectar();
    }
    
    public Setor buscarPorId(int id) throws SQLException {
        conectar();

        ResultSet rset = conn.createStatement().executeQuery("SELECT * FROM setor WHERE id=" + id);
        Setor setor = null;
        
        if (rset.next())
        {   
            setor = new Setor();
            
            setor.setId       (           rset.getInt("id") ); 
            setor.setAndar    (     rset.getString("andar") );
            setor.setDescricao( rset.getString("descricao") );
        //  setor.setEstacionamento(new EstacionamentoDAO().buscarPorId(rset.getInt("estacionamento_id")));
            
            setor.setVagas(new VagaDAO().listarPorSetorId(setor.getId()));            
        }
                
        desconectar();
        
        return setor; 
    }
    
    public List<Setor> listar () throws SQLException {
        conectar();

        List<Setor> lista = new ArrayList<>();
        
        ResultSet rset = conn.createStatement().executeQuery("SELECT * FROM setor");
        
        VagaDAO vdao = new VagaDAO();
        
        while (rset.next())  {
            Setor setor = new Setor();
            
            setor.setId       (           rset.getInt("id")); 
            setor.setAndar    (     rset.getString("andar"));
            setor.setDescricao( rset.getString("descricao"));
            setor.setPrefixo  (   rset.getString("prefixo"));
    //      setor.setEstacionamento(new EstacionamentoDAO().buscarPorId(rset.getInt("estacionamento_id")));
            
            setor.setVagas(vdao.listarPorSetorId(setor.getId())); 
            
            lista.add(setor);
        } 
                
        desconectar();
        
        return lista;
    }    
}
