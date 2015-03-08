package nominas.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Empleado implements Serializable {
    private int id_empleado;
    private String nombre;
    private String apellido;
    private String email;
    private String rfc;
    private String curp;
    private String imss;
    private int departamento;
    private int puesto;
    private Date fechaIngreso;
    private Date fechaSalida;
    private int horas_dia;
    private int dias_jornada;
    private int nomina;
    private double salario;

    public Empleado() {
    }

    public Empleado(int id_empleado, String nombre, String apellido, String email, String rfc, String curp, String imss, int departamento, int puesto, Date fechaIngreso, Date fechaSalida, int horas_dia, int dias_jornada, int nomina, double salario) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.rfc = rfc;
        this.curp = curp;
        this.imss = imss;
        this.departamento = departamento;
        this.puesto = puesto;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.horas_dia = horas_dia;
        this.dias_jornada = dias_jornada;
        this.nomina = nomina;
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
    
    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
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
    
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.id_empleado;
        hash = 73 * hash + Objects.hashCode(this.rfc);
        hash = 73 * hash + Objects.hashCode(this.curp);
        hash = 73 * hash + Objects.hashCode(this.imss);
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
        if (this.id_empleado != other.id_empleado) {
            return false;
        }
        if (!Objects.equals(this.rfc, other.rfc)) {
            return false;
        }
        if (!Objects.equals(this.curp, other.curp)) {
            return false;
        }
        if (!Objects.equals(this.imss, other.imss)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
    
    
}
