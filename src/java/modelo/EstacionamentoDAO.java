package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstacionamentoDAO extends DatabaseAccessObject {
    void inserir(Estacionamento estacionamento) throws SQLException {
        conectar();
        
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO estacionamento(funcionamento_id) VALUES(?)");

        pstmt.setInt(1, estacionamento.getFuncionario().getId());
        
        pstmt.execute();
        
        desconectar();
    }
    
    void alterar (Estacionamento estacionamento) throws SQLException {
        conectar();
        
        PreparedStatement pstmt = conn.prepareStatement("UPDATE estacionamento SET funcionario_id=? WHERE id=?)");
        
        pstmt.setInt(2, estacionamento.getId());
        pstmt.setInt(1, estacionamento.getFuncionario().getId());
        
        pstmt.execute();
        
        desconectar();
    }
    
    void excluirPorId (int id) throws SQLException {
        conectar();

        conn.createStatement().execute("DELETE FROM estacionamento WHERE id=" + id);
        
        desconectar();
    }
    
    Estacionamento buscarPorId(int id) throws SQLException {
        conectar();

        ResultSet rset = conn.createStatement().executeQuery("SELECT * FROM estacionamento WHERE id=" + id);

        Estacionamento estacionamento = null;
        List<Setor> todosSetores = new SetorDAO().listar();
        
        if (rset.next())
        {   
            estacionamento = new Estacionamento(); 
            
            estacionamento.setFuncionario(new FuncionarioDAO().buscarPorId(rset.getInt("funcionario_id")));
            estacionamento.setId(rset.getInt("id"));
            List<Setor> setores = new ArrayList<>();

            for(Setor s : todosSetores){
                if(s.getEstacionamento().getId() == estacionamento.getId())
                    setores.add(s);
            } 
            
            estacionamento.setSetores(setores);            
        }
                
        desconectar();
        
        return estacionamento; 
    }
    
    List<Estacionamento> listar () throws SQLException {
        conectar();

        List<Estacionamento> lista = new ArrayList<>();
        
        ResultSet rset = conn.createStatement().executeQuery("SELECT id FROM estacionamento");
        
        while (rset.next())           
            lista.add( buscarPorId( rset.getInt("id") ) );
                
        desconectar();
        
        return lista;
    } 
}
