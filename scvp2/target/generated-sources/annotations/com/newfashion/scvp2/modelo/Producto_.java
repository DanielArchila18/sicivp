package com.newfashion.scvp2.modelo;

import com.newfashion.scvp2.modelo.Categoria;
import com.newfashion.scvp2.modelo.Detalle_Compra;
import com.newfashion.scvp2.modelo.Detalle_Producto;
import com.newfashion.scvp2.modelo.Detalle_Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-03T10:54:02")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, Long> precio;
    public static volatile SingularAttribute<Producto, byte[]> foto;
    public static volatile ListAttribute<Producto, Detalle_Producto> listDetallesProductos;
    public static volatile SingularAttribute<Producto, Categoria> Fk_Categoria;
    public static volatile ListAttribute<Producto, Detalle_Compra> listDetallesCompras;
    public static volatile SingularAttribute<Producto, Long> id_Producto;
    public static volatile ListAttribute<Producto, Detalle_Venta> listDetallesVentas;
    public static volatile SingularAttribute<Producto, String> nombre;
    public static volatile SingularAttribute<Producto, String> referencia;

}