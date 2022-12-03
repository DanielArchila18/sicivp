/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.controller;

import com.newfashion.scvp2.facadeImp.CategoriaImp;
import com.newfashion.scvp2.modelo.Categoria;
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
public class CategoriaBean {
    Categoria categoria = new Categoria();
    List<Categoria> listCategorias = new ArrayList<Categoria>();
     private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getListCategorias() {
        return listCategorias;
    }

    public void setListCategorias(List<Categoria> listCategorias) {
        this.listCategorias = listCategorias;
    }
     
    
    public List<Categoria> findAll(){
        CategoriaImp categoriaImp =new CategoriaImp();
        this.listCategorias = categoriaImp.findAll();
        return this.listCategorias;    
    
    }
    
    public String callCategoria(int id_categoria){
    Categoria cat = new Categoria();
    CategoriaImp categoriaImp =new CategoriaImp();
    cat = categoriaImp.findById(id_categoria);
    this.sessionMap.put("categoria", cat);
    return"";
    }
    
}
