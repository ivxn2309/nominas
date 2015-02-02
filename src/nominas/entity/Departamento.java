package nominas.entity;

import java.io.Serializable;

public class Departamento implements Serializable {
    private int id_dep;
    private String nombre;

    public Departamento() {
    }

    public Departamento(int id_dep, String nombre) {
        this.id_dep = id_dep;
        this.nombre = nombre;
    }

    public int getId_dep() {
        return id_dep;
    }

    public void setId_dep(int id_dep) {
        this.id_dep = id_dep;
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
