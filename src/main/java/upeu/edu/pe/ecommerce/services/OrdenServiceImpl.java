/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.services;


import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import upeu.edu.pe.ecommerce.models.Orden;
import upeu.edu.pe.ecommerce.models.Usuario;
import upeu.edu.pe.ecommerce.repository.OrdenRepository;
import upeu.edu.pe.ecommerce.repository.UsuarioRepository;

/**
 *
 * @author JAST
 */
@Service
public class OrdenServiceImpl implements OrdenService {

    private OrdenRepository ordenRepository;

    @Transactional
    @Override
    public Orden save(Orden orden) {
        return ordenRepository.save(orden);
    }
    
     @Transactional(readOnly = true)
    @Override
    public List<Orden> findAll() {
        return (List<Orden>) ordenRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    @Override
    public Optional<Orden> findById(Integer id) {
        return ordenRepository.findById(id);
    }

    @Override
    public String generarNumeroOrden() {
        int numero = 0;
        String numeroConcatenado = "";

        List<Orden> ordenes = findAll();

        List<Integer> numeros = new ArrayList<Integer>();

        ordenes.stream().forEach(o -> numeros.add(Integer.parseInt(o.getNumero())));

        if (ordenes.isEmpty()) {
            numero = 1;
        } else {
            numero = numeros.stream().max(Integer::compare).get();
            numero++;
        }

        if (numero < 10) { //0000001000
            numeroConcatenado = "000000000" + String.valueOf(numero);
        } else if (numero < 100) {
            numeroConcatenado = "00000000" + String.valueOf(numero);
        } else if (numero < 1000) {
            numeroConcatenado = "0000000" + String.valueOf(numero);
        } else if (numero < 10000) {
            numeroConcatenado = "0000000" + String.valueOf(numero);
        }

        return numeroConcatenado;
    }
    @Transactional(readOnly = true)
    @Override
    public List<Orden> findByUsuario(Usuario usuario) {
        return ordenRepository.findByUsuario((UsuarioRepository) usuario);
    }

}
