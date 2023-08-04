/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.ecommerce.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.ecommerce.models.Orden;
import upeu.edu.pe.ecommerce.models.Usuario;

/**
 *
 * @author JAST
 */
@Repository
public interface OrdenRepository extends CrudRepository<Orden, Integer>{
    List<Orden> findByUsuario (Usuario usuario);
    
}
