package com.utn.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = true)
public class Producto extends Base {

    private String nombre;
    private String descripcion;
    private double precio;
    private Categoria categoria;
}