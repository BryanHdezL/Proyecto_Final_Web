/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Usuario;
import java.io.Serializable;

/**
 *
 * @author darkdestiny
 */
public class UsuarioDTO implements Serializable{
    private Usuario entidad;

    public UsuarioDTO() {
        entidad = new Usuario();
    }

    public Usuario getEntidad() {
        return entidad;
    }

    public void setEntidad(Usuario entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Clave Usuario : ").append(getEntidad().getIdUsuario()).append("\n");
        sb.append("Nombre Usuario : ").append(getEntidad().getNombreUsuario()).append("\n");
        sb.append("Telefono Usuario : ").append(getEntidad().getTelefonoUsuario()).append("\n");
        sb.append("Puesto Usuario : ").append(getEntidad().getPuestoUsuario()).append("\n");
        sb.append("Clave Categoria : ").append(getEntidad().getNombreCredencial()).append("\n");
        
        return sb.toString();
    }
    
    
    public static void main(String[] args) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.getEntidad().setIdUsuario(1);
        dto.getEntidad().setNombreUsuario("Emiliano");
        dto.getEntidad().setTelefonoUsuario("Hurtado");
        dto.getEntidad().setPuestoUsuario("Morales");
        dto.getEntidad().setNombreCredencial("EMO");
        
        
        System.out.println(dto);
    }
    
    
}
