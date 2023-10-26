
package clases;

import conexion.conexion;
import java.sql.ResultSet;
import java.util.Date;

public class cita implements interfaz {
    private String codigo_cita;
    private String nombre;
    private String vehiculo;
    private String tipoServicio;
    private String fecha;
    private String nombre_mecanico;
    private String consulta;
    private String Mensaje;
    private final conexion con;
    
    public cita() {
         con = new conexion();
    }

    public String getCodigo_cita() {
        return codigo_cita;
    }

    public void setCodigo_cita(String codigo_cita) {
        this.codigo_cita = codigo_cita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre_mecanico() {
        return nombre_mecanico;
    }

    public void setNombre_mecanico(String nombre_mecanico) {
        this.nombre_mecanico = nombre_mecanico;
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

    

    @Override
    public boolean Guardar() {
         try{
            consulta = " insert  into cita( codigo_ cita, nombre, vehiculo, tipoServicio, fecha, nombre_mecanico ) values"
                    + "('" + codigo_cita + "', '" + nombre + "', '" + vehiculo + "', '" + tipoServicio +  "', '" + fecha +"','" + nombre_mecanico +"' )";
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
            consulta = " UPDATE  into cita( codigo_ cita, nombre, vehiculo, tipoServicio, fecha, nombre_mecanico ) values"
                    + "('" + codigo_cita + "', '" + nombre + "', '" + vehiculo + "', '" + tipoServicio +  "', '" + fecha +"','" + nombre_mecanico +"'  )";
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
            rs = con.EjecutarConsulta("SELECT codigo_cita, nombre, vehiculo, tipoServicio,fecha, nombre_mecanico ");
            return rs;
        } catch (Exception x) {
            return null;
        }
    }
    
        
}
