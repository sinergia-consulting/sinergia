/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "cuentatipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuentatipo.findAll", query = "SELECT c FROM Cuentatipo c"),
    @NamedQuery(name = "Cuentatipo.findByPkId", query = "SELECT c FROM Cuentatipo c WHERE c.pkId = :pkId"),
    @NamedQuery(name = "Cuentatipo.findByDescripcion", query = "SELECT c FROM Cuentatipo c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Cuentatipo.findByDeslarga", query = "SELECT c FROM Cuentatipo c WHERE c.deslarga = :deslarga"),
    @NamedQuery(name = "Cuentatipo.findByFecReg", query = "SELECT c FROM Cuentatipo c WHERE c.fecReg = :fecReg"),
    @NamedQuery(name = "Cuentatipo.findByEstadoExistencia", query = "SELECT c FROM Cuentatipo c WHERE c.estadoExistencia = :estadoExistencia")})
public class Cuentatipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id")
    private Integer pkId;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 2000)
    @Column(name = "deslarga")
    private String deslarga;
    @Column(name = "fec_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecReg;
    @Column(name = "estado_existencia")
    private Boolean estadoExistencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentatipo", fetch = FetchType.LAZY)
    private List<Cuenta> cuentaList;

    public Cuentatipo() {
    }

    public Cuentatipo(Integer pkId) {
        this.pkId = pkId;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDeslarga() {
        return deslarga;
    }

    public void setDeslarga(String deslarga) {
        this.deslarga = deslarga;
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

    @XmlTransient
    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
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
        if (!(object instanceof Cuentatipo)) {
            return false;
        }
        Cuentatipo other = (Cuentatipo) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Cuentatipo[ pkId=" + pkId + " ]";
    }
    
}
