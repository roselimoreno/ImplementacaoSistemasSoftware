/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.enumeracao;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Gabriel
 */

@ManagedBean (name="categoriaProdutoEnum")
@ApplicationScoped
public class CategoriaProdutoEnumBean {
    
    private CategoriaProdutoEnum[] categorias = {CategoriaProdutoEnum.CASUAL, CategoriaProdutoEnum.FUTEBOL, CategoriaProdutoEnum.CORRIDA} ;
    
    public CategoriaProdutoEnumBean() {
        
    }

    public CategoriaProdutoEnum[] getCategorias() {
        return categorias;
    }
    
}
