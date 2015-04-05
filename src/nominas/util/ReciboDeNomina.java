package nominas.util;

import java.util.Calendar;
import java.util.List;
import nominas.control.DeptoController;
import nominas.control.PuestoController;
import nominas.control.SalarioController;
import nominas.entity.Deduccion;
import nominas.entity.Empleado;
import nominas.entity.Percepcion;

public class ReciboDeNomina {

    private final Empleado empleado;
    private final Fecha fecha;
    private String head;
    private String data1;
    private String period;
    private String data2;
    private String percepciones;
    private double sumaPer;
    private double sumaDed;
    private final double neto;
    private String deducciones;
    private String footer;
    private String isr;

    public ReciboDeNomina(Empleado empleado, Fecha fecha) {
        this.empleado = empleado;
        this.fecha = fecha;
        initHead();
        initPeriod();
        initData1();
        initData2();
        initPercep();
        initDeducc();
        neto = sumaPer - sumaDed;
        initFooter();
        initISR();
    }

    private void initHead() {
        String enterprise = "H.Ayuntamiento de Villanueva 2013 - 2016";
        String address = "Plaza Principal Num 1, Villanueva, Zacatecas";
        String rfc = "R.F.C.:  MVI650101HF1";
        String imss = "Reg. IMSS:  R091008010";
        head = enterprise + "\n" + address + "\n" + rfc + "   " + imss;
    }

    private void initPeriod() {
        //Por defecto los intervalos representan la segunda quincena del mes
        int inicio = 16;
        int fin = fecha.getCalendar().getActualMaximum(Calendar.DATE);
        //Si la fecha es de la primera quincena del mes
        if (fecha.dia < 16) {
            inicio = 1;
            fin = 15;
        }
        period = "Recibo de nomina del " + inicio + " al " + fin + " de " + fecha.mes + " de " + fecha.year;
    }

    private void initData1() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("Folio: ").append(empleado.getId_empleado()).append("\n");
        cadena.append("Nombre: ").append(empleado.toString()).append("\n");
        cadena.append("Depto: ").append(new DeptoController().getDepartamento(empleado.getDepartamento()).getNombre()).append("\n");
        cadena.append("C.U.R.P.: ").append(empleado.getCurp()).append("\n");
        cadena.append("S.B.C.: ").append("0.00").append("\n");
        cadena.append("Cotiza: ").append("Fijo").append("\n");
        cadena.append("Fecha ingr. : ").append(new Fecha(empleado.getFechaIngreso()).toString());
        cadena.append("Sdo. Día: ").append(empleado.getSalario()).append("\n");
        data1 = cadena.toString();
    }

    private void initData2() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("R.F.C.: ").append(empleado.getRfc()).append("\n");
        cadena.append("Reg. IMSS: ").append(empleado.getImss()).append("\n");
        cadena.append("Puesto: ").append(new PuestoController().getPuesto(empleado.getPuesto()).getNombre()).append("\n");
        cadena.append("Sdo. Int.: ").append("0.00").append("\n");
        cadena.append("Hrs. x Día: ").append(empleado.getHoras_dia()).append("\n");
        cadena.append("Días Trab.: ").append(empleado.getDias_jornada()).append("\n");
        cadena.append("Hrs. x Per.: ").append(empleado.getHoras_dia() * empleado.getDias_jornada()).append("\n");
        data2 = cadena.toString();
    }

    private void initPercep() {
        List<Percepcion> lista = new SalarioController().getPercepcionesOf(empleado, fecha);
        Percepcion salario = new Percepcion(0, "Salario", 0, empleado.getSalario(), null, null);
        
        StringBuilder cadena = new StringBuilder();
        sumaPer = salario.getCantidad();
        
        cadena.append(salario.toString()).append("\n");
        
        if (lista != null) {
            lista.stream().forEach((per) -> {
                sumaPer += per.getCantidad();
                cadena.append(per.toString()).append("\n");
            });
        }
        percepciones = cadena.toString()+"\n";
    }

    private void initDeducc() {
        sumaDed = 0;
        List<Deduccion> lista = new SalarioController().getDeduccionesOf(empleado, fecha);
        StringBuilder cadena = new StringBuilder();
        if (lista != null) 
            lista.stream().forEach((ded) -> {
                sumaDed += ded.getCantidad();
                cadena.append(ded.toString()).append("\n");
            });
        deducciones = cadena.toString()+"\n";
    }

    private void initFooter() {
        StringBuilder cadena = new StringBuilder();
          cadena.append("Recibi de H.Ayuntamiento de Villanueva 2013 - 2016 el neto ")
                .append("arriba indicado por concepto de pago de la nomina del presente periodo. ")
                .append("Y estoy de acuerdo que los importes que aqui se imprimen son correctos. \n")
                .append("Fecha: ").append(fecha.toString())
                .append("                    Firma: _________________________");
        footer = cadena.toString();
    }

    private void initISR() {
        isr = "ISR antes de SUB $ " + 159.81 + ";     SUB Aplicado $ " + 160.35;
    }

    // =========================================================================
    public Empleado getEmpleado() {
        return empleado;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public String getHead() {
        return head;
    }

    public String getData1() {
        return data1;
    }

    public String getPeriod() {
        return period;
    }

    public String getData2() {
        return data2;
    }

    public String getPercepciones() {
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

    public String getDeducciones() {
        return deducciones;
    }

    public String getFooter() {
        return footer;
    }

    public String getIsr() {
        return isr;
    }

}
