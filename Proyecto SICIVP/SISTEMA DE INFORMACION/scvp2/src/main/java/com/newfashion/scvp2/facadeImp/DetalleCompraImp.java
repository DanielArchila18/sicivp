/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.facadeImp;

import com.newfashion.scvp2.facade.IDetalleCompra;
import com.newfashion.scvp2.modelo.Detalle_Compra;
import com.newfashion.scvp2.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author DANIEL
 */
public class DetalleCompraImp implements IDetalleCompra{
Query q;
EntityManager session =JPAUtil.getEntityManagerFactory().createEntityManager();
List <Detalle_Compra> listDetalles = new ArrayList<Detalle_Compra>();
    @Override
    public List<Detalle_Compra> findAll() {
        try {
            this.session.getTransaction().begin();
            q = this.session.createQuery("SELECT d FROM Detalle_Compra d");
            this.listDetalles = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
       return this.listDetalles;
    }

    @Override
    public Detalle_Compra findById(long id_detalle) {
        Detalle_Compra detalle = new Detalle_Compra();
        try {
            this.session.getTransaction().begin();
            detalle = this.session.find(Detalle_Compra.class, id_detalle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detalle;
    }

    @Override
    public long addDetalle(Detalle_Compra detalle) {
        try {
            this.session.getTransaction().begin();
            this.session.persist(detalle);
            this.session.getTransaction().commit();
        
            System.out.println("@@ DetalleCompra" + detalle.toString());
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        return detalle.getId_Compra();
    }

    @Override
    public List<Detalle_Compra> findByOrden(long id) {
       try {
            this.session.getTransaction().begin();
            q = this.session.createQuery("SELECT d FROM Detalle_Compra d WHERE d.fk_orden_compra.id_Compra=" +id);
            this.listDetalles = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
       return this.listDetalles;
    }
    
    
    
}
