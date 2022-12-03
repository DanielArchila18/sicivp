/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.facadeImp;

import com.newfashion.scvp2.facade.IRol;
import com.newfashion.scvp2.modelo.Rol;
import com.newfashion.scvp2.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author DANIEL
 */
public class RolImp implements IRol{
    Query q;
    List<Rol> listRoles = new ArrayList<Rol>();
    EntityManager session =JPAUtil.getEntityManagerFactory().createEntityManager();
    
    @Override
    public Rol findById(long id_rol) {
       Rol rol = new Rol();
       
       try{
       this.session.getTransaction().begin();
       rol = this.session.find(Rol.class, id_rol);
       this.session.getTransaction().commit();
       }catch(Exception e){
       e.printStackTrace();
       }
       return rol;
    }

    @Override
    public List<Rol> findAll() {
       String consulta = "SELECT r FROM Rol r ";
        try{
        this.session.getTransaction().begin();
        q = this.session.createQuery(consulta);
        this.listRoles = q.getResultList();
        }
        catch(Exception e){
            e.printStackTrace();
    }
        return this.listRoles;
    }
    
}
