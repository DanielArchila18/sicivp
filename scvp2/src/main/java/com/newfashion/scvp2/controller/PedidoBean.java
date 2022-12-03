/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.controller;

import com.newfashion.scvp2.facadeImp.PedidoImp;
import com.newfashion.scvp2.facadeImp.PersonaImp;
import com.newfashion.scvp2.facadeImp.RolImp;
import com.newfashion.scvp2.modelo.Pedido;
import com.newfashion.scvp2.modelo.Persona;
import com.newfashion.scvp2.modelo.Rol;
import com.newfashion.scvp2.modelo.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author DANIEL
 */
@ManagedBean
@RequestScoped
public class PedidoBean {

    Pedido pedido = new Pedido();
    List<Pedido> listPedidos = new ArrayList<Pedido>();
    long id_persona;
    long id_rol;
    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    List<Persona> listPersonas;
    List<Rol> listRoles;

    public PedidoBean() {
        this.callPersonas();
        this.callRoles();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> getListPedidos() {
        return listPedidos;
    }

    public void setListPedidos(List<Pedido> listPedidos) {
        this.listPedidos = listPedidos;
    }

    public long getId_persona() {
        return id_persona;
    }

    public void setId_persona(long id_persona) {
        this.id_persona = id_persona;
    }

    public long getId_rol() {
        return id_rol;
    }

    public void setId_rol(long id_rol) {
        this.id_rol = id_rol;
    }

   
    public List<Persona> getListPersonas() {
        return listPersonas;
    }

    public void setListPersonas(List<Persona> listPersonas) {
        this.listPersonas = listPersonas;
    }

    public List<Rol> getListRoles() {
        return listRoles;
    }

    public void setListRoles(List<Rol> listRoles) {
        this.listRoles = listRoles;
    }

    public List<Pedido> findAll() {
        PedidoImp pedidoImp = new PedidoImp();
        this.listPedidos = pedidoImp.findAll();
        return this.listPedidos;

    }

    public void enviarPedido(long id_pedido) throws IOException {
        Pedido ped = new Pedido();
        PedidoImp pedidoImp = new PedidoImp();
        ped = pedidoImp.findById(id_pedido);
        this.sessionMap.put("pedido", ped);
        FacesContext.getCurrentInstance().getExternalContext().redirect("./../Pedidos/detallePedido.xhtml");
        
    }

    public List<Pedido> findDespachados(){
     PedidoImp pedidoImp = new PedidoImp();
        this.listPedidos = pedidoImp.findDespachados();
        return this.listPedidos;
        
    }
    
    public List<Pedido> findGenerados(){
    
     PedidoImp pedidoImp = new PedidoImp();
        this.listPedidos = pedidoImp.findGenerados();
        return this.listPedidos;
    
    }
     public void actualizarDespachado(long id) throws IOException{
         System.out.println("@@" + id);
     Pedido ped = new Pedido();
     PedidoImp pedidoImp = new PedidoImp();
    
     ped = pedidoImp.findById(id);
     ped.setEstado("Despachado");
     ped.setFecha_Envio(new Date());
     pedidoImp.editPedido(pedido);
     FacesContext.getCurrentInstance().getExternalContext().redirect("./../Pedidos/listDisponibles.xhtml");
     }
     
     public void actualizarEntregado(long id) throws IOException{
      Pedido ped = new Pedido();
     PedidoImp pedidoImp = new PedidoImp();
     ped = pedidoImp.findById(id);
     ped.setEstado("Entregado");
     ped.setFecha_Entrega(new Date());
     pedidoImp.editPedido(pedido);
     FacesContext.getCurrentInstance().getExternalContext().redirect("./../Pedidos/listDisponibles.xhtml");
     }
     
     public List<Pedido>findByCliente(){
     Usuario usuario = new Usuario();
     usuario = (Usuario) this.sessionMap.get("sesion");
     PedidoImp pedidoImp = new PedidoImp();
     this.listPedidos = pedidoImp.findByCliente(usuario.getFk_persona().getId_persona());
     return this.listPedidos;
     }
     
     
    public String addPedido() {
        PedidoImp pedidoImp = new PedidoImp();
        RolImp rolImp = new RolImp();
        PersonaImp personaImp = new PersonaImp();
        Rol rol = new Rol();
        Persona persona = new Persona();
        rol = rolImp.findById(id_rol);
        persona = personaImp.findById(id_persona);
        pedido.setFk_persona(persona);
      
        pedidoImp.editPedido(pedido);
        return "";
    }

    public void callRoles() {
        RolImp rolImp = new RolImp();
        this.listRoles = rolImp.findAll();
    }

    public void callPersonas() {
        PersonaImp personaImp = new PersonaImp();
        this.listPersonas = personaImp.findAll();
    }
}
