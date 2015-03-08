package nominas.control;

import java.util.List;
import nominas.entity.Departamento;
import nominas.entity.Empleado;
import nominas.entity.ListaNomina;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class StatController {

    public StatController() {
    }
    
    public ChartPanel getGeneralStatGraphic() {
        //Grafico de area por fecha, del gasto total de salarios
        List<Empleado> empleados = new EmpleadoController().getAllEmpleados();
        return null;
    }
    
    public ChartPanel getEmployeesStatGraphic() {
        List<Empleado> empleados = new EmpleadoController().getAllEmpleados();
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        empleados.stream().forEach((emp) -> {
            data.addValue(emp.getSalario(), "Empleados", emp.getNombre());
        });
        
        JFreeChart graphic = ChartFactory.createBarChart("Gasto en Salario de Empleados", "Empleados", 
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
