package nominas.util;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
public class Fecha implements Serializable {
    private Date fecha;
    private Calendar calendar;

    public Fecha(Date fecha) {
        this.fecha = fecha;
        calendar = Calendar.getInstance();
        calendar.setTime(fecha);
    }
    
    private String translateMonth(String month) {
        if(month.equals("Jan")) return "Enero";
        if(month.equals("Feb")) return "Febrero";
        if(month.equals("Mar")) return "Marzo";
        if(month.equals("Apr")) return "Abril";
        if(month.equals("May")) return "Mayo";
        if(month.equals("Jun")) return "Junio";
        if(month.equals("Jul")) return "Julio";
        if(month.equals("Aug")) return "Agosto";
        if(month.equals("Sep")) return "Septiembre";
        if(month.equals("Oct")) return "Octubre";
        if(month.equals("Nov")) return "Noviembre";
        if(month.equals("Dec")) return "Diciembre";
        return null;
    }
    
    @Override
    public String toString() {
        StringBuilder bufer = new StringBuilder();
        bufer.append(calendar.get(Calendar.DAY_OF_MONTH));
        bufer.append(" - ");
        String mes = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US);
        bufer.append(translateMonth(mes));
        bufer.append(" - ");
        bufer.append(calendar.get(Calendar.YEAR));
        bufer.append("\n");
        return bufer.toString();
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
        calendar = Calendar.getInstance();
        calendar.setTime(fecha);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.fecha);
        hash = 71 * hash + Objects.hashCode(this.calendar);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fecha other = (Fecha) obj;
        return Objects.equals(this.fecha, other.fecha);
    }   
}
