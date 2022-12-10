package com.newfashion.scvp2.modelo;

import com.newfashion.scvp2.modelo.Detalle_Compra;
import com.newfashion.scvp2.modelo.Detalle_Venta;
import com.newfashion.scvp2.modelo.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-06T16:55:37")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile ListAttribute<Rol, Usuario> listUsuarios;
    public static volatile SingularAttribute<Rol, Long> id_rol;
    public static volatile ListAttribute<Rol, Detalle_Compra> listDetallesCompras;
    public static volatile SingularAttribute<Rol, String> nombre_rol;
    public static volatile ListAttribute<Rol, Detalle_Venta> listDetallesVentas;

}