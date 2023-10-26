/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Monedero;

/**
 *
 * @author Daniel Xocol
 */
public class Monedero {
    private double cantidad;
    
    // Constructor para inicializar la cantidad de dinero en el monedero
    public Monedero(double cantidadInicial) {
        if (cantidadInicial >= 0) {
            this.cantidad = cantidadInicial;
        } else {
            System.out.println("La cantidad inicial no puede ser negativa. Se establecerá a cero.");
            this.cantidad = 0;
        }
    }
    
    // Método para agregar dinero al monedero
    public void meterDinero(double cantidad) {
        if (cantidad > 0) {
            this.cantidad += cantidad;
            System.out.println(cantidad + " unidades de dinero han sido agregadas al monedero.");
        } else {
            System.out.println("La cantidad a agregar debe ser positiva.");
        }
    }
    
    // Método para retirar dinero del monedero
    public void sacarDinero(double cantidad) {
        if (cantidad > 0 && cantidad <= this.cantidad) {
            this.cantidad -= cantidad;
            System.out.println(cantidad + " unidades de dinero han sido retiradas del monedero.");
        } else {
            System.out.println("La cantidad a retirar debe ser positiva y no puede exceder el saldo actual.");
        }
    }
    
    // Método para consultar el saldo actual en el monedero
    public double consultarDisponible() {
        return cantidad;
    }
}
