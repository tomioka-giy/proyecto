/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Heroe;

/**
 *
 * @author Daniel Xocol
 */
public class Heroe {
     // Atributos
    private String nombre;
    private double altura;
    private double peso;
    private String colorPiel;
    private int porcentajePoder;
    private String estado;

    // Constructor para crear el personaje

    /**
     *
     * @param nombre
     * @param altura
     * @param peso
     * @param colorPiel
     * @param porcentajePoder
     * @param estado
     */
    public Heroe(String nombre, double altura,double peso, String colorPiel, int porcentajePoder, String estado) {
        this.nombre = nombre;
        this.altura = altura;
        this.peso = peso;
        this.colorPiel = colorPiel;
        this.porcentajePoder = porcentajePoder;
        this.estado = "Vivo";
    }

    // Método para realizar un ataque
    public void atacar() {
        if (estado.equals("Vivo")) {
            System.out.println(nombre + " está atacando a sus enemigos.");
        } else {
            System.out.println(nombre + " no puede atacar, está " + estado);
        }
    }

    // Método para correr
    public void correr() {
        if (estado.equals("Vivo")) {
            System.out.println(nombre + " está corriendo a toda velocidad.");
        } else {
            System.out.println(nombre + " no puede correr, está " + estado);
        }
    }

    // Método para saltar
    public void saltar() {
        if (estado.equals("Vivo")) {
            System.out.println(nombre + " está saltando alto en el aire.");
        } else {
            System.out.println(nombre + " no puede saltar, está " + estado);
        }
    }

    // Método para esquivar
    public void esquivar() {
        if (estado.equals("Vivo")) {
            System.out.println(nombre + " está esquivando los ataques enemigos.");
        } else {
            System.out.println(nombre + " no puede esquivar, está " + estado);
        }
    }

    // Método para simular la muerte del personaje
    public void morir() {
        estado = "Muerto";
        System.out.println(nombre + " ha muerto en la batalla.");
    }

    // Método para obtener el estado actual del personaje
    public String obtenerEstado() {
        return estado;
    }

    public static void main(String[] args) {
        Heroe miPersonaje = new Heroe("Héroe", 1.75, 75, "Blanca", 90);
        miPersonaje.atacar();
        miPersonaje.correr();
        miPersonaje.saltar();
        miPersonaje.esquivar();
        miPersonaje.morir();
        miPersonaje.atacar();
    }
}
