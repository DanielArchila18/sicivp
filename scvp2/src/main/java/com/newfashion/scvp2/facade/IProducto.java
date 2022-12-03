/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.facade;

import com.newfashion.scvp2.modelo.Producto;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public interface IProducto {
    
    public List<Producto> findAll();
    public Producto findById(long id);
    public boolean editProducto(Producto producto);
    public long addProducto (Producto producto);
    public long cargaProductos(Producto producto);
    
}
