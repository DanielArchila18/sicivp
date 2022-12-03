/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.facadeImp;

import com.newfashion.scvp2.facade.IDetalleVenta;
import com.newfashion.scvp2.modelo.Detalle_Venta;
import com.newfashion.scvp2.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author DANIEL
 */
public class DetalleVentaImp implements IDetalleVenta {

    List<Detalle_Venta> listDetalles = new ArrayList<Detalle_Venta>();
    Query q;
    EntityManager session = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public List<Detalle_Venta> findAll(long id) {
        try {
            this.session.getTransaction().begin();
            q = this.session.createQuery("SELECT d FROM Detalle_Venta d where d.fk_comprobante.Id_Comprobante_Venta = " +id);
            this.listDetalles = q.getResultList();

        } catch (Exception e) {
        }
        return this.listDetalles;
    }

    @Override
    public Detalle_Venta findById(long id) {
        Detalle_Venta detalle = new Detalle_Venta();
        try {
            this.session.getTransaction().begin();
            detalle = this.session.find(Detalle_Venta.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detalle;
    }

    @Override
    public boolean editDetalle(Detalle_Venta detalle) {
        try {
            this.session.getTransaction().begin();
            this.session.merge(detalle);
            this.session.getTransaction().begin();

        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public long addDetalle(Detalle_Venta detalle) {
        try {
            this.session.getTransaction().begin();
            this.session.persist(detalle);
            this.session.getTransaction().commit();

        } catch (Exception e) {
        }
        return detalle.getId_Detalle_Venta();
    }

    @Override
    public List<Detalle_Venta> findByComprobante(long id) {
        try {
            this.session.getTransaction().begin();
            q = this.session.createQuery("SELECT d FROM Detalle_Venta d where d.fk_comprobante.Id_Comprobante_Venta =" + id );
            this.listDetalles = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listDetalles;
    }

    @Override
    public List<Detalle_Venta> findByPedido(long id) {
         try {
            this.session.getTransaction().begin();
            q = this.session.createQuery("SELECT d FROM Detalle_Venta d where d.fk_pedido.Id_Domicilio =" + id );
            this.listDetalles = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listDetalles;
    }

}
