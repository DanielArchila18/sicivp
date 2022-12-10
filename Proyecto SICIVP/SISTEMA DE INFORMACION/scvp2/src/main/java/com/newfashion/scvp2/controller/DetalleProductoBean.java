/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.controller;

import com.newfashion.scvp2.facadeImp.DetalleProductoImp;
import com.newfashion.scvp2.facadeImp.MovimientoImp;
import com.newfashion.scvp2.modelo.Detalle_Producto;
import com.newfashion.scvp2.modelo.Movimiento;
import java.io.IOException;
import java.util.ArrayList;
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
public class DetalleProductoBean {
    
    List<Detalle_Producto> listDetalles = new ArrayList<Detalle_Producto>();
    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    Detalle_Producto detalleP = new Detalle_Producto();
    List<Movimiento> listMovimientos;

    public List<Detalle_Producto> getListDetalles() {
        return listDetalles;
    }

    public void setListDetalles(List<Detalle_Producto> listDetalles) {
        this.listDetalles = listDetalles;
    }

    public List<Movimiento> getListMovimientos() {
        return listMovimientos;
    }

    public void setListMovimientos(List<Movimiento> listMovimientos) {
        this.listMovimientos = listMovimientos;
    }
    
    public List <Detalle_Producto>findAll(){
    DetalleProductoImp detalleImp = new DetalleProductoImp();
    this.listDetalles = detalleImp.findAll();
    return this.listDetalles;
    }
    
    public void enviarDetalle(long id) throws IOException{
    DetalleProductoImp detalleImp = new DetalleProductoImp();
    detalleP = detalleImp.findById(id);
    this.sessionMap.put("detalleP", detalleP);
    FacesContext.getCurrentInstance().getExternalContext().redirect("./../Inventario/listMovimientos.xhtml?faces-redirect=true");
    }
    
    
    public List<Movimiento> listByDetalleP(){
    MovimientoImp movimientoImp = new MovimientoImp();
    DetalleProductoImp detalleProductoImp = new DetalleProductoImp(); 
    Detalle_Producto detalleP = new Detalle_Producto();
    detalleP =(Detalle_Producto) this.sessionMap.get("detalleP");
    detalleP = detalleProductoImp.findById(detalleP.getId_Detalle_Producto());
    this.listMovimientos = movimientoImp.findByDetalle(detalleP.getId_Detalle_Producto());
    return this.listMovimientos;
    }
}
