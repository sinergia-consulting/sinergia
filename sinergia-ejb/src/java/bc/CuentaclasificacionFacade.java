/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.Cuentaclasificacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author argos
 */
@Stateless
public class CuentaclasificacionFacade extends AbstractFacade<Cuentaclasificacion> implements CuentaclasificacionFacadeLocal {
    @PersistenceContext(unitName = "sinergia-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentaclasificacionFacade() {
        super(Cuentaclasificacion.class);
    }
    
}
