public static void main(String[] args) {

    Categoria cat = Categoria.builder()
            .id(1L)
            .nombre("Hamburguesas")
            .build();

    Producto prod = Producto.builder()
            .id(1L)
            .nombre("Burger")
            .descripcion("Doble carne")
            .precio(2000)
            .categoria(cat)
            .build();

    System.out.println(prod);
}

DetallePedido d1 = DetallePedido.builder()
        .producto(prod1)
        .cantidad(2)
        .build();

Pedido pedido = Pedido.builder()
        .id(1L)
        .detalles(List.of(d1))
        .estado(Estado.PENDIENTE)
        .formaPago(FormaPago.EFECTIVO)
        .build();

System.out.println(pedido.calcularTotal());

package com.utn;

import com.utn.entities.*;
import com.utn.enums.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        
        Categoria cat1 = Categoria.builder().id(1L).nombre("Hamburguesas").build();
        Categoria cat2 = Categoria.builder().id(2L).nombre("Pizzas").build();
        Categoria cat3 = Categoria.builder().id(3L).nombre("Bebidas").build();

        
        List<Producto> productos = new ArrayList<>();

        productos.add(Producto.builder().id(1L).nombre("Burger Simple").descripcion("Carne y pan").precio(2000).categoria(cat1).build());
        productos.add(Producto.builder().id(2L).nombre("Burger Doble").descripcion("Doble carne").precio(3000).categoria(cat1).build());
        productos.add(Producto.builder().id(3L).nombre("Burger Triple").descripcion("Triple carne").precio(4000).categoria(cat1).build());

        productos.add(Producto.builder().id(4L).nombre("Pizza Muzzarella").descripcion("Clásica").precio(3500).categoria(cat2).build());
        productos.add(Producto.builder().id(5L).nombre("Pizza Especial").descripcion("Con todo").precio(4500).categoria(cat2).build());
        productos.add(Producto.builder().id(6L).nombre("Pizza Napolitana").descripcion("Tomate y ajo").precio(4000).categoria(cat2).build());

        productos.add(Producto.builder().id(7L).nombre("Coca Cola").descripcion("500ml").precio(1500).categoria(cat3).build());
        productos.add(Producto.builder().id(8L).nombre("Sprite").descripcion("500ml").precio(1500).categoria(cat3).build());
        productos.add(Producto.builder().id(9L).nombre("Agua").descripcion("Sin gas").precio(1000).categoria(cat3).build());
        productos.add(Producto.builder().id(10L).nombre("Jugo").descripcion("Naranja").precio(1200).categoria(cat3).build());

       
        DetallePedido d1 = DetallePedido.builder().producto(productos.get(0)).cantidad(2).build();
        DetallePedido d2 = DetallePedido.builder().producto(productos.get(3)).cantidad(1).build();

        DetallePedido d3 = DetallePedido.builder().producto(productos.get(1)).cantidad(1).build();
        DetallePedido d4 = DetallePedido.builder().producto(productos.get(6)).cantidad(3).build();

        DetallePedido d5 = DetallePedido.builder().producto(productos.get(2)).cantidad(1).build();
        DetallePedido d6 = DetallePedido.builder().producto(productos.get(4)).cantidad(2).build();

        
        Pedido p1 = Pedido.builder()
                .id(1L)
                .detalles(List.of(d1, d2))
                .estado(Estado.PENDIENTE)
                .formaPago(FormaPago.EFECTIVO)
                .build();

        Pedido p2 = Pedido.builder()
                .id(2L)
                .detalles(List.of(d3, d4))
                .estado(Estado.PAGADO)
                .formaPago(FormaPago.TARJETA)
                .build();

        Pedido p3 = Pedido.builder()
                .id(3L)
                .detalles(List.of(d5, d6))
                .estado(Estado.ENVIADO)
                .formaPago(FormaPago.EFECTIVO)
                .build();

       
        Usuario u1 = Usuario.builder()
                .id(1L)
                .nombre("Juan")
                .email("juan@mail.com")
                .password("1234")
                .rol(Rol.CLIENTE)
                .pedidos(List.of(p1, p2))
                .build();

        Usuario u2 = Usuario.builder()
                .id(2L)
                .nombre("Ana")
                .email("ana@mail.com")
                .password("5678")
                .rol(Rol.CLIENTE)
                .pedidos(List.of(p3))
                .build();

        List<Usuario> usuarios = List.of(u1, u2);

        
        System.out.println("=== UN PRODUCTO ===");
        System.out.println(productos.get(0));

        System.out.println("\n=== LISTA DE PRODUCTOS ===");
        productos.forEach(System.out::println);

        
        Usuario maxUsuario = usuarios.get(0);

        for (Usuario u : usuarios) {
            if (u.getPedidos().size() > maxUsuario.getPedidos().size()) {
                maxUsuario = u;
            }
        }

        System.out.println("\n=== USUARIO CON MÁS PEDIDOS ===");
        System.out.println(maxUsuario.getNombre());

        System.out.println("\nPedidos de ese usuario:");
        maxUsuario.getPedidos().forEach(System.out::println);

       
        Producto productoNuevo = Producto.builder()
                .id(99L)
                .nombre("Burger Simple")
                .descripcion("Carne y pan")
                .precio(2000)
                .categoria(cat1)
                .build();

        System.out.println("\n=== PRUEBA EQUALS ===");
        for (Producto p : productos) {
            System.out.println("¿Es igual a " + p.getNombre() + "? " + productoNuevo.equals(p));
        }
    }
}