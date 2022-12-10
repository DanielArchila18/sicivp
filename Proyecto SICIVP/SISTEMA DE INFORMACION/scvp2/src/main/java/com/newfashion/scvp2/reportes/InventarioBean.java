/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.reportes;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author DANIEL
 */
@ManagedBean
@ViewScoped
public class InventarioBean implements Serializable{
     public InventarioBean (){
        
            
}
      public void verReportePdf() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        
        System.out.println("Entro a descargar");
          
        //Instancia hacia la clase reporteClientes        
        reporteInventario rInventario = new reporteInventario();
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reportesjasper/inventario.jasper");
        
        rInventario.getReportePdf(ruta);        
        FacesContext.getCurrentInstance().responseComplete();               
    }
    
}
