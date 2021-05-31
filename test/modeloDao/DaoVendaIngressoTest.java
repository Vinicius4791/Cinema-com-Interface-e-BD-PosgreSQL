package modeloDao;

import modeloBeans.BeansVendaIngresso;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author vinic
 */
public class DaoVendaIngressoTest {
    
    public DaoVendaIngressoTest() {
    }

    @Test
    @Ignore
    public void testSaveVendaIngresso() {
        BeansVendaIngresso beans = new BeansVendaIngresso();
        DaoVendaIngresso dao = new DaoVendaIngresso();
        
        beans.setNomeCliente("admin");
        beans.setNomeBilheteiro("Daniel");
        beans.setTituloFilme("IT");
        beans.setValorIngresso(20);
        
        dao.Salvar(beans);
    }
    
}
