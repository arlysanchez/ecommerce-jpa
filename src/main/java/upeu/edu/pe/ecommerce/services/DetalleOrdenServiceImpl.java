/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upeu.edu.pe.ecommerce.models.DetalleOrden;
import upeu.edu.pe.ecommerce.repository.DetalleOrdenRepository;

/**
 *
 * @author JAST
 */
@Service
public class DetalleOrdenServiceImpl implements DetalleOrdenService {

    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;
    
    @Transactional
    @Override
    public DetalleOrden save(DetalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }

}
