/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.controller;

import com.newfashion.scvp2.facadeImp.CategoriaImp;
import com.newfashion.scvp2.facadeImp.DetalleProductoImp;
import com.newfashion.scvp2.facadeImp.ProductoImp;
import com.newfashion.scvp2.modelo.Categoria;
import com.newfashion.scvp2.modelo.Detalle_Producto;
import com.newfashion.scvp2.modelo.Producto;
import java.io.InputStream;

import java.io.Serializable;
import java.util.ArrayList;
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
public class ProductoBean implements Serializable {

    Producto producto = new Producto();
    List<Producto> listProductos = new ArrayList<Producto>();
    List<Categoria> listCategorias;
    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    long id_categoria;
    UploadedFile carga;

    UploadedFile file;

    public UploadedFile getCarga() {
        return carga;
    }

    public void setCarga(UploadedFile carga) {
        this.carga = carga;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    long idProducto;

    public ProductoBean() {
        this.listaCategorias();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Producto> listProductos) {
        this.listProductos = listProductos;
    }

    public List<Categoria> getListCategorias() {
        return listCategorias;
    }

    public void setListCategorias(List<Categoria> listCategorias) {
        this.listCategorias = listCategorias;
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public List<Producto> findAll() {
        ProductoImp productoImp = new ProductoImp();
        this.listProductos = productoImp.findAll();
        return this.listProductos;
    }

    public String callProducto(int id) {
        Producto producto = new Producto();
        ProductoImp productoImp = new ProductoImp();
        producto = productoImp.findById(id);
        this.sessionMap.put("producto", producto);
        return "";
    }

    public void addProducto() {
        try {
            Detalle_Producto detalleP = new Detalle_Producto();
            DetalleProductoImp detalleProdImp = new DetalleProductoImp();
            ProductoImp productoImp = new ProductoImp();
            CategoriaImp categoriaImp = new CategoriaImp();
            Categoria categoria = new Categoria();
            System.out.println("idd" + id_categoria);
            categoria = categoriaImp.findById(id_categoria);
            try {
                if (file != null) {
                    producto.setFoto(file.getInputStream().readAllBytes());
                }
            } catch (Exception e) {
                e.printStackTrace();

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                        "Error",
                        "Foto no subida "
                ));

            }
            producto.setFk_Categoria(categoria);
            idProducto = productoImp.addProducto(producto);
            detalleP.setId_Detalle_Producto(idProducto);
            producto = productoImp.findById(idProducto);
            detalleP.setFk_producto(producto);
            detalleP.setTotal_Ext(0);
            detalleP.setEstado("Agotado");
            detalleProdImp.addDetalle(detalleP);
            
            System.out.println("Registro Realizado");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Exito",
                    "Registro realizado con exito"
            ));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Registro no hecho");
        }
    }

    public List<Categoria> listaCategorias() {
        CategoriaImp categoriaImp = new CategoriaImp();
        this.listCategorias = categoriaImp.findAll();
        return this.listCategorias;
    }

    public void cargarProductos() {
        ProductoImp productoImp = new ProductoImp();
        CategoriaImp categoriaImp = new CategoriaImp();
        Categoria categoria = new Categoria();
        
        DetalleProductoImp detalleProdImp = new DetalleProductoImp();
        long size = carga.getSize();
        System.out.println("TAMANO" + size);
        if (carga.getSize() > 0) {
            try {
                InputStream inputStream = carga.getInputStream();
                XSSFWorkbook libro = new XSSFWorkbook(inputStream);
                Sheet sheet = libro.getSheetAt(0);
                Iterator<Row> iterator = sheet.iterator();
                int i = 0;

                while (iterator.hasNext()) {
                    Producto prod = new Producto();
                    Detalle_Producto detalleP = new Detalle_Producto();
                    Row currentRow = iterator.next();
                    if (i > 0) {
                        if (currentRow.getCell(0) == null && currentRow.getCell(1)
                                != null && currentRow.getCell(2)
                                != null && currentRow.getCell(3)
                                != null && currentRow.getCell(4)
                                != null) {
                            prod.setNombre(currentRow.getCell(1).getStringCellValue());
                            System.out.println("nombre" + prod.getNombre());
                            prod.setReferencia(currentRow.getCell(2).getStringCellValue());
                            System.out.println("referencia" + prod.getReferencia());
                            prod.setPrecio((long) currentRow.getCell(3).getNumericCellValue());
                            System.out.println("precio" + prod.getPrecio());
                            id_categoria = (long) currentRow.getCell(4).getNumericCellValue();
                            System.out.println("Categoria" + id_categoria);
                            categoria = categoriaImp.findById(id_categoria);

                            prod.setFk_Categoria(categoria);
                            idProducto = productoImp.cargaProductos(prod);
                            detalleP.setId_Detalle_Producto(idProducto);
                            producto = productoImp.findById(idProducto);
                            detalleP.setFk_producto(producto);
                            detalleP.setTotal_Ext(0);
                            detalleP.setEstado("Agotado");
                            detalleProdImp.addDetalle(detalleP);
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Carga realizada correctamente"));
                        } else {
                            break;
                        }

                    }
                    i++;

                }
                libro.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Seleccione un archivo"));

        }
        PrimeFaces.current().ajax().update("table");
    }

}
