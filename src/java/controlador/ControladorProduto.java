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
import modelo.enumeracao.DepartamentoEnum;
import modelo.enumeracao.GeneroEnum;
import modelo.enumeracao.OrdenacaoListaEnum;
import modelo.enumeracao.CategoriaEnum;
import persistencia.EMF;

/**
 *
 * @author Gabriel
 */
@ManagedBean (name="controladorProduto")
@ViewScoped
public class ControladorProduto implements Serializable {
      
    private EntityManager em ;
   
    private boolean buscaRealizada ;
    private List<Produto> produtosSemFiltros ;
    private List<Produto> produtos ;
    private String campoBusca ;
   
    
    private GeneroEnum genero ;
    private CategoriaEnum categoria ;
    private DepartamentoEnum departamento ;
    private OrdenacaoListaEnum ordenacaoAtual ;
    
    
    public ControladorProduto() {
        em = EMF.createEntityManager() ;
    }
    
    // CRUD produtos
    public void adicionar(Produto p) {
       
        //imagens temporarias apenas para a fase de testes do projeto
        if (p.getGenero() == GeneroEnum.MASCULINO) {
            if (p.getCategoria() == CategoriaEnum.BERMUDAS) {
                if (p.getDepartamento() == DepartamentoEnum.CASUAL) p.setImagemURL("img/produtos/bermudaMascCas.jpg");
                if (p.getDepartamento() == DepartamentoEnum.FUTEBOL) p.setImagemURL("img/produtos/bermudaMascFut.jpg");
                if (p.getDepartamento() == DepartamentoEnum.CORRIDA) p.setImagemURL("img/produtos/bermudaMascCor.jpg");
            }     
            if (p.getCategoria() == CategoriaEnum.CAMISETAS) {
                if (p.getDepartamento() == DepartamentoEnum.CASUAL) p.setImagemURL("img/produtos/camisetaMascCas.jpg");
                if (p.getDepartamento() == DepartamentoEnum.FUTEBOL) p.setImagemURL("img/produtos/camisetaMascFut.jpg");
                if (p.getDepartamento() == DepartamentoEnum.CORRIDA) p.setImagemURL("img/produtos/camisetaMascCor.jpg");
            }
            if (p.getCategoria() == CategoriaEnum.CALCADOS) {
                if (p.getDepartamento() == DepartamentoEnum.CASUAL) p.setImagemURL("img/produtos/calcadoMascCas.jpg");
                if (p.getDepartamento() == DepartamentoEnum.FUTEBOL) p.setImagemURL("img/produtos/calcadoMascFut.jpg");
                if (p.getDepartamento() == DepartamentoEnum.CORRIDA) p.setImagemURL("img/produtos/calcadoMascCor.jpg");
            }
        }
        
        if (p.getGenero() == GeneroEnum.FEMININO) {
            if (p.getCategoria() == CategoriaEnum.BERMUDAS) {
                if (p.getDepartamento() == DepartamentoEnum.CASUAL) p.setImagemURL("img/produtos/bermudaFemCas.jpg");
                if (p.getDepartamento() == DepartamentoEnum.FUTEBOL) p.setImagemURL("img/produtos/bermudaFemFut.jpg");
                if (p.getDepartamento() == DepartamentoEnum.CORRIDA) p.setImagemURL("img/produtos/bermudaFemCor.jpg");    
            }
            if (p.getCategoria() == CategoriaEnum.CAMISETAS) {
                if (p.getDepartamento() == DepartamentoEnum.CASUAL) p.setImagemURL("img/produtos/camisetaFemCas.jpg");
                if (p.getDepartamento() == DepartamentoEnum.FUTEBOL) p.setImagemURL("img/produtos/camisetaFemFut.jpg");
                if (p.getDepartamento() == DepartamentoEnum.CORRIDA) p.setImagemURL("img/produtos/camisetaFemCor.jpg");
            }
            if (p.getCategoria() == CategoriaEnum.CALCADOS) {
                if (p.getDepartamento() == DepartamentoEnum.CASUAL) p.setImagemURL("img/produtos/calcadoFemCas.jpg");
                if (p.getDepartamento() == DepartamentoEnum.FUTEBOL) p.setImagemURL("img/produtos/calcadoFemFut.jpg");
                if (p.getDepartamento() == DepartamentoEnum.CORRIDA) p.setImagemURL("img/produtos/calcadoFemCor.jpg");
            }
        }
        
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
    
     public void insereProdutosTeste() {
        for(GeneroEnum g : GeneroEnum.values()) {
            for (CategoriaEnum c : CategoriaEnum.values()) {
                for (DepartamentoEnum d : DepartamentoEnum.values()) {
                    Produto p = new Produto("TESTE", null, 0, c, d, g) ;
                    adicionar(p) ;
                }
            }
        }
    }
    
    //queries no banco
    public void listarTodosProdutos() {
        Query q = em.createQuery("from Produto order by id desc") ;
        executarQuery(q);
    }
    
    public void buscarProdutosStr(String str) {
        Query q = em.createQuery("from Produto where nome=:str order by id desc") ;
        q.setParameter("str",str) ;
        executarQuery(q);
    }
    
    public void buscarProdutosGenCat(GeneroEnum g, CategoriaEnum c) {
        Query q = em.createQuery("from Produto where genero=:g and categoria=:c order by id desc") ;
        q.setParameter("g",g) ;
        q.setParameter("c", c) ;
        genero = g ;
        categoria = c ;
        executarQuery(q);
    }
    
    public void buscarProdutosGenDep(GeneroEnum g, DepartamentoEnum d) {
        Query q = em.createQuery("from Produto where genero=:g and departamento=:d order by id desc") ;
        q.setParameter("g",g) ;
        q.setParameter("d", d) ;
        genero = g ;
        departamento = d ;
        executarQuery(q);
    }
    
    public void buscarProdutosGenDepCat(GeneroEnum g, DepartamentoEnum d, CategoriaEnum c) {
        Query q = em.createQuery("from Produto where genero=:g and departamento=:d and categoria=:c order by id desc") ;
        q.setParameter("g",g) ;
        q.setParameter("d", d) ;
        q.setParameter("c", c) ;
        genero = g ;
        departamento = d ;
        categoria = c ;
        executarQuery(q);
    }
        
    public void executarQuery(Query q) {
        em.getTransaction().begin();
        produtosSemFiltros = q.getResultList();
        produtos = produtosSemFiltros ;
        em.getTransaction().commit();
        ordenacaoAtual = OrdenacaoListaEnum.MAIS_NOVOS ;
        buscaRealizada = true ;
    }
    

    //ordenaçao da lista exibida
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

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }

    public DepartamentoEnum getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoEnum departamento) {
        this.departamento = departamento;
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

    public boolean isBuscaRealizada() {
        return buscaRealizada;
    }

    public String getCampoBusca() {
        return campoBusca;
    }

    public void setCampoBusca(String campoBusca) {
        this.campoBusca = campoBusca;
    }

    
    
    
}
