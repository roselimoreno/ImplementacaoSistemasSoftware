/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.enumeracao.OrdenacaoListaEnum;

/**
 *
 * @author Gabriel
 */

@ManagedBean (name="ordenacaoLista")
@ApplicationScoped
public class OrdenacaoListaEnumBean {
    
    public OrdenacaoListaEnumBean() {
        
    }
    
    public OrdenacaoListaEnum getMaisNovos() {
       return OrdenacaoListaEnum.MAIS_NOVOS ;
    }
    
    public OrdenacaoListaEnum getMaisVendidos() {
       return OrdenacaoListaEnum.MAIS_VENDIDOS ;
    }
     
    public OrdenacaoListaEnum getMenorPreco() {
       return OrdenacaoListaEnum.MENOR_PRECO ;
    }
    
    public OrdenacaoListaEnum getMaiorPreco() {
       return OrdenacaoListaEnum.MAIOR_PRECO ;
    }
}
