/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.Cuentatipo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author argos
 */
@Stateless
public class CuentatipoFacade extends AbstractFacade<Cuentatipo> implements CuentatipoFacadeLocal {
    @PersistenceContext(unitName = "sinergia-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentatipoFacade() {
        super(Cuentatipo.class);
    }
    
}
