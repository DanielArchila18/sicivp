/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.facadeImp;

import com.newfashion.scvp2.facade.IPedido;
import com.newfashion.scvp2.modelo.Pedido;
import com.newfashion.scvp2.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author DANIEL
 */
public class PedidoImp implements IPedido{
    Query q;
    List<Pedido> listPedidos = new ArrayList<Pedido>();
    EntityManager session =JPAUtil.getEntityManagerFactory().createEntityManager();
    
    
    @Override
    public List<Pedido> findAll() {
       String consulta = "SELECT p FROM Pedido p";
        try{
       this.session.getTransaction().begin();
       q = this.session.createQuery(consulta);
       this.listPedidos = q.getResultList();
       }catch(Exception e){{
           
           e.printStackTrace();
       }
       }
        return this.listPedidos;
    }

    @Override
    public Pedido findById(long id_Pedido) {
       Pedido pedido = new Pedido();
        try {
            this.session.getTransaction().begin();
            pedido = this.session.find(Pedido.class, id_Pedido);
            this.session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pedido;
    }

    @Override
    public boolean editPedido(Pedido pedido) {
        try {
            this.session.getTransaction().begin();
            this.session.merge(pedido);
            this.session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public long addPedido(Pedido pedido) {
       try {
            this.session.getTransaction().begin();
            this.session.persist(pedido);
            this.session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pedido.getId_Domicilio();
    }

    @Override
    public List<Pedido> findGenerados() {
        
        try{
       this.session.getTransaction().begin();
       q = this.session.createQuery("SELECT p FROM Pedido p WHERE p.estado ='Generado'");
       this.listPedidos = q.getResultList();
       }catch(Exception e){{
           
           e.printStackTrace();
       }
       }
        return this.listPedidos;
    }

    @Override
    public List<Pedido> findDespachados() {
         try{
       this.session.getTransaction().begin();
       q = this.session.createQuery("SELECT p FROM Pedido p WHERE p.estado ='Despachado'");
       this.listPedidos = q.getResultList();
       }catch(Exception e){{
           
           e.printStackTrace();
       }
       }
        return this.listPedidos;
    }

    @Override
    public List<Pedido> findByCliente(long id) {
         
        try{
       this.session.getTransaction().begin();
       q = this.session.createQuery("SELECT p FROM Pedido p WHERE p.fk_persona.id_persona = " + id);
       this.listPedidos = q.getResultList();
       }catch(Exception e){{
           
           e.printStackTrace();
       }
       }
        return this.listPedidos;
    }
    
}
