package nominas.util;

import java.util.Calendar;
import java.util.List;
import nominas.control.DeptoController;
import nominas.control.PuestoController;
import nominas.control.SalarioController;
import nominas.entity.Deduccion;
import nominas.entity.Empleado;
import nominas.entity.Percepcion;

public class ListaDeRaya {

    private final Empleado empleado;
    private final Fecha fecha;
    private String data1;
    private String data2;
    private List<Percepcion> percepciones;
    private Percepcion totalPercepciones;
    private Deduccion totalDeducciones;    
    private List<Deduccion> deducciones;
    private double sumaPer;
    private double sumaDed;
    private final double neto;

    public ListaDeRaya(Empleado empleado, Fecha fecha) {
        this.empleado = empleado;
        this.fecha = fecha;
        initData1();
        initData2();
        initPercep();
        initDeducc();
        neto = sumaPer - sumaDed;
        initTotalPercep();
        initTotalDeducc();
    }

    private void initData1() {
        StringBuilder cadena = new StringBuilder();
        cadena.append(new PuestoController().getPuesto(empleado.getPuesto()).getNombre())
                .append("         ")
                .append("R.F.C.: ").append(empleado.getRfc())
                .append("\n");
        cadena.append("Fecha Ingr: ").append(empleado.getFechaIngreso().toString())
                .append("         ")
                .append("Sal. día: ").append(empleado.getSalario())
                .append("\n");
        cadena.append("Días pagados: ").append(empleado.getDias_jornada())
                .append("         ")
                .append("Tot Hrs trab: ").append(empleado.getHoras_dia() * empleado.getDias_jornada());
        
        data1 = cadena.toString();
    }

    private void initData2() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("Afiliación IMSS: ").append(empleado.getImss())
                .append("\n");
        cadena.append("Cotiza: ").append("Fijo")
                .append("         ")
                .append("Hrs día: ").append(empleado.getHoras_dia())
                .append("\n");
        cadena.append("C.U.R.P.: ").append(empleado.getCurp());
        data2 = cadena.toString();
    }

    private void initPercep() {
        List<Percepcion> lista = new SalarioController().getPercepcionesOf(empleado, fecha);
        Percepcion salario = new Percepcion(0, "Sueldo", 0, empleado.getSalario() * empleado.getDias_jornada(), null, null);
        
        sumaPer = salario.getCantidad();        
        
        if (lista != null) {
            lista.add(0, salario);
            lista.stream().forEach((per) -> {
                sumaPer += per.getCantidad();
            });
        }
        percepciones = lista;
    }

    private void initDeducc() {
        sumaDed = 0;
        List<Deduccion> lista = new SalarioController().getDeduccionesOf(empleado, fecha);
        if (lista != null) 
            lista.stream().forEach((ded) -> {
                sumaDed += ded.getCantidad();
            });
        deducciones = lista;
    }

    // =========================================================================
    public Empleado getEmpleado() {
        return empleado;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public String getData1() {
        return data1;
    }

    public String getData2() {
        return data2;
    }

    public List<Percepcion> getPercepciones() {
        return percepciones;
    }

    public double getSumaPer() {
        return sumaPer;
    }

    public double getSumaDed() {
        return sumaDed;
    }

    public double getNeto() {
        return neto;
    }

    public List<Deduccion> getDeducciones() {
        return deducciones;
    }

    public Percepcion getTotalPercepciones() {
        return totalPercepciones;
    }

    public Deduccion getTotalDeducciones() {
        return totalDeducciones;
    }

    private void initTotalPercep() {
        totalPercepciones = new Percepcion();
        totalPercepciones.setNombre("Total");
        totalPercepciones.setCantidad(sumaPer);
    }

    private void initTotalDeducc() {
        totalDeducciones = new Deduccion();
        totalDeducciones.setNombre("Total");
        totalDeducciones.setCantidad(sumaDed);
    }

}
