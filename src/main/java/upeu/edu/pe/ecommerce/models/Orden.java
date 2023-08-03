/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JAST
 */

@Entity
@Table(name = "ordenes")
public class Orden {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;
    private double total;
    
    @ManyToOne
    private Usuario usuario;
    
    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleOrden> detalle_orden;
    
    public Orden() {
    }

    public Orden(Integer id, String numero, Date fechaCreacion, Date fechaRecibida, double total, Usuario usuario) {
        this.id = id;
        this.numero = numero;
        this.fechaCreacion = fechaCreacion;
        this.fechaRecibida = fechaRecibida;
        this.total = total;
        this.usuario = usuario;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaRecibida() {
        return fechaRecibida;
    }

    public void setFechaRecibida(Date fechaRecibida) {
        this.fechaRecibida = fechaRecibida;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<DetalleOrden> getDetalle_orden() {
        return detalle_orden;
    }

    public void setDetalle_orden(List<DetalleOrden> detalle_orden) {
        this.detalle_orden = detalle_orden;
    }

      
    

    @Override
    public String toString() {
        return "Orden{" + "id=" + id + ", numero=" + numero + ", fechaCreacion=" + fechaCreacion + ", fechaRecibida=" + fechaRecibida + ", total=" + total + '}';
    }
    
    
    

    
}
