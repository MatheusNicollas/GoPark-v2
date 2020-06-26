package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseAccessObject {
    static final String HOST_NAME = "jdbc:mysql://localhost/estacionamento_bd";
    static final String USER_NAME = "root";
    static final String PASSWORD  = "";
    
    void conectar() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (conn == null)
            conn = DriverManager.getConnection(HOST_NAME, USER_NAME, PASSWORD);            
        else {
            if(conn.isClosed()) 
                conn = DriverManager.getConnection(HOST_NAME, USER_NAME, PASSWORD);                     
        }
            
    }
    
    void desconectar() throws SQLException {
        if (! conn.isClosed())
            conn.close(); 
    }
    
    boolean estaAberto() throws SQLException {
        return !conn.isClosed();
    }
     
    /**
     *
     * @throws SQLException
     * @throws Throwable
     */
    @Override
    protected void finalize() throws SQLException, Throwable {
        try {
            desconectar();
        } finally {
            super.finalize();
        }
    }
    
    protected Connection conn = null;
}
