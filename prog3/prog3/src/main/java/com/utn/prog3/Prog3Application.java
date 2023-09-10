package com.utn.prog3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.utn.prog3.entities.Cliente;
import com.utn.prog3.entities.DetallePedido;
import com.utn.prog3.entities.Domicilio;
import com.utn.prog3.entities.Factura;
import com.utn.prog3.entities.Pedido;
import com.utn.prog3.entities.Rubro;
import com.utn.prog3.entities.Usuario;
import com.utn.prog3.repository.RepoPedido;
import com.utn.prog3.repository.RepoCliente;
import com.utn.prog3.repository.RepoDetallePedido;
import com.utn.prog3.repository.RepoDomicilio;
import com.utn.prog3.repository.RepoFactura;
import com.utn.prog3.repository.RepoRubro;
import com.utn.prog3.repository.RepoUsuario;

@SpringBootApplication
public class Prog3Application {

    @Autowired
    RepoPedido rPedido;
    @Autowired
    RepoDomicilio rDomicilio;
    @Autowired
    RepoDetallePedido rDetallePedido;
    @Autowired
    RepoProducto rProducto;

    public static void main(String[] args) {
        SpringApplication.run(Prog3Application.class, args);
    }

    @Bean
    CommandLineRunner init(RepoPedido rPedido) {
        return args -> {
            Pedido pedido = new Pedido();
            pedido.setFecha("08-09-2023");
            pedido.setTipoEnvio('DELIVERY');
            pedido.setTotal(2350);
            pedido.setEstado('INICIADO');
            pedido.setHoraEstimadaEntrega("21:35");

            rPedido.save(pedido);

        };
    }

    @Bean
    CommandLineRunner init(RepoDomicilio rDomicilio) {
        return args -> {

            Domicilio domicilio = new Domicilio();
            domicilio.setCalle("Av. San Martin");
            domicilio.setNumero("537");
            domicilio.setLocalidad("Las Heras");

            rDomicilio.save(domicilio);

        };
    }
    
    @Bean
    CommandLineRunner init(RepoDetallePedido rDetallePedido) {
        return args -> {

            DetallePedido detPed = new DetallePedido();
            detPed.setCantidad(2);
            detPed.setSubTotal(2350);

            rDetallePedido.save(detPed);

        };
    }
    
    @Bean
    CommandLineRunner init(RepoProducto rProducto) {
        return args -> {

            Producto producto = new Producto();
            producto.setTipo('MANUFACTURADO');
            producto.setTiempoEstimadoCocina(15);
            producto.setPrecioVenta(1175);
            producto.setPrecioCompra(800);
            producto.setStockActual(32);
            producto.setStockMinimo(10);
            producto.setUnidadMedida("Unidades.");
            producto.setFoto("pizzaMuzzarella.jpg");
            producto.setReceta("Masa Casera(300g), salsa especial(100g),"
                    + "queso muzzarella(200g), 15 minutos de horno");
            producto.setDenominación("Pizzas Clasicas");

            rProducto.save(producto);

        };
    }

    public void mostrarPedido() {
        pedido pedidoRecuperado = rPedido.findById(pedido.getId()).orElse(null);
        if (pedidoRecuperado != null) {
            domicilio domicilioRecuperado = rDomicilio.findById(domicilio.getId()).orElse(null);
            System.out.println("Fecha: " + pedidoRecuperado.getFecha());
            System.out.println("Tipo Envio: " + pedidoRecuperado.getTipoEnvio());
            if (domicilioRecuperado != null) {
                System.out.println("    Domicilio: " + domicilioRecuperado.getCalle() + " "
                        + domicilioRecuperado.getNumero() + ", " + domicilioRecuperado.getLocalidad());
            }
            detPed detPedRecuperado = rDetallePedido.findById(detPed.getId()).orElse(null);
            producto productoRecuperado = rProducto.findById(producto.getId()).orElse(null);
            if (detPedRecuperado != null && productoRecuperado != null) {
                System.out.println("Detalle: " + detPedRecuperado.getCantidad()
                        + productoRecuperado.getUnidadMedida() + " --- " + productoRecuperado.getDenominacion()
                        + ": " + productoRecuperado.getFoto() + " => " + detPedRecuperado.getSubTotal());
            }
            System.out.println("Total: " + pedidoRecuperado.getTotal());
            System.out.println("Estado: " + pedidoRecuperado.getEstado());
            System.out.println("Hora Entrega: " + pedidoRecuperado.getHoraEstimadaEntrega());
        }
    }

}
