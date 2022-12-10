/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author luzam
 */
@Entity
@Table(name = "Usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "Correo")
    private String correo;
    
    @Column(name= "Password")
    private String contrasena;

   
    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name="Fk_Persona", referencedColumnName= "id_persona")
    private Persona fk_persona;
    
    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name="Fk_Rol", referencedColumnName= "id_rol")
    private Rol fk_rol;

    public Usuario() {
    }

    public Usuario( String correo, String contraseña, Persona fk_persona, Rol fk_rol) {
      
        this.correo = correo;
        this.contrasena = contrasena;
        this.fk_persona = fk_persona;
        this.fk_rol = fk_rol;
    }




    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contraseña) {
        this.contrasena = contraseña;
    }

    public Persona getFk_persona() {
        return fk_persona;
    }

    public void setFk_persona(Persona fk_persona) {
        this.fk_persona = fk_persona;
    }

    public Rol getFk_rol() {
        return fk_rol;
    }

    public void setFk_rol(Rol fk_rol) {
        this.fk_rol = fk_rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + ", correo=" + correo + ", contrase\u00f1a=" + contrasena + ", fk_persona=" + fk_persona + ", fk_rol=" + fk_rol + '}';
    }
    
    


    
}
