package com.newfashion.scvp2.modelo;

import com.newfashion.scvp2.modelo.Detalle_Compra;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-03T10:54:02")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile SingularAttribute<Proveedor, Long> id_Proveedor;
    public static volatile SingularAttribute<Proveedor, String> correo;
    public static volatile SingularAttribute<Proveedor, String> direccion;
    public static volatile ListAttribute<Proveedor, Detalle_Compra> listDetallesCompras;
    public static volatile SingularAttribute<Proveedor, Long> telefono;
    public static volatile SingularAttribute<Proveedor, String> nombre;
    public static volatile SingularAttribute<Proveedor, String> nombre_Repr;

}