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


public enum CategoriasEnum {
    
    CAMISETAS("Camisetas"), BERMUDAS("Bermudas"), CALCADOS("Calçados") ;
    
    private final String str;
    
    private CategoriasEnum(final String str) {
        this.str = str;
    }
    
    
    @Override
    public String toString() {
        return str;
    }
}
