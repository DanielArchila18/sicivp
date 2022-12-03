/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.newfashion.scvp2.facade;

import com.newfashion.scvp2.modelo.Orden_Compra;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public interface IOrdenCompra {
    public List<Orden_Compra> findAll();
    public Orden_Compra findById(long id_orden);
    public long addOrden (Orden_Compra orden);
}
