/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.enumeracao.CategoriaEnum;


 /**
 *
 * @author Gabriel
 */


@ManagedBean (name="categoriaEnum")
@ApplicationScoped
public class CategoriaEnumBean implements Serializable {
    

    public CategoriaEnumBean() {
        
    }

    public CategoriaEnum[] getCategorias() {
        return CategoriaEnum.values() ;
    }
    
    public CategoriaEnum getCamisetas() {
        return CategoriaEnum.CAMISETAS ;
    }
    
    public CategoriaEnum getBermudas() {
        return CategoriaEnum.BERMUDAS ;
    }
    
     public CategoriaEnum getCalcados() {
        return CategoriaEnum.CALCADOS ;
    }
    
}
