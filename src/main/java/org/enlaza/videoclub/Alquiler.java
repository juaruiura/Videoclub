/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.enlaza.videoclub;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Juan Manuel
 */
@Entity
@Table(name = "alquiler")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alquiler.findAll", query = "SELECT a FROM Alquiler a")
    , @NamedQuery(name = "Alquiler.findById", query = "SELECT a FROM Alquiler a WHERE a.id = :id")
    , @NamedQuery(name = "Alquiler.findByDesde", query = "SELECT a FROM Alquiler a WHERE a.desde = :desde")
    , @NamedQuery(name = "Alquiler.findByHasta", query = "SELECT a FROM Alquiler a WHERE a.hasta = :hasta")
    , @NamedQuery(name = "Alquiler.findByDevolucion", query = "SELECT a FROM Alquiler a WHERE a.devolucion = :devolucion")})
public class Alquiler implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "Desde")
    @Temporal(TemporalType.DATE)
    private Date desde;
    @Column(name = "Hasta")
    @Temporal(TemporalType.DATE)
    private Date hasta;
    @Column(name = "Devolucion")
    @Temporal(TemporalType.DATE)
    private Date devolucion;
    @JoinColumn(name = "PeliculaTitulo", referencedColumnName = "Titulo")
    @ManyToOne(optional = false)
    private Pelicula peliculaTitulo;
    @JoinColumn(name = "EmpleadoNumEmpleado", referencedColumnName = "NumEmpleado")
    @ManyToOne(optional = false)
    private Empleado empleadoNumEmpleado;
    @JoinColumn(name = "ClienteNumSocio", referencedColumnName = "NumSocio")
    @ManyToOne(optional = false)
    private Cliente clienteNumSocio;

    public Alquiler() {
    }

    public Alquiler(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public Date getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(Date devolucion) {
        this.devolucion = devolucion;
    }

    public Pelicula getPeliculaTitulo() {
        return peliculaTitulo;
    }

    public void setPeliculaTitulo(Pelicula peliculaTitulo) {
        this.peliculaTitulo = peliculaTitulo;
    }

    public Empleado getEmpleadoNumEmpleado() {
        return empleadoNumEmpleado;
    }

    public void setEmpleadoNumEmpleado(Empleado empleadoNumEmpleado) {
        this.empleadoNumEmpleado = empleadoNumEmpleado;
    }

    public Cliente getClienteNumSocio() {
        return clienteNumSocio;
    }

    public void setClienteNumSocio(Cliente clienteNumSocio) {
        this.clienteNumSocio = clienteNumSocio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alquiler)) {
            return false;
        }
        Alquiler other = (Alquiler) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.enlaza.videoclub.Alquiler[ id=" + id + " ]";
    }
    
}
