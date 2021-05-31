package modeloDao;

import modeloBeans.BeansFilme;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author vinic
 */
public class DaoFilmeTest {
    
    public DaoFilmeTest() {
    }

    @Test
    @Ignore
    public void testSaveFilme() {
        BeansFilme beans = new BeansFilme();
        DaoFilme dao = new DaoFilme();
        
        beans.setTituloFilme("Batman Begins");
        beans.setGeneroFilme("Ação");
        beans.setSinopseFilme("Origem do Batman");
        beans.setValorEntrada(20);
        
        dao.SalvarFilme(beans);
    }
    
    @Test
    public void testBuscaFilme(){
        BeansFilme beans = new BeansFilme();
        DaoFilme dao = new DaoFilme();
        
        beans.setTituloFilme("Batman Begins");
        beans.setGeneroFilme("Ação");
        beans.setSinopseFilme("Origem do Batman");
        beans.setValorEntrada(20);
        
        String tituloAnterior = beans.getTituloFilme();
        beans = dao.buscaFilme(beans);
        
        if(tituloAnterior.equals(beans.getTituloFilme()))
            System.out.println("Encontrado.");
        else
            System.out.println("Não encontrado");
    }
    
}
