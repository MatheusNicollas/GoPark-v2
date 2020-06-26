package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MensalistaDAO extends DatabaseAccessObject {
    public void inserir(Mensalista mensalista) throws SQLException {
        conectar();
        
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO mensalista(cod_cartao, data_de_cadastro, pagamento_id) VALUES(?,?,?)");

        pstmt.setString(1, mensalista.getCodCartao());
        pstmt.setDate(2, new Date(Calendar.getInstance().getTime().getTime()));
        pstmt.setLong(3, mensalista.getPagamento().getId());
        
        pstmt.execute();
        
        desconectar();
    }
    
    public void alterar (Mensalista mensalista) throws SQLException {
        conectar();
        
        PreparedStatement pstmt = conn.prepareStatement("UPDATE mensalista SET cod_cartao=?,  ultimo_mes_pago=?, pagamento_id=? WHERE id=?");
        
        pstmt.setInt(4, mensalista.getId());
        pstmt.setString(1, mensalista.getCodCartao());
        pstmt.setInt(2, mensalista.getUltimoMesPago());
        pstmt.setLong(3, mensalista.getPagamento().getId());
        
        pstmt.execute();
        
        desconectar();
    }
    
    public void excluirPorId (int id) throws SQLException {
        conectar();

        conn.createStatement().execute("DELETE FROM mensalista WHERE id=" + id);
        
        desconectar();
    }
    
    public Mensalista buscarPorId(int id) throws SQLException {
        conectar();

        ResultSet rset = conn.createStatement().executeQuery("SELECT * FROM mensalista WHERE id=" + id);

        Mensalista mensalista = null;
        
        if (rset.next())
        {   
            mensalista = new Mensalista();
            
            mensalista.setId(rset.getInt("id"));
            mensalista.setDataDeCadastro(rset.getDate("data_de_cadastro"));
            mensalista.setUltimoMesPago(rset.getInt("ultimo_mes_pago"));            
            mensalista.setCodCartao(rset.getString("cod_cartao"));
            mensalista.setPagamento(new PagamentoDAO().buscarPorId(rset.getInt("pagamento_id")));             
        }
                
        desconectar()   ;
        
        return mensalista; 
    }
    
    public Mensalista buscarPorCodCartao(String cod) throws SQLException {
        conectar();

        ResultSet rset = conn.createStatement().executeQuery("SELECT * FROM mensalista WHERE cod_cartao='" + cod + "'");

        Mensalista mensalista = null;
        
        if (rset.next())
        {   
            mensalista = new Mensalista();
            
            mensalista.setId(rset.getInt("id"));
            mensalista.setDataDeCadastro(rset.getDate("data_de_cadastro"));
            mensalista.setUltimoMesPago(rset.getInt("ultimo_mes_pago"));            
            mensalista.setCodCartao(rset.getString("cod_cartao"));
            mensalista.setPagamento(new PagamentoDAO().buscarPorId(rset.getInt("pagamento_id")));             
        }
                
        desconectar()   ;
        
        return mensalista; 
    }
    
    public List<Mensalista> listar () throws SQLException {
        conectar();

        List<Mensalista> lista = new ArrayList<>();
        
        ResultSet rset = conn.prepareStatement("SELECT * FROM mensalista").executeQuery();
        PagamentoDAO pdao = new PagamentoDAO();
        
        while (rset.next()) {
            Mensalista mensalista = new Mensalista();
            
            mensalista.setId(rset.getInt("id"));
            mensalista.setDataDeCadastro(rset.getDate("data_de_cadastro"));
            mensalista.setUltimoMesPago(rset.getInt("ultimo_mes_pago"));           
            mensalista.setCodCartao(rset.getString("cod_cartao"));
            mensalista.setPagamento(pdao.buscarPorId(rset.getLong("pagamento_id"))); 
            
            lista.add(mensalista);
        }
                
        desconectar();
        
        return lista;
    } 
    
    public boolean codCartaoExiste(String cod) throws SQLException {     
        conectar();
        
        ResultSet rset = conn.createStatement().executeQuery("SELECT cod_cartao FROM mensalista WHERE cod_cartao ='" + cod + "'");
        
        boolean ok = rset.next();
        
        desconectar();
        
        return ok;
    }
}
