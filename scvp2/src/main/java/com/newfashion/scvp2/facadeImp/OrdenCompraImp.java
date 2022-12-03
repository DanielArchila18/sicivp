/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.facadeImp;

import com.newfashion.scvp2.facade.IOrdenCompra;
import com.newfashion.scvp2.modelo.Orden_Compra;
import com.newfashion.scvp2.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author DANIEL
 */
public class OrdenCompraImp implements IOrdenCompra{
    Query q;
    List<Orden_Compra> listOrdenes = new ArrayList<Orden_Compra>();
    EntityManager session =JPAUtil.getEntityManagerFactory().createEntityManager();
    @Override
    public List<Orden_Compra> findAll() {
        try{
        this.session.getTransaction().begin();
        q = session.createQuery("SELECT o FROM Orden_Compra o");
        this.listOrdenes = q.getResultList();
        }catch(Exception e){
        e.printStackTrace();
        }
        return this.listOrdenes;
    }

    @Override
    public Orden_Compra findById(long id_orden) {
        Orden_Compra orden = new Orden_Compra();
        try{
        this.session.getTransaction().begin();
        orden = this.session.find(Orden_Compra.class, id_orden);
        this.session.getTransaction().commit();
        }catch(Exception e){
        e.printStackTrace();
        }
        return orden;
    }

    @Override
    public long addOrden(Orden_Compra orden) {
        try{
        this.session.getTransaction().begin();
        this.session.persist(orden);
        this.session.getTransaction().commit();
        
        }catch(Exception e){
        e.printStackTrace();
        
        }
        return orden.getId_Compra();
    }
    
}
