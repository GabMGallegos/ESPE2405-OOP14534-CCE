/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.SystemForBakery.view;

import ec.edu.espe.SystemForBakery.model.Supplier;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author CODE_CRAFTING_ENGINEERS
 */
public class SupplierMenu {
    Scanner scanner = new Scanner(System.in);
    public void displaySupplierMenu(){
        List<Supplier> suppliers = new ArrayList<>();
        int option = 0;
        Supplier supplier = new Supplier();
        while (true){
            try{
                System.out.println("--------Option ----------");
            System.out.println("1. Nuevo Provedor");
            System.out.println("2. Borrar Provedor");
            System.out.println("3. Buscar Provedor");
            System.out.println("4. Ver Provedores");
            System.out.println("5. Volver al Menu Principal");
            System.out.print("Ingrese la opción que desea visualizar: ");
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine();
             switch (option) {
                    case 1:
                        supplier.manageSuppliers(scanner, suppliers);
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        supplier.viewSuppliers("supplier.json");
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Opción inválida, ingrese de nuevo: ");
                        break;
                }
            } else {
                String input = scanner.nextLine();
                System.out.println("Error: La entrada '" + input + "' no es un número válido.");
            }
        }catch (InputMismatchException e) {
            System.out.println("Error: La entrada debe ser un número válido.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    }
}
