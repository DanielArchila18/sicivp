package com.newfashion.scvp2.modelo;

import com.newfashion.scvp2.modelo.Detalle_Compra;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-06T16:55:37")
@StaticMetamodel(Orden_Compra.class)
public class Orden_Compra_ { 

    public static volatile SingularAttribute<Orden_Compra, Date> Fecha_Orden;
    public static volatile ListAttribute<Orden_Compra, Detalle_Compra> listDetallesCompras;
    public static volatile SingularAttribute<Orden_Compra, Long> id_Compra;

}