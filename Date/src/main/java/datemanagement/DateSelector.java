/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datemanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import com.toedter.calendar.JDateChooser;    //Libreria necesaria: JCalendar 1.4: https://toedter.com/jcalendar/ 

/**
 *
 * @author Andrés
 */

public class DateSelector extends JFrame {
    private JDialog dialog;
    private JDateChooser datePicker;
    private JButton btnAceptar;
    private Date selectedDate;

    public DateSelector(Frame parent) {
        dialog = new JDialog(parent, "Seleccionar Fecha", true);
        dialog.setLayout(new BorderLayout()); // Cambiamos el diseño del diálogo a BorderLayout

        // Panel para contener el JDateChooser
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centramos el panel
        datePicker = new JDateChooser();
        panelCentral.add(datePicker);
        dialog.add(panelCentral, BorderLayout.CENTER);

        // Panel para contener el botón
        JPanel panelBoton = new JPanel();
        panelBoton.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centramos el botón
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedDate = datePicker.getDate();
                dialog.dispose(); // Cerramos el diálogo al aceptar
            }
        });
        panelBoton.add(btnAceptar);
        dialog.add(panelBoton, BorderLayout.SOUTH);

        dialog.setSize(300, 200); // Ajustamos el tamaño del diálogo
        dialog.setLocationRelativeTo(parent); // Centramos la ventana en relación al padre
    }

    public Date selectDate() {
        dialog.setVisible(true); // Mostramos el diálogo
        return selectedDate; // Retornamos la fecha seleccionada
    }
}