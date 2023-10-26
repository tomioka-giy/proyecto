/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import conexion.conexion;
import java.sql.ResultSet;
import java.util.Date;


/**
 *
 * @author USUARIO
 */
public class ventas implements interfaz{
    private String consulta;
    private String Mensaje;
    private int codigo_venta; // Código único generado automáticamente
    private int cantidad;
    private Date fecha_venta;
    private String nombre_cliente; 
    private int nit_cliente;
    private final conexion con;

    public ventas(){
        con = new conexion(); 
    }

    public int getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(int codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public int getNit_cliente() {
        return nit_cliente;
    }

    public void setNit_cliente(int nit_cliente) {
        this.nit_cliente = nit_cliente;
    }

    
    
    @Override
    public boolean Guardar() {
        try {
            consulta = "insert into cliente (codigo_venta, cantidad, fecha_venta, nombre_cliente, nit_cliente) values "
                    + "(" + codigo_venta + ", " + cantidad + ", '" + fecha_venta + "', '" + nombre_cliente + "', " + nit_cliente + ")";
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

    // Metodo para actualizar un registro
    @Override
    public boolean Actualizar() {
        try {
            consulta = "update cliente set "
                    + "cantidad = '" + cantidad + "', "
                    + "fecha_venta = '" + fecha_venta + "', "
                    + "nombre_cliente = '" + nombre_cliente + "', "
                    + "nit_cliente = " + nit_cliente + " "
                    + "where codigo_venta = " + codigo_venta;
            String respuesta = con.Ejecutar(consulta);
            if (respuesta.equals("")) {
                return true;
            } else {
                Mensaje = "Error la informacion no se actualizo, " + respuesta;
                return false;
            }
        } catch (Exception x) {
            Mensaje = "Error la informacion no se actualizo, " + x.toString();
            return false;
        }
    }

    // Metodo para eliminar un registro
    @Override
    public boolean Borrar() {
        try {
            consulta = "delete from cliente where codigo_venta = " + codigo_venta;
            String respuesta = con.Ejecutar(consulta);
            if (respuesta.equals("")) {
                return true;
            } else {
                Mensaje = "Error la informacion no se elimino, " + respuesta;
                return false;
            }
        } catch (Exception x) {
            Mensaje = "Error la informacion no se elimino, " + x.toString();
            return false;
        }}
    @Override
    public ResultSet verInformacion() {
     try {
        consulta = "select * from ventas";
        ResultSet rs = con.EjecutarConsulta(consulta);
        return rs;
    } catch (Exception x) {
        Mensaje = "Error al obtener la información, " + x.toString();
        return null;
    }  
    }
}
