/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.controller;

import com.newfashion.scvp2.facadeImp.ComprobanteVentaImp;
import com.newfashion.scvp2.facadeImp.PedidoImp;
import com.newfashion.scvp2.facadeImp.PersonaImp;
import com.newfashion.scvp2.facadeImp.UsuarioImp;
import com.newfashion.scvp2.modelo.Comprobante_Venta;
import com.newfashion.scvp2.modelo.Pedido;
import com.newfashion.scvp2.modelo.Persona;
import com.newfashion.scvp2.modelo.Usuario;
import java.io.IOException;
import java.io.Serializable;
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
public class ComprobanteBean implements Serializable {

    Comprobante_Venta comprobante = new Comprobante_Venta();
    List<Comprobante_Venta> listComprobantes = new ArrayList<Comprobante_Venta>();
    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    List<Persona> listPersonas;
    List<Usuario> listUsuarios;
    long idPersona;
    long id_comprobante;
    long idPedido;
    public ComprobanteBean() {
        this.listaPersonas();
        this.listaUsuarios();
    }

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }
    
    public List<Persona> getListPersonas() {
        return listPersonas;
    }

    public void setListPersonas(List<Persona> listPersonas) {
        this.listPersonas = listPersonas;
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public Comprobante_Venta getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante_Venta comprobante) {
        this.comprobante = comprobante;
    }

    public List<Comprobante_Venta> getListComprobantes() {
        return listComprobantes;
    }

    public void setListComprobantes(List<Comprobante_Venta> listComprobantes) {
        this.listComprobantes = listComprobantes;
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public long getId_comprobante() {
        return id_comprobante;
    }

    public void setId_comprobante(long id_comprobante) {
        this.id_comprobante = id_comprobante;
    }

    public List<Comprobante_Venta> findAll() {
        ComprobanteVentaImp comprobanteImp = new ComprobanteVentaImp();
        this.listComprobantes = comprobanteImp.findAll();
        return this.listComprobantes;
    }

    public String callComprobante(int id) {
        ComprobanteVentaImp comprobanteImp = new ComprobanteVentaImp();
        Comprobante_Venta comprobanteV = new Comprobante_Venta();
        comprobanteV = comprobanteImp.findById(id);
        this.sessionMap.put("comprobante", comprobanteV);

        return null;

    }

    public void addFromCliente() throws IOException {
        PersonaImp personaImp = new PersonaImp();
        ComprobanteVentaImp comprobanteImp = new ComprobanteVentaImp();
        Pedido pedido = new Pedido();
        PedidoImp pedidoImp = new PedidoImp();
        Usuario usuario = new Usuario();
        usuario = (Usuario) this.sessionMap.get("sesion");
        Persona persona = new Persona();
        persona = personaImp.findById(usuario.getFk_persona().getId_persona());
        pedido.setFecha_Pedido(new Date());
        pedido.setFk_persona(persona);
        pedido.setEstado("Generado");
        idPedido = pedidoImp.addPedido(pedido);
        pedido = pedidoImp.findById(idPedido);
        comprobante.setFecha_Comprobante(new Date());
        comprobante.setFk_persona(persona);
        id_comprobante = comprobanteImp.addComprobante(comprobante);
        comprobante = comprobanteImp.findById(id_comprobante);
        this.sessionMap.put("comprobante", comprobante);
        this.sessionMap.put("pedido", pedido);
        FacesContext.getCurrentInstance().getExternalContext().redirect("./../Ventas/addCompra.xhtml");
    }

    public void addFromVendedor() throws IOException {
        ComprobanteVentaImp comprobanteImp = new ComprobanteVentaImp();
        PersonaImp personaImp = new PersonaImp();
        Persona persona = new Persona();
        persona = personaImp.findById(idPersona);
        comprobante.setFecha_Comprobante(new Date());
        comprobante.setFk_persona(persona);
        id_comprobante = comprobanteImp.addComprobante(comprobante);
        comprobante = comprobanteImp.findById(id_comprobante);
        this.sessionMap.put("comprobante", comprobante);

        FacesContext.getCurrentInstance().getExternalContext().redirect("./../Ventas/addDetalle.xhtml?faces-redirect=true");

    }

    public List<Comprobante_Venta> listByPerson() {
        ComprobanteVentaImp comprobanteImp = new ComprobanteVentaImp();
        Usuario usuario = new Usuario();
        usuario = (Usuario) this.sessionMap.get("sesion");
        this.listComprobantes = comprobanteImp.findByUser(usuario.getFk_persona().getId_persona());
        return this.listComprobantes;

    }

    public List<Persona> listaPersonas() {
        PersonaImp personaImp = new PersonaImp();
        this.listPersonas = personaImp.findAll();
        return this.listPersonas;

    }

    public List<Usuario> listaUsuarios() {
        UsuarioImp usuarioImp = new UsuarioImp();
        this.listUsuarios = usuarioImp.findByRol();
        return this.listUsuarios;
    }

    public void EnviarComprobante(long id) throws IOException {
        ComprobanteVentaImp comprobanteImp = new ComprobanteVentaImp();
        comprobante = comprobanteImp.findById(id);
        this.sessionMap.put("comprobante", comprobante);
        FacesContext.getCurrentInstance().getExternalContext().redirect("./../Ventas/listDetalles.xhtml?faces-redirect=true");
    }
    
     public void EnviarComprobanteU(long id) throws IOException {
        ComprobanteVentaImp comprobanteImp = new ComprobanteVentaImp();
        comprobante = comprobanteImp.findById(id);
        this.sessionMap.put("comprobante", comprobante);
        FacesContext.getCurrentInstance().getExternalContext().redirect("./../Ventas/listDetalles.xhtml?faces-redirect=true");
    }

}
