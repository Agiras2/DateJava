/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package datemanagement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.swing.JLabel;
import java.util.Date;
import lecture.Lecture;

/**
 *
 * @author Andrés
 */

public class DateManagement {
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private final Lecture lecture = new Lecture(); // Instancia de la clase Lecture

    // Método para obtener la fecha actual como un objeto DateManagement
    public java.util.Date getCurrentDate() {
        return new java.util.Date(); // Devuelve la fecha y hora actuales
    }
    
    // Método para obtener la fecha actual como un objeto LocalDate (Java 8+)
    public LocalDate getCurrentLocalDate() {
        return LocalDate.now(); 
    }
    
    // Método para obtener la fecha actual como una cadena de texto formateada (Java 8+)
    public String getCurrentDateFormatted() {
        LocalDate currentDate = LocalDate.now(); // Obtiene la fecha actual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        return currentDate.format(formatter); // Devuelve la fecha formateada como una cadena de texto
    }
    
    public void setFormattedDate(JLabel label) {
        LocalDate currentDate = LocalDate.now(); // Obtiene la fecha actual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        label.setText(formattedDate); // Asigna la fecha formateada al JLabel
    }
    
    public Date chooseDate() {
        DateSelector selector = new DateSelector(null); // Pasamos null para indicar que no hay un Frame padre
        Date date = selector.selectDate();
        return date; // Retornamos la fecha seleccionada
    }
    
    public String formatDate(Date date) {
        if (date == null) {
            return ""; // Si la fecha es null, devolvemos una cadena vacía
        }
        // Convertimos la fecha a LocalDate para formatearla
        LocalDate localDate = date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        // Formateamos la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return localDate.format(formatter); // Devolvemos la fecha formateada como una cadena de texto
    }
    
    public Date validateDateInput(String message) {
        while (true) {
            System.out.print(message + ": ");
            String userInput = lecture.readLine(""); // Utilizando el método readLine de la clase Lecture
            try {
                // Dividir la entrada del usuario en partes
                String[] parts = userInput.split("/");
                if (parts.length != 3) {
                    throw new ParseException("Formato de fecha inválido. Intente nuevamente (dd/MM/yyyy).", 0);
                }

                // Convertir las partes a enteros
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                // Validar el día, mes y año
                if (isValidDate(day, month, year)) {
                    // Intentamos parsear la cadena de entrada a un objeto Date
                    Date parsedDate = dateFormat.parse(userInput);
                    return parsedDate;
                } else {
                    System.out.println("Fecha inválida. Intente nuevamente (dd/MM/yyyy).");
                }
            } catch (NumberFormatException | ParseException e) {
                System.out.println("Formato de fecha inválido. Intente nuevamente (dd/MM/yyyy).");
            }
        }
    }

    private boolean isValidDate(int day, int month, int year) {
        if (year < 0 || month < 1 || month > 12 || day < 1) {
            return false;
        }

        int maxDays = 31;
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            maxDays = 30;
        } else if (month == 2) {
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                maxDays = 29; // Febrero en año bisiesto
            } else {
                maxDays = 28; // Febrero en año no bisiesto
            }
        }

        return day <= maxDays;
    }
}
