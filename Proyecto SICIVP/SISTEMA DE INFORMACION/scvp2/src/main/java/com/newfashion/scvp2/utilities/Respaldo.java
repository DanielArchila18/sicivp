/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DANIEL
 */
public class Respaldo {
     private static Respaldo instancia;
    
    //Creamos el método para generar la copia
    public void crearBackup(HttpServletResponse response) throws IOException{ //puede llamarse crearRespaldo()
        Process proceso = Runtime.getRuntime().exec("mysqldump -u root -XFXyef40158 bd_sicivp"); //aqui pones tu ruta de Mysql , usuario y password
        InputStream entrada = proceso.getInputStream();
        ServletOutputStream archivo = response.getOutputStream();
        
        byte[] buffer = new byte[1000]; 
        int byteLeido = entrada.read(buffer);
        
        while(byteLeido > 0){
            archivo.write(buffer,0, byteLeido);
            byteLeido = entrada.read(buffer);
        }
        
        archivo.close();
    }
    
    
    public static Respaldo getInstance(){
        if(instancia == null){
            instancia = new Respaldo();
        }
        return instancia;
    }
}
