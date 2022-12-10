/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.reportes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author DANIEL
 */
public class reporteInventario {
    public void getReportePdf(String ruta) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException {
        
       
        Connection reportes;
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        reportes = DriverManager.getConnection("jdbc:mysql://localhost/bd_sicivp?autoReconnect=true&useSSL=false", "root", "FA-200306");

        //Se definen los parametros si es que el reporte necesita
        Map parameter = new HashMap();

        try {
            File file = new File(ruta);
            
            FileInputStream fis = new FileInputStream(file);
            
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

            httpServletResponse.setContentType("application/pdf");
            
            httpServletResponse.addHeader("Content-Disposition", "attachment; filename=reporte.pdf");
            
            /*
            httpServletResponse.setHeader("Cache-Control", "no-cache");
            httpServletResponse.setHeader("Pragma", "no-cache");
            httpServletResponse.setDateHeader("Expires", 0);
*/
           // httpServletResponse.setContentType("application/PDF");
           
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, reportes);
            byte[] bytes = JasperRunManager.runReportToPdf(file.getPath(), parameter, reportes);
            
            httpServletResponse.setContentLength(bytes.length);
            
            System.out.println("Intento descargar");
          
            
            ServletOutputStream outStream = httpServletResponse.getOutputStream();
            outStream.write(bytes, 0 ,bytes.length);
            
           
        
         outStream.flush();
         outStream.close();
      

        } catch (JRException e) {
            e.printStackTrace();
        } finally {
            if (reportes != null) {
                try {
                    reportes.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
