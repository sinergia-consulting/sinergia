/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.Cuentaclasificacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author argos
 */
@Local
public interface CuentaclasificacionFacadeLocal {

    void create(Cuentaclasificacion cuentaclasificacion);

    void edit(Cuentaclasificacion cuentaclasificacion);

    void remove(Cuentaclasificacion cuentaclasificacion);

    Cuentaclasificacion find(Object id);

    List<Cuentaclasificacion> findAll();

    List<Cuentaclasificacion> findRange(int[] range);

    int count();
    
}
