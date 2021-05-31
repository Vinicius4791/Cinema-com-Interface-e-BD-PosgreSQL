package modeloDao;

import modeloConection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansFuncionario;

/**
 *
 * @author vinic
 */
public class DaoFuncionario {
    ConexaoBD conex = new ConexaoBD();
    BeansFuncionario mod = new BeansFuncionario();
    
    public void Salvar(BeansFuncionario mod){
        conex.conexao();

        try {
            PreparedStatement pst = conex.con.prepareStatement(
            "insert into funcionarios(nome, cpf, sexo, salario, funcao) values(?, ?, ?, ?, ?)");
            
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getCpf());
            pst.setString(3, mod.getSexo());
            pst.setString(4, mod.getSalario());
            pst.setString(5, mod.getFuncao());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Inseridos com Sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao Inserir Dados: "+ ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Dados!");
        }

        conex.desconecta();
    }
    
    public void Excluir(BeansFuncionario mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from funcionarios where cod_funcionario=?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Excluidos com Sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao Deletar Dados: "+ ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao Deletar Dados!");
        }
        
        
        conex.desconecta();
    }
    
    public void Editar(BeansFuncionario mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement(
            "update funcionarios set nome=?, cpf=?, sexo=?, salario=?, funcao=? where cod_funcionario=?");
            
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getCpf());
            pst.setString(3, mod.getSexo());
            pst.setString(4, mod.getSalario());
            pst.setString(5, mod.getFuncao());
            pst.setInt(6, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao Alterar Dados: "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Dados!");
        }
        
        conex.desconecta();
    }
    
    public BeansFuncionario buscaFuncionario(BeansFuncionario mod){
        conex.conexao();
        
        conex.executaSql("select * from funcionarios where nome like'%" +mod.getPesquisa() +"%'");
        try {
            conex.rs.first();
            mod.setCodigo(conex.rs.getInt("cod_funcionario"));
            mod.setNome(conex.rs.getString("nome"));
            mod.setCpf(conex.rs.getString("cpf"));
            mod.setSexo(conex.rs.getString("sexo"));
            mod.setSalario(conex.rs.getString("salario"));
            mod.setFuncao(conex.rs.getString("funcao"));
        } catch (SQLException ex) {
            System.out.println("Erro ao Buscar Funcionário:\n"+ ex);
            JOptionPane.showMessageDialog(null, "Funcionário não cadastrado.");
        }
        
        conex.desconecta();
        return mod;
    }
    
}
