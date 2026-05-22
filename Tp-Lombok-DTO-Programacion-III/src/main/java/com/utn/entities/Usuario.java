package com.utn.entities;

import com.utn.enums.Rol;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = true)
public class Usuario extends Base {

    private String nombre;
    private String email;
    private String password;
    private Rol rol;

    private List<Pedido> pedidos;
}