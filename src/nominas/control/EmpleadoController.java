package nominas.control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import nominas.entity.Empleado;
import nominas.util.HibernateUtil;

public class EmpleadoController {

    public EmpleadoController() {
    }
    
    public Object saveNewEmpleado(Empleado empleado) {
        return HibernateUtil.saveObject(empleado);
    }
    
    public void updateEmpleado(Empleado empleado) {
        HibernateUtil.updateObject(empleado);
    }
    
    public void deleteEmpleado(Empleado empleado) {
        HibernateUtil.removeObject(empleado);
    }
    
    public List<Empleado> getAllEmpleados(){
        String hql = "From Empleado";
        return HibernateUtil.executeHQLQuery(hql);
    }
    
    public List<Empleado> getAllActualEmpleados(){
        String hql = "From Empleado";
        List<Empleado> list = HibernateUtil.executeHQLQuery(hql);
        List<Empleado> actuales = new ArrayList<>();
        Date today = Calendar.getInstance().getTime();
        list.stream().forEach(emp -> {
            actuales.add(emp);
            Date salida = emp.getFechaSalida();
            if(salida != null && salida.before(today)){
                actuales.remove(emp);
            }
        });
        return actuales;
    }
    
    public Empleado getOldestEmployee(){
        List<Empleado> empleados = getAllEmpleados();
        Date fecha = empleados.get(0).getFechaIngreso();
        Empleado oldest = empleados.get(0);
        for(Empleado emp : empleados) {
            if(emp.getFechaIngreso().before(fecha))
                oldest = emp;
        }
        return oldest;
    }
}
