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


@ManagedBean (name="categoriasEnum")
@ApplicationScoped
public class CategoriasEnumBean {
    
    private CategoriasEnum categorias[] = {CategoriasEnum.CAMISETAS, CategoriasEnum.BERMUDAS, CategoriasEnum.CALCADOS} ;

    public CategoriasEnumBean() {
        
    }

    public CategoriasEnum[] getCategorias() {
        return categorias;
    }
    
}
