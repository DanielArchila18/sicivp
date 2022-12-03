/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.newfashion.scvp2.facade;

import com.newfashion.scvp2.modelo.Usuario;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public interface IUsuario {
    public List<Usuario> findAll();
    public Usuario findById(String correo);
    public boolean updateUsuario(Usuario usuario);
    public boolean addUsuario(Usuario usuario);
    public boolean deleteUsuario(String correo);
    public String validarUsuario(Usuario usu);
    public List<Usuario> findByRol();
    public Usuario findByCedula(long id);
}
