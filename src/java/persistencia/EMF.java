/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import modelo.entidade.Produto;
import modelo.enumeracao.TipoProdutoEnum;
import modelo.enumeracao.GeneroEnum;

/**
 *
 * @author Gabriel
 */

@WebListener
public class EMF implements ServletContextListener {
    
    private static EntityManagerFactory emf; 
     
    
   @Override 
    public void contextInitialized(ServletContextEvent event) {  
        emf = Persistence.createEntityManagerFactory("TrabalhoISS");  
        
        EntityManager em = emf.createEntityManager();
        
    }  
   
   @Override
    public void contextDestroyed(ServletContextEvent event) {  
        emf.close();  
    }  
    
 
    public static EntityManager createEntityManager() {  
        if (emf == null) {  
            throw new IllegalStateException("Contexto nao inicializado");  
        } return emf.createEntityManager() ;
    }  
    
} 
