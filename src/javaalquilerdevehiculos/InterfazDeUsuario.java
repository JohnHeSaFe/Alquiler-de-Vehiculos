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
        System.out.println("=====================\n");

        int opcion;
        while (true) {
            System.out.println("\n===========================");
            System.out.println("Menu principal Alquiler de Vehiculos");
            System.out.println("===========================");
            System.out.println("1) Nuevo vehículo");
            System.out.println("2) Mostrar flota");
            System.out.println("3) Alquilar vehículo");
            System.out.println("0) Salir programa");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            System.out.println();
            
            switch(opcion) {
                case 0 -> {
                    return;
                }
                    
                case 1 -> nuevoVehiculo();
                    
                case 2 -> mostrarFlota();
                    
                case 3 -> {
                    if (flota.isEmpty()) {
                        System.out.println("No hay ningun vehiculo en la flota");
                        continue;
                    }
                    
                    alquilarVehiculo();
                }
                    
                default -> System.out.println("Opcion no valida");
            }
        }
    }
    /**
     * Añadir vehículo a la flota
     */
    public void nuevoVehiculo(){
        String tipoVehiculo = tipoVehiculo();
        
        System.out.print("Introduce matricula: ");
        String matricula = scanner.nextLine();
        
        System.out.print("Introduce color: ");
        String color = capitalizarPalabras(scanner.nextLine());
        
        System.out.print("Introduce fabricante: ");
        String fabricante = capitalizarPalabras(scanner.nextLine());
        
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
     * Pedir escoger tipo de vehiculo
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
    
    /**
     * Mostrar todos los vehiculos
     */
    public void mostrarFlota(){
        for (int i = 0; i < flota.size(); i++) {
            System.out.println((i + 1) + ")\n" + flota.get(i));
        }
    }

    /**
     * Mostrar precio de alquiler al escoger un vehiculo y especificar dias
     */
    public void alquilarVehiculo(){
        int opcion;
        do {
            mostrarFlota();
            System.out.print("\nSeleccione un vehiculo: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");
        } while (opcion < 1 || opcion > flota.size());
        
        int dias;
        do {
            System.out.print("Introduce cantidad de dias: ");
            dias = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");
        } while (dias < 1);
        
        System.out.println("Importe del alquiler: " + (double)flota.get(opcion - 1).calcularPrecioAlquiler(dias));
    }
    
    /**
     * Capitalizar strings (1ª letra mayúscula y las demás minúscula)
     * @param input
     * @return 
     */
    public static String capitalizarPalabras(String input) {
        String[] palabras = input.split(" ");
        
        String output = "";
        for (String palabra : palabras) {
            output += palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase() + " ";
        }

        return output.trim();
    }
}
