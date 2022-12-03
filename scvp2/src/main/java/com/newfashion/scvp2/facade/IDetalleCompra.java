/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.newfashion.scvp2.facade;

import com.newfashion.scvp2.modelo.Detalle_Compra;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public interface IDetalleCompra {
    public List<Detalle_Compra> findAll();
    public Detalle_Compra findById(long id_detalle);
    public long addDetalle(Detalle_Compra detalle);
    public List<Detalle_Compra> findByOrden(long id);
}
