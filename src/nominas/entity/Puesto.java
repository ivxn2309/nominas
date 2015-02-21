package nominas.entity;
import java.io.Serializable;
import java.util.Objects;

public class Puesto implements Serializable{
    private int id_puesto;
    private String nombre;

    public Puesto() {
    }
    
    public Puesto(int id_puesto, String nombre) {
        this.id_puesto = id_puesto;
        this.nombre = nombre;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Puesto other = (Puesto) obj;
        if (this.id_puesto != other.id_puesto) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    
}
