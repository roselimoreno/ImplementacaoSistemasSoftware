/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.enumeracao;

/**
 *
 * @author Gabriel
 */
public enum CategoriaProdutoEnum {
    
    CORRIDA("Corrida"), FUTEBOL("Futebol"), CASUAL("Casual") ;
    
    private final String str;
    
    private CategoriaProdutoEnum(final String str) {
        this.str = str;
    }
    
    
    @Override
    public String toString() {
        return str;
    }
}
