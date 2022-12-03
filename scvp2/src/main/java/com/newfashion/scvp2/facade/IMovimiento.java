/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.newfashion.scvp2.facade;

import com.newfashion.scvp2.modelo.Movimiento;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public interface IMovimiento {
    public List<Movimiento> findAll();
    public Movimiento findById(long id);
    public boolean editMovimiento(Movimiento movimiento);
    public boolean addMovimiento(Movimiento movimiento);
    public List<Movimiento> findByDetalle(long id);
    
}
