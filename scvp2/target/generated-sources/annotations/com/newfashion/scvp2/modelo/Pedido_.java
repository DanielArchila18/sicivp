package com.newfashion.scvp2.modelo;

import com.newfashion.scvp2.modelo.Detalle_Venta;
import com.newfashion.scvp2.modelo.Persona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-03T10:54:02")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Date> Fecha_Pedido;
    public static volatile SingularAttribute<Pedido, String> estado;
    public static volatile SingularAttribute<Pedido, Long> Id_Domicilio;
    public static volatile SingularAttribute<Pedido, Long> Numero_Pedido;
    public static volatile ListAttribute<Pedido, Detalle_Venta> listDetallesVentas;
    public static volatile SingularAttribute<Pedido, Date> Fecha_Envio;
    public static volatile SingularAttribute<Pedido, Persona> fk_persona;
    public static volatile SingularAttribute<Pedido, Date> Fecha_Entrega;

}