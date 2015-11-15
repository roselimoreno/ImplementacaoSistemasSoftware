/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import modelo.entidade.Produto;
import modelo.enumeracao.TipoProdutoEnum;
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
        if (p.getTipo() == TipoProdutoEnum.BERMUDAS) p.setImagemURL("img/produtos/bermuda.jpg");
        if (p.getTipo() == TipoProdutoEnum.CAMISETAS) p.setImagemURL("img/produtos/camiseta.jpg");
        if (p.getTipo() == TipoProdutoEnum.CALCADOS) p.setImagemURL("img/produtos/tenis.jpg");
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        listarProdutos() ;
    }
    
    public void atualizar(Produto p, int id) {
        em.getTransaction().begin() ;
        Produto pAux = em.find(Produto.class, id) ;
        pAux.setNome(p.getNome());
        pAux.setTipo(p.getTipo());
        pAux.setGenero(p.getGenero());
        em.merge(pAux) ;
        em.getTransaction().commit() ;
    }
    
    public void remover(int id) {
        em.getTransaction().begin();
        Produto p = em.find(Produto.class, id) ;
        em.remove(p);
        em.getTransaction().commit();
        listarProdutos() ;
    }
    
    public void listarProdutos() {
        em.getTransaction().begin();
        produtos = em.createQuery("from Produto").getResultList();
        em.getTransaction().commit();
    }
    
    public void ordenarMaisVendidos() {
        
    }
    
    public void ordenarMaiorPreco() {
        Collections.sort(produtos, new Comparator<Produto>() {

            @Override
            public int compare(Produto p1, Produto p2) {
                return (int)(p2.getPreco()-p1.getPreco()) ;
            }
            
        });
    }
    
    public void ordenarMenorPreco() {
        Collections.sort(produtos, new Comparator<Produto>() {

            @Override
            public int compare(Produto p1, Produto p2) {
                return (int)(p1.getPreco()-p2.getPreco()) ;
            }
            
        });
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
