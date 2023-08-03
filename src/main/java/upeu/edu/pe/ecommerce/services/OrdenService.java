/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.ecommerce.services;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.ecommerce.models.Orden;
import upeu.edu.pe.ecommerce.models.Usuario;

/**
 *
 * @author JAST
 */
public interface OrdenService {

    List<Orden> findAll();
    Optional<Orden> findById(Integer id);
    Orden save(Orden orden);
    String generarNumeroOrden();
    List<Orden> findByUsuario(Usuario usuario);
}
