package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO extends DatabaseAccessObject {
    public void inserir(Pagamento pagamento) throws SQLException {
        conectar();
        
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO pagamento(valor, ticket_id, funcionario_id) VALUES(?,?,?)");

        pstmt.setDouble(1, pagamento.getValor());
        pstmt.setLong(2, pagamento.getTicket().getId());
        pstmt.setInt(3, pagamento.getFuncionario().getId());
        
        pstmt.execute();
        
        desconectar();
    }
    
    public long gerar(double valor) throws SQLException {
        conectar();
        
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO pagamento(id, valor) VALUES(NULL, ?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setDouble(1, valor);
        
        pstmt.executeUpdate();
        
        ResultSet rset = pstmt.getGeneratedKeys();
        
        rset.next();
        
        long id = rset.getLong(1);
        
        desconectar();
        
        return id;
    }
    
    public void alterar (Pagamento pagamento) throws SQLException {
        conectar();
        
        PreparedStatement pstmt = conn.prepareStatement("UPDATE pagamento SET valor=?, ticket_id=?, funcionario_id=? WHERE id=?)");
        
        pstmt.setLong(4, pagamento.getId());
        pstmt.setDouble(1, pagamento.getValor());
        pstmt.setLong(2, pagamento.getTicket().getId());
        pstmt.setInt(3, pagamento.getFuncionario().getId());
        
        pstmt.execute();
        
        desconectar();
    }
    
    public void excluirPorId (long id) throws SQLException {
        conectar();

        conn.createStatement().execute("DELETE FROM pagamento WHERE id=" + id);
        
        desconectar();
    }
    
    public Pagamento buscarPorId(long id) throws SQLException {
        conectar();

        ResultSet rset = conn.createStatement().executeQuery("SELECT * FROM pagamento WHERE id=" + id);

        Pagamento pagamento = null;
        
        if (rset.next())
        {   
            pagamento = new Pagamento();
            
            pagamento.setId(rset.getLong("id"));
            pagamento.setValor(rset.getDouble("valor"));            
            pagamento.setTicket(new TicketDAO().buscarPorId(rset.getLong("ticket_id")));
            pagamento.setFuncionario(new FuncionarioDAO().buscarPorId(rset.getInt("funcionario_id")));             
        }
                
        desconectar();
        
        return pagamento; 
    }
    
    public List<Pagamento> listar () throws SQLException {
        conectar();

        List<Pagamento> lista = new ArrayList<>();
        
        ResultSet rset = conn.createStatement().executeQuery("SELECT id FROM pagamento");
        
        while (rset.next())           
            lista.add(buscarPorId(rset.getLong("id")));
                
        desconectar();
        
        return lista;
    } 
}
