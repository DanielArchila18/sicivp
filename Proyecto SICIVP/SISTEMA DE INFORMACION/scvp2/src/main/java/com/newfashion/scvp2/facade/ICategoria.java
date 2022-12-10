/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.newfashion.scvp2.facade;

import com.newfashion.scvp2.modelo.Categoria;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public interface ICategoria {
    public List<Categoria> findAll();
    public Categoria findById(long id_categoria);
}
