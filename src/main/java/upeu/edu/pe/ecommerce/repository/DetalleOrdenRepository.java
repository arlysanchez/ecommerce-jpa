/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.ecommerce.models.DetalleOrden;

/**
 *
 * @author JAST
 */
@Repository
public interface DetalleOrdenRepository extends CrudRepository<DetalleOrden, Integer>{
    
}
