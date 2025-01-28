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
    boolean esElectrica;
    
    public Bicicleta(String matricula, String color, String fabricante, boolean esElectrica) {
        super(matricula, color, fabricante);
        this.esElectrica = esElectrica;
    }

    @Override
    public double calcularPrecioAlquiler(int dias) {
        return calcularPrecioBase(dias) + (esElectrica ? 15 : 10);
    }
    
}
