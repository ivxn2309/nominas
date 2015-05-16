package nominas.control;

import java.util.List;
import nominas.entity.Institucion;
import nominas.util.HibernateUtil;

public class InstitucionController {
    public InstitucionController() {
    }
    
    public void updateInstitucion(Institucion institucion){
        HibernateUtil.updateObject(institucion);
    }
    
    public Institucion get() {
        String hql = "FROM Institucion";
        List<Institucion> result = HibernateUtil.executeHQLQuery(hql);
        if(result != null && result.size() > 0)
            return result.get(0);
        return null;
    }
}
