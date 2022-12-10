/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.facadeImp;

import com.newfashion.scvp2.facade.IPersona;
import com.newfashion.scvp2.modelo.Persona;
import com.newfashion.scvp2.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author DANIEL
 */
public class PersonaImp implements IPersona{
    List<Persona> listPersonas = new ArrayList<Persona>();
    EntityManager session =JPAUtil.getEntityManagerFactory().createEntityManager();
    Query q;
    
    @Override
    public Persona findById(long id_persona) {
        Persona persona = new Persona();
        try{
        this.session.getTransaction().begin();
        persona = this.session.find(Persona.class, id_persona);
        this.session.getTransaction().commit();
        }catch(Exception e){
        e.printStackTrace();
        }
        return persona;
    }

    @Override
    public List<Persona> findAll() {
    String consulta = "SELECT p FROM Persona p";
    try{
        
    this.session.getTransaction().begin();
    q = this.session.createQuery(consulta);
    this.listPersonas = q.getResultList();
    
    }catch(Exception e){
    e.printStackTrace();
    }
    return this.listPersonas;
    }

    @Override
    public boolean editPersona(Persona persona) {
      try{
          this.session.getTransaction().begin();
          this.session.merge(persona);
          this.session.getTransaction().commit();
      }catch(Exception e){
      e.printStackTrace();
      }
      return false;
    }

    @Override
    public boolean addPersona(Persona persona) {
        try{
          this.session.getTransaction().begin();
          this.session.persist(persona);
          this.session.getTransaction().commit();
      }catch(Exception e){
      e.printStackTrace();
      }
      return false;
    }


    
    
}
