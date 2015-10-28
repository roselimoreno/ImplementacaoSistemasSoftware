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


public enum GenerosEnum {
    
    MASCULINO("Masculino"), FEMININO("Feminino"), UNISEX("Unisex") ;
    
    private final String str;
    
    private GenerosEnum(final String str) {
        this.str = str;
    }
    
    
    @Override
    public String toString() {
        return str;
    }
}