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
@Table
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Movimiento")
    private long id_Movimiento;
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha;
    
    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name="Fk_Detalle_Compra", referencedColumnName= "Id_Detalle_Compra")
    private  Detalle_Compra fk_detalle_compra;
    
    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name="Fk_Detalle_Venta", referencedColumnName= "Id_Detalle_Venta")
    private  Detalle_Venta fk_detalle_venta;
    
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "fk_detalleP", referencedColumnName = "Id_Detalle_Producto")
    private Detalle_Producto fk_detalleP;


  

    public Movimiento() {
    }

    public Movimiento(long id_Movimiento, Date Fecha, Detalle_Compra fk_detalle_compra, Detalle_Venta fk_detalle_venta, Detalle_Producto fk_detalleP) {
        this.id_Movimiento = id_Movimiento;
        this.Fecha = Fecha;
        this.fk_detalle_compra = fk_detalle_compra;
        this.fk_detalle_venta = fk_detalle_venta;
        this.fk_detalleP = fk_detalleP;
    }
    

    public Detalle_Producto getFk_detalleP() {
        return fk_detalleP;
    }

    public void setFk_detalleP(Detalle_Producto fk_detalleP) {
        this.fk_detalleP = fk_detalleP;
    }

    



    public long getId_Movimiento() {
        return id_Movimiento;
    }

    public void setId_Movimiento(long id_Movimiento) {
        this.id_Movimiento = id_Movimiento;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Detalle_Compra getFk_detalle_compra() {
        return fk_detalle_compra;
    }

    public void setFk_detalle_compra(Detalle_Compra fk_detalle_compra) {
        this.fk_detalle_compra = fk_detalle_compra;
    }

    public Detalle_Venta getFk_detalle_venta() {
        return fk_detalle_venta;
    }

    public void setFk_detalle_venta(Detalle_Venta fk_detalle_venta) {
        this.fk_detalle_venta = fk_detalle_venta;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "id_Movimiento=" + id_Movimiento + ", Fecha=" + Fecha + ", fk_detalle_compra=" + fk_detalle_compra + ", fk_detalle_venta=" + fk_detalle_venta + ", fk_detalleP=" + fk_detalleP + '}';
    }

  

  

    
    
    
    
    

   
}
