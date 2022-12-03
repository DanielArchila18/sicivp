/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.controller;

import com.newfashion.scvp2.facadeImp.OrdenCompraImp;
import com.newfashion.scvp2.modelo.Orden_Compra;
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
public class OrdenCompraBean {
    
    Orden_Compra ordenCompra =new Orden_Compra();
    List <Orden_Compra> listOrdenes = new ArrayList <Orden_Compra>();
    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    private long idOrden;

    public long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(long idOrden) {
        this.idOrden = idOrden;
    }
    
    
    
    public Orden_Compra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(Orden_Compra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public List<Orden_Compra> getListOrdenes() {
        return listOrdenes;
    }

    public void setListOrdenes(List<Orden_Compra> listOrdenes) {
        this.listOrdenes = listOrdenes;
    }

    
    
    public List<Orden_Compra> findAll(){
    OrdenCompraImp ordenImp = new OrdenCompraImp();
    this.listOrdenes =ordenImp.findAll();
    return this.listOrdenes;
    }
    
    public void enviarOrden(long id_orden) throws IOException{
    Orden_Compra orden = new Orden_Compra();
    OrdenCompraImp ordenImp = new OrdenCompraImp();
    orden = ordenImp.findById(id_orden);
    this.sessionMap.put("orden", orden);
    FacesContext.getCurrentInstance().getExternalContext().redirect("./../Compras/listCompras.xhtml");
    
    }
    
    public void addOrden() throws IOException{
     OrdenCompraImp ordenImp = new OrdenCompraImp();
        ordenCompra.setFecha_Orden(new Date());
        idOrden = ordenImp.addOrden(ordenCompra);
        ordenCompra = ordenImp.findById(idOrden);
        this.sessionMap.put("orden", ordenCompra);
        FacesContext.getCurrentInstance().getExternalContext().redirect("./../Compras/addDetalle.xhtml?faces-redirect=true");

    }
    
   
}
