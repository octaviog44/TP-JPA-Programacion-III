package com.utn.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class DetallePedido {

    private Producto producto;
    private int cantidad;

    public double calcularSubtotal() {
        return producto.getPrecio() * cantidad;
    }
}