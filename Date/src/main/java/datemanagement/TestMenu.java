/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datemanagement;

import java.util.Date;
import java.time.LocalDate;
import javax.swing.JLabel;
import lecture.Lecture;

public class TestMenu {
    private static final Lecture lecture = new Lecture();

    public static void Menu() {
        DateManagement dateManager = new DateManagement();
        
        JLabel label = new JLabel();
        
        
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Menú ===");
            System.out.println("1. Obtener fecha y hora actual");
            System.out.println("2. Obtener fecha actual (LocalDate)");
            System.out.println("3. Obtener fecha actual formateada");
            System.out.println("4. Establecer fecha formateada en JLabel");
            System.out.println("5. Elegir una fecha");
            System.out.println("6. Formatear una fecha");
            System.out.println("7. Validar una fecha ingresada");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            
            int choice = lecture.readIntPositive("");
            switch (choice) {
                case 1:
                    // Obtener fecha y hora actual
                    Date currentDate = dateManager.getCurrentDate();
                    System.out.println("Fecha y hora actual: " + currentDate);
                    break;
                case 2:
                    // Obtener fecha actual (LocalDate)
                    LocalDate localDate = dateManager.getCurrentLocalDate();
                    System.out.println("Fecha actual (LocalDate): " + localDate);
                    break;
                case 3:
                    // Obtener fecha actual formateada
                    String formattedDate = dateManager.getCurrentDateFormatted();
                    System.out.println("Fecha actual formateada: " + formattedDate);
                    break;
                case 4:
                    // Establecer fecha formateada en JLabel
                    dateManager.setFormattedDate(label);
                    System.out.println("Fecha formateada establecida en JLabel: " + label.getText());
                    break;
                case 5:
                    // Elegir una fecha
                    Date selectedDate = dateManager.chooseDate();
                    System.out.println("Fecha seleccionada: " + selectedDate);
                    break;
                case 6:
                    // Formatear una fecha
                    Date inputDate = dateManager.chooseDate();
                    String formatted = dateManager.formatDate(inputDate);
                    System.out.println("Fecha formateada: " + formatted);
                    break;
                case 7:
                    // Validar una fecha ingresada
                    Date validatedDate = dateManager.validateDateInput("Ingrese una fecha");
                    System.out.println("Fecha validada: " + validatedDate);
                    break;
                case 8:
                    // Salir
                    exit = true;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }
}
