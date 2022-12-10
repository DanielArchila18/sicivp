/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.facadeImp;

import com.newfashion.scvp2.facade.IProveedor;
import com.newfashion.scvp2.modelo.Proveedor;
import com.newfashion.scvp2.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author DANIEL
 */
public class ProveedorImp implements IProveedor{
    Query q;
    EntityManager session =JPAUtil.getEntityManagerFactory().createEntityManager();
    List<Proveedor> listProveedores =new ArrayList<Proveedor>();

    @Override
    public List<Proveedor> findAll() {
        try {
            this.session.getTransaction().begin();
            q = this.session.createQuery("SELECT p FROM Proveedor p");
            this.listProveedores = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listProveedores;
    }

    @Override
    public Proveedor findById(long id_proveedor) {
       Proveedor proveedor =new Proveedor();
        try {
            this.session.getTransaction().begin();
            proveedor = this.session.find(Proveedor.class, id_proveedor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proveedor;
    }

    @Override
    public boolean editProveedor(Proveedor proveedor) {
        try {
           this.session.getTransaction().begin();
           this.session.merge(proveedor);
           this.session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addProveedor(Proveedor proveedor) {
       try {
           this.session.getTransaction().begin();
           this.session.persist(proveedor);
           this.session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
