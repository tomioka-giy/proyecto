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
public class vehiculo implements interfaz  {
    private String consulta;
    private String Mensaje;
    private final conexion con;
    private int placa;
    private String marca;
    private int numero_serie;
    private String cilindraje;
    private String nombre_cliente;
    
    public vehiculo(){
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

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(int numero_serie) {
        this.numero_serie = numero_serie;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    @Override
    public boolean Guardar() {
         try{
            consulta = " insert  into vehiculo(  placa, marca, numero_serie, cilindraje, nombre_cliente ) values"
                    + "('" + placa + "', '" + marca + "', '" + numero_serie + "', '" + cilindraje +  "', '" + nombre_cliente+"' )";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Actualizar() {
        try{
            consulta = " UPDATE  into vehiculo(  placa, marca, numero_serie, cilindraje, nombre_cliente ) values"
                    + "('" + placa + "', '" + marca + "', '" + numero_serie + "', '" + cilindraje +  "', '" + nombre_cliente+"' )";
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
    public ResultSet verInformacion() {
        try {
            ResultSet rs;
            rs = con.EjecutarConsulta("SELECT placa, marca, numero_serie, cilindraje, nombre_cliente ");
            return rs;
        } catch (Exception x) {
            return null;
        }
    }
    
    
    
}
