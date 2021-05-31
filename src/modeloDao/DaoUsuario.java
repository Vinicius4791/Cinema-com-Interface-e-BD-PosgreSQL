package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansFuncionario;
import modeloBeans.BeansUsuario;
import modeloConection.ConexaoBD;

/**
 *
 * @author vinic
 */
public class DaoUsuario {
    ConexaoBD conex = new ConexaoBD();
    BeansUsuario mod = new BeansUsuario();
    
    public void Salvar(BeansUsuario mod){
        conex.conexao();

        try {
            PreparedStatement pst = conex.con.prepareStatement(
            "insert into usuarios(nome_usuario, idade, num_cartao, usu_senha, usu_tipo, valor_conta) values(?, ?, ?, ?, ?, ?)");
            
            pst.setString(1, mod.getUsuNome());
            pst.setInt(2, mod.getUsuIdade());
            pst.setInt(3, mod.getNumCartao());
            pst.setString(4, mod.getUsuSenha());
            pst.setString(5, mod.getUsuTipo());
            pst.setDouble(6, mod.getValorConta());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuário Inserido Com Sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao Inserir Usuario: "+ ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Usuário!");
        }

        conex.desconecta();
    }
    
    public void Editar(BeansUsuario mod){
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement(
            "update usuarios set nome_usuario=?, idade=?, num_cartao=?, usu_senha=?, usu_tipo=?, valor_conta=? where cod_usuario=?");
            
            pst.setString(1, mod.getUsuNome());
            pst.setInt(2, mod.getUsuIdade());
            pst.setInt(3, mod.getNumCartao());
            pst.setString(4, mod.getUsuSenha());
            pst.setString(5, mod.getUsuTipo());
            pst.setDouble(6, mod.getValorConta());
            pst.setInt(7, mod.getCodUsuario());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao Alterar Dados: "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Dados!");
        }
        
        conex.desconecta();
    }
    
    public void Excluir(BeansUsuario mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from usuarios where cod_usuario=?");
            pst.setInt(1, mod.getCodUsuario());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Excluidos com Sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao Deletar Dados: "+ ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao Deletar Dados!");
        }
        
        
        conex.desconecta();
    }
    
    public BeansUsuario buscaUsuario(BeansUsuario mod){
        conex.conexao();
        
        conex.executaSql("select * from usuarios where nome_usuario like'%" +mod.getUsuPesquisa() +"%'");
        try {
            conex.rs.first();
            mod.setCodUsuario(conex.rs.getInt("cod_usuario"));
            mod.setUsuNome(conex.rs.getString("nome_usuario"));
            mod.setUsuIdade(Integer.parseInt(conex.rs.getString("idade")));
            mod.setNumCartao(conex.rs.getInt("num_cartao"));
            mod.setUsuSenha(conex.rs.getString("usu_senha"));
            mod.setUsuTipo(conex.rs.getString("usu_tipo"));
            mod.setValorConta(conex.rs.getDouble("valor_conta"));
        } catch (SQLException ex) {
            System.out.println("Erro ao Buscar Usuario:\n"+ ex);
            JOptionPane.showMessageDialog(null, "Usuário não cadastrado.");
        }
        
        conex.desconecta();
        return mod;
    }
    
    
}
