/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Credencial;
import java.io.Serializable;

/**
 *
 * @author darkdestiny
 */
public class CredencialDTO implements Serializable{
    private Credencial entidad;

    public CredencialDTO() {
        entidad = new Credencial();
    }

    public Credencial getEntidad() {
        return entidad;
    }

    public void setEntidad(Credencial entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre Credencial : ").append(getEntidad().getNombreCredencial()).append("\n");
        sb.append("Password Credencial : ").append(getEntidad().getPasswordCredencial()).append("\n");
        
        return sb.toString();
    }
    
    
    public static void main(String[] args) {
        CredencialDTO dto = new CredencialDTO();
        dto.getEntidad().setNombreCredencial("Emiliano");
        dto.getEntidad().setPasswordCredencial("Hurtado");
        
        System.out.println(dto);
    }
    
    
}
