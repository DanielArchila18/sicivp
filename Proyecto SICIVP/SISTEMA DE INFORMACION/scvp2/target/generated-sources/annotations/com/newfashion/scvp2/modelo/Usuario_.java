package com.newfashion.scvp2.modelo;

import com.newfashion.scvp2.modelo.Persona;
import com.newfashion.scvp2.modelo.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-06T16:55:37")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> correo;
    public static volatile SingularAttribute<Usuario, String> contrasena;
    public static volatile SingularAttribute<Usuario, Rol> fk_rol;
    public static volatile SingularAttribute<Usuario, Persona> fk_persona;

}