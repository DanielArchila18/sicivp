/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.utilities;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author luzam
 */
public class JPAUtil {
   private static final String PERSISTENCE_UNIT_NAME = "UPERSISTENCE";
   private static EntityManagerFactory factory;
   public static EntityManagerFactory getEntityManagerFactory(){
   if(factory == null){
    factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
   }
       return factory;
   
   }
   public static void shutdown(){
   if (factory != null){
   factory.close();
   }
   
   }
   
    
}
