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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author luzam
 */
@Entity
@Table(name="Proveedores")
public class Proveedor implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="Id_Proveedor")
    private long id_Proveedor;
    @Column(name="Nombre")
    private String nombre;
    @Column(name="Nombre_Repr")
    private String nombre_Repr;
    @Column(name="Correo")
    private String correo;
    @Column(name="Telefono")
    private long telefono;
    @Column(name="Direccion")
    private String direccion;
    
    @OneToMany(mappedBy="fk_proveedor",cascade = {CascadeType.MERGE})
    private List<Detalle_Compra> listDetallesCompras;

    public Proveedor() {
    }

    public Proveedor(long id_Proveedor, String nombre, String nombre_Repr, String correo, long telefono, String direccion, List<Detalle_Compra> listDetallesCompras) {
        this.id_Proveedor = id_Proveedor;
        this.nombre = nombre;
        this.nombre_Repr = nombre_Repr;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.listDetallesCompras = listDetallesCompras;
    }

    public long getId_Proveedor() {
        return id_Proveedor;
    }

    public void setId_Proveedor(long id_Proveedor) {
        this.id_Proveedor = id_Proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_Repr() {
        return nombre_Repr;
    }

    public void setNombre_Repr(String nombre_Repr) {
        this.nombre_Repr = nombre_Repr;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Detalle_Compra> getListDetallesCompras() {
        return listDetallesCompras;
    }

    public void setListDetallesCompras(List<Detalle_Compra> listDetallesCompras) {
        this.listDetallesCompras = listDetallesCompras;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id_Proveedor=" + id_Proveedor + ", nombre=" + nombre + ", nombre_Repr=" + nombre_Repr + ", correo=" + correo + ", telefono=" + telefono + ", direccion=" + direccion + ", listDetallesCompras=" + listDetallesCompras + '}';
    }
    
    

}