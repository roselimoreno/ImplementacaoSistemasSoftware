/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.entidade.Produto;
import modelo.enumeracao.CategoriaProdutoEnum;
import modelo.enumeracao.GeneroEnum;
import modelo.enumeracao.OrdenacaoListaEnum;
import modelo.enumeracao.TipoProdutoEnum;
import persistencia.EMF;

/**
 *
 * @author Gabriel
 */
@ManagedBean (name="controladorProduto")
@ViewScoped
public class ControladorProduto implements Serializable {
      
    private EntityManager em ;
   
    private List<Produto> produtosSemFiltros ;
    private List<Produto> produtos ;
    private OrdenacaoListaEnum ordenacaoAtual ;
    
    private GeneroEnum genero ;
    private TipoProdutoEnum tipo ;
    private CategoriaProdutoEnum categoria ;
    
    
    public ControladorProduto() {
        em = EMF.createEntityManager() ;
    }
    
    // CRUD no banco
    public void adicionar(Produto p) {
        if (p.getTipo() == TipoProdutoEnum.BERMUDAS) p.setImagemURL("img/produtos/bermuda.jpg");
        if (p.getTipo() == TipoProdutoEnum.CAMISETAS) p.setImagemURL("img/produtos/camiseta.jpg");
        if (p.getTipo() == TipoProdutoEnum.CALCADOS) p.setImagemURL("img/produtos/tenis.jpg");
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
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
    }
    
    
    //buscas no banco
    public void listarTodosProdutos() {
        em.getTransaction().begin();
        produtosSemFiltros = em.createQuery("from Produto order by id desc").getResultList();
        produtos = produtosSemFiltros ;
        em.getTransaction().commit();
        ordenacaoAtual = OrdenacaoListaEnum.MAIS_NOVOS ;
    }
    
    public void buscarProdutos(GeneroEnum g, TipoProdutoEnum tp) {
        Query query = em.createQuery("from Produto where genero=:g and tipo=:tp order by id desc") ;
        query.setParameter("g",g) ;
        query.setParameter("tp", tp) ;
        
        em.getTransaction().begin();
        produtosSemFiltros = query.getResultList();
        produtos = produtosSemFiltros ;
        em.getTransaction().commit();
        ordenacaoAtual = OrdenacaoListaEnum.MAIS_NOVOS ;
        genero = g ;
        tipo = tp ;
    }
        
    
    //ordençao da lista exibida
    public void ordenarMaisNovos() {
        Collections.sort(produtos, new Comparator<Produto>() {

            @Override
            public int compare(Produto p1, Produto p2) {
                return (int)(p2.getId()-p1.getId()) ;
            }
            
        });
        ordenacaoAtual = OrdenacaoListaEnum.MAIS_NOVOS ;
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
        ordenacaoAtual = OrdenacaoListaEnum.MAIOR_PRECO ;
    }
    
    public void ordenarMenorPreco() {
        Collections.sort(produtos, new Comparator<Produto>() {

            @Override
            public int compare(Produto p1, Produto p2) {
                return (int)(p1.getPreco()-p2.getPreco()) ;
            }
            
        });
        ordenacaoAtual = OrdenacaoListaEnum.MENOR_PRECO ;
    }

    
    //getters e setters
    public List<Produto> getProdutos() {
        return produtos;
    }

    public OrdenacaoListaEnum getOrdenacaoAtual() {
        return ordenacaoAtual;
    }

    public int getIndiceOrdenacaoAtual() {
        if (ordenacaoAtual == OrdenacaoListaEnum.MAIS_NOVOS) return 0 ;
        if (ordenacaoAtual == OrdenacaoListaEnum.MAIS_VENDIDOS) return 1 ;
        if (ordenacaoAtual == OrdenacaoListaEnum.MENOR_PRECO) return 2 ;
        else return 3 ;
    }

    public TipoProdutoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoProdutoEnum tipo) {
        this.tipo = tipo;
    }

    public CategoriaProdutoEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProdutoEnum categoria) {
        this.categoria = categoria;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void setOrdenacaoAtual(OrdenacaoListaEnum ordenacaoAtual) {
        this.ordenacaoAtual = ordenacaoAtual;
    }

    public List<Produto> getProdutoSemFiltros() {
        return produtosSemFiltros;
    }

    public void setProdutoSemFiltros(List<Produto> produtoSemFiltros) {
        this.produtosSemFiltros = produtoSemFiltros;
    }    


}
