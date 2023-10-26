/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;
 
import java.sql.ResultSet;


/**
 *
 * @author samuel
 */
public interface interfaz {
     
    public abstract boolean Guardar();
    public abstract boolean Borrar();
    public abstract boolean Actualizar();
    public abstract ResultSet verInformacion();
    
}
