package nominas.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Deduccion implements Serializable {
    private int id_deduccion;
    private String nombre;
    private int empleado;
    private double cantidad;
    private Date fecha;
    private Date fin;

    public Deduccion() {
    }

    public Deduccion(int id_deduccion, String nombre, int empleado, double cantidad, Date fecha, Date fin) {
        this.id_deduccion = id_deduccion;
        this.nombre = nombre;
        this.empleado = empleado;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.fin = fin;
    }
    
    public int getId_deduccion() {
        return id_deduccion;
    }

    public void setId_deduccion(int id_deduccion) {
        this.id_deduccion = id_deduccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }
        
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_deduccion;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + this.empleado;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.cantidad) ^ (Double.doubleToLongBits(this.cantidad) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.fecha);
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
        final Deduccion other = (Deduccion) obj;
        if (this.id_deduccion != other.id_deduccion) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (this.empleado != other.empleado) {
            return false;
        }
        if (Double.doubleToLongBits(this.cantidad) != Double.doubleToLongBits(other.cantidad)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.fin, other.fin)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre + "  [ $" + cantidad + " ]";
    }
    
    
}
