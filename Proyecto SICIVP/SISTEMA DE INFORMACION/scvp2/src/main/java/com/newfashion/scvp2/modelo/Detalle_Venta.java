/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author luzam
 */
@Entity
@Table(name = "Venta")
public class Detalle_Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Detalle_Venta")
    private long Id_Detalle_Venta;
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha;
    @Column(name = "Cantidad")
    private long Cantidad;
    @Column(name = "Total")
    private long Total;
    
    @OneToMany(mappedBy="fk_detalle_venta", cascade ={CascadeType.MERGE})
    private List<Movimiento> listMovimientos;
    
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "Fk_Persona", referencedColumnName = "id_persona")
    private Persona fk_persona;
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "Fk_Producto", referencedColumnName = "id_Producto")
    private Producto fk_producto;
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "Fk_Rol", referencedColumnName = "id_rol")
    private Rol fk_rol;
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "Fk_Comprobante_Venta", referencedColumnName = "Id_Comprobante_Venta")
    private Comprobante_Venta fk_comprobante;
    
     @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "Fk_Pedidos", referencedColumnName = "Id_Domicilio")
    private Pedido fk_pedido;
    
    
    
    public Detalle_Venta() {
    }

    public Detalle_Venta(long Id_Detalle_Venta, Date Fecha, long Cantidad, long Total, List<Movimiento> listMovimientos, Persona fk_persona, Producto fk_producto, Rol fk_rol, Comprobante_Venta fk_comprobante, Pedido fk_pedido) {
        this.Id_Detalle_Venta = Id_Detalle_Venta;
        this.Fecha = Fecha;
        this.Cantidad = Cantidad;
        this.Total = Total;
        this.listMovimientos = listMovimientos;
        this.fk_persona = fk_persona;
        this.fk_producto = fk_producto;
        this.fk_rol = fk_rol;
        this.fk_comprobante = fk_comprobante;
        this.fk_pedido = fk_pedido;
    }

    public long getId_Detalle_Venta() {
        return Id_Detalle_Venta;
    }

    public void setId_Detalle_Venta(long Id_Detalle_Venta) {
        this.Id_Detalle_Venta = Id_Detalle_Venta;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public long getCantidad() {
        return Cantidad;
    }

    public void setCantidad(long Cantidad) {
        this.Cantidad = Cantidad;
    }

    public long getTotal() {
        return Total;
    }

    public void setTotal(long Total) {
        this.Total = Total;
    }

    public List<Movimiento> getListMovimientos() {
        return listMovimientos;
    }

    public void setListMovimientos(List<Movimiento> listMovimientos) {
        this.listMovimientos = listMovimientos;
    }

    public Persona getFk_persona() {
        return fk_persona;
    }

    public void setFk_persona(Persona fk_persona) {
        this.fk_persona = fk_persona;
    }

    public Producto getFk_producto() {
        return fk_producto;
    }

    public void setFk_producto(Producto fk_producto) {
        this.fk_producto = fk_producto;
    }

    public Rol getFk_rol() {
        return fk_rol;
    }

    public void setFk_rol(Rol fk_rol) {
        this.fk_rol = fk_rol;
    }

    public Comprobante_Venta getFk_comprobante() {
        return fk_comprobante;
    }

    public void setFk_comprobante(Comprobante_Venta fk_comprobante) {
        this.fk_comprobante = fk_comprobante;
    }

    public Pedido getFk_pedido() {
        return fk_pedido;
    }

    public void setFk_pedido(Pedido fk_pedido) {
        this.fk_pedido = fk_pedido;
    }

    @Override
    public String toString() {
        return "Detalle_Venta{" + "Id_Detalle_Venta=" + Id_Detalle_Venta + ", Fecha=" + Fecha + ", Cantidad=" + Cantidad + ", Total=" + Total + ", listMovimientos=" + listMovimientos + ", fk_persona=" + fk_persona + ", fk_producto=" + fk_producto + ", fk_rol=" + fk_rol + ", fk_comprobante=" + fk_comprobante + ", fk_pedido=" + fk_pedido + '}';
    }

   
}
