/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller;

/**
 *
 * @author Daniel Xocol
 */
public class taller {
    private double monto;
    private boolean metTarjeta;

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setmetTarjeta(boolean metTarjeta) {
        this.metTarjeta = metTarjeta;
    }

    public double calcularImpuestos() {
        return monto * 0.12; //impuesto es el iva, lo cual es el 12%
    }

    public double calcularTotal() {
        double total = monto + calcularImpuestos();
        if (!metTarjeta) {
        } else {
            total += total * 0.05; // 5% de recargo
        }
        if (monto > 5000 && !metTarjeta) {
            total = total * 0.1; // 10% de descuento
        }
        return total;
    }
}
