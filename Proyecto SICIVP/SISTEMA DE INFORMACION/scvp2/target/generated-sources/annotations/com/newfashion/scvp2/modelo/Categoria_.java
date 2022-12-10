package com.newfashion.scvp2.modelo;

import com.newfashion.scvp2.modelo.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-06T16:55:37")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, String> descripcion;
    public static volatile ListAttribute<Categoria, Producto> listProductos;
    public static volatile SingularAttribute<Categoria, Long> id;
    public static volatile SingularAttribute<Categoria, String> nombre;

}