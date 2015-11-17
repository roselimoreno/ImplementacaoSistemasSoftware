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
    
    private TipoProdutoEnum[] tipos = {TipoProdutoEnum.CAMISETAS, TipoProdutoEnum.BERMUDAS, TipoProdutoEnum.CALCADOS} ;

    public TipoProdutoEnumBean() {
        
    }

    public TipoProdutoEnum[] getTipos() {
        return tipos;
    }
    
}
