package com.newfashion.scvp2.modelo;

import com.newfashion.scvp2.modelo.Movimiento;
import com.newfashion.scvp2.modelo.Producto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-06T16:55:37")
@StaticMetamodel(Detalle_Producto.class)
public class Detalle_Producto_ { 

    public static volatile ListAttribute<Detalle_Producto, Movimiento> listMovimientos;
    public static volatile SingularAttribute<Detalle_Producto, Date> Fecha;
    public static volatile SingularAttribute<Detalle_Producto, Producto> fk_producto;
    public static volatile SingularAttribute<Detalle_Producto, Long> Total_Ext;
    public static volatile SingularAttribute<Detalle_Producto, Long> Id_Detalle_Producto;
    public static volatile SingularAttribute<Detalle_Producto, String> Estado;

}