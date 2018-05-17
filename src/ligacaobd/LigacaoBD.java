/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligacaobd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ligacaobd.Models.Cliente;

/**
 *
 * @author ricar
 */
public class LigacaoBD {
    
    private static final String PERSISTENCE_UNIT_NAME = "LigacaoBDPU";
    private static EntityManagerFactory factory;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        
        
        
        Cliente v = new Cliente();
        v.setNome("aosçndg");
        v.setLocalidade("dfgfedg");
        

        
        em.getTransaction().begin();
        em.persist(v);
        em.getTransaction().commit();
        System.out.println(" WORKED");
        
    }
    
}
