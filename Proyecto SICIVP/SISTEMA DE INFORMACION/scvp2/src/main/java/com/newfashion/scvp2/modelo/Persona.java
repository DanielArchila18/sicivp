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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Personas")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Id_Persona")
    private long id_persona;

    @Column(name = "Tipo_Documento")
    private String tipo_documento;
    


    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Direccion")
    private String direccion;

    @Column(name = "Telefono")
    private String telefono;
    
    @OneToMany(mappedBy="fk_persona", cascade ={CascadeType.MERGE})
    private List<Detalle_Venta> listDetallesVentas;
    
    @OneToMany(mappedBy="fk_persona", cascade ={CascadeType.MERGE})
    private List<Detalle_Compra> listDetallesCompras;
    

    
    @OneToMany(mappedBy="fk_persona", cascade ={CascadeType.MERGE})
    private List<Pedido> listPedidos;

    @OneToMany(mappedBy="fk_persona", cascade={CascadeType.MERGE})
    private List<Usuario> listUsuarios;
    @OneToMany(mappedBy="fk_persona", cascade={CascadeType.MERGE})
    private List<Comprobante_Venta> listComprobantes;


    public Persona() {
    }

    public Persona(long id_persona, String tipo_documento, String nombre, String apellido, String direccion, String telefono, List<Detalle_Venta> listDetallesVentas, List<Detalle_Compra> listDetallesCompras, List<Pedido> listPedidos, List<Usuario> listUsuarios, List<Comprobante_Venta> listComprobantes) {
        this.id_persona = id_persona;
        this.tipo_documento = tipo_documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listDetallesVentas = listDetallesVentas;
        this.listDetallesCompras = listDetallesCompras;
        this.listPedidos = listPedidos;
        this.listUsuarios = listUsuarios;
        this.listComprobantes = listComprobantes;
    }

   

    public long getId_persona() {
        return id_persona;
    }

    public void setId_persona(long id_persona) {
        this.id_persona = id_persona;
    }

    

    

   

   

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

   

    public List<Pedido> getListPedidos() {
        return listPedidos;
    }

    public void setListPedidos(List<Pedido> listPedidos) {
        this.listPedidos = listPedidos;
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public List<Comprobante_Venta> getListComprobantes() {
        return listComprobantes;
    }

    public void setListComprobantes(List<Comprobante_Venta> listComprobantes) {
        this.listComprobantes = listComprobantes;
    }

    @Override
    public String toString() {
        return "Persona{" + "id_persona=" + id_persona + ", tipo_documento=" + tipo_documento + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", telefono=" + telefono + ", listDetallesVentas=" + listDetallesVentas + ", listDetallesCompras=" + listDetallesCompras + ", listPedidos=" + listPedidos + ", listUsuarios=" + listUsuarios + ", listComprobantes=" + listComprobantes + '}';
    }

    
   
    

    
    


}
