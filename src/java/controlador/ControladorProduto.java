/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import modelo.entidade.Produto;
import persistencia.EMF;

/**
 *
 * @author Gabriel
 */
@ManagedBean (name="controladorProduto")
@SessionScoped
public class ControladorProduto {
    
    private Produto produto ;
    private List<Produto> produtos ;
    private EntityManager em ;

    
    public ControladorProduto() {
        em = EMF.createEntityManager() ;
    }
    
    public void adicionar(Produto p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
    
    public void atualizar(Produto p, int id) {
        em.getTransaction().begin() ;
        Produto pAux = em.find(Produto.class, id) ;
        pAux.setNome(p.getNome());
        pAux.setCategoria(p.getCategoria());
        pAux.setGenero(p.getGenero());
        em.merge(pAux) ;
        em.getTransaction().commit() ;
    }
    
    public void remover(int id) {
        em.getTransaction().begin();
        Produto p = em.find(Produto.class, id) ;
        em.remove(p);
        em.getTransaction().commit();
    }
    
    public void listarProdutos() {
        em.getTransaction().begin();
        produtos = em.createQuery("from Produto").getResultList();
        em.getTransaction().commit();
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    
    
}
