/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.controllers;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.ecommerce.models.Usuario;
import upeu.edu.pe.ecommerce.services.UsuarioServices;

/**
 *
 * @author JAST
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioServices usuarioService;
    
    //BCryptPasswordEncoder passEncode= new BCryptPasswordEncoder();

    // /usuario/registro
    @GetMapping("/registro")
    public String create() {
        return "usuario/registro";
    }

    @PostMapping("/save")
    public String save(Usuario usuario) {
        logger.info("Usuario registro: {}", usuario);
        usuario.setTipo("USER");
        //usuario.setPassword(passEncode.encode(usuario.getPassword()));
        usuarioService.save(usuario);
        return "redirect:/";
    }

}
