/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.controllers;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import upeu.edu.pe.ecommerce.models.DetalleOrden;
import upeu.edu.pe.ecommerce.models.Orden;
import upeu.edu.pe.ecommerce.models.Producto;
import upeu.edu.pe.ecommerce.models.Usuario;
import upeu.edu.pe.ecommerce.services.DetalleOrdenService;
import upeu.edu.pe.ecommerce.services.OrdenService;
import upeu.edu.pe.ecommerce.services.ProductoService;
import upeu.edu.pe.ecommerce.services.UsuarioServices;

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

    @Autowired
    private UsuarioServices usuarioService;

    @Autowired
    private OrdenService ordenService;

    @Autowired
    private DetalleOrdenService detalleOrdenService;

    // para almacenar los detalles de la orden
    List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();

    // datos de la orden
    Orden orden = new Orden();

    @GetMapping("")
    public String home(Model model) {

        // log.info("Sesion del usuario: {}", session.getAttribute("idusuario"));
        model.addAttribute("productos", productoService.findAll());
        //session
        // model.addAttribute("sesion", session.getAttribute("idusuario"));

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

    @PostMapping("/cart")
    public String addCart(@RequestParam Integer id, @RequestParam Integer cantidad, Model model) {
        DetalleOrden detalleOrden = new DetalleOrden();
        Producto producto = new Producto();
        double sumaTotal = 0;

        Optional<Producto> optionalProducto = productoService.get(id);
        log.info("Producto añadido: {}", optionalProducto.get());
        log.info("Cantidad: {}", cantidad);
        producto = optionalProducto.get();

        detalleOrden.setCantidad(cantidad);
        detalleOrden.setPrecio(producto.getPrecio());
        detalleOrden.setNombre(producto.getNombre());
        detalleOrden.setTotal(producto.getPrecio() * cantidad);
        detalleOrden.setProducto(producto);

        //validar que le producto no se añada 2 veces
        Integer idProducto = producto.getId();
        boolean ingresado = detalles.stream().anyMatch(p -> p.getProducto().getId() == idProducto);

        if (!ingresado) {
            detalles.add(detalleOrden);
        }

        sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

        orden.setTotal(sumaTotal);
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);

        return "usuario/carrito";
    }

    @GetMapping("/delete/cart/{id}")
    public String deleteProductoCart(@PathVariable Integer id, Model model) {

        // lista nueva de prodcutos
        List<DetalleOrden> ordenesNueva = new ArrayList<DetalleOrden>();

        for (DetalleOrden detalleOrden : detalles) {
            if (detalleOrden.getProducto().getId() != id) {
                ordenesNueva.add(detalleOrden);
            }
        }

        // poner la nueva lista con los productos restantes
        detalles = ordenesNueva;

        double sumaTotal = 0;
        sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

        orden.setTotal(sumaTotal);
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);

        return "usuario/carrito";
    }

    @GetMapping("/getCart")
    public String getCart(Model model) {

        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);

        //sesion
        // model.addAttribute("sesion", session.getAttribute("idusuario"));
        return "/usuario/carrito";
    }

    @GetMapping("/order")
    public String order(Model model) {

        //Usuario usuario = usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString())).get();
        Usuario usuario = usuarioService.findById(1).get();
        log.info("ver el usuario {}", usuario);

        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);
        model.addAttribute("usuario", usuario);

        return "usuario/resumenorden";
    }

    @GetMapping("/saveOrder")
    public String saveOrder() {
        Date fechaCreacion = new Date();
        orden.setFechaCreacion(fechaCreacion);
        orden.setNumero(ordenService.generarNumeroOrden());

        //usuario
        // Usuario usuario = usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString())).get();
        Usuario usuario = usuarioService.findById(1).get();
        orden.setUsuario(usuario);//añadir el usuario a la orden
        ordenService.save(orden);//guardar la orden

        //guardar detalles
        for (DetalleOrden dt : detalles) {
            dt.setOrden(orden);
            detalleOrdenService.save(dt);//guardar detalle de la orden
        }

        ///limpiar lista y orden
        orden = new Orden();
        detalles.clear();

        return "redirect:/";

    }

    @PostMapping("/search")
    public String searchProduct(@RequestParam String nombre, Model model) {
        log.info("Nombre del producto: {}", nombre);
        List<Producto> productos = productoService.findAll().stream().filter(p -> p.getNombre().contains(nombre)).collect(Collectors.toList());
        model.addAttribute("productos", productos);
        return "usuario/home";
    }

}
