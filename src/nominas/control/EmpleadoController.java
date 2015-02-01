package nominas.control;

import nominas.entity.Empleado;
import nominas.util.HibernateUtil;

public class EmpleadoController {

    public EmpleadoController() {
    }
    
    public Object saveNewEmpleado(Empleado empleado) {
        return HibernateUtil.saveObject(empleado);
    }
}
