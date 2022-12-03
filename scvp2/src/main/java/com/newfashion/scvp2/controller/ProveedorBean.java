/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.controller;

import com.newfashion.scvp2.facadeImp.ProveedorImp;
import com.newfashion.scvp2.modelo.Proveedor;
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
public class ProveedorBean {
    Proveedor proveedor = new Proveedor();
    List <Proveedor>listProveedores = new ArrayList<Proveedor>();
    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedor> getListProveedores() {
        return listProveedores;
    }

    public void setListProveedores(List<Proveedor> listProveedores) {
        this.listProveedores = listProveedores;
    }

    
    public List<Proveedor>findAll(){
    ProveedorImp proveedorImp = new ProveedorImp();
    this.listProveedores = proveedorImp.findAll();
    return this.listProveedores;
    }
    
    public String callProveedor(int id_proveedor){
    Proveedor prov =new Proveedor(); 
    ProveedorImp proveedorImp = new ProveedorImp();
    prov = proveedorImp.findById(id_proveedor);
    this.sessionMap.put("proveedor", prov);
    return"";
    }
    public String editProveedor(Proveedor prov){
    ProveedorImp proveedorImp = new ProveedorImp();
    proveedorImp.editProveedor(prov);
    return"";
    }
    public String addProveedor(){
    ProveedorImp proveedorImp = new ProveedorImp();
    proveedorImp.addProveedor(proveedor);
    return"";
    }
    
    
    
}
