/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.newfashion.scvp2.facade;

import com.newfashion.scvp2.modelo.Proveedor;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public interface IProveedor {
    public List<Proveedor> findAll();
    public Proveedor findById(long id_proveedor);
    public boolean editProveedor(Proveedor proveedor);
    public boolean addProveedor(Proveedor proveedor);
}
