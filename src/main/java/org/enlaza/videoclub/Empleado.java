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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juan Manuel
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByNumEmpleado", query = "SELECT e FROM Empleado e WHERE e.numEmpleado = :numEmpleado")
    , @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Empleado.findByApellidos", query = "SELECT e FROM Empleado e WHERE e.apellidos = :apellidos")})
public class Empleado implements Serializable {

    @Lob
    @Column(name = "Foto")
    private byte[] foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoNumEmpleado")
    private Collection<Alquiler> alquilerCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NumEmpleado")
    private Integer numEmpleado;
    @Size(max = 255)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "Apellidos")
    private String apellidos;
    @JoinColumn(name = "VideoclubCif", referencedColumnName = "Cif")
    @ManyToOne(optional = false)
    private Videoclub videoclubCif;

    public Empleado() {
    }

    public Empleado(Integer numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public Integer getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(Integer numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    public Videoclub getVideoclubCif() {
        return videoclubCif;
    }

    public void setVideoclubCif(Videoclub videoclubCif) {
        this.videoclubCif = videoclubCif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numEmpleado != null ? numEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.numEmpleado == null && other.numEmpleado != null) || (this.numEmpleado != null && !this.numEmpleado.equals(other.numEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.enlaza.videoclub.Empleado[ numEmpleado=" + numEmpleado + " ]";
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @XmlTransient
    public Collection<Alquiler> getAlquilerCollection() {
        return alquilerCollection;
    }

    public void setAlquilerCollection(Collection<Alquiler> alquilerCollection) {
        this.alquilerCollection = alquilerCollection;
    }
    
}
