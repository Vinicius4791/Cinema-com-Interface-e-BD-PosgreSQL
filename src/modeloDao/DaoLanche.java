package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansLanche;
import modeloConection.ConexaoBD;

/**
 *
 * @author vinic
 */
public class DaoLanche {
    ConexaoBD conex = new ConexaoBD();
    BeansLanche mod = new BeansLanche();
    
    public void Salvar(BeansLanche mod){
        conex.conexao();

        try {
            PreparedStatement pst = conex.con.prepareStatement(
            "insert into lanches(nome_lanche, preco_lanche, ingredientes_lanche) values(?, ?, ?)");
            
            pst.setString(1, mod.getNomeLanche());
            pst.setDouble(2, mod.getPrecoLanche());
            pst.setString(3, mod.getIngredientesLanche());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Inseridos com Sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao Inserir Dados: "+ ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Dados!");
        }

        conex.desconecta();
    }
    
    public void Editar(BeansLanche mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement(
            "update lanches set nome_lanche=?, preco_lanche=?, ingredientes_lanche=? where id_lanche=?");
            
            pst.setString(1, mod.getNomeLanche());
            pst.setDouble(2, mod.getPrecoLanche());
            pst.setString(3, mod.getIngredientesLanche());
            pst.setInt(4, mod.getCodLanche());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao Alterar Dados: "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Dados!");
        }
        
        conex.desconecta();
    }
    
    public BeansLanche buscaLanche(BeansLanche mod){
        conex.conexao();
        
        conex.executaSql("select * from lanches where nome_lanche like'%" +mod.getPesquisa() +"%'");
        try {
            conex.rs.first();
            mod.setCodLanche(conex.rs.getInt("id_lanche"));
            mod.setNomeLanche(conex.rs.getString("nome_lanche"));
            mod.setPrecoLanche(conex.rs.getDouble("preco_lanche"));
            mod.setIngredientesLanche(conex.rs.getString("ingredientes_lanche"));
        } catch (SQLException ex) {
            System.out.println("Erro ao Buscar Lanche:\n"+ ex);
            JOptionPane.showMessageDialog(null, "Lanche não cadastrado.");
        }
        
        conex.desconecta();
        return mod;
    }
    
    public void ExcluirLanche(BeansLanche mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from lanches where id_lanche=?");
            pst.setInt(1, mod.getCodLanche());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Excluidos com Sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao Deletar Dados: "+ ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao Deletar Dados!");
        }
        
        
        conex.desconecta();
    }
}
