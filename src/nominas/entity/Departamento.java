package nominas.entity;

import java.io.Serializable;
import java.util.Objects;

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
        final Departamento other = (Departamento) obj;
        if (this.id_dep != other.id_dep) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
