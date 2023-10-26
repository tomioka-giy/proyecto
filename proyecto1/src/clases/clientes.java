
package clases;

import conexion.conexion;
import java.sql.ResultSet;

public class clientes implements interfaz {

    private String codigo_cliente;
    private String nombre;
    private String apellido;
    private String numero_telefono;
    private String direccion;
    private String metodoPago;
    private String consulta;
    private String Mensaje;
    private final conexion con;

    public clientes(){
        con = new conexion();
    }

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
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
        try {
            consulta = "insert into cliente (nombre, apellido, numero_telefono, direccion, metodoPago) values "
                    + "('" + nombre + "', '" + apellido + "', " + numero_telefono + ", '" + direccion + "', " + metodoPago + ")";
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
    public boolean Actualizar() {
        try {
            consulta = "update cliente set "
                    + "nombre = '" + nombre + "', "
                    + "apellido = '" + apellido + "', "
                    + "numero_telefono = " + numero_telefono + ", "
                    + "direccion = '" + direccion + "', "
                    + "metodoPago = " + metodoPago + " "
                    + "where codigo_cliente = " + codigo_cliente;
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

    @Override
    public boolean Borrar() {
        try {
            consulta = "delete from cliente where codigo_cliente = " + codigo_cliente;
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
        }
    }

    @Override
    public ResultSet verInformacion() {
       try {
        consulta = "select * from cliente";
        ResultSet rs = con.EjecutarConsulta(consulta);
        return rs;
    } catch (Exception x) {
        Mensaje = "Error al obtener la información, " + x.toString();
        return null;
    }
}
}
