/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.facadeImp;

import com.newfashion.scvp2.facade.IMovimiento;
import com.newfashion.scvp2.modelo.Movimiento;
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
public class MovimientoImp implements IMovimiento{
    
    List<Movimiento> listMovimientos = new ArrayList<Movimiento>();
    Query q;
    EntityManager session =JPAUtil.getEntityManagerFactory().createEntityManager();
    @Override
    public List<Movimiento> findAll() {
        try {
            this.session.getTransaction().begin();
            q = this.session.createQuery("SELECT m FROM Movimiento m");
            this.listMovimientos = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listMovimientos;
    }

    @Override
    public Movimiento findById(long id) {
       Movimiento movimiento = new Movimiento();
        try {
            this.session.getTransaction().begin();
            movimiento = this.session.find(Movimiento.class, id);
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return movimiento;
    }

    @Override
    public boolean editMovimiento(Movimiento movimiento) {
        try {
            this.session.getTransaction().begin();
            this.session.merge(movimiento);
            this.session.getTransaction().commit();
        } catch (Exception e) {
        }
        return false;
        
    }

    @Override
    @Transactional
    public boolean addMovimiento(Movimiento movimiento) {
        try {
            this.session.getTransaction().begin();
            this.session.persist(movimiento);
            this.session.flush();
            this.session.getTransaction().commit();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public List<Movimiento> findByDetalle(long id) {
           try {
            this.session.getTransaction().begin();
            q = this.session.createQuery("SELECT m FROM Movimiento  m where m.fk_detalleP.Id_Detalle_Producto =" + id +" ORDER BY m.Fecha desc ");
            this.listMovimientos = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listMovimientos;
    }
    
}
