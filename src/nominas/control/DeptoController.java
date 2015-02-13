package nominas.control;

import java.util.List;
import nominas.entity.Departamento;
import nominas.util.HibernateUtil;

public class DeptoController {
    public DeptoController() {
    }
    
    public List<Departamento> getAllDepartamentos(){
        String hql = "FROM Departamento";
        return HibernateUtil.executeHQLQuery(hql);
    }
    
    public Departamento getDepartamento(int idx) {
        String hql = "FROM Departamento WHERE id_dep='" + idx + "'";
        List<Departamento> result = HibernateUtil.executeHQLQuery(hql);
        if(result != null && result.size() > 0)
            return result.get(0);
        return null;
    }
}
