package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeloBeans.BeansVendaLanche;
import modeloConection.ConexaoBD;

/**
 *
 * @author vinic
 */
public class DaoVendaLanche {
    BeansVendaLanche venda = new BeansVendaLanche();
    ConexaoBD conex = new ConexaoBD();
    ConexaoBD conexCliente = new ConexaoBD();
    ConexaoBD conexVendedor = new ConexaoBD();
    ConexaoBD conexLanche = new ConexaoBD();
    int codCliente;
    int codVendedor;
    int codLanche;
    
    public void Salvar(BeansVendaLanche venda){
        BuscaVendedor(venda.getVendaNomeVendedor());
        BuscaCliente(venda.getVendaNomeCliente());
        System.out.println("Lanche: "+venda.getVendaNomeLanche());
        BuscaLanche(venda.getVendaNomeLanche());
        
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into vendalanche(venda_clicod, venda_vendcod, venda_valor, venda_lanccod) values(?, ?, ?, ?)");
            pst.setInt(1, codCliente);
            pst.setInt(2, codVendedor);
            pst.setDouble(3, venda.getValorVenda());
            pst.setInt(4, codLanche);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Venda Realizada com Sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar compra!");
        }
        
        conex.desconecta();
    }
    
    public void BuscaVendedor(String nomeVendedor){
        conexVendedor.conexao();
        conexVendedor.executaSql("select * from funcionarios where nome like '"+nomeVendedor+"'");
        try {
            conexVendedor.rs.first();
            System.out.println(conexVendedor.rs.getInt("cod_funcionario"));
            codVendedor = conexVendedor.rs.getInt("cod_funcionario");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Vendedor não encontrado");
        }
    }
    
    public void BuscaCliente(String nomeCliente){
        conexCliente.conexao();
        conexCliente.executaSql("select * from usuarios where nome_usuario like '"+nomeCliente+"'");
        try {
            conexCliente.rs.first();
            codCliente = conexCliente.rs.getInt("cod_usuario");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
        }
    }
    
    public void BuscaLanche(String nomeLanche){
        conexLanche.conexao();
        conexLanche.executaSql("select * from lanches where nome_lanche like'"+nomeLanche+"'");
        try {
            conexLanche.rs.first();
            codLanche = conexLanche.rs.getInt("id_lanche");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lanche não encontrado");
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
