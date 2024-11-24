package Vista.GestionCursosyHorarios.Horario.ModelsAdapter;

import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class TimeAdapter {
    
      private JFormattedTextField timeField;

    public TimeAdapter(JFormattedTextField timeField) {
        this.timeField = timeField;
        configureTimeField();
    }

    public TimeAdapter() {
    }
    
    

    private void configureTimeField() {
        MaskFormatter timeFormatter = null;
        try {
            timeFormatter = new MaskFormatter("##:##:##");
            timeFormatter.setPlaceholderCharacter('0');
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        DefaultFormatterFactory formatterFactory = new DefaultFormatterFactory(timeFormatter);
        timeField.setFormatterFactory(formatterFactory);
        timeField.setColumns(8);
        timeField.setValue("00:00:00");

        // Listener para validar la hora
        PropertyChangeListener listener = evt -> validateTime();
        timeField.addPropertyChangeListener("value", listener);
    }

    private void validateTime() {
        String input = timeField.getText();
        String[] parts = input.split(":");
        try {
            int hour = Integer.parseInt(parts[0]);
            if (hour < 0 || hour > 23) {
                timeField.setValue("00:00:00");
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            timeField.setValue("00:00:00");
        }
    }

    public JFormattedTextField getTimeField() {
        return timeField;
    }
    
    public LocalTime getTimeValue(String value){
        LocalTime time = null;
                try {
                    // Crear un LocalTime a partir del texto
                     time = LocalTime.parse(value, DateTimeFormatter.ofPattern("HH:mm:ss"));
                } catch (DateTimeParseException ex) {
                    System.out.println("ERROR " + ex.getMessage());
                }
         return time;
    }
    
    
}
