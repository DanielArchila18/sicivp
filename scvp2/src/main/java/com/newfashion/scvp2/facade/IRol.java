/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.newfashion.scvp2.facade;

import com.newfashion.scvp2.modelo.Rol;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public interface IRol {
        
    public Rol findById(long id_rol);
    public List<Rol> findAll();
}
