/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.controller;

import com.newfashion.scvp2.facadeImp.PersonaImp;
import com.newfashion.scvp2.facadeImp.RolImp;
import com.newfashion.scvp2.facadeImp.UsuarioImp;
import com.newfashion.scvp2.modelo.Persona;
import com.newfashion.scvp2.modelo.Rol;
import com.newfashion.scvp2.modelo.Usuario;
import com.newfashion.scvp2.utilities.EmailSender;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;



/**
 *
 * @author DANIEL
 */
@ManagedBean(name="usuarioBean")
@RequestScoped
public class UsuarioBean implements Serializable{
    
    
    Usuario usuario = new Usuario();
    long id_rol;
    long id_persona;
    List<Usuario> listUsuarios = new ArrayList<Usuario>();
    List<Rol> listRol;
    Persona persona = new Persona();
    String dest;
    String asun;
    String body;
  private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

    public List<Rol> getListRol() {
        return listRol;
    }

    public void setListRol(List<Rol> listRol) {
        this.listRol = listRol;
    }

  
  
    
    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public long getId_rol() {
        return id_rol;
    }

    public void setId_rol(long id_rol) {
        this.id_rol = id_rol;
    }

    public long getId_persona() {
        return id_persona;
    }

    public void setId_persona(long id_persona) {
        this.id_persona = id_persona;
    }

   
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getAsun() {
        return asun;
    }

