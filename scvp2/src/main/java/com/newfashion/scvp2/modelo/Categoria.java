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
@Table(name="Categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_Categoria")
    private long id;
    @Column(name="Nombre")
    private String nombre;
    @Column(name="Descripcion")
    private String descripcion;
    @OneToMany(mappedBy="Fk_Categoria",cascade = {CascadeType.MERGE})
    private List<Producto> listProductos;

    public Categoria() {
    }

    public Categoria(Long id, String nombre, String descripcion, List<Producto> listProductos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listProductos = listProductos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Producto> listProductos) {
        this.listProductos = listProductos;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", listProductos=" + listProductos + '}';
    }

    
    
}
