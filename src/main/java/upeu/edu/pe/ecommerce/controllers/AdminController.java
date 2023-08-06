/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.controllers;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.ecommerce.models.Orden;
import upeu.edu.pe.ecommerce.models.Producto;
import upeu.edu.pe.ecommerce.services.OrdenService;
import upeu.edu.pe.ecommerce.services.ProductoService;
import upeu.edu.pe.ecommerce.services.UsuarioServices;

/**
 *
 * @author JAST
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    private final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private ProductoService productoService;

    @Autowired
    private OrdenService ordenesService;

    @Autowired
    private UsuarioServices usuarioServices;

    @GetMapping("")
    public String home(Model model, HttpSession session) {
        // log.info("Sesion del admin: {}", session.getAttribute("idusuario"));
        //log.info("nombre del admin: {}", session.getAttribute("nombre"));
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        model.addAttribute("nombre_session", session.getAttribute("nombre"));
        return "admin/home";
    }

    @GetMapping("/ordenes")
    public String ordenes(Model model, HttpSession session) {
        model.addAttribute("ordenes", ordenesService.findAll());
        model.addAttribute("nombre_session", session.getAttribute("nombre"));

        return "admin/ordenes";
    }

    @GetMapping("/detalle/{id}")
    public String detalle(Model model, @PathVariable Integer id, HttpSession session) {
        log.info("Id de la orden {}", id);
        Orden orden = ordenesService.findById(id).get();

        model.addAttribute("detalles", orden.getDetalle_orden());
        model.addAttribute("nombre_session", session.getAttribute("nombre"));

        return "admin/detalleorden";
    }

    @GetMapping("/usuarios")
    public String usuarios(Model model, HttpSession session) {
        model.addAttribute("usuarios", usuarioServices.findAll());
        model.addAttribute("nombre_session", session.getAttribute("nombre"));

        return "admin/usuarios";
    }

}
