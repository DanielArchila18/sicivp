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
@Table(name="Detalles_Productos")

public class Detalle_Producto implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Id_Detalle_Producto")
    private long Id_Detalle_Producto;
    @Column(name="Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha;
    @Column (name = "Total_Existencias")
    private long Total_Ext;
    @Column (name = "Estado")
    private String Estado;
    
 @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "fk_producto", referencedColumnName = "Id_Producto")
    private Producto fk_producto;
    
    @OneToMany(mappedBy="fk_detalleP",cascade = {CascadeType.MERGE})
    private List<Movimiento> listMovimientos;
    
    public Detalle_Producto() {
    }

    public Detalle_Producto(long Id_Detalle_Producto, Date Fecha, long Total_Ext, String Estado, Producto fk_producto, List<Movimiento> listMovimientos) {
        this.Id_Detalle_Producto = Id_Detalle_Producto;
        this.Fecha = Fecha;
        this.Total_Ext = Total_Ext;
        this.Estado = Estado;
        this.fk_producto = fk_producto;
        this.listMovimientos = listMovimientos;
    }

    public Producto getFk_producto() {
        return fk_producto;
    }

    public void setFk_producto(Producto fk_producto) {
        this.fk_producto = fk_producto;
    }

   

    public long getId_Detalle_Producto() {
        return Id_Detalle_Producto;
    }

    public void setId_Detalle_Producto(long Id_Detalle_Producto) {
        this.Id_Detalle_Producto = Id_Detalle_Producto;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public long getTotal_Ext() {
        return Total_Ext;
    }

    public void setTotal_Ext(long Total_Ext) {
        this.Total_Ext = Total_Ext;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public List<Movimiento> getListMovimientos() {
        return listMovimientos;
    }

    public void setListMovimientos(List<Movimiento> listMovimientos) {
        this.listMovimientos = listMovimientos;
    }

 
    

  

    @Override
    public String toString() {
        return "Detalle_Producto{" + "Id_Detalle_Producto=" + Id_Detalle_Producto + ", Fecha=" + Fecha + ", Total_Ext=" + Total_Ext + ", Estado=" + Estado + ", listMovimientos=" + listMovimientos + '}';
    }

  
  


    
    
            
 
        
}
