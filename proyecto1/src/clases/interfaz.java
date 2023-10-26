/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clases;

import java.sql.ResultSet;

/**
 *
 * @author USUARIO
 */
public interface interfaz {
     
    public abstract boolean Guardar();
    public abstract boolean Borrar();
    public abstract boolean Actualizar();
    public abstract ResultSet verInformacion();
    
}
