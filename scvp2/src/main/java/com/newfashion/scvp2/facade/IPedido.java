/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.facade;

import com.newfashion.scvp2.modelo.Pedido;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public interface IPedido {
    public List<Pedido> findAll();
    public Pedido findById(long id_Pedido);
    public boolean editPedido(Pedido pedido);
    public long addPedido(Pedido pedido);
    public List<Pedido>findGenerados();
    public List<Pedido>findDespachados();
    public List<Pedido>findByCliente(long id);
    
}
