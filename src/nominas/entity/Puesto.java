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
}
