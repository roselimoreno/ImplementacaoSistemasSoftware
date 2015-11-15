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


@ManagedBean (name="tipoProdutoEnum")
@ApplicationScoped
public class TipoProdutoEnumBean {
    
    private TipoProdutoEnum[] tipos = {TipoProdutoEnum.CAMISETAS, TipoProdutoEnum.BERMUDAS, TipoProdutoEnum.CALCADOS} ;

    public TipoProdutoEnumBean() {
        
    }

    public TipoProdutoEnum[] getTipos() {
        return tipos;
    }
    
}
