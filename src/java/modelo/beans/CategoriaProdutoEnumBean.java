/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.enumeracao.CategoriaProdutoEnum;

/**
 *
 * @author Gabriel
 */

@ManagedBean (name="categoriaProdutoEnum")
@ApplicationScoped
public class CategoriaProdutoEnumBean implements Serializable {
    
    private CategoriaProdutoEnum[] categorias = {CategoriaProdutoEnum.CASUAL, CategoriaProdutoEnum.FUTEBOL, CategoriaProdutoEnum.CORRIDA} ;
    
    public CategoriaProdutoEnumBean() {
        
    }

    public CategoriaProdutoEnum[] getCategorias() {
        return categorias;
    }
    
}
