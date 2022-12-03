/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "Detalles_Compras")
public class Detalle_Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Detalle_Compra")
    private long id_Compra;
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha;
    @Column (name= "Cantidad")
    private int Cantidad;
    @Column (name= "Total")
    private int Total;
    
    @OneToMany(mappedBy="fk_detalle_compra", cascade ={CascadeType.MERGE})
    private List<Movimiento> listMovimientos;
    
    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name="Fk_Orden_Compra", referencedColumnName= "id_Compra")
    private  Orden_Compra fk_orden_compra;
    
    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name="Fk_Proveedor", referencedColumnName= "id_Proveedor")
    private Proveedor fk_proveedor;
    
    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name="Fk_Persona", referencedColumnName= "id_persona")
    private Persona fk_persona;
    
    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name="Fk_Rol", referencedColumnName= "id_rol")
    private Rol fk_rol;
    
    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name="Fk_Producto", referencedColumnName= "id_Producto")
    private Producto fk_producto;

    public Detalle_Compra() {
    }

    public Detalle_Compra(long id_Compra, Date Fecha, int Cantidad, int Total, List<Movimiento> listMovimientos, Orden_Compra fk_orden_compra, Proveedor fk_proveedor, Persona fk_persona, Rol fk_rol, Producto fk_producto) {
        this.id_Compra = id_Compra;
        this.Fecha = Fecha;
        this.Cantidad = Cantidad;
        this.Total = Total;
        this.listMovimientos = listMovimientos;
        this.fk_orden_compra = fk_orden_compra;
        this.fk_proveedor = fk_proveedor;
        this.fk_persona = fk_persona;
        this.fk_rol = fk_rol;
        this.fk_producto = fk_producto;
    }

   

    public long getId_Compra() {
        return id_Compra;
    }

    public void setId_Compra(long id_Compra) {
        this.id_Compra = id_Compra;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

    public Orden_Compra getFk_orden_compra() {
        return fk_orden_compra;
    }

    public void setFk_orden_compra(Orden_Compra fk_orden_compra) {
        this.fk_orden_compra = fk_orden_compra;
    }

    public Proveedor getFk_proveedor() {
        return fk_proveedor;
    }

    public void setFk_proveedor(Proveedor fk_proveedor) {
        this.fk_proveedor = fk_proveedor;
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

    public Producto getFk_producto() {
        return fk_producto;
    }

    public void setFk_producto(Producto fk_producto) {
        this.fk_producto = fk_producto;
    }

    public List<Movimiento> getListMovimientos() {
        return listMovimientos;
    }

    public void setListMovimientos(List<Movimiento> listMovimientos) {
        this.listMovimientos = listMovimientos;
    }

    @Override
    public String toString() {
        return "Detalle_Compra{" + "id_Compra=" + id_Compra + ", Fecha=" + Fecha + ", Cantidad=" + Cantidad + ", Total=" + Total + ", listMovimientos=" + listMovimientos + ", fk_orden_compra=" + fk_orden_compra + ", fk_proveedor=" + fk_proveedor + ", fk_persona=" + fk_persona + ", fk_rol=" + fk_rol + ", fk_producto=" + fk_producto + '}';
    }
    
    
   
}
 