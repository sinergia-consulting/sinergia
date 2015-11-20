/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.Cuentanodo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author argos
 */
@Local
public interface CuentanodoFacadeLocal {

    void create(Cuentanodo cuentanodo);

    void edit(Cuentanodo cuentanodo);

    void remove(Cuentanodo cuentanodo);

    Cuentanodo find(Object id);

    List<Cuentanodo> findAll();

    List<Cuentanodo> findRange(int[] range);

    int count();
    
}
