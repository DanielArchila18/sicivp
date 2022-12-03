/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.facadeImp;

import com.newfashion.scvp2.facade.IUsuario;
import com.newfashion.scvp2.modelo.Rol;
import com.newfashion.scvp2.modelo.Usuario;
import com.newfashion.scvp2.utilities.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;


import javax.persistence.Query;

/**
 *
 * @author DANIEL
 */
public class UsuarioImp implements IUsuario{
    
    List<Usuario> listUsuarios = new ArrayList<Usuario>();
    EntityManager session =JPAUtil.getEntityManagerFactory().createEntityManager();
    
    
    Query q;
    
    @Override
    public boolean updateUsuario(Usuario usuario) {
        try{
            this.session.getTransaction().begin();
            this.session.merge(usuario);
            this.session.getTransaction().commit();
            this.session.close();
        }catch(Exception e){
        e.printStackTrace();
        }
        
        return false;
    }

    @Override
    public boolean addUsuario(Usuario usuario) {
       try{
            this.session.getTransaction().begin();
            this.session.persist(usuario);
            this.session.getTransaction().commit();
            this.session.close();
        }catch(Exception e){
        e.printStackTrace();
        }
        
        return false;
    }

    @Override
    public boolean deleteUsuario(String correo) {
        Usuario usuario = new Usuario();
        try{
        this.session.getTransaction().begin();
        usuario = this.session.find(Usuario.class, correo);
        this.session.remove(usuario);
        this.session.getTransaction().commit();
        this.session.close();
        }catch(Exception e){
        e.printStackTrace();
        }
        return false;
        
    }

    @Override
    public List<Usuario> findAll() {
       String consulta = "SELECT u FROM Usuario u ";
      try{
      this.session.getTransaction().begin();
      q = this.session.createQuery(consulta);
      this.listUsuarios= q.getResultList();
      }catch(Exception e){
      e.printStackTrace();
      }
      return this.listUsuarios;
    }

    @Override
    public Usuario findById(String correo) {
    Usuario usuario = new Usuario();
    try{
    this.session.getTransaction().begin();
    usuario = this.session.find(Usuario.class, correo);
    this.session.getTransaction().commit();
    }catch(Exception e){
    e.printStackTrace();
    }
    return usuario;
    }

 
 @Override
    public String validarUsuario(Usuario usu) {
         String roles = "none";
        try {
            this.session.getTransaction().begin();
            Query q = this.session.createQuery("SELECT u FROM Usuario u where u.contrasena=?1 AND u.correo=?2");
            q.setParameter(1, usu.getContrasena());
            q.setParameter(2, usu.getCorreo());
            this.listUsuarios = q.getResultList();
            
            for (Usuario us : this.listUsuarios) {
                RolImp rolImp = new RolImp();
                Rol rol = new Rol();
                rol = rolImp.findById(us.getFk_rol().getId_rol());
                System.out.println("Nombre rol " + rol.getNombre_rol());
                roles = rol.getNombre_rol();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            this.session.getTransaction().commit();
            this.session.clear();
            
            this.q = null;
        }
        
        return roles;
        
    }

    @Override
    public List<Usuario> findByRol() {
          
      try{
      this.session.getTransaction().begin();
      q = this.session.createQuery("SELECT u FROM Usuario u WHERE u.fk_rol.id_rol = 3");
      this.listUsuarios= q.getResultList();
      }catch(Exception e){
      e.printStackTrace();
      }
      return this.listUsuarios;
    }

    @Override
    public Usuario findByCedula(long id) {
      Usuario usuario = null;
      try{
      this.session.getTransaction().begin();
      q = this.session.createQuery("SELECT u FROM Usuario u where u.fk_persona.id_persona=?1");
      q.setParameter(1, id);
      usuario =(Usuario) q.getSingleResult();
     
      }catch(Exception e){
      e.printStackTrace();
      }
      return usuario;
    }
    
}
