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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author luzam
 */
@Entity
@Table(name = "Productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Producto")
    private long id_Producto;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Ref_producto")
    private String referencia;
    @Column(name = "Precio_Unitario")
    private long precio;
    @Lob
    @Column(name="foto")
    private byte[] foto;
    
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "Fk_Categoria", referencedColumnName = "Id_Categoria")
    private Categoria Fk_Categoria;
    
    @OneToMany(mappedBy="fk_producto",cascade = {CascadeType.MERGE})
    private List<Detalle_Compra> listDetallesCompras;
    
    @OneToMany(mappedBy="fk_producto",cascade = {CascadeType.MERGE})
    private List<Detalle_Venta> listDetallesVentas;
    
    @OneToMany(mappedBy="fk_producto",cascade = {CascadeType.MERGE})
    private List<Detalle_Producto> listDetallesProductos;
    

    
    
    
    public Producto() {
    }

    public Producto(long id_Producto, String nombre, String referencia, long precio, byte[] foto, Categoria Fk_Categoria, List<Detalle_Compra> listDetallesCompras, List<Detalle_Venta> listDetallesVentas, List<Detalle_Producto> listDetallesProductos) {
        this.id_Producto = id_Producto;
        this.nombre = nombre;
        this.referencia = referencia;
        this.precio = precio;
        this.foto = foto;
        this.Fk_Categoria = Fk_Categoria;
        this.listDetallesCompras = listDetallesCompras;
        this.listDetallesVentas = listDetallesVentas;
        this.listDetallesProductos = listDetallesProductos;
    }

   

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public long getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(long id_Producto) {
        this.id_Producto = id_Producto;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }



    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Categoria getFk_Categoria() {
        return Fk_Categoria;
    }

    public void setFk_Categoria(Categoria Fk_Categoria) {
        this.Fk_Categoria = Fk_Categoria;
    }

    public List<Detalle_Compra> getListDetallesCompras() {
        return listDetallesCompras;
    }

    public void setListDetallesCompras(List<Detalle_Compra> listDetallesCompras) {
        this.listDetallesCompras = listDetallesCompras;
    }

    public List<Detalle_Venta> getListDetallesVentas() {
        return listDetallesVentas;
    }

    public void setListDetallesVentas(List<Detalle_Venta> listDetallesVentas) {
        this.listDetallesVentas = listDetallesVentas;
    }

    public List<Detalle_Producto> getListDetallesProductos() {
        return listDetallesProductos;
    }

    public void setListDetallesProductos(List<Detalle_Producto> listDetallesProductos) {
        this.listDetallesProductos = listDetallesProductos;
    }



   
    @Override
    public String toString() {
        return "Producto{" + "id_Producto=" + id_Producto + ", nombre=" + nombre + ", referencia=" + referencia + ", precio=" + precio + ", Fk_Categoria=" + Fk_Categoria + ", listDetallesCompras=" + listDetallesCompras + ", listDetallesVentas=" + listDetallesVentas + ", listDetallesProductos=" + listDetallesProductos +  '}';
    }
    
    

  
    
    


}
