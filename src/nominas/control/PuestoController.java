package nominas.control;

import java.util.List;
import nominas.entity.Puesto;
import nominas.util.HibernateUtil;

public class PuestoController {

    public PuestoController() {
    }
    
    public void saveNewPuesto(Puesto puesto){
        HibernateUtil.saveObject(puesto);
    }
    
    public void updatePuesto(Puesto puesto){
        HibernateUtil.updateObject(puesto);
    }
    
    public List<Puesto> getAllPuestos(){
        String hql = "From Puesto";
        return HibernateUtil.executeHQLQuery(hql);
    }
    
    public Puesto getPuesto(int idx){
        String hql = "FROM Puesto WHERE id_puesto='" + idx + "'";
        List<Puesto> result = HibernateUtil.executeHQLQuery(hql);
        if(result != null && result.size() > 0)
            return result.get(0);
        return null;
    }
}
