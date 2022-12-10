package com.newfashion.scvp2.modelo;

import com.newfashion.scvp2.modelo.Comprobante_Venta;
import com.newfashion.scvp2.modelo.Detalle_Compra;
import com.newfashion.scvp2.modelo.Detalle_Venta;
import com.newfashion.scvp2.modelo.Pedido;
import com.newfashion.scvp2.modelo.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-06T16:55:37")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile ListAttribute<Persona, Usuario> listUsuarios;
    public static volatile SingularAttribute<Persona, Long> id_persona;
    public static volatile SingularAttribute<Persona, String> tipo_documento;
    public static volatile SingularAttribute<Persona, String> apellido;
    public static volatile SingularAttribute<Persona, String> direccion;
    public static volatile ListAttribute<Persona, Detalle_Compra> listDetallesCompras;
    public static volatile ListAttribute<Persona, Comprobante_Venta> listComprobantes;
    public static volatile SingularAttribute<Persona, String> telefono;
    public static volatile ListAttribute<Persona, Detalle_Venta> listDetallesVentas;
    public static volatile SingularAttribute<Persona, String> nombre;
    public static volatile ListAttribute<Persona, Pedido> listPedidos;

}