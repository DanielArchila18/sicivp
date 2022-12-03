package com.newfashion.scvp2.modelo;

import com.newfashion.scvp2.modelo.Detalle_Compra;
import com.newfashion.scvp2.modelo.Detalle_Producto;
import com.newfashion.scvp2.modelo.Detalle_Venta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-03T10:54:02")
@StaticMetamodel(Movimiento.class)
public class Movimiento_ { 

    public static volatile SingularAttribute<Movimiento, Detalle_Venta> fk_detalle_venta;
    public static volatile SingularAttribute<Movimiento, Date> Fecha;
    public static volatile SingularAttribute<Movimiento, Long> id_Movimiento;
    public static volatile SingularAttribute<Movimiento, Detalle_Compra> fk_detalle_compra;
    public static volatile SingularAttribute<Movimiento, Detalle_Producto> fk_detalleP;

}