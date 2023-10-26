/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import conexion.conexion;
import java.sql.ResultSet;

/**
 *
 * @author USUARIO
 */
public class articulos implements interfaz {

    public static void setcodigo_articulo(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void setnombre(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void setprecio(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void setexistencia_total(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private String consulta;
    private String Mensaje;
    private String codigo_articulo; // Código único generado automáticamente
    private String nombre;
    private String precio;
    private int existencia_total;
    private final conexion con;

    public articulos() {
        con = new conexion();
    }
    
    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public String getCodigo_articulo() {
        return codigo_articulo;
    }

    public void setCodigo_articulo(String codigo_articulo) {
        this.codigo_articulo = codigo_articulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getExistencia_total() {
        return existencia_total;
    }

    public void setExistencia_total(int existencia_total) {
        this.existencia_total = existencia_total;
    }

    @Override
    public boolean Guardar() {
        try{
            consulta = " insert  into articulo(  codigo_articulo, nombre, precio, existencia_total ) values"
                    + "('" + codigo_articulo + "', '" + nombre + "', '" + precio + "', '" + existencia_total +  "')";
            String respuesta = con.Ejecutar(consulta);
            if (respuesta.equals("")) {
                return true;
            } else {
                Mensaje = "Error la informacion no se guardo, " + respuesta;
                return false;
            }
        } catch (Exception x){
            Mensaje = "Error la informacion no se guardo, " + x.toString();
            return false;
        }
    }

    @Override
    public boolean Borrar() {
        try{
        con.Ejecutar(" update articulo set existencia_total= '"+existencia_total+"', " 
                + "precio = '"+precio+"' where codigo_articulo = '"+codigo_articulo+"'  ");
        return true ;
        }catch (Exception x){
        return false;}
    }

    @Override
    public boolean Actualizar() {
        try{
        con.Ejecutar(" update articulo set precio = '"+precio+"', " 
                + "existencia_total = '"+existencia_total+"' where codigo_articulo = '"+codigo_articulo+"'  ");
        return true ;
        }catch (Exception x){
        return false;}
    }

    @Override
    public ResultSet verInformacion() {
        try {
            ResultSet rs;
            rs = con.EjecutarConsulta("SELECT codigo_articulo, nombre, precio, existencia_total from articulo ");
            return rs;
        } catch (Exception x) {
            return null;
        }
    }
    
    
}
