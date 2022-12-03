package com.newfashion.scvp2.modelo;

import com.newfashion.scvp2.modelo.Detalle_Venta;
import com.newfashion.scvp2.modelo.Persona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-03T10:54:02")
@StaticMetamodel(Comprobante_Venta.class)
public class Comprobante_Venta_ { 

    public static volatile SingularAttribute<Comprobante_Venta, Long> Id_Comprobante_Venta;
    public static volatile SingularAttribute<Comprobante_Venta, Date> Fecha_Comprobante;
    public static volatile ListAttribute<Comprobante_Venta, Detalle_Venta> listDetallesVentas;
    public static volatile SingularAttribute<Comprobante_Venta, Persona> fk_persona;

}