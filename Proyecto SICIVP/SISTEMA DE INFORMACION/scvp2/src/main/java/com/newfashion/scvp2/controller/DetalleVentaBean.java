/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.controller;

import com.newfashion.scvp2.facadeImp.ComprobanteVentaImp;
import com.newfashion.scvp2.facadeImp.DetalleProductoImp;
import com.newfashion.scvp2.facadeImp.DetalleVentaImp;
import com.newfashion.scvp2.facadeImp.MovimientoImp;
import com.newfashion.scvp2.facadeImp.PedidoImp;
import com.newfashion.scvp2.facadeImp.PersonaImp;
import com.newfashion.scvp2.facadeImp.ProductoImp;
import com.newfashion.scvp2.facadeImp.UsuarioImp;
import com.newfashion.scvp2.modelo.Comprobante_Venta;
import com.newfashion.scvp2.modelo.Detalle_Producto;
import com.newfashion.scvp2.modelo.Detalle_Venta;
import com.newfashion.scvp2.modelo.Movimiento;
import com.newfashion.scvp2.modelo.Pedido;
import com.newfashion.scvp2.modelo.Persona;
import com.newfashion.scvp2.modelo.Producto;
import com.newfashion.scvp2.modelo.Usuario;
import com.newfashion.scvp2.utilities.EmailSender;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.PrimeFaces;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author DANIEL
 */
@ManagedBean
@RequestScoped
public class DetalleVentaBean implements Serializable {

    Detalle_Venta detalleV = new Detalle_Venta();
    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    List<Detalle_Venta> listDetalles = new ArrayList<Detalle_Venta>();
    List<Detalle_Producto> listDetalleP;
    List<Producto> listProductos;
    List<Persona> listPersonas;
    long id_comprobante;
    long idProd;
    long idPersona;
    long idDetalleV;
    String dest;
    String asun;
    String body;
    UploadedFile carga;
    List<Detalle_Producto> listDetallesP;

    public DetalleVentaBean() {
        this.listaPersonas();

        this.allProductDisp();

    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public UploadedFile getCarga() {
        return carga;
    }

    public void setCarga(UploadedFile carga) {
        this.carga = carga;
    }

    public List<Detalle_Producto> getListDetallesP() {
        return listDetallesP;
    }

    public void setListDetallesP(List<Detalle_Producto> listDetallesP) {
        this.listDetallesP = listDetallesP;
    }

    public Detalle_Venta getDetalleV() {
        return detalleV;
    }

    public void setDetalleV(Detalle_Venta detalleV) {
        this.detalleV = detalleV;
    }

    public List<Detalle_Venta> getListDetalles() {
        return listDetalles;
    }

    public void setListDetalles(List<Detalle_Venta> listDetalles) {
        this.listDetalles = listDetalles;
    }

    public List<Detalle_Producto> getListDetalleP() {
        return listDetalleP;
    }

    public void setListDetalleP(List<Detalle_Producto> listDetalleP) {
        this.listDetalleP = listDetalleP;
    }

    public List<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Producto> listProductos) {
        this.listProductos = listProductos;
    }

    public List<Persona> getListPersonas() {
        return listPersonas;
    }

    public void setListPersonas(List<Persona> listPersonas) {
        this.listPersonas = listPersonas;
    }

    public long getId_comprobante() {
        return id_comprobante;
    }

    public void setId_comprobante(long id_comprobante) {
        this.id_comprobante = id_comprobante;
    }

    public long getIdProd() {
        return idProd;
    }

