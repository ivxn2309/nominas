package nominas.control;

import java.util.List;
import nominas.entity.ListaNomina;
import nominas.util.HibernateUtil;

public class ListaNominaController {

    public ListaNominaController() {
    }
    
    public List<ListaNomina> getAllTypesOfNomina(){
        String hql = "From ListaNomina";
        return HibernateUtil.executeHQLQuery(hql);
    }
}
