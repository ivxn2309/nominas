package nominas.control;

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
}
