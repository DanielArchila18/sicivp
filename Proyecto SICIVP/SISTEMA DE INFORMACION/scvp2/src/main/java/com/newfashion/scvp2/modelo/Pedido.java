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
@Table(name = "Pedidos")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Domicilio")
    private long Id_Domicilio;
    @Column(name = "Numero_Pedido")
    private long Numero_Pedido;
    @Column(name = "Fecha_Entrega")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_Entrega;
    @Column(name = "Fecha_Pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_Pedido;
    @Column(name = "Fecha_Envio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_Envio;
    @Column(name = "Estado")
    private String estado;

        
   
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "Fk_Persona", referencedColumnName = "id_persona")
    private Persona fk_persona;
    
    @OneToMany(mappedBy="fk_pedido", cascade ={CascadeType.MERGE})
    private List<Detalle_Venta> listDetallesVentas;

    public Pedido() {
    }
    
    public Pedido(long Id_Domicilio, long Numero_Pedido, Date Fecha_Entrega, Date Fecha_Pedido, Date Fecha_Envio, String estado, Persona fk_persona, List<Detalle_Venta> listDetallesVentas) {
        this.Id_Domicilio = Id_Domicilio;
        this.Numero_Pedido = Numero_Pedido;
        this.Fecha_Entrega = Fecha_Entrega;
        this.Fecha_Pedido = Fecha_Pedido;
        this.Fecha_Envio = Fecha_Envio;
        this.estado = estado;
        this.fk_persona = fk_persona;
        this.listDetallesVentas = listDetallesVentas;
    }

    public long getId_Domicilio() {
        return Id_Domicilio;
    }

    public void setId_Domicilio(long Id_Domicilio) {
        this.Id_Domicilio = Id_Domicilio;
    }

    public long getNumero_Pedido() {
        return Numero_Pedido;
    }

    public void setNumero_Pedido(long Numero_Pedido) {
        this.Numero_Pedido = Numero_Pedido;
    }

    public Date getFecha_Entrega() {
        return Fecha_Entrega;
    }

    public void setFecha_Entrega(Date Fecha_Entrega) {
        this.Fecha_Entrega = Fecha_Entrega;
    }

    public Date getFecha_Pedido() {
        return Fecha_Pedido;
    }

    public void setFecha_Pedido(Date Fecha_Pedido) {
        this.Fecha_Pedido = Fecha_Pedido;
    }

    public Date getFecha_Envio() {
        return Fecha_Envio;
    }

    public void setFecha_Envio(Date Fecha_Envio) {
        this.Fecha_Envio = Fecha_Envio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Persona getFk_persona() {
        return fk_persona;
    }

    public void setFk_persona(Persona fk_persona) {
        this.fk_persona = fk_persona;
    }

    public List<Detalle_Venta> getListDetallesVentas() {
        return listDetallesVentas;
    }

    public void setListDetallesVentas(List<Detalle_Venta> listDetallesVentas) {
        this.listDetallesVentas = listDetallesVentas;
    }

    @Override
    public String toString() {
        return "Pedido{" + "Id_Domicilio=" + Id_Domicilio + ", Numero_Pedido=" + Numero_Pedido + ", Fecha_Entrega=" + Fecha_Entrega + ", Fecha_Pedido=" + Fecha_Pedido + ", Fecha_Envio=" + Fecha_Envio + ", estado=" + estado + ", fk_persona=" + fk_persona + ", listDetallesVentas=" + listDetallesVentas + '}';
    }

    

 


    
    


    

}
