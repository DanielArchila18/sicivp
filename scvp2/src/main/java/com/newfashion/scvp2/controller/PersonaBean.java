/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newfashion.scvp2.controller;

import com.newfashion.scvp2.facadeImp.PersonaImp;
import com.newfashion.scvp2.modelo.Persona;
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
public class PersonaBean {

    Persona persona = new Persona();
    List<Persona> listPersonas = new ArrayList<Persona>();
    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getListPersonas() {
        return listPersonas;
    }

    public void setListPersonas(List<Persona> listPersonas) {
        this.listPersonas = listPersonas;
    }

    public List<Persona> findAll() {
        PersonaImp personaImp = new PersonaImp();
        this.listPersonas = personaImp.findAll();
        return this.listPersonas;
    }

    public String callPersona(int id_persona) {
        Persona per = new Persona();
        PersonaImp personaImp = new PersonaImp();
        per = personaImp.findById(id_persona);
        this.sessionMap.put("Persona", per);
        return "";
    }

    public String editPersona(Persona persona) {
        PersonaImp personaImp = new PersonaImp();
        personaImp.editPersona(persona);
        return "";
    }

    public String addPersona() {
        PersonaImp personaImp = new PersonaImp();
        personaImp.addPersona(persona);
        return "";
    }

}
