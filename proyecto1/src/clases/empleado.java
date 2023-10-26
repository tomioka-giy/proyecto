
package clases;

import conexion.conexion;
import java.sql.ResultSet;

public class empleado implements interfaz{
    private String consulta;
    private String Mensaje;
    private final conexion con;
    private String nombre;
    private String apellido;
    private int numero_cel;
    private  String codigo;
    private String salario;

    public empleado() {
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

    public int getNumero_cel() {
        return numero_cel;
    }

    public void setNumero_cel(int numero_cel) {
        this.numero_cel = numero_cel;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    @Override
    public boolean Guardar() {
        try{
            consulta = " insert  into empleado(  codigo, nombre, apellido, numero_cel, salario ) values"
                    + "('" + codigo + "', '" + nombre + "', '" + apellido+ "', '"+ numero_cel+"','"+salario+ "')";
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
        con.Ejecutar(" update articulo set salario= '"+salario+"', " 
                + "nombre = '"+nombre+"' where codigo = '"+codigo+"'  ");
        return true ;
        }catch (Exception x){
        return false;}
    }

    @Override
    public boolean Actualizar() {
        try{
        con.Ejecutar(" update articulo set numero_cel = '"+numero_cel+"', " 
                + "salario = '"+salario+"' where codigo='"+codigo+"'  ");
        return true ;
        }catch (Exception x){
        return false;}
    }

    @Override
    public ResultSet verInformacion() {
                 try {
            ResultSet rs;
            rs = con.EjecutarConsulta("SELECT codigo, nombre, apellido, numero_cel, salario from empleado");
            return rs;
        } catch (Exception x) {
            return null;
        }
    }

    
}
