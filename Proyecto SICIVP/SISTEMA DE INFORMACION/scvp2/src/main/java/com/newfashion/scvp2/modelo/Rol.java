/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author luzam
 */
@Entity 
@Table (name="Rol")
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_rol")
    private long id_rol;
    @Column(name="Nombre_Rol")
    private String nombre_rol;
    
    @OneToMany(mappedBy = "fk_rol", cascade = {CascadeType.MERGE})
    private List<Usuario> listUsuarios;
    
    @OneToMany(mappedBy = "fk_rol", cascade = {CascadeType.MERGE})
    private List<Detalle_Venta> listDetallesVentas;
    
    @OneToMany(mappedBy = "fk_rol", cascade = {CascadeType.MERGE})
    private List<Detalle_Compra> listDetallesCompras;

    
    
    
   

    public Rol() {
    }

    public Rol(long id_rol, String nombre_rol, List<Usuario> listUsuarios, List<Detalle_Venta> listDetallesVentas, List<Detalle_Compra> listDetallesCompras) {
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
        this.listUsuarios = listUsuarios;
        this.listDetallesVentas = listDetallesVentas;
        this.listDetallesCompras = listDetallesCompras;
       
    }

   

    public long getId_rol() {
        return id_rol;
    }

    public void setId_rol(long id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public List<Detalle_Venta> getListDetallesVentas() {
        return listDetallesVentas;
    }

    public void setListDetallesVentas(List<Detalle_Venta> listDetallesVentas) {
        this.listDetallesVentas = listDetallesVentas;
    }

    public List<Detalle_Compra> getListDetallesCompras() {
        return listDetallesCompras;
    }

    public void setListDetallesCompras(List<Detalle_Compra> listDetallesCompras) {
        this.listDetallesCompras = listDetallesCompras;
    }


  

    @Override
    public String toString() {
        return "Rol{" + "id_rol=" + id_rol + ", nombre_rol=" + nombre_rol + ", listUsuarios=" + listUsuarios + ", listDetallesVentas=" + listDetallesVentas + ", listDetallesCompras=" + listDetallesCompras + '}';
    }

    


  
}