    public void setAsun(String asun) {
        this.asun = asun;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    
    
    public List<Usuario> findAll(){
        UsuarioImp usuarioImp =new UsuarioImp();
        this.listUsuarios = usuarioImp.findAll();
        return this.listUsuarios;
    
    }

    public UsuarioBean() {
        this.listRoles();
    }
    
    
    
    
    public void callUsuario(String correo) throws IOException{
    Usuario usu = new Usuario();
    UsuarioImp usuarioImp =new UsuarioImp();
    usu = usuarioImp.findById(correo);
    this.sessionMap.put("usuario", usu);
    FacesContext.getCurrentInstance().getExternalContext().redirect("./../GestionUsuarios/editRol.xhtml?faces-redirect=true");
    }
    
     public String callForEdit(String correo){
    Usuario usu = new Usuario();
    UsuarioImp usuarioImp =new UsuarioImp();
    usu = usuarioImp.findById(correo);
    this.sessionMap.put("usuario", usu);
    return "";
    }
    
    public void updateUsuario(Usuario usuario){
    UsuarioImp usuarioImp = new UsuarioImp();
    Rol rol= new Rol();
    Persona persona = new Persona();
    RolImp rolImp = new RolImp();
    PersonaImp personaImp= new PersonaImp();
    rol = rolImp.findById(usuario.getFk_rol().getId_rol());
    persona = personaImp.findById(usuario.getFk_persona().getId_persona());
    usuario.setFk_rol(rol);
    usuario.setFk_persona(persona);
    usuarioImp.updateUsuario(usuario);
    
    }
    
    public void addUsuario() throws IOException{ 
    UsuarioImp usuarioImp = new UsuarioImp();
    Rol rol= new Rol();
    Persona per = new Persona();
    PersonaImp personaImp= new PersonaImp();
    RolImp rolImp = new RolImp();
    personaImp.addPersona(persona);
    id_rol= 3;
    rol = rolImp.findById(id_rol);
    per = personaImp.findById(persona.getId_persona());
    usuario.setFk_persona(per);
    usuario.setFk_rol(rol);
    usuarioImp.addUsuario(usuario);
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = dateFormatter.format(new Date());
        dest = usuario.getCorreo();
        asun = "Registro de usuario nuevo";
        body = "Señor/a " + persona.getNombre() + persona.getApellido() + ", el dia " + fecha + " usted se registró en la pagina sicivp exitosamente, recuerde ingresar con su correo " + usuario.getCorreo() +" y la contraseña que establecio en el registro";
        System.out.println("correo " + dest);
        System.out.println("asunto " + asun);
        System.out.println("Cuerpo " + body);
        if (EmailSender.enviarConGMail(dest, asun, body)) {
            
            FacesContext.getCurrentInstance().getExternalContext().redirect("./../autenticacion/inicioSesion.xhtml?facesRedirect=true");
      
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Exito",
                            "Registro realizado correctamente, la confirmación ha sido enviada al correo."));
            PrimeFaces.current().ajax().update("message");
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "Error",
                            "Envio de detalle al correo no se realizó."));
        }
    
    
    }
    
    public String deleteUsuario(String correo){
    UsuarioImp usuarioImp = new UsuarioImp();
    usuarioImp.deleteUsuario(correo);
        return null;
    
    
    }
    
    public void callPersona(long id) throws IOException{
    PersonaImp personaImp = new PersonaImp();
    Persona per = new Persona();
    per = personaImp.findById(id);
    this.sessionMap.put("persona", per);
    FacesContext.getCurrentInstance().getExternalContext().redirect("./editarPersona.xhtml?faces-redirect=true");
    
    }
    
    public void editPersona(Persona persona){
        Usuario usuario= new Usuario();
        UsuarioImp usuarioImp =new UsuarioImp();
      try{
    PersonaImp personaImp = new PersonaImp();
    personaImp.editPersona(persona);
    usuario = usuarioImp.findByCedula(persona.getId_persona());
    this.sessionMap.put("sesion", usuario);
    FacesContext.getCurrentInstance().getExternalContext().redirect("./../GestionUsuarios/infoUsuario.xhtml");
  FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Exito",
                            "Datos actualizados correctamente"));
        }catch(Exception e){
        e.printStackTrace();
        }
    

            }
    
    
    public List<Rol> listRoles(){
    RolImp rolImp = new RolImp();
    this.listRol= rolImp.findAll();
    return this.listRol;
    }
    
   public void addFromAdmin(){
   
        UsuarioImp usuarioImp = new UsuarioImp();
    Rol rol= new Rol();
    Persona per = new Persona();
    PersonaImp personaImp= new PersonaImp();
    RolImp rolImp = new RolImp();
    personaImp.addPersona(persona);
    
    rol = rolImp.findById(id_rol);
    per = personaImp.findById(persona.getId_persona());
    usuario.setFk_persona(per);
    usuario.setFk_rol(rol);
    usuario.setContrasena(usuario.getFk_rol().getNombre_rol() + persona.getId_persona());
    usuarioImp.addUsuario(usuario);
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = dateFormatter.format(new Date());
        dest = usuario.getCorreo();
        asun = "Registro de usuario nuevo";
        body = "Señor/a " + persona.getNombre() + persona.getApellido() + ", el dia " + fecha + " usted se registró en la pagina sicivp exitosamente, recuerde ingresar con su correo " + usuario.getCorreo() +" y la contraseña: " + usuario.getContrasena();
        System.out.println("correo " + dest);
        System.out.println("asunto " + asun);
        System.out.println("Cuerpo " + body);
        if (EmailSender.enviarConGMail(dest, asun, body)) {
            
          
      
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Exito",
                            "Registro realizado correctamente, la confirmación ha sido enviada al correo."));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "Error",
                            "Envio de detalle al correo no se realizó."));
        }
        
       
   
   }
   
   
   public void addFromEmpleado(){
             UsuarioImp usuarioImp = new UsuarioImp();
    Rol rol= new Rol();
    Persona per = new Persona();
    PersonaImp personaImp= new PersonaImp();
    RolImp rolImp = new RolImp();
    personaImp.addPersona(persona);
    id_rol =3;
    rol = rolImp.findById(id_rol);
    per = personaImp.findById(persona.getId_persona());
    usuario.setFk_persona(per);
    usuario.setFk_rol(rol);
    usuario.setContrasena(usuario.getFk_rol().getNombre_rol() + persona.getId_persona());
    usuarioImp.addUsuario(usuario);
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = dateFormatter.format(new Date());
        dest = usuario.getCorreo();
        asun = "Registro de usuario nuevo";
        body = "Señor/a " + persona.getNombre() + persona.getApellido() + ", el dia " + fecha + " usted se registró en la pagina sicivp exitosamente, recuerde ingresar con su correo " + usuario.getCorreo() +" y la contraseña: " + usuario.getContrasena();
        System.out.println("correo " + dest);
        System.out.println("asunto " + asun);
        System.out.println("Cuerpo " + body);
        if (EmailSender.enviarConGMail(dest, asun, body)) {
            
          
      
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Exito",
                            "Registro realizado correctamente, la confirmación ha sido enviada al correo."));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "Error",
                            "Envio de detalle al correo no se realizó."));
        }
       
       
   }
   
   
   
    public void editRolU(Usuario usuario) throws IOException{
     UsuarioImp usuarioImp = new UsuarioImp();
     RolImp rolImp = new RolImp();
     Rol rol = new Rol();
     rol = rolImp.findById(usuario.getFk_rol().getId_rol());
     usuario.setFk_rol(rol);
     usuarioImp.updateUsuario(usuario);
     FacesContext.getCurrentInstance().getExternalContext().redirect("./../GestionUsuarios/listUsuarios.xhtml?faces-redirect=true");
    }
}
