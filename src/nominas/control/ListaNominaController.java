package nominas.control;

import java.util.List;
import nominas.entity.ListaNomina;
import nominas.util.HibernateUtil;

public class ListaNominaController {

    public ListaNominaController() {
    }
    
    public List<ListaNomina> getAllTypesOfNomina(){
        String hql = "FROM ListaNomina";
        return HibernateUtil.executeHQLQuery(hql);
    }
    
    public ListaNomina getListaNomina(int idx){
        String hql = "FROM ListaNomina WHERE id='" + idx + "'";
        List<ListaNomina> result = HibernateUtil.executeHQLQuery(hql);
        if(result != null && result.size() > 0)
            return result.get(0);
        return null;
    }
}
