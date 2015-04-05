package nominas.control;

import java.util.List;
import nominas.entity.Deduccion;
import nominas.entity.Empleado;
import nominas.entity.Percepcion;
import nominas.util.Fecha;
import nominas.util.HibernateUtil;

public class SalarioController {

    public SalarioController() {
    }
    
    public List<Percepcion> getAllPercepcionesOf(Empleado empleado) {
        String hql = "FROM Percepcion WHERE empleado='" + 
                empleado.getId_empleado() + "'";
        return HibernateUtil.executeHQLQuery(hql);
    }
    
    public List<Deduccion> getAllDeduccionesOf(Empleado empleado) {
        String hql = "FROM Deduccion WHERE empleado='" + 
                empleado.getId_empleado() + "'";
        return HibernateUtil.executeHQLQuery(hql);
    }
    
    public List<Percepcion> getAllCurrentPercepcionesOf(Empleado empleado) {
        String hql = "FROM Percepcion WHERE empleado='" + 
                empleado.getId_empleado() + "' AND (fin IS NULL OR fin > current_date())";
        return HibernateUtil.executeHQLQuery(hql);
    }
    
    public List<Percepcion> getPercepcionesOf(Empleado empleado, Fecha fecha) {
        String start = fecha.getPeriodInterval()[0].getShortRepr("/", true);
        String end = fecha.getPeriodInterval()[1].getShortRepr("/", true);
        String hql = "FROM Percepcion WHERE empleado=" + 
                empleado.getId_empleado() + " AND fecha < '" + end + "' AND (fin IS NULL OR fin > '" + start + "')";
        return HibernateUtil.executeHQLQuery(hql);
    }
    
    public List<Deduccion> getDeduccionesOf(Empleado empleado, Fecha fecha) {
        String start = fecha.getPeriodInterval()[0].getShortRepr("/", true);
        String end = fecha.getPeriodInterval()[1].getShortRepr("/", true);
        String hql = "FROM Deduccion WHERE empleado='" + 
                empleado.getId_empleado() + "' AND fecha < '" + end + "' AND (fin IS NULL OR fin > '" + start + "')";
        return HibernateUtil.executeHQLQuery(hql);
    }
    
    public List<Deduccion> getAllCurrentDeduccionesOf(Empleado empleado) {
        String hql = "FROM Deduccion WHERE empleado='" + 
                empleado.getId_empleado() + "' AND (fin IS NULL OR fin > current_date())";
        return HibernateUtil.executeHQLQuery(hql);
    }
    
    public void savePercepcion(Percepcion percepcion){
        HibernateUtil.saveObject(percepcion);
    }
    
    public void saveDeduccion(Deduccion deduccion) {
        HibernateUtil.saveObject(deduccion);
    }
    
    public void updatePercepcion(Percepcion percepcion){
        HibernateUtil.updateObject(percepcion);
    }
    
    public void updateDeduccion(Deduccion deduccion) {
        HibernateUtil.updateObject(deduccion);
    }
    
    public void deletePercepcion(Percepcion percepcion) {
        HibernateUtil.removeObject(percepcion);
    }
    
    public void deleteAllPercepcionesOf(Empleado emp) {
        List<Percepcion> list = getAllPercepcionesOf(emp);
        list.stream().forEach((p) -> {
            deletePercepcion(p);
        });
    }
    
    public void deleteDeduccion(Deduccion deduccion) {
        HibernateUtil.removeObject(deduccion);
    }
    
    public void deleteAllDeduccionesOf(Empleado emp) {
        List<Deduccion> list = getAllDeduccionesOf(emp);
        list.stream().forEach((d) -> {
            deleteDeduccion(d);
        });
    }
}
