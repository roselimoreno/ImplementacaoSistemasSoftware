/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.enumeracao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Gabriel
 */


public enum TipoProdutoEnum {
    
    CAMISETAS("Camisetas"), BERMUDAS("Bermudas"), CALCADOS("Calçados") ;
    
    private final String str;
    
    private TipoProdutoEnum(final String str) {
        this.str = str;
    }
       
    
    @Override
    public String toString() {
        return str;
    }
}
