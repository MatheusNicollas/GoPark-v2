package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO extends DatabaseAccessObject {
    void inserir(Ticket ticket) throws SQLException {
        conectar();
        
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ticket(status, check_in, check_out) VALUES(?, ?, ?)");
        
        pstmt.setInt(1, ticket.getStatus());
        pstmt.setDate(2, ticket.getCheckIn());
        pstmt.setDate(3, ticket.getCheckOut());
        
        pstmt.execute();
        
        desconectar();
    }
    
    void alterar (Ticket ticket) throws SQLException {
        conectar();
        
        PreparedStatement pstmt = conn.prepareStatement("UPDATE ticket SET especial=?, status=?, setor_id=? WHERE id=?)");
        
        pstmt.setLong(4, ticket.getId());
        pstmt.setInt(1, ticket.getStatus());
        pstmt.setDate(2, ticket.getCheckIn());
        pstmt.setDate(3, ticket.getCheckOut());
        
        pstmt.execute();
        
        desconectar();
    }
    
    void excluirPorId (long id) throws SQLException {
        conectar();
        
       conn.createStatement().execute("DELETE FROM ticket WHERE id=" + id);
       
        desconectar();
    }
    
    Ticket buscarPorId (long id) throws SQLException {
        conectar();

        ResultSet rset = conn.prepareStatement("SELECT * FROM ticket WHERE id=" + id).executeQuery();
        Ticket ticket = null;
        
        if (rset.next())
        {   
            ticket = new Ticket();
            
            ticket.setId(rset.getLong("id")); 
            ticket.setStatus(rset.getInt("status"));
            ticket.setCheckIn(rset.getDate("check_in"));
            ticket.setCheckOut(rset.getDate("check_out"));
        }
                
        desconectar();
        
        return ticket; 
    }
    
    List<Ticket> listar () throws SQLException {
        conectar();
        
        List<Ticket> lista = new ArrayList<>();
        
        ResultSet rset = conn.createStatement().executeQuery("SELECT id FROM ticket");
        
        while (rset.next())
        {
            long id = rset.getLong("id"); 

            lista.add(buscarPorId(id));
        }
                
        desconectar();
        
        return lista;
    }
}
