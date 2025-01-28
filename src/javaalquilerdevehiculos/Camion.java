/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaalquilerdevehiculos;

/**
 *
 * @author henar
 */
public class Camion extends Vehiculo{
    private int pma;
    
    public Camion(String matricula, String color, String fabricante, int pma) {
        super(matricula, color, fabricante);
        this.pma = pma;
    }

    @Override
    public double calcularPrecioAlquiler(int dias) {
        return calcularPrecioBase(dias) + 20 * pma;
    }  
}
