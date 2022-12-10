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
@Table(name = "Comprobantes_Ventas")
public class Comprobante_Venta implements Serializable {

     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Comprobante_Venta")
    private long Id_Comprobante_Venta;
  
    @Column(name = "Fecha_Comprobante")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_Comprobante;
    
    @OneToMany(mappedBy="fk_comprobante", cascade ={CascadeType.MERGE})
    private List<Detalle_Venta> listDetallesVentas;
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "fk_Persona", referencedColumnName = "Id_Persona")
    private Persona fk_persona;

    public Comprobante_Venta() {
    }

    public Comprobante_Venta(long Id_Comprobante_Venta, Date Fecha_Comprobante, List<Detalle_Venta> listDetallesVentas, Persona fk_persona) {
        this.Id_Comprobante_Venta = Id_Comprobante_Venta;
        this.Fecha_Comprobante = Fecha_Comprobante;
        this.listDetallesVentas = listDetallesVentas;
        this.fk_persona = fk_persona;
    }

    public long getId_Comprobante_Venta() {
        return Id_Comprobante_Venta;
    }

    public void setId_Comprobante_Venta(long Id_Comprobante_Venta) {
        this.Id_Comprobante_Venta = Id_Comprobante_Venta;
    }

    public Date getFecha_Comprobante() {
        return Fecha_Comprobante;
    }

    public void setFecha_Comprobante(Date Fecha_Comprobante) {
        this.Fecha_Comprobante = Fecha_Comprobante;
    }

    public List<Detalle_Venta> getListDetallesVentas() {
        return listDetallesVentas;
    }

    public void setListDetallesVentas(List<Detalle_Venta> listDetallesVentas) {
        this.listDetallesVentas = listDetallesVentas;
    }

    public Persona getFk_persona() {
        return fk_persona;
    }

    public void setFk_persona(Persona fk_persona) {
        this.fk_persona = fk_persona;
    }

    @Override
    public String toString() {
        return "Comprobante_Venta{" + "Id_Comprobante_Venta=" + Id_Comprobante_Venta + ", Fecha_Comprobante=" + Fecha_Comprobante + ", listDetallesVentas=" + listDetallesVentas + ", fk_persona=" + fk_persona + '}';
    }

    

  
    
    
    

}
