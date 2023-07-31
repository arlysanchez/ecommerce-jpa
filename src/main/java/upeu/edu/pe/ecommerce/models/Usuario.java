/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author JAST
 */
@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
    private String tipo;
    private String username;
    private String password;
    
    @OneToMany(mappedBy = "usuario")
    private List<Producto> productos;
    
    @OneToMany(mappedBy = "usuario")
    private List<Orden> ordenes;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String email, String direccion, String telefono, String tipo, String username, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipo = tipo;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", direccion=" + direccion + ", telefono=" + telefono + ", tipo=" + tipo + ", username=" + username + ", password=" + password + '}';
    }
    
    
    
    }


