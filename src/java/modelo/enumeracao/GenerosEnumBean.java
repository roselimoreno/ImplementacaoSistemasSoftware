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

@ManagedBean (name="generosEnum")
@ApplicationScoped
public class GenerosEnumBean {
    
    private GenerosEnum generos[] = {GenerosEnum.MASCULINO, GenerosEnum.FEMININO, GenerosEnum.UNISEX} ;

    public GenerosEnumBean() {
        
    }

    public GenerosEnum[] getGeneros() {
        return generos;
    }

   
    
}
