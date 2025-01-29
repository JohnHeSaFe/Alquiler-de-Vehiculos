/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaalquilerdevehiculos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author henar
 */
public class InterfazDeUsuario {
    private ArrayList<Vehiculo> flota;
    private Scanner scanner;
    
    public InterfazDeUsuario() {
        this.flota = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    
    public void empezar() {
        System.out.println("=====================");
        System.out.println("Alquiler de Vehiculos");
        System.out.println("=====================");
        System.out.println("\n");

        int opcion;
        while (true) {
            System.out.println("\n");
            System.out.println("===========================");
            System.out.println("Menu principal Alquiler de Vehiculos");
            System.out.println("===========================");
            System.out.println("1) Nuevo vehículo");
            System.out.println("2) Mostrar flota");
            System.out.println("3) Alquilar vehículo");
            System.out.println("0) Salir programa");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            System.out.println("\n");
            
            switch(opcion) {
                case 0 -> {
                    return;
                }
                    
                case 1 -> nuevoVehiculo();
                    
                case 2 -> mostrarFlota();
                    
                case 3 -> alquilarVehiculo();
                    
                default -> System.out.println("Opcion no correcta");
            }
        }
    }
    /**
     * Pedir parámetros de vehiculo, tipo de vehiculo, parámetros de tipo de vehiculo, y añadir a la flota segun el tipo
     */
    public void nuevoVehiculo(){
        String tipoVehiculo = tipoVehiculo();
        
        System.out.print("Introduce matricula: ");
        String matricula = scanner.nextLine();
        
        System.out.print("Introduce color: ");
        String color = scanner.nextLine();
        
        System.out.print("Introduce fabricante: ");
        String fabricante = scanner.nextLine();
        
        switch (tipoVehiculo) {
            case "coche" -> {
                System.out.print("Introduce plazas: ");
                int plazas = scanner.nextInt();
                scanner.nextLine();
                
                flota.add(new Coche(matricula, color, fabricante, plazas));
                System.out.println("Coche añadido");
            }
            
            case "moto" -> {
                System.out.print("Introduce cilindrada: ");
                int cilindrada = scanner.nextInt();
                scanner.nextLine();
                
                flota.add(new Moto(matricula, color, fabricante, cilindrada));
                System.out.println("Moto añadida");
            }
            
            case "camion" -> {
                System.out.print("Introduce PMA: ");
                int pma = scanner.nextInt();
                scanner.nextLine();
                
                flota.add(new Camion(matricula, color, fabricante, pma));
                System.out.println("Camión añadido");
            }
            
            case "bicicleta" -> {
                String input;
                do {
                    System.out.print("¿Es electrica? (y / n): ");
                    input = scanner.nextLine().toLowerCase();
                } while (!input.equals("y") && !input.equals("n"));
                
                flota.add(new Bicicleta(matricula, color, fabricante, input.equals("y")));
                System.out.println("Bicicleta añadida");
            }
        }
    }

    /**
     * Interfaz de pedir tipo de vehiculo
     * 
     * @return 
     */
    public String tipoVehiculo() {
        while (true) {
            System.out.println("1) Coche");
            System.out.println("2) Moto");
            System.out.println("3) Camion");
            System.out.println("4) Bicicleta");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion) {
            case 1 -> { return "coche"; }
            case 2 -> { return "moto"; }
            case 3 -> { return "camion"; }
            case 4 -> { return "bicicleta"; }
            default -> System.out.println("Opción no correcta");
            }
        }
    }
    
    public void mostrarFlota(){
        for (Object vehiculo: flota) {
            System.out.println(vehiculo + "\n");
        }
    }

    public void alquilarVehiculo(){

    }
}
