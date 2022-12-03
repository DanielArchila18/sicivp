/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.facadeImp;

import com.newfashion.scvp2.facade.IDetalleProducto;
import com.newfashion.scvp2.modelo.Detalle_Producto;
import com.newfashion.scvp2.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author DANIEL
 */
public class DetalleProductoImp implements IDetalleProducto{
    EntityManager session =JPAUtil.getEntityManagerFactory().createEntityManager();
    Query q;
    List <Detalle_Producto> listDetalles = new ArrayList<Detalle_Producto>();   
    @Override
    public List<Detalle_Producto> findAll() {
        try{
        this.session.getTransaction().begin();
        q = this.session.createQuery("SELECT d FROM Detalle_Producto d");
        this.listDetalles = q.getResultList();
        }catch(Exception e){
        e.printStackTrace();
        }
        return this.listDetalles;
    }

    @Override
    public Detalle_Producto findById(long id) {
      
       Detalle_Producto detalle = new Detalle_Producto();
        try {
           this.session.getTransaction().begin();
            detalle = this.session.find(Detalle_Producto.class, id);
            this.session.getTransaction().commit();
          
        } catch (Exception e) {
            e.printStackTrace();
        }

        return detalle;
    }

    @Override
    public boolean editDetalle(Detalle_Producto detalle) {
        try {
            this.session.getTransaction().begin();
            this.session.merge(detalle);
            this.session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
    @Transactional
    @Override
    public boolean addDetalle(Detalle_Producto detalle) {
      try {
            this.session.getTransaction().begin();
            this.session.persist(detalle);
            this.session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Detalle_Producto> findAllDisp() {
          try{
        this.session.getTransaction().begin();
        q = this.session.createQuery("SELECT d FROM Detalle_Producto d WHERE d.Estado ='Disponible'");
        this.listDetalles = q.getResultList();
        }catch(Exception e){
        e.printStackTrace();
        }
        return this.listDetalles;
    }
    
}
