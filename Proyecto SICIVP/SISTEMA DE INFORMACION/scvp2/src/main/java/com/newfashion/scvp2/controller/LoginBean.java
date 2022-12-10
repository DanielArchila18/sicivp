/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.controller;

import com.newfashion.scvp2.facadeImp.RolImp;
import com.newfashion.scvp2.facadeImp.UsuarioImp;
import com.newfashion.scvp2.modelo.Persona;
import com.newfashion.scvp2.modelo.Usuario;
import com.newfashion.scvp2.utilities.SessionUtils;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luzam
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    UsuarioImp usuarioImp = new UsuarioImp();
 
    Usuario usuario = new Usuario();

    public LoginBean() {

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String iniciarSession() {
        Usuario usu = new Usuario();
        String path = "";
        String usuarioRol = "";
        usuarioRol = this.usuarioImp.validarUsuario(usuario);
         FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usu", usuarioRol);
        HttpSession session = SessionUtils.getSession();
        System.out.println("Rol" + usuarioRol);
        if (!usuarioRol.equalsIgnoreCase("none")){
        usu = usuarioImp.findById(usuario.getCorreo());
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sesion", usu);
        }
        
        
        System.out.println("@@ "+usu.toString());
        

        switch (usuarioRol) {

            case "Administrador":
                session.setAttribute("username", usuario.getCorreo());

               
               
                path = "/dashadministrador/admin.xhtml?faces-redirect=true";
                break;
            case "Empleado":
                session.setAttribute("username", usuario.getCorreo());
                
               
                

                path = "/dashempleado/admin.xhtml?faces-redirect=true";
                break;

            case "Usuario":
                session.setAttribute("username", usuario.getCorreo());
            
               
            

                path = "/dashcliente/admin.xhtml?faces-redirect=true";
                break;
            default:

                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Error al iniciar sesión",
                                "Correo o contraseña incorrectas, por favor ingrese unas credenciales validas."));
                
                break;

        }
        
        return path;

    }
    
    
    
    public void cerrarSesion() {
    
        try {
            HttpSession session = SessionUtils.getSession();
            session.invalidate();
            FacesContext.getCurrentInstance().getExternalContext().redirect("./../autenticacion/inicioSesion.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Seion cerrada correctamente");
    }


   
}
