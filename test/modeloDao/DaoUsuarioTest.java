package modeloDao;

import modeloBeans.BeansUsuario;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author vinic
 */
public class DaoUsuarioTest {
    
    public DaoUsuarioTest() {
    }

    @Test
    @Ignore
    public void testSaveUsuario() {
        BeansUsuario beans = new BeansUsuario();
        DaoUsuario dao = new DaoUsuario();
        
        beans.setUsuNome("Vitor");
        beans.setUsuSenha("654");
        beans.setUsuTipo("Usuario");
        beans.setNumCartao(555);
        beans.setUsuIdade(19);
        beans.setUsuPesquisa("Vitor");
        
        dao.Salvar(beans);
    }
    
    @Test
    public void testBuscaUsuario(){
        BeansUsuario beans = new BeansUsuario();
        DaoUsuario dao = new DaoUsuario();
        
        beans.setUsuPesquisa("Vitor");
        
        String nomeAnterior = beans.getUsuPesquisa();
        beans = dao.buscaUsuario(beans);
        
        if(nomeAnterior.equals(beans.getUsuNome()))
            System.out.println("Encontrado.");
        else
            System.out.println("Não encontrado");
    }
    
}
