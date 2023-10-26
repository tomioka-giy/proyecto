/*;
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import Conexion.conexion;
import java.sql.ResultSet;

/**
 *
 * @author alumno
 */
public class Cliente implements interfaz {

    private String consulta;
    private String Mensaje;
    private conexion con;
    private String Dpi;
    private String Nombre;
    private String Direccion;
    private String Telefono;
    private boolean Estado;

    public Cliente() {
        con = new conexion();
    }

    // <editor-fold defaultstate="collapsed" desc="Gets y Sets">
    public String getMensaje() {
        return Mensaje;
    }

    public String getDpi() {
        return Dpi;
    }

    public void setDpi(String Dpi) {
        this.Dpi = Dpi;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos">
    @Override
    public boolean Guardar() {
        try {
            consulta = "insert into cliente (Dpi, Nombre, Direccion, Telefono, Estado) values "
                    + "('" + Dpi + "', '" + Nombre + "', '" + Direccion + "', '" + Telefono + "', " + Estado + ")";
            String respuesta = con.Ejecutar(consulta);
            if (respuesta.equals("")) {
                return true;
            } else {
                Mensaje = "Error la informacion no se guardo, " + respuesta;
                return false;
            }
        } catch (Exception x) {
            Mensaje = "Error la informacion no se guardo, " + x.toString();
            return false;
        }
    }

    @Override
    public ResultSet verInformacion() {
        try {
            ResultSet rs;
            rs = con.EjecutarConsulta("SELECT dpi, nombre, direccion, telefono, estado from cliente ");
            return rs;
        } catch (Exception x) {
            return null;
        }
    }

    @Override
    public boolean Borrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // </editor-fold>

}
