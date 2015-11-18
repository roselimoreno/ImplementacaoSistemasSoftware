/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.enumeracao.DepartamentoEnum;

/**
 *
 * @author Gabriel
 */

@ManagedBean (name="departamentoEnum")
@ApplicationScoped
public class DepartamentoEnumBean implements Serializable {
    
    
    public DepartamentoEnumBean() {
        
    }

    public DepartamentoEnum[] getDepartamentos() {
        return DepartamentoEnum.values() ;
    }
    
    public DepartamentoEnum getCasual() {
        return DepartamentoEnum.CASUAL ;
    }
    
    public DepartamentoEnum getFutebol() {
        return DepartamentoEnum.FUTEBOL ;
    }
    
    public DepartamentoEnum getCorrida() {
        return DepartamentoEnum.CORRIDA ;
    }
}
