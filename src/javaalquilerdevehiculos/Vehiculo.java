/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaalquilerdevehiculos;

/**
 *
 * @author henar
 */
public abstract class Vehiculo {
    private String matricula;
    private String color;
    private String fabricante;

    public Vehiculo(String matricula, String color, String fabricante) {
        this.matricula = matricula;
        this.color = color;
        this.fabricante = fabricante;
    }
    
    public double calcularPrecioBase(int dias) {
        return 50 * dias;
    }
    
    public abstract double calcularPrecioAlquiler(int dias);
    
    @Override
    public String toString() {
        return "Matricula: " + this.matricula + "\n" + "Color: " + this.color + "\n" + "Fabricante: " + this.fabricante;
    }
}
