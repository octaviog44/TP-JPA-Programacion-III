package com.utn.entities;

import com.utn.enums.Estado;
import com.utn.enums.FormaPago;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = true)
public class Pedido extends Base implements Calculable {

    private List<DetallePedido> detalles;
    private Estado estado;
    private FormaPago formaPago;

    @Override
    public double calcularTotal() {
        double total = 0;

        for (DetallePedido detalle : detalles) {
            total += detalle.calcularSubtotal();
        }

        return total;
    }
}