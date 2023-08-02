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
import upeu.edu.pe.ecommerce.models.Usuario;
import upeu.edu.pe.ecommerce.repository.UsuarioRepository;

/**
 *
 * @author JAST
 */
@Service
public class UsuarioServiceImpl implements UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    @Override
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }
    
    @Transactional
    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    @Transactional(readOnly = true)
    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

}
