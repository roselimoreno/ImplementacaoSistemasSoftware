/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.enumeracao.GeneroEnum;

/**
 *
 * @author Gabriel
 */

@ManagedBean (name="generoEnum")
@ApplicationScoped
public class GeneroEnumBean implements Serializable {

    public GeneroEnumBean() {
        
    }

    public GeneroEnum[] getGeneros() {
        return GeneroEnum.values() ;
    }
    
    public GeneroEnum getMasculino() {
        return GeneroEnum.MASCULINO ;
    }
    
    public GeneroEnum getFeminino() {
        return GeneroEnum.FEMININO ;
    }
    
    
}
