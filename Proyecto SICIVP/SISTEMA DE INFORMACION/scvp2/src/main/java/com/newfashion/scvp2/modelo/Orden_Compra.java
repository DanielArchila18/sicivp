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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author luzam
 */
@Entity
@Table(name = "Ordenes_Compras")
public class Orden_Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Compra")
    private long id_Compra;
 
    @Column(name = "Fecha_Orden")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_Orden;
    
    @OneToMany(mappedBy="fk_orden_compra", cascade ={CascadeType.MERGE})
    private List<Detalle_Compra> listDetallesCompras;

    public Orden_Compra() {
    }

    

    public long getId_Compra() {
        return id_Compra;
    }

    public void setId_Compra(long id_Compra) {
        this.id_Compra = id_Compra;
    }

    

    public Date getFecha_Orden() {
        return Fecha_Orden;
    }

    public void setFecha_Orden(Date Fecha_Orden) {
        this.Fecha_Orden = Fecha_Orden;
    }

    public List<Detalle_Compra> getListDetallesCompras() {
        return listDetallesCompras;
    }

    public void setListDetallesCompras(List<Detalle_Compra> listDetallesCompras) {
        this.listDetallesCompras = listDetallesCompras;
    }

    @Override
    public String toString() {
        return "Orden_Compra{" + "id_Compra=" + id_Compra + ", Fecha_Orden=" + Fecha_Orden + ", listDetallesCompras=" + listDetallesCompras + '}';
    }

    
    
    

}
