/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.ecommerce.services;

import java.util.List;
import java.util.Optional;
import upeu.edu.pe.ecommerce.models.Usuario;

/**
 *
 * @author JAST
 */
public interface UsuarioServices {

    List<Usuario> findAll();
    Optional<Usuario> findById(Integer id);
    Usuario save(Usuario usuario);
    Optional<Usuario> findByEmail(String email);
}
