/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.facadeImp;

import com.newfashion.scvp2.facade.IProducto;
import com.newfashion.scvp2.modelo.Producto;
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
public class ProductoImp implements IProducto {

    List<Producto> listProductos = new ArrayList<Producto>();
    Query q;
    EntityManager session = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public List<Producto> findAll() {
        try {
            this.session.getTransaction().begin();
            q = this.session.createQuery("SELECT p FROM Producto p");
            this.listProductos = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listProductos;
    }

    @Override
    public Producto findById(long id) {
        Producto producto = new Producto();
        try {
            producto = this.session.find(Producto.class, id);
            System.out.println("@@" + producto.toString());
           
        } catch (Exception e) {
        }
         
        return producto;
    }

    @Override
    public boolean editProducto(Producto producto) {
        try {
            this.session.getTransaction().begin();
            this.session.merge(producto);
            this.session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    
    public long addProducto(Producto producto) {
        try {
            this.session.getTransaction().begin();
            this.session.persist(producto);
            this.session.getTransaction().commit();
            System.out.println("@@Producto "+producto.toString());
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return producto.getId_Producto();
    }
    
    @Transactional
    @Override
    public long cargaProductos(Producto producto) {
        try {
            this.session.getTransaction().begin();
            this.session.persist(producto);
            this.session.flush();
            this.session.getTransaction().commit();
            
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Id " + producto.getId_Producto());
        return producto.getId_Producto();
    }
    
    
}
