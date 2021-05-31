package modeloDao;

import modeloBeans.BeansVendaLanche;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vinic
 */
public class DaoVendaLancheTest {
    
    public DaoVendaLancheTest() {
    }

    @Test
    public void testSaveVendaLanche() {
        BeansVendaLanche beans = new BeansVendaLanche();
        DaoVendaLanche dao = new DaoVendaLanche();
        
        beans.setVendaNomeCliente("Carlos");
        beans.setVendaNomeVendedor("Daniel");
        beans.setVendaNomeCliente("Água");
        beans.setValorVenda(2);
        
        dao.Salvar(beans);
    }
    
}
