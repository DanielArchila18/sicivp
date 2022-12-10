/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.controller;

import com.newfashion.scvp2.facadeImp.DetalleCompraImp;
import com.newfashion.scvp2.facadeImp.DetalleProductoImp;
import com.newfashion.scvp2.facadeImp.MovimientoImp;
import com.newfashion.scvp2.facadeImp.OrdenCompraImp;
import com.newfashion.scvp2.facadeImp.PersonaImp;
import com.newfashion.scvp2.facadeImp.ProductoImp;
import com.newfashion.scvp2.facadeImp.ProveedorImp;
import com.newfashion.scvp2.facadeImp.RolImp;
import com.newfashion.scvp2.modelo.Detalle_Compra;
import com.newfashion.scvp2.modelo.Detalle_Producto;
import com.newfashion.scvp2.modelo.Movimiento;
import com.newfashion.scvp2.modelo.Orden_Compra;
import com.newfashion.scvp2.modelo.Persona;
import com.newfashion.scvp2.modelo.Producto;
import com.newfashion.scvp2.modelo.Proveedor;
import com.newfashion.scvp2.modelo.Rol;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author DANIEL
 */
@ManagedBean
@RequestScoped
public class DetalleCompraBean implements Serializable {

    Detalle_Compra detalleCompra = new Detalle_Compra();
    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    List<Detalle_Compra> listDetalles = new ArrayList<Detalle_Compra>();
    List<Persona> listPersonas;
    List<Producto> listProductos;
    List<Proveedor> listProveedor;
    List<Orden_Compra> listOrdenes;
    List<Rol> listRoles;
    long idDetalle;
    long id_persona;
    long id_producto;
    long id_proveedor;
    long id_orden;
    long id_rol;

    public DetalleCompraBean() {
        this.listaProductos();
    }

    public long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Detalle_Compra getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(Detalle_Compra detalleCompra) {
        this.detalleCompra = detalleCompra;
    }

    public List<Detalle_Compra> getListDetalles() {
        return listDetalles;
    }

    public void setListDetalles(List<Detalle_Compra> listDetalles) {
        this.listDetalles = listDetalles;
    }

    public List<Persona> getListPersonas() {
        return listPersonas;
    }

    public void setListPersonas(List<Persona> listPersonas) {
        this.listPersonas = listPersonas;
    }

    public List<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Producto> listProductos) {
        this.listProductos = listProductos;
    }

    public List<Proveedor> getListProveedor() {
        return listProveedor;
    }

    public void setListProveedor(List<Proveedor> listProveedor) {
        this.listProveedor = listProveedor;
    }

    public List<Orden_Compra> getListOrdenes() {
        return listOrdenes;
    }

    public void setListOrdenes(List<Orden_Compra> listOrdenes) {
        this.listOrdenes = listOrdenes;
    }

    public List<Rol> getListRoles() {
        return listRoles;
    }

    public void setListRoles(List<Rol> listRoles) {
        this.listRoles = listRoles;
    }

    public long getId_persona() {
        return id_persona;
    }

    public void setId_persona(long id_persona) {
        this.id_persona = id_persona;
    }

    public long getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(long id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public long getId_orden() {
        return id_orden;
    }

    public void setId_orden(long id_orden) {
        this.id_orden = id_orden;
    }

    public long getId_rol() {
        return id_rol;
    }

    public void setId_rol(long id_rol) {
        this.id_rol = id_rol;
    }

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
        this.id_producto = id_producto;
    }

    public List<Detalle_Compra> findAll() {
        DetalleCompraImp detalleImp = new DetalleCompraImp();
        this.listDetalles = detalleImp.findAll();
        return this.listDetalles;

    }

    public String callDetalle(int id_detalle) {
        Detalle_Compra detalle = new Detalle_Compra();
        DetalleCompraImp detalleImp = new DetalleCompraImp();
        detalle = detalleImp.findById(id_detalle);
        this.sessionMap.put("detalleCompra", detalle);
        return "";
    }

    public void addDetalle() {
        //Instanciamos las clases
        Persona persona = new Persona();
        Producto producto = new Producto();
        Proveedor proveedor = new Proveedor();
        Rol rol = new Rol();
        DetalleCompraImp detalleImp = new DetalleCompraImp();
        OrdenCompraImp ordenImp = new OrdenCompraImp();
        Movimiento movimiento = new Movimiento();
        MovimientoImp movimientoImp = new MovimientoImp();
        Detalle_Producto detalleP = new Detalle_Producto();
        DetalleProductoImp detalleProdImp = new DetalleProductoImp();
        PersonaImp personaImp = new PersonaImp();
        ProductoImp productoImp = new ProductoImp();
        ProveedorImp proveedorImp = new ProveedorImp();
        RolImp rolImp = new RolImp();
        Orden_Compra orden = new Orden_Compra();
        //Recibimos la entidad orden autogenerada
        orden = (Orden_Compra) this.sessionMap.get("orden");
        System.out.println("@@" + orden.toString());
        //Buscamos la orden por id
       orden = ordenImp.findById(orden.getId_Compra());
        System.out.println("@@Id" + id_producto);
        //Buscar el dato del producto
        producto = productoImp.findById(id_producto);
        
        System.out.println("Producto" + producto.toString());
        proveedor = proveedorImp.findById(id_proveedor);
        rol = rolImp.findById(id_rol);
        detalleCompra.setFk_orden_compra(orden);
        detalleCompra.setFk_producto(producto);
        detalleCompra.setFk_proveedor(proveedor);
        detalleCompra.setFk_rol(rol);
        detalleCompra.setFecha(new Date());
        idDetalle = detalleImp.addDetalle(detalleCompra);
        detalleCompra = detalleImp.findById(idDetalle);
        movimiento.setFk_detalle_compra(detalleCompra);

        movimiento.setFecha(new Date());
        movimiento.setFk_detalle_venta(null);

        detalleP = detalleProdImp.findById(producto.getId_Producto());

        detalleP.setTotal_Ext(detalleP.getTotal_Ext() + detalleCompra.getCantidad());

        if (detalleP.getEstado().equalsIgnoreCase("Agotado")) {
            detalleP.setEstado("Disponible");
        }
        movimiento.setFk_detalleP(detalleP);
        movimientoImp.addMovimiento(movimiento);
        detalleProdImp.editDetalle(detalleP);
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Exito",
                        "Dato registrado correctamente"));
        PrimeFaces.current().ajax().update("table");

    }

    public List<Producto> listaProductos() {
        ProductoImp productoImp = new ProductoImp();
        this.listProductos = productoImp.findAll();
        return this.listProductos;

    }

    public List<Detalle_Compra> findByOrden() {
        Orden_Compra orden = new Orden_Compra();
        OrdenCompraImp ordenImp = new OrdenCompraImp();
        DetalleCompraImp detalleImp = new DetalleCompraImp();
        orden =(Orden_Compra) this.sessionMap.get("orden");
        orden = ordenImp.findById(orden.getId_Compra());
        this.listDetalles = detalleImp.findByOrden(orden.getId_Compra());
        return this.listDetalles;
    }
    
    
    public void confirmarCompra() throws IOException{
    
    FacesContext.getCurrentInstance().getExternalContext().redirect("./../Compras/listOrdenes.xhtml");
    
    }
}
