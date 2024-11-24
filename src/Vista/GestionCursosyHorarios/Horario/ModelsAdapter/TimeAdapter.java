package Vista.GestionCursosyHorarios.Horario.ModelsAdapter;

import java.text.ParseException;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;

public class TimeAdapter extends DefaultFormatterFactory{
    
      public TimeAdapter() {
        super(new TimeFormatter()); // Establecer un formateador personalizado
    }

    // Formateador personalizado para validar y formatear la hora
    static class TimeFormatter extends DefaultFormatter {

        public TimeFormatter() {
            setOverwriteMode(true); // Sobrescribir texto en lugar de insertar
            setAllowsInvalid(false); // No permite entradas inválidas
        }

        @Override
        public Object stringToValue(String text) throws ParseException {
            if (!text.matches("\\d{1,2}:\\d{1,2}:\\d{1,2}")) {
                throw new ParseException("Formato inválido", 0);
            }

            String[] parts = text.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            int seconds = Integer.parseInt(parts[2]);

            if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59 || seconds < 0 || seconds > 59) {
                throw new ParseException("Valores fuera de rango", 0);
            }

            // Devuelve el valor como una cadena en formato HH:mm:ss
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value == null) {
                return "00:00:00";
            }

            // Asume que el valor es un String en formato HH:mm:ss
            return value.toString();
        }
    }
}
