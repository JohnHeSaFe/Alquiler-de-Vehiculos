/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaalquilerdevehiculos;

/**
 *
 * @author henar
 */
public class Bicicleta extends Vehiculo{
    boolean isElectrica;
    
    public Bicicleta(String matricula, String color, String fabricante, boolean isElectrica) {
        super(matricula, color, fabricante);
        this. isElectrica = isElectrica;
    }

    @Override
    public double calcularPrecioAlquiler(int dias) {
        return calcularPrecioBase(dias) +  (this.isElectrica ? 15 : 10);
    }
    
    @Override
    public String toString() {
        return "Tipo: Camion \n" + super.toString() + "\n¿Es electrica?: " + (this.isElectrica ? "si" : "no");
    }
}
