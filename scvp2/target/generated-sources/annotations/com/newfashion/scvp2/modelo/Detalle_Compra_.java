package com.newfashion.scvp2.modelo;

import com.newfashion.scvp2.modelo.Movimiento;
import com.newfashion.scvp2.modelo.Orden_Compra;
import com.newfashion.scvp2.modelo.Persona;
import com.newfashion.scvp2.modelo.Producto;
import com.newfashion.scvp2.modelo.Proveedor;
import com.newfashion.scvp2.modelo.Rol;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-03T10:54:02")
@StaticMetamodel(Detalle_Compra.class)
public class Detalle_Compra_ { 

    public static volatile SingularAttribute<Detalle_Compra, Orden_Compra> fk_orden_compra;
    public static volatile SingularAttribute<Detalle_Compra, Proveedor> fk_proveedor;
    public static volatile ListAttribute<Detalle_Compra, Movimiento> listMovimientos;
    public static volatile SingularAttribute<Detalle_Compra, Date> Fecha;
    public static volatile SingularAttribute<Detalle_Compra, Integer> Cantidad;
    public static volatile SingularAttribute<Detalle_Compra, Integer> Total;
    public static volatile SingularAttribute<Detalle_Compra, Producto> fk_producto;
    public static volatile SingularAttribute<Detalle_Compra, Long> id_Compra;
    public static volatile SingularAttribute<Detalle_Compra, Rol> fk_rol;
    public static volatile SingularAttribute<Detalle_Compra, Persona> fk_persona;

}