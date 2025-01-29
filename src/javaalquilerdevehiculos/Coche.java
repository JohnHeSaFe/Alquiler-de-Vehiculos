/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaalquilerdevehiculos;

/**
 *
 * @author henar
 */
public class Coche extends Vehiculo{
    private int plazas;
    
    public Coche(String matricula, String color, String fabricante, int plazas) {
        super(matricula, color, fabricante);
        this.plazas = plazas;
    }
    
    @Override
    public double calcularPrecioAlquiler(int dias) {
        return calcularPrecioBase(dias) + 1.5 * plazas * dias;
    }
    
    @Override
    public String toString() {
        return "Tipo: Coche \n" + super.toString() + "\nPlazas: " + this.plazas + " plazas";
    }
}
