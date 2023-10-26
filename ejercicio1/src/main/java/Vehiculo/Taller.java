/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculo;

/**
 *
 * @author Daniel Xocol
 */
public class Taller {
    public static void main(String[] args) {
        Vehículo vehículo1 = new Vehículo("Toyota", "Corolla", 2022, "Blanco", 25000.0);
        Vehículo vehículo2 = new Vehículo("Honda", "Civic", 2021, "Gris", 22000.0);
        Vehículo vehículo3 = new Vehículo("Ford", "Focus", 2020, "Negro", 20000.0);
        Vehículo vehículo4 = new Vehículo("Chevrolet", "Cruze", 2022, "Rojo", 23000.0);
        Vehículo vehículo5 = new Vehículo("Nissan", "Sentra", 2022, "Azul", 24000.0);

        vehículo1.mostrarDetalles();
        System.out.println();
        vehículo2.mostrarDetalles();
        System.out.println();
        vehículo3.mostrarDetalles();
        System.out.println();
        vehículo4.mostrarDetalles();
        System.out.println();
        vehículo5.mostrarDetalles();
    }
}
