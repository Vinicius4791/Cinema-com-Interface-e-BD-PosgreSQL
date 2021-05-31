package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansVendaIngresso;
import modeloConection.ConexaoBD;

/**
 *
 * @author vinic
 */
public class DaoVendaIngresso {
    BeansVendaIngresso venda = new BeansVendaIngresso();
    ConexaoBD conex = new ConexaoBD();
    ConexaoBD conexCliente = new ConexaoBD();
    ConexaoBD conexBilheteiro = new ConexaoBD();
    ConexaoBD conexFilme = new ConexaoBD();
    int codCliente;
    int codBilheteiro;
    int codFilme;
    
    
    public void Salvar(BeansVendaIngresso venda){
        BuscaBilheteiro(venda.getNomeBilheteiro());
        BuscaCliente(venda.getNomeCliente());
        System.out.println("Filme: "+venda.getTituloFilme());
        BuscaFilme(venda.getTituloFilme());
        
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into vendaingresso(id_vendacliente, id_vendafilme, id_vendabilheteiro, valor_ingresso) values(?, ?, ?, ?)");
            pst.setInt(1, codCliente);
            pst.setInt(2, codFilme);
            pst.setInt(3, codBilheteiro);
            pst.setDouble(4, venda.getValorIngresso());
            pst.execute();
            
            //JOptionPane.showMessageDialog(null, "Venda Realizada com Sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar compra!");
        }
        
        conex.desconecta();
    }
    
    public void BuscaBilheteiro(String nomeBilheteiro){
        conexBilheteiro.conexao();
        conexBilheteiro.executaSql("select * from funcionarios where nome like '"+nomeBilheteiro+"'");
        try {
            conexBilheteiro.rs.first();
            codBilheteiro = conexBilheteiro.rs.getInt("cod_funcionario");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //ex.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Bilheteiro não encontrado");
        }
    }
    
    public void BuscaCliente(String nomeCliente){
        conexCliente.conexao();
        conexCliente.executaSql("select * from usuarios where nome_usuario like '"+nomeCliente+"'");
        try {
            conexCliente.rs.first();
            codCliente = conexCliente.rs.getInt("cod_usuario");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //ex.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Cliente não encontrado");
        }
    }
    
    public void BuscaFilme(String nomeFilme){
        conexFilme.conexao();
        conexFilme.executaSql("select * from filmes where titulo like'"+nomeFilme+"'");
        try {
            conexFilme.rs.first();
            codFilme = conexFilme.rs.getInt("id_filme");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //ex.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Filme não encontrado");
        }
    }
    
    public void CobrarValor(String nomeCliente, double conta){
        conexCliente.conexao();
        try {
            conexCliente.executaSql("select * from usuarios where nome_usuario like'"+nomeCliente+"'");
            conexCliente.rs.first();
            double contaAntiga = conexCliente.rs.getDouble("valor_conta");
            
            int id = conexCliente.rs.getInt("cod_usuario");
            
            double novovalor = contaAntiga+conta;
            
            PreparedStatement pst = conexCliente.con.prepareStatement(
            "update usuarios set valor_conta=? where cod_usuario=?");
            
            pst.setDouble(1, novovalor);
            pst.setInt(2, id);
            pst.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao fazer cobrança!");
        }
        conexCliente.desconecta();
    }
}
