package nominas.control;

import java.util.List;
import nominas.entity.Puesto;
import nominas.util.HibernateUtil;

public class PuestoController {

    public PuestoController() {
    }
    
    public List<Puesto> getAllPuestos(){
        String hql = "From Puesto";
        return HibernateUtil.executeHQLQuery(hql);
    }
}
