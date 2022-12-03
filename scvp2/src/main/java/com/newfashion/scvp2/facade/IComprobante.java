/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.newfashion.scvp2.facade;

import com.newfashion.scvp2.modelo.Comprobante_Venta;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public interface IComprobante {
    public List<Comprobante_Venta> findAll();
    public Comprobante_Venta findById(long id);
    public long addComprobante(Comprobante_Venta comprobante);
    public List<Comprobante_Venta> findByUser(long id);
    
}
