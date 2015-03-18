package nominas.control;

import java.util.Calendar;
import java.util.List;
import nominas.entity.Deduccion;
import nominas.entity.Departamento;
import nominas.entity.Empleado;
import nominas.entity.ListaNomina;
import nominas.entity.Percepcion;
import nominas.util.Fecha;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class StatController {

    public StatController() {
    }
    
    public ChartPanel getGeneralStatGraphic() {
        //Grafico de area por fecha, del gasto total de salarios
        List<Empleado> empleados = new EmpleadoController().getAllEmpleados();
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        
        double sumaSalarios;
        double sumaDeducciones;
        double sumaPercepciones;
        Calendar today = Calendar.getInstance();
        Calendar oneYearAgo = Calendar.getInstance();
        oneYearAgo.set(Calendar.YEAR, oneYearAgo.get(Calendar.YEAR) - 1);
        //oneYearAgo.set(Calendar.MONTH, oneYearAgo.get(Calendar.MONTH) - 6);
        oneYearAgo.set(Calendar.DATE, 15);
        
        //Se genera un calendario que llevara el conteo
        Calendar inProcess = Calendar.getInstance();
        inProcess.setTime(oneYearAgo.getTime());
        //Mientras que esta fecha sea antes de hoy
        while(inProcess.before(today)){
            //Se reinicia el contador de salarios
            sumaSalarios = 0;
            sumaDeducciones = 0;
            sumaPercepciones = 0;
            //Recorre todos los empleados
            for(Empleado emp : empleados){
                //Si el empleado ingreso antes de la fecha procesada
                if(emp.getFechaIngreso().before(inProcess.getTime()) &&
                        //Y su fecha de salida es nula 
                        (emp.getFechaSalida() == null || 
                            //O bien es posterior
                            emp.getFechaSalida().after(inProcess.getTime()))){
                    //Se agrega su salario a la suma de esta quincena
                    sumaSalarios += emp.getSalario();
                    //Se obtienen todas las deducciones del empleado en cuestion
                    List<Deduccion> deducciones = new SalarioController().getAllDeduccionesOf(emp);
                                        
                    //Se recorren todas las deducciones
                    for(Deduccion ded : deducciones){
                        //Si la fecha de inicio es anterior a la que es procesada
                        if(ded.getFecha().before(inProcess.getTime()) &&(
                                //Y la fecha de finalizacion es nula o bien posterior
                                ded.getFin() == null || ded.getFin().after(inProcess.getTime()))){
                            //Se agrega a la suma
                            sumaDeducciones += ded.getCantidad();
                        }
                    }
                    
                    //Se obtienen todas las percepciones del empleado en cuestion
                    List<Percepcion> percepciones = new SalarioController().getAllPercepcionesOf(emp);
                                        
                    //Se recorren todas las percepciones
                    for(Percepcion per : percepciones){
                        //Si la fecha de inicio es anterior a la que es procesada
                        if(per.getFecha().before(inProcess.getTime()) &&(
                                //Y la fecha de finalizacion es nula o bien posterior
                                per.getFin() == null || per.getFin().after(inProcess.getTime()))){
                            //Se agrega a la suma
                            sumaPercepciones += per.getCantidad();
                        }
                    }
                }
            }
            //En este punto se acaba de recorrer todos los empleados para la fecha en proceso
            //Se agrega los valores al conjunto de datos
            String date = new Fecha(inProcess.getTime()).toString();
            data.addValue(sumaSalarios, "Salario Base", date);
            data.addValue(sumaPercepciones - sumaDeducciones + sumaSalarios, "Total", date);
            data.addValue(sumaDeducciones, "Deduccion", date);
            data.addValue(sumaPercepciones, "Percepcion", date);
                        
            //Datos procesados
            //Dia actual
            int actualDay = inProcess.get(Calendar.DATE);
            //Mes actual
            int actualMonth = inProcess.get(Calendar.MONTH);
            //Actual Year
            int actualYear = inProcess.get(Calendar.YEAR);
            //El ultimo dia del mes
            int maxActualDay = inProcess.getActualMaximum(Calendar.DATE);
            
            //Se avanza a la siguiente quincena a procesar
            //Si se procesa la quincena del 15 del mes
            if(actualDay == 15) {
                //La fecha a procesar es la ultima del mes
                inProcess.set(Calendar.DATE, maxActualDay);
            }
            //De lo contrario se proceso la de fin de mes
            else {
                //Y le toca a la del 15 del mes próximo
                inProcess.set(Calendar.DATE, 15);
                //Si era ultimo del year actual
                if(actualMonth == 12){
                    //Se avanza un año y se va a enero
                    inProcess.set(Calendar.YEAR, actualYear + 1);
                    inProcess.set(Calendar.MONTH, 1);
                }
                //De lo contrario solo se avanza el mes
                else {
                    inProcess.set(Calendar.MONTH, actualMonth + 1);
                }
            }
        }
        //Se crea el grafico
        JFreeChart graphic = ChartFactory.createAreaChart("Quincenas de un año", "Fecha", "Cantidad $$$", data, PlotOrientation.HORIZONTAL, true, true, true);
        //JFreeChart graphic = ChartFactory.createLineChart("Quincenas de un año", "Fecha", "Cantidad $$$", data, PlotOrientation.HORIZONTAL, true, true, true);
        //JFreeChart graphic = ChartFactory.createStackedAreaChart("Quincenas de un año", "Fecha", "Cantidad $$$", data, PlotOrientation.VERTICAL, true, true, false);
        //JFreeChart graphic = ChartFactory.createWaterfallChart("Quincenas de un año", "Fecha", "Cantidad $$$", data, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panel = new ChartPanel(graphic);
        return panel;
    }
    
    public ChartPanel getEmployeesStatGraphic() {
        List<Empleado> empleados = new EmpleadoController().getAllActualEmpleados();
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        empleados.stream().forEach((emp) -> {
            data.addValue(emp.getSalario(), "Empleados", emp.toString());
        });
        
        JFreeChart graphic = ChartFactory.createBarChart("Gasto en Salario de Empleados", "Empleados", 
                "Salario", data, PlotOrientation.VERTICAL, true, true, false);
        return new ChartPanel(graphic);
    }
    
    public ChartPanel getEmployeeStatGraphic() {
        List<Empleado> empleados = new EmpleadoController().getAllActualEmpleados();
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        empleados.stream().forEach((Empleado emp) -> {
            data.addValue(emp.getSalario(), "Salario", emp.toString());
            List<Deduccion> deducciones = new SalarioController().getAllCurrentDeduccionesOf(emp);
            double suma = 0;
            for(Deduccion ded : deducciones){
                suma += ded.getCantidad();
            }
            data.addValue(suma, "Deducciones", emp.toString());
            List<Percepcion> percepciones = new SalarioController().getAllCurrentPercepcionesOf(emp);
            suma = 0;
            suma = percepciones.stream().map((per) -> 
                    per.getCantidad()).reduce(suma, (accumulator, _item) -> {
                return accumulator + _item;
            });
            data.addValue(suma, "Percepciones", emp.toString());
        });
        
        JFreeChart graphic = ChartFactory.createBarChart("Salarios de Empleado", "Empleados", 
                "Salario", data, PlotOrientation.VERTICAL, true, true, false);
        return new ChartPanel(graphic);
    }
    
    public ChartPanel getNominaStatGraphic(){
        List<Empleado> empleados = new EmpleadoController().getAllEmpleados();
        List<ListaNomina> nominas = new ListaNominaController().getAllTypesOfNomina();
        int max = new ListaNominaController().getMaxID();
        double [] dinero = new double [max+1];
        
        empleados.stream().forEach(emp -> {
            int nom = emp.getNomina();
            dinero[nom] += emp.getSalario();
        });
        
        DefaultPieDataset data = new DefaultPieDataset();
        int id = 0;
        //Si existen departamentos
        if (nominas != null) {
            //Para cada departamento
            for(ListaNomina nom : nominas){
                //Si se esta gastando en salario para ese departamento
                if(dinero[nom.getId()] != 0){
                    //Se inserta en la grafica
                    data.insertValue(id, nom.toString(), dinero[nom.getId()]);
                    id++;
                }
            }
        }
        JFreeChart graphic = ChartFactory.createPieChart3D("Salarios por Nomina", 
                data, true, true, false);
        return new ChartPanel(graphic);
    }
    
    public ChartPanel getDeptoStatGraphic(){
        List<Empleado> empleados = new EmpleadoController().getAllEmpleados();
        List<Departamento> deptos = new DeptoController().getAllDepartamentos();
        int max = new DeptoController().getMaxID();
        double [] dinero = new double [max+1];
        
        empleados.stream().forEach(emp -> {
            int dep = emp.getDepartamento();
            dinero[dep] += emp.getSalario();
        });
        
        DefaultPieDataset data = new DefaultPieDataset();
        int id = 0;
        //Si existen departamentos
        if (deptos != null) {
            //Para cada departamento
            for(Departamento dep : deptos){
                //Si se esta gastando en salario para ese departamento
                if(dinero[dep.getId_dep()] != 0){
                    //Se inserta en la grafica
                    data.insertValue(id, dep.toString(), dinero[dep.getId_dep()]);
                    id++;
                }
            }
        }
        JFreeChart graphic = ChartFactory.createPieChart3D("Salarios por Departamento", 
                data, true, true, false);
        return new ChartPanel(graphic);
    }
}
