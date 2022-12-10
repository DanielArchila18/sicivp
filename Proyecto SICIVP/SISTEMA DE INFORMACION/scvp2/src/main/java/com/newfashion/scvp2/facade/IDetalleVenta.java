/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.newfashion.scvp2.facade;

import com.newfashion.scvp2.modelo.Detalle_Venta;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public interface IDetalleVenta {
    public List<Detalle_Venta>findAll(long id);
    public Detalle_Venta findById(long id);
    public boolean editDetalle(Detalle_Venta detalle);
    public long addDetalle(Detalle_Venta detalle);
    public List<Detalle_Venta> findByComprobante(long id);
    public List<Detalle_Venta> findByPedido(long id);
}
