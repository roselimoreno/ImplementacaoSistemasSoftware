/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidade;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import modelo.enumeracao.CategoriasEnum;
import modelo.enumeracao.GenerosEnum;

/**
 *
 * @author Gabriel
 */

@ManagedBean (name="produto")
@RequestScoped
@Entity
public class Produto {
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private int id ;
    private String nome ;
    private CategoriasEnum categoria ;
    private GenerosEnum genero ;

    public Produto() {
    
    }
    
    public Produto(String nome, CategoriasEnum categoria, GenerosEnum genero) {
        this.nome = nome ;
        this.categoria = categoria ;
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

    public CategoriasEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasEnum categoria) {
        this.categoria = categoria;
    }

    public GenerosEnum getGenero() {
        return genero;
    }

    public void setGenero(GenerosEnum genero) {
        this.genero = genero;
    }
    
    
    
    

}
