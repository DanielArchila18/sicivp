/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.facadeImp;

import com.newfashion.scvp2.facade.ICategoria;
import com.newfashion.scvp2.modelo.Categoria;
import com.newfashion.scvp2.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author DANIEL
 */
public class CategoriaImp implements ICategoria{
    Query q;
    List<Categoria>listCategorias = new ArrayList<Categoria>();
    EntityManager session =JPAUtil.getEntityManagerFactory().createEntityManager();
    
    @Override
    public List<Categoria> findAll() {
        try{
        this.session.getTransaction().begin();
        q = this.session.createQuery("SELECT c FROM Categoria c");
        this.listCategorias = q.getResultList();
        }catch(Exception e){
        e.printStackTrace();
        }
        return this.listCategorias;
    }

    @Override
    public Categoria findById(long id_categoria) {
       Categoria categoria = new Categoria();
        try {
            this.session.getTransaction().begin();
            categoria = this.session.find(Categoria.class, id_categoria);
            this.session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
       return categoria;
    }
    
}
