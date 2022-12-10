/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.newfashion.scvp2.facade;

import com.newfashion.scvp2.modelo.Persona;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public interface IPersona {
    public List<Persona> findAll();
    public Persona findById(long id_persona);
    public boolean editPersona(Persona persona);
    public boolean addPersona(Persona persona);
    
    
}
