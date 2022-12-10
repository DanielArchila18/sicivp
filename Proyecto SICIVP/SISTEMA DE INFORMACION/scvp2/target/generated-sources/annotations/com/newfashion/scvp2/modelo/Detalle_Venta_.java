package com.newfashion.scvp2.modelo;

import com.newfashion.scvp2.modelo.Comprobante_Venta;
import com.newfashion.scvp2.modelo.Movimiento;
import com.newfashion.scvp2.modelo.Pedido;
import com.newfashion.scvp2.modelo.Persona;
import com.newfashion.scvp2.modelo.Producto;
import com.newfashion.scvp2.modelo.Rol;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-06T16:55:37")
@StaticMetamodel(Detalle_Venta.class)
public class Detalle_Venta_ { 

    public static volatile SingularAttribute<Detalle_Venta, Pedido> fk_pedido;
    public static volatile ListAttribute<Detalle_Venta, Movimiento> listMovimientos;
    public static volatile SingularAttribute<Detalle_Venta, Date> Fecha;
    public static volatile SingularAttribute<Detalle_Venta, Long> Cantidad;
    public static volatile SingularAttribute<Detalle_Venta, Long> Total;
    public static volatile SingularAttribute<Detalle_Venta, Producto> fk_producto;
    public static volatile SingularAttribute<Detalle_Venta, Rol> fk_rol;
    public static volatile SingularAttribute<Detalle_Venta, Comprobante_Venta> fk_comprobante;
    public static volatile SingularAttribute<Detalle_Venta, Persona> fk_persona;
    public static volatile SingularAttribute<Detalle_Venta, Long> Id_Detalle_Venta;

}