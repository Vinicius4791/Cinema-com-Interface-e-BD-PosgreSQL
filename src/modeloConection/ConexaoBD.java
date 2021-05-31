package modeloConection;
 
//  @author vinic

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoBD {

    public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/cinejava";
    private String usuario = "postgres";
    private String senha = "";
    public Connection con;
    
    public void conexao(){
        try {
            System.setProperty("jdbc.Drivers", driver);
            con = DriverManager.getConnection(caminho, usuario, senha);
            System.out.println("Conexão Efetuada com Sucesso!");
            //JOptionPane.showMessageDialog(null, "Conexão Efetuada com Sucesso!");
        } catch (SQLException ex) {
            //System.out.println("Erro ao se Conectar com o Banco de Dados:\n"+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao se Conectar com o Banco de Dados:\n"+ex.getMessage());
        }
        
    }
    
    public void executaSql(String sql){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Erro ao Executar SQL: " +ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao Executar SQL!");
        }
    }
    
    public void desconecta(){
        try {
            con.close();
            System.out.println("Desconectado com Sucesso!");
            //JOptionPane.showMessageDialog(null, "Desconectado com Sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao Fechar Conexão com o BD:\n"+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao Fechar Conexão com o BD:\n"+ex.getMessage());
        }
        
    }
    
    /**
     *
     * @return
     */
    public Connection getConexao(){
        return con;
    }
}
