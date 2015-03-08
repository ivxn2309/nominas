package nominas.control;

import java.util.List;
import nominas.entity.Departamento;
import nominas.util.HibernateUtil;

public class DeptoController {
    public DeptoController() {
    }
    
    public void saveNewDepartamento(Departamento departamento){
        HibernateUtil.saveObject(departamento);
    }
    
    public void updateDepartamento(Departamento departamento){
        HibernateUtil.updateObject(departamento);
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
    
    public int getMaxID() {
        List<Departamento> deptos = getAllDepartamentos();
        int max = 0;        
        if(deptos != null)
            for(Departamento dep : deptos){
                int id = dep.getId_dep();
                if (id > max) 
                    max = id;
            }        
        return max;
    }
}
