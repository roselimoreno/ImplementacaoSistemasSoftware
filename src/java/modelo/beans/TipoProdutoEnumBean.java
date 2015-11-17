/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.enumeracao.TipoProdutoEnum;

/**
 *
 * @author Gabriel
 */


@ManagedBean (name="tipoProdutoEnum")
@ApplicationScoped
public class TipoProdutoEnumBean implements Serializable {
    

    public TipoProdutoEnumBean() {
        
    }

    public TipoProdutoEnum[] getTipos() {
        return TipoProdutoEnum.values() ;
    }
    
    public TipoProdutoEnum getCamisetas() {
        return TipoProdutoEnum.CAMISETAS ;
    }
    
    public TipoProdutoEnum getBermudas() {
        return TipoProdutoEnum.BERMUDAS ;
    }
    
     public TipoProdutoEnum getCalcados() {
        return TipoProdutoEnum.CALCADOS ;
    }
    
}
