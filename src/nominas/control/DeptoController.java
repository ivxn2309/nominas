package nominas.control;

import java.util.List;
import nominas.entity.Departamento;
import nominas.util.HibernateUtil;

public class DeptoController {
    public DeptoController() {
    }
    
    public List<Departamento> getAllDepartamentos(){
        String hql = "From Departamento";
        return HibernateUtil.executeHQLQuery(hql);
    }
}
