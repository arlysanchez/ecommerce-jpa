/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upeu.edu.pe.ecommerce.models.Producto;
import upeu.edu.pe.ecommerce.repository.ProductoRepository;

/**
 *
 * @author JAST
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> get(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    @Transactional
    public void update(Producto producto) {
        productoRepository.save(producto);
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<Producto> findAll() {
         return (List<Producto>) productoRepository.findAll();
    }
    
   @Transactional
   @Override
    public void delete(Integer id) {
        productoRepository.deleteById(id);
    }

  

}
