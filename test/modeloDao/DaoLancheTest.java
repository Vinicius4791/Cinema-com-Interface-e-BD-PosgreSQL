/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;

import modeloBeans.BeansLanche;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author vinic
 */
public class DaoLancheTest {
    
    public DaoLancheTest() {
    }

    @Test
    @Ignore
    public void testSaveLanche() {
        BeansLanche beans = new BeansLanche();
        DaoLanche dao = new DaoLanche();
        
        beans.setNomeLanche("Batata Frita Média");
        beans.setIngredientesLanche("Batata, óleo, sal.");
        beans.setPrecoLanche(10);
        
        dao.Salvar(beans);
    }
    
    @Test
    public void testBuscaLanche(){
        BeansLanche beans = new BeansLanche();
        DaoLanche dao = new DaoLanche();
        
        beans.setNomeLanche("Batata Frita Média");
        beans.setIngredientesLanche("Batata, óleo, sal.");
        beans.setPrecoLanche(10);
        beans.setPesquisa("Batata Frita Média");
        
        String nomeAnterior = beans.getNomeLanche();
        beans = dao.buscaLanche(beans);
        
        if(nomeAnterior.equals(beans.getNomeLanche()))
            System.out.println("Encontrado.");
        else
            System.out.println("Não encontrado");
    }
    
}
