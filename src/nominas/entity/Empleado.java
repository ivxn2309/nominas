package nominas.entity;

import java.util.Date;
import java.util.Objects;

public class Empleado {
    private int id_empleado;
    private String nombre;
    private String apellido;
    private String email;
    private String rfc;
    private String imss;
    private int departamento;
    private int puesto;
    private Date fecha_ingeso;
    private int horas_dia;
    private int dias_jornada;
    private int nomina;
    private int salario;

    public Empleado() {
    }

    public Empleado(int id_empleado, String nombre, String apellido, String email, String rfc, String imss, int departamento, int puesto, Date fecha_ingeso, int horas_dia, int dias_jornada, int nomina, int salario) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.rfc = rfc;
        this.imss = imss;
        this.departamento = departamento;
        this.puesto = puesto;
        this.fecha_ingeso = fecha_ingeso;
        this.horas_dia = horas_dia;
        this.dias_jornada = dias_jornada;
        this.nomina = nomina;
        this.salario = salario;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }    

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getImss() {
        return imss;
    }

    public void setImss(String imss) {
        this.imss = imss;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public Date getFecha_ingeso() {
        return fecha_ingeso;
    }

    public void setFecha_ingeso(Date fecha_ingeso) {
        this.fecha_ingeso = fecha_ingeso;
    }

    public int getHoras_dia() {
        return horas_dia;
    }

    public void setHoras_dia(int horas_dia) {
        this.horas_dia = horas_dia;
    }

    public int getDias_jornada() {
        return dias_jornada;
    }

    public void setDias_jornada(int dias_jornada) {
        this.dias_jornada = dias_jornada;
    }

    public int getNomina() {
        return nomina;
    }

    public void setNomina(int nomina) {
        this.nomina = nomina;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id_empleado;
        hash = 29 * hash + Objects.hashCode(this.rfc);
        hash = 29 * hash + Objects.hashCode(this.imss);
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
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.rfc, other.rfc)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
    
    
}
