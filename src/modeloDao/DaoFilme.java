package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansFilme;
import modeloConection.ConexaoBD;

/**
 *
 * @author vinic
 */
public class DaoFilme {
    ConexaoBD conex = new ConexaoBD();
    BeansFilme mod = new BeansFilme();
    
    public void SalvarFilme(BeansFilme mod){
        conex.conexao();

        try {
            PreparedStatement pst = conex.con.prepareStatement(
            "insert into filmes(titulo, genero, valor_entrada, sinopse_filme) values(?, ?, ?, ?)");
            
            pst.setString(1, mod.getTituloFilme());
            pst.setString(2, mod.getGeneroFilme());
            pst.setDouble(3, mod.getValorEntrada());
            pst.setString(4, mod.getSinopseFilme());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Inseridos com Sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Dados!");
        }

        conex.desconecta();
    }
    
    public void EditarFilme(BeansFilme mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement(
            "update filmes set titulo=?, genero=?, valor_entrada=?, sinopse_filme=? where id_filme=?");
            
            pst.setString(1, mod.getTituloFilme());
            pst.setString(2, mod.getGeneroFilme());
            pst.setDouble(3, mod.getValorEntrada());
            pst.setString(4, mod.getSinopseFilme());
            pst.setInt(5, mod.getIdFilme());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao Alterar Dados: "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Dados!");
        }
        
        conex.desconecta();
    }
    
    public BeansFilme buscaFilme(BeansFilme mod){
        conex.conexao();
        
        conex.executaSql("select * from filmes where titulo like'%" +mod.getPesquisa() +"%'");
        try {
            conex.rs.first();
            mod.setIdFilme(conex.rs.getInt("id_filme"));
            mod.setTituloFilme(conex.rs.getString("titulo"));
            mod.setSinopseFilme(conex.rs.getString("sinopse_filme"));
            mod.setGeneroFilme(conex.rs.getString("genero"));
            mod.setValorEntrada(conex.rs.getDouble("valor_entrada"));
        } catch (SQLException ex) {
            System.out.println("Erro ao Buscar Filme:\n"+ ex);
            JOptionPane.showMessageDialog(null, "Filme não cadastrado.");
        }
        
        conex.desconecta();
        return mod;
    }
    
    public void ExcluirFilme(BeansFilme mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from filmes where id_filme=?");
            pst.setInt(1, mod.getIdFilme());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Excluidos com Sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao Deletar Dados: "+ ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao Deletar Dados!");
        }
        
        
        conex.desconecta();
    }
}