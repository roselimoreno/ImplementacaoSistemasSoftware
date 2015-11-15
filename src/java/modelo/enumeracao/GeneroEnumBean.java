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

@ManagedBean (name="generoEnum")
@ApplicationScoped
public class GeneroEnumBean {
    
    private GeneroEnum generos[] = {GeneroEnum.MASCULINO, GeneroEnum.FEMININO, GeneroEnum.UNISEX} ;

    public GeneroEnumBean() {
        
    }

    public GeneroEnum[] getGeneros() {
        return generos;
    }

   
    
}
