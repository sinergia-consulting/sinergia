/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "cuentanodo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuentanodo.findAll", query = "SELECT c FROM Cuentanodo c"),
    @NamedQuery(name = "Cuentanodo.findByPkId", query = "SELECT c FROM Cuentanodo c WHERE c.pkId = :pkId"),
    @NamedQuery(name = "Cuentanodo.findByFecReg", query = "SELECT c FROM Cuentanodo c WHERE c.fecReg = :fecReg"),
    @NamedQuery(name = "Cuentanodo.findByEstadoExistencia", query = "SELECT c FROM Cuentanodo c WHERE c.estadoExistencia = :estadoExistencia")})
public class Cuentanodo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id")
    private Integer pkId;
    @Column(name = "fec_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecReg;
    @Column(name = "estado_existencia")
    private Boolean estadoExistencia;
    @JoinColumn(name = "fk_cuenta_hijo", referencedColumnName = "pk_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cuenta cuenta;
    @JoinColumn(name = "fk_cuenta_padre", referencedColumnName = "pk_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cuenta cuenta1;

    public Cuentanodo() {
    }

    public Cuentanodo(Integer pkId) {
        this.pkId = pkId;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public Date getFecReg() {
        return fecReg;
    }

    public void setFecReg(Date fecReg) {
        this.fecReg = fecReg;
    }

    public Boolean getEstadoExistencia() {
        return estadoExistencia;
    }

    public void setEstadoExistencia(Boolean estadoExistencia) {
        this.estadoExistencia = estadoExistencia;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Cuenta getCuenta1() {
        return cuenta1;
    }

    public void setCuenta1(Cuenta cuenta1) {
        this.cuenta1 = cuenta1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkId != null ? pkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentanodo)) {
            return false;
        }
        Cuentanodo other = (Cuentanodo) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Cuentanodo[ pkId=" + pkId + " ]";
    }
    
}
