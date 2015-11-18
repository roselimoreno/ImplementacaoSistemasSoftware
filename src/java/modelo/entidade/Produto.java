/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidade;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import modelo.enumeracao.DepartamentoEnum;
import modelo.enumeracao.CategoriaEnum;
import modelo.enumeracao.GeneroEnum;

/**
 *
 * @author Gabriel
 */

@ManagedBean (name="produto")
@RequestScoped
@Entity
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private int id ;
    private String nome ;
    private String imagemURL ;
    private double preco ;
    private CategoriaEnum categoria ;
    private DepartamentoEnum departamento ;
    private GeneroEnum genero ;

    public Produto() {
    
    }
    
    public Produto(String nome, String imagemURL, double preco, CategoriaEnum categoria, DepartamentoEnum departamento, GeneroEnum genero) {
        this.nome = nome ;
        this.imagemURL = imagemURL ;
        this.preco = preco ;
        this.categoria = categoria ;
        this.departamento = departamento ;
        this.genero = genero ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagemURL() {
        return imagemURL;
    }

    public void setImagemURL(String imagemURL) {
        this.imagemURL = imagemURL;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public DepartamentoEnum getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoEnum departamento) {
        this.departamento = departamento;
    }
    
    
    
}
