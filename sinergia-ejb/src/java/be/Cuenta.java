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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findByPkId", query = "SELECT c FROM Cuenta c WHERE c.pkId = :pkId"),
    @NamedQuery(name = "Cuenta.findByCodigo", query = "SELECT c FROM Cuenta c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Cuenta.findByDescripcion", query = "SELECT c FROM Cuenta c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Cuenta.findByDeslarga", query = "SELECT c FROM Cuenta c WHERE c.deslarga = :deslarga"),
    @NamedQuery(name = "Cuenta.findByNivel", query = "SELECT c FROM Cuenta c WHERE c.nivel = :nivel"),
    @NamedQuery(name = "Cuenta.findByFecReg", query = "SELECT c FROM Cuenta c WHERE c.fecReg = :fecReg"),
    @NamedQuery(name = "Cuenta.findByEstadoExistencia", query = "SELECT c FROM Cuenta c WHERE c.estadoExistencia = :estadoExistencia")})
public class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id")
    private Integer pkId;
    @Size(max = 20)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 2000)
    @Column(name = "deslarga")
    private String deslarga;
    @Column(name = "nivel")
    private Integer nivel;
    @Column(name = "fec_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecReg;
    @Column(name = "estado_existencia")
    private Boolean estadoExistencia;
    @JoinColumn(name = "fk_cuentatipo", referencedColumnName = "pk_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cuentatipo cuentatipo;
    @JoinColumn(name = "fk_cuentaclasificacion", referencedColumnName = "pk_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cuentaclasificacion cuentaclasificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta", fetch = FetchType.LAZY)
    private List<Cuentanodo> cuentanodoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta1", fetch = FetchType.LAZY)
    private List<Cuentanodo> cuentanodoList1;

    public Cuenta() {
    }

    public Cuenta(Integer pkId) {
        this.pkId = pkId;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
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

    public Cuentatipo getCuentatipo() {
        return cuentatipo;
    }

    public void setCuentatipo(Cuentatipo cuentatipo) {
        this.cuentatipo = cuentatipo;
    }

    public Cuentaclasificacion getCuentaclasificacion() {
        return cuentaclasificacion;
    }

    public void setCuentaclasificacion(Cuentaclasificacion cuentaclasificacion) {
        this.cuentaclasificacion = cuentaclasificacion;
    }

    @XmlTransient
    public List<Cuentanodo> getCuentanodoList() {
        return cuentanodoList;
    }

    public void setCuentanodoList(List<Cuentanodo> cuentanodoList) {
        this.cuentanodoList = cuentanodoList;
    }

    @XmlTransient
    public List<Cuentanodo> getCuentanodoList1() {
        return cuentanodoList1;
    }

    public void setCuentanodoList1(List<Cuentanodo> cuentanodoList1) {
        this.cuentanodoList1 = cuentanodoList1;
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
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Cuenta[ pkId=" + pkId + " ]";
    }
    
}
