package modeloDao;

import modeloBeans.BeansFuncionario;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author vinic
 */
public class DaoFuncionarioTest {
    
    public DaoFuncionarioTest() {
    }

    @Test
    @Ignore
    public void testSaveFuncionario() {
        BeansFuncionario beans = new BeansFuncionario();
        DaoFuncionario dao = new DaoFuncionario();
        
        beans.setNome("Mario");
        beans.setCpf("4567893216");
        beans.setSexo("Masculino");
        beans.setSalario("1100");
        beans.setFuncao("Faxineiro");
        
        dao.Salvar(beans);
    }
 
    @Test
    public void testBuscaFuncionario(){
        BeansFuncionario beans = new BeansFuncionario();
        DaoFuncionario dao = new DaoFuncionario();
        
        beans.setNome("Mario");
        beans.setCpf("4567893216");
        beans.setSexo("Masculino");
        beans.setSalario("1100");
        beans.setFuncao("Faxineiro");
        beans.setPesquisa("Mario");
        
        String nomeAnterior = beans.getNome();
        beans = dao.buscaFuncionario(beans);
        
        if(nomeAnterior.equals(beans.getNome()))
            System.out.println("Encontrado.");
        else
            System.out.println("Não encontrado");
    }
}