    public void setIdProd(long idProd) {
        this.idProd = idProd;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public long getIdDetalleV() {
        return idDetalleV;
    }

    public void setIdDetalleV(long idDetalleV) {
        this.idDetalleV = idDetalleV;
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

    public List<Detalle_Venta> findAll() {
        Comprobante_Venta comprobante = new Comprobante_Venta();
        DetalleVentaImp detalleImp = new DetalleVentaImp();
        comprobante = (Comprobante_Venta) this.sessionMap.get("comprobante");
        id_comprobante = comprobante.getId_Comprobante_Venta();
        this.listDetalles = detalleImp.findAll(id_comprobante);
        return this.listDetalles;

    }

    public List<Detalle_Venta> findByPedido() {
        DetalleVentaImp detalleImp = new DetalleVentaImp();
        Pedido pedido = new Pedido();
        pedido = (Pedido) this.sessionMap.get("pedido");
        System.out.println("@@" + pedido.toString());
        this.listDetalles = detalleImp.findByPedido(pedido.getId_Domicilio());
        return this.listDetalles;

    }

    public void registrarVenta() {

        //Intanciar clases
        Comprobante_Venta comprobante = new Comprobante_Venta();
        ComprobanteVentaImp comprobanteImp = new ComprobanteVentaImp();
        Pedido pedido = null;
        Pedido ped = new Pedido();
        PedidoImp pedidoImp = new PedidoImp();
        Detalle_Producto detalleP = new Detalle_Producto();
        DetalleProductoImp detalleProdImp = new DetalleProductoImp();
        Producto producto = new Producto();
        ProductoImp productoImp = new ProductoImp();
        Comprobante_Venta comp = new Comprobante_Venta();
        DetalleVentaImp detalleImp = new DetalleVentaImp();
        Movimiento movimiento = new Movimiento();
        MovimientoImp movimientoImp = new MovimientoImp();
        Persona persona = new Persona();
        PersonaImp personaImp = new PersonaImp();

        //Registrar
        comprobante = (Comprobante_Venta) this.sessionMap.get("comprobante");
        comprobante = comprobanteImp.findById(comprobante.getId_Comprobante_Venta());
        pedido = (Pedido) this.sessionMap.get("pedido");
        if (pedido != null) {
            ped = pedidoImp.findById(pedido.getId_Domicilio());
            detalleV.setFk_pedido(ped);
        }

        producto = productoImp.findById(idProd);
        detalleP = detalleProdImp.findById(idProd);

        persona = personaImp.findById(idPersona);

        detalleV.setFecha(new Date());
        detalleV.setFk_persona(persona);
        detalleV.setFk_producto(producto);
        detalleV.setFk_comprobante(comprobante);
        System.out.println("Precio" + producto.getPrecio() + "Cantidad" + detalleV.getCantidad());
        detalleV.setTotal(producto.getPrecio() * detalleV.getCantidad());
        detalleV.getTotal();
        if (detalleV.getCantidad() > detalleP.getTotal_Ext()) {
            FacesContext.getCurrentInstance().addMessage(
                                        null,
                                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                "Cantidad del producto no disponible o producto agotado",
                                                "El producto " + producto.getNombre() + " tiene " + detalleP.getTotal_Ext() + " disponibles."));

        } else {
            detalleV.setFk_comprobante(comprobante);
            idDetalleV = detalleImp.addDetalle(detalleV);
            detalleV = detalleImp.findById(idDetalleV);
            movimiento.setFecha(new Date());
            movimiento.setFk_detalle_venta(detalleV);

            detalleP.setTotal_Ext(detalleP.getTotal_Ext() - detalleV.getCantidad());
            if (detalleP.getTotal_Ext() <= 0) {
                detalleP.setEstado("Agotado");
            }

            detalleProdImp.editDetalle(detalleP);
            movimiento.setFk_detalleP(detalleP);
            movimientoImp.addMovimiento(movimiento);
            PrimeFaces.current().ajax().update("table");

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Exito",
                            "Producto registrado correctamente"));

        }

    }

    public List<Detalle_Venta> listByComprobante() {
        Comprobante_Venta comprobante = new Comprobante_Venta();
        DetalleVentaImp detalleImp = new DetalleVentaImp();
        comprobante = (Comprobante_Venta) this.sessionMap.get("comprobante");
        this.listDetalles = detalleImp.findByComprobante(comprobante.getId_Comprobante_Venta());
        return this.listDetalles;
    }

    public List<Persona> listaPersonas() {
        PersonaImp personaImp = new PersonaImp();
        this.listPersonas = personaImp.findAll();

        return this.listPersonas;

    }

    public List<Detalle_Producto> allProductDisp() {
        DetalleProductoImp detalleImp = new DetalleProductoImp();
        this.listDetallesP = detalleImp.findAllDisp();
        return this.listDetallesP;
    }

    public void confirmarCompra() throws IOException {
        ComprobanteVentaImp comprobanteImp = new ComprobanteVentaImp();
        Comprobante_Venta comprobante = new Comprobante_Venta();
        UsuarioImp usuarioImp = new UsuarioImp();
        Usuario usuario = new Usuario();
        comprobante = (Comprobante_Venta) this.sessionMap.get("comprobante");
        comprobante = comprobanteImp.findById(comprobante.getId_Comprobante_Venta());
        usuario = usuarioImp.findByCedula(comprobante.getFk_persona().getId_persona());
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = dateFormatter.format(new Date());
        dest = usuario.getCorreo();
        asun = "Confirmacion de compra n°" + comprobante.getId_Comprobante_Venta();
        body = "Señor/a " + usuario.getFk_persona().getNombre() + usuario.getFk_persona().getApellido() + ", Se confirma su compra n " + comprobante.getId_Comprobante_Venta() + "Del dia" + fecha + " Adjuntamos su factura de compra, Agradecemos la confianza que deposito en nosotros para traer las mejores prendas de calidad";
        System.out.println("correo " + dest);
        System.out.println("asunto " + asun);
        System.out.println("Cuerpo " + body);
        if (EmailSender.enviarConGMail(dest, asun, body)) {

            FacesContext.getCurrentInstance().getExternalContext().redirect("./../Ventas/listVentas.xhtml");

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

    public void cargarProductos() {
        Comprobante_Venta comprobante = new Comprobante_Venta();
        ComprobanteVentaImp comprobanteImp = new ComprobanteVentaImp();
        Pedido pedido = null;
        Pedido ped = new Pedido();
        PedidoImp pedidoImp = new PedidoImp();

        DetalleProductoImp detalleProdImp = new DetalleProductoImp();

        ProductoImp productoImp = new ProductoImp();
        Comprobante_Venta comp = new Comprobante_Venta();
        DetalleVentaImp detalleImp = new DetalleVentaImp();

        MovimientoImp movimientoImp = new MovimientoImp();
        Persona persona = new Persona();
        PersonaImp personaImp = new PersonaImp();
        comprobante = (Comprobante_Venta) this.sessionMap.get("comprobante");
        comprobante = comprobanteImp.findById(comprobante.getId_Comprobante_Venta());

        long size = carga.getSize();
        System.out.println("TAMANO" + size);
        if (size > 0) {
            try {
                InputStream inputStream = carga.getInputStream();
                XSSFWorkbook libro = new XSSFWorkbook(inputStream);
                Sheet sheet = libro.getSheetAt(0);
                Iterator<Row> iterator = sheet.iterator();
                int i = 0;
                System.out.println("Inicia la operacion");
                
                while (iterator.hasNext()) {
                    
                    Movimiento movimiento = new Movimiento();
                    Detalle_Venta detalleVen = new Detalle_Venta();
                    Detalle_Producto detalleP = new Detalle_Producto();
                    Producto producto = null;
                    Row currentRow = iterator.next();
                    if (i > 0) {
                        if (currentRow.getCell(0) == null && currentRow.getCell(1)
                                != null && currentRow.getCell(2)
                                != null) {
                            System.out.println("Inicia la operacion");
                            idProd = (long) currentRow.getCell(1).getNumericCellValue();
                            System.out.println(idProd);
                            producto = productoImp.findById(idProd);
                            if(producto != null){
                            System.out.println("@@"+ producto.toString());
                            detalleP = detalleProdImp.findById(idProd);
                            System.out.println("@@"+ detalleP.toString());
                            detalleVen.setFk_producto(producto);
                            detalleVen.setCantidad((long) currentRow.getCell(2).getNumericCellValue());
                            detalleVen.setTotal(producto.getPrecio() * detalleVen.getCantidad());

                            if (detalleVen.getCantidad() > detalleP.getTotal_Ext()) {
                                FacesContext.getCurrentInstance().addMessage(
                                        null,
                                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                "Cantidad del producto no disponible o producto agotado",
                                                "El producto " + producto.getNombre() + " tiene " + detalleP.getTotal_Ext() + " disponibles."));

                            } else {
                                detalleVen.setFk_comprobante(comprobante);
                                idDetalleV = detalleImp.addDetalle(detalleVen);
                                detalleVen = detalleImp.findById(idDetalleV);
                                movimiento.setFecha(new Date());
                                movimiento.setFk_detalle_venta(detalleVen);

                                detalleP.setTotal_Ext(detalleP.getTotal_Ext() - detalleVen.getCantidad());
                                if (detalleP.getTotal_Ext() <= 0) {
                                    detalleP.setEstado("Agotado");
                                }

                                detalleProdImp.editDetalle(detalleP);
                                movimiento.setFk_detalleP(detalleP);
                                movimientoImp.addMovimiento(movimiento);

                                FacesContext.getCurrentInstance().addMessage(
                                        null,
                                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                "Exito",
                                                "Producto registrado correctamente"));

                            }
                            }
                            else{
                             FacesContext.getCurrentInstance().addMessage(
                                        null,
                                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                "La prenda con el codigo " +idProd+ " no existe",
                                                "Intente ingresando un codigo de un producto existente."));
                            }
                        }else {
                            break;
                        }
                    }
                    i++;
                }
                libro.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            PrimeFaces.current().ajax().update("table");
        }

    }

}
