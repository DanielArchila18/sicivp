/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.facadeImp;

import com.newfashion.scvp2.facade.IComprobante;
import com.newfashion.scvp2.modelo.Comprobante_Venta;
import com.newfashion.scvp2.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author DANIEL
 */
public class ComprobanteVentaImp implements IComprobante{
    List <Comprobante_Venta> listCombrobantes = new ArrayList<Comprobante_Venta>();
    Query q;
    EntityManager session =JPAUtil.getEntityManagerFactory().createEntityManager();
    @Override
    public List<Comprobante_Venta> findAll() {
        try {
            this.session.getTransaction().begin();
            q = this.session.createQuery("SELECT c FROM Comprobante_Venta c ORDER BY c.Fecha_Comprobante desc");
            this.listCombrobantes =q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listCombrobantes;
    }

    @Override
    public Comprobante_Venta findById(long id) {
       Comprobante_Venta comprobante = new Comprobante_Venta();
        try {
            this.session.getTransaction().begin();
            comprobante =this.session.find(Comprobante_Venta.class, id);
        } catch (Exception e) {
        }
        return comprobante;
    }

    @Override
    public long addComprobante(Comprobante_Venta comprobante) {
        try {
            this.session.getTransaction().begin();
            this.session.persist(comprobante);
            this.session.getTransaction().commit();
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comprobante.getId_Comprobante_Venta();
    }

    @Override
    public List<Comprobante_Venta> findByUser(long id) {
        try {
            this.session.getTransaction().begin();
            q = this.session.createQuery("SELECT c FROM Comprobante_Venta c where c.fk_persona.id_persona= " + id);
            this.listCombrobantes = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.listCombrobantes;
    }
    
}
