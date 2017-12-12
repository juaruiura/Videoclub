/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.enlaza.videoclub;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juan Manuel
 */
@Entity
@Table(name = "videoclub")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Videoclub.findAll", query = "SELECT v FROM Videoclub v")
    , @NamedQuery(name = "Videoclub.findByCif", query = "SELECT v FROM Videoclub v WHERE v.cif = :cif")
    , @NamedQuery(name = "Videoclub.findByNombre", query = "SELECT v FROM Videoclub v WHERE v.nombre = :nombre")})
public class Videoclub implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "videoclubCif")
    private Collection<Empleado> empleadoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Cif")
    private String cif;
    @Size(max = 255)
    @Column(name = "Nombre")
    private String nombre;

    public Videoclub() {
    }

    public Videoclub(String cif) {
        this.cif = cif;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cif != null ? cif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Videoclub)) {
            return false;
        }
        Videoclub other = (Videoclub) object;
        if ((this.cif == null && other.cif != null) || (this.cif != null && !this.cif.equals(other.cif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.enlaza.videoclub.Videoclub[ cif=" + cif + " ]";
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }
    
}
