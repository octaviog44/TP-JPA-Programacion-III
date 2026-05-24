package com.utn.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends Base {

    private String nombre;

    private String email;

    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;
}