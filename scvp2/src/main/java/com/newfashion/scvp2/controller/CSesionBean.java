/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.controller;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author DANIEL
 */
@ManagedBean(name="msesionBean")
@ViewScoped
public class CSesionBean implements Serializable{
    
     public void verificarAdministador()  throws IOException {
String rol = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usu");   
            if (rol ==null){
                rol = "none";
            }
            System.out.println("Rol " + rol);
            if (!rol.equals("Administrador")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("./../index.xhtml");
                System.out.println("Acceso denegado");
            }
            else{
            }
    }

    public void verificarEmpleado() throws IOException {

      

            String rol = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usu");
            
            if (rol == null) {
                rol = "none";
            }
            System.out.println("Rol" + rol);
            if (!rol.equals("Empleado")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("./../index.xhtml");
                System.out.println("Acceso denegado");
            }
            else{
            }
   

    }

    public void verificarCliente() throws IOException {

    

            String rol = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usu");
            
            if (rol == null) {
                rol = "none";
            }
            System.out.println("Rol" + rol);
             if (!rol.equals("Usuario")) {

                FacesContext.getCurrentInstance().getExternalContext().redirect("./../index.xhtml");
                System.out.println("Acceso denegado");
            }
            else{
                 
            }
      

    }

        public String cerrarSesion() {
  try {
  FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

  
      System.out.println("Sesión cerrada correctamente");
  }
  catch(Exception e){
  e.printStackTrace();
  }
  return "./../index.xhtml?faces-redirect=true";
    }
}
