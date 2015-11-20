/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.Cuentatipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author argos
 */
@Local
public interface CuentatipoFacadeLocal {

    void create(Cuentatipo cuentatipo);

    void edit(Cuentatipo cuentatipo);

    void remove(Cuentatipo cuentatipo);

    Cuentatipo find(Object id);

    List<Cuentatipo> findAll();

    List<Cuentatipo> findRange(int[] range);

    int count();
    
}
