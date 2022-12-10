/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.newfashion.scvp2.facade;

import com.newfashion.scvp2.modelo.Detalle_Producto;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public interface IDetalleProducto {
    public List<Detalle_Producto>findAll();
    public Detalle_Producto findById(long id);
    public boolean editDetalle(Detalle_Producto detalle);
    public boolean addDetalle(Detalle_Producto detalle);
    public List<Detalle_Producto>findAllDisp();
    
}
