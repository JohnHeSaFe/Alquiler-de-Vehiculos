/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaalquilerdevehiculos;

/**
 *
 * @author henar
 */
public class Moto extends Vehiculo{
    private int cilindrada;
    
    public Moto(String matricula, String color, String fabricante, int cilindrada) {
        super(matricula, color, fabricante);
        this.cilindrada = cilindrada;
    }

    @Override
    public double calcularPrecioAlquiler(int dias) {
        return calcularPrecioBase(dias) + cilindrada * 5 / 100;
    }
    
    @Override
    public String toString() {
        return "Tipo: Moto \n" + super.toString() + "\nCilindrada: " + this.cilindrada + " cc";
    }
}
