package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class VagaDAO extends DatabaseAccessObject {
    public void inserir(Vaga vaga) throws SQLException {
        conectar();
        
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO vaga(especial, status, setor_id) VALUES(?, ?, ?)");
        
        pstmt.setBoolean(1, vaga.isEspecial());
        pstmt.setInt(2, vaga.getStatus());
        pstmt.setInt(3, vaga.getSetor().getId());
        
        pstmt.execute();
        
        desconectar();
    }
    
    public void alterar (Vaga vaga) throws SQLException {
        conectar();
        
        PreparedStatement pstmt = conn.prepareStatement("UPDATE vaga SET especial=?, status=?, setor_id=? WHERE id=?");
        
        pstmt.setInt(4, vaga.getId());
        pstmt.setBoolean(1, vaga.isEspecial());
        pstmt.setInt(2, vaga.getStatus());
        pstmt.setInt(3, vaga.getSetor().getId());
        
        pstmt.execute();
        
        desconectar();
    }
    
    public void excluirPorId (int id) throws SQLException {
        conectar();
        
       conn.createStatement().execute("DELETE FROM vaga WHERE id=" + id);
       
        desconectar();
    }
    
    public Vaga buscarPorId (int id) throws SQLException {
        conectar();
        
        ResultSet rset = conn.createStatement().executeQuery("SELECT * FROM vaga WHERE id=" + id);
        Vaga vaga = null;
        
        if (rset.next())
        {   
            vaga = new Vaga();
            
            vaga.setId(rset.getInt("id")); 
            vaga.setEspecial(rset.getBoolean("especial"));
            vaga.setStatus(rset.getInt("status"));
            vaga.setSetor(new SetorDAO().buscarPorId(rset.getInt("setor_id")));
        }
                
        desconectar();
        
        return vaga; 
    }
 
    public List<Vaga> listar() throws SQLException {
        conectar();

        ResultSet rset = conn.createStatement().executeQuery("SELECT * from vaga");

        List<Vaga> vagas = new ArrayList<>();

        while (rset.next()) {
            Vaga vaga = new Vaga();

            vaga.setId(rset.getInt("id"));
            vaga.setEspecial(rset.getBoolean("especial"));
            vaga.setStatus(rset.getInt("status"));

            vagas.add(vaga);
        }
        
        desconectar();
        
        return vagas;
    }
    
     public List<Vaga> listarPorSetorId(int id) throws SQLException {
        conectar();

        ResultSet rset = conn.createStatement().executeQuery("SELECT * from vaga WHERE setor_id=" + id);

        List<Vaga> vagas = new ArrayList<>();

        while (rset.next()) {
            Vaga vaga = new Vaga();

            vaga.setId(rset.getInt("id"));
            vaga.setEspecial(rset.getBoolean("especial"));
            vaga.setStatus(rset.getInt("status"));

            vagas.add(vaga);
        }
        
        desconectar();
        
        return vagas;
    }

    public void excluirPorSetorId(int id) throws SQLException {
        conectar();
        
       conn.createStatement().execute("DELETE FROM vaga WHERE setor_id=" + id);
       
        desconectar();
    }
    
    public int totalVagas() throws SQLException{
        conectar();
        
        String sql = "SELECT id FROM vaga";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        int cont = 0;
        while(rs.next()){
            rs.getInt("id");
            cont ++;
        }
        
        return cont;
        
    }
    
    public int vagasOcupadas() throws SQLException{
        conectar();
        
        String sql = "SELECT id FROM vaga WHERE status=1";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        int cont = 0;
        while(rs.next()){
            rs.getInt("id");
            cont ++;
        }
        
        return cont;
        
    }
    
    public int vagasLivres() throws SQLException{
        conectar();
        
        String sql = "SELECT id FROM vaga WHERE status=0";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        int cont = 0;
        while(rs.next()){
            rs.getInt("id");
            cont ++;
        }
        
        return cont;
        
    }
    
    public int vagasInterditadas() throws SQLException{
        conectar();
        
        String sql = "SELECT id FROM vaga WHERE status=2";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        int cont = 0;
        while(rs.next()){
            rs.getInt("id");
            cont ++;
        }
        
        return cont;
        
    }
}
