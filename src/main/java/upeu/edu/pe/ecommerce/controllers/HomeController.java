/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.controllers;

import jakarta.servlet.http.HttpSession;
import java.util.Optional;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.ecommerce.models.Producto;
import upeu.edu.pe.ecommerce.services.ProductoService;

/**
 *
 * @author JAST
 */
@Controller

@RequestMapping("/")
public class HomeController {
    	private final Logger log = LoggerFactory.getLogger(HomeController.class);
        
        @Autowired
	private ProductoService productoService;


    @GetMapping("")
    public String home(Model model, HttpSession session) {

        log.info("Sesion del usuario: {}", session.getAttribute("idusuario"));

        model.addAttribute("productos", productoService.findAll());
        //session
        model.addAttribute("sesion", session.getAttribute("idusuario"));

        return "usuario/home";
    }
    @GetMapping("productohome/{id}")
	public String productoHome(@PathVariable Integer id, Model model) {
		log.info("Id producto enviado como parámetro {}", id);
		      Producto producto = new Producto();
		      Optional<Producto> productoOptional = productoService.get(id);
		producto = productoOptional.get();

		model.addAttribute("producto", producto);

		return "usuario/productohome";
	}

}
