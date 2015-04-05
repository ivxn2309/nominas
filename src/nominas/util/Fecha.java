package nominas.util;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import sun.awt.FwDispatcher;
public class Fecha implements Serializable {
    private Date fecha;
    private Calendar calendar;
    public int dia;
    public int mes;
    public int year;

    public Fecha(Date fecha) {
        this.fecha = fecha;
        calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        dia = calendar.get(Calendar.DATE);
        mes = calendar.get(Calendar.MONTH) + 1;
        year = calendar.get(Calendar.YEAR);
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
    
    public String getShortRepr(String div, boolean inv){
        if(inv) return year + div + mes + div + dia;
        return dia + div + mes + div + year;
    }

    public Fecha [] getPeriodInterval(){
        Fecha inicio = new Fecha(fecha);
        Fecha fin = new Fecha(fecha);
        if(dia < 16) {
            inicio.dia = 1;
            fin.dia = 15;
        } 
        else {
            inicio.dia = 16;
            fin.dia = calendar.getActualMaximum(Calendar.DATE);
        }            
        return new Fecha[] {inicio, fin};
    }
    
    public Calendar getCalendar() {
        return calendar;
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
