/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parcial1;

import java.util.Scanner;
import taller.taller;

/**
 *
 * @author Daniel Xocol
 */
public class Parcial1 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        taller taller = new taller();

        System.out.print("Ingrese el monto del servicio: ");
        double monto = scanner.nextDouble();
        taller.setMonto(monto);

        System.out.print("¿El pago es en tarjeta? (t/f): ");
        boolean metTarjeta = scanner.nextBoolean();
        taller.equals(metTarjeta);

        double total = taller.calcularTotal();

        System.out.println("\nResumen del servicio:");
        System.out.println("Monto del servicio: $" + monto); 
       System.out.println("Impuestos: $" + taller.calcularImpuestos());
       
        if (metTarjeta) {
            System.out.println("Recargo por pago con tarjeta: 5%");
        }
        if (monto > 5000 && !metTarjeta) {
            System.out.println("Descuento por pago en efectivo: 10%");
        }
        System.out.println("total a paagar: $" + total);
    }
    }

