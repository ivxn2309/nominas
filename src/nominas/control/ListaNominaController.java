package nominas.control;

import java.util.List;
import nominas.entity.ListaNomina;
import nominas.util.HibernateUtil;

public class ListaNominaController {

    public ListaNominaController() {
    }
    
    public void saveNewNomina(ListaNomina nomina){
        HibernateUtil.saveObject(nomina);
    }
    
    public void updateNomina(ListaNomina nomina){
        HibernateUtil.updateObject(nomina);
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
    
    public int getMaxID() {
        List<ListaNomina> nominas = getAllTypesOfNomina();
        int max = 0;        
        if(nominas != null)
            for(ListaNomina nom : nominas){
                int id = nom.getId();
                if (id > max) 
                    max = id;
            }        
        return max;
    }
}
