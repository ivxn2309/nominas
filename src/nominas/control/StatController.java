package nominas.control;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class StatController {

    public StatController() {
    }
    
    public ChartPanel getGeneralStatGraphic() {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        data.addValue(5.2, "Nomina", "Pepe");
        data.addValue(7.0, "Nomina", "Jorge");
        data.addValue(3.1, "Nomina", "Juan");
        data.addValue(9.5, "Nomina", "Ivan");
        data.addValue(5.8, "Nomina", "Lupe");
        JFreeChart graphic = ChartFactory.createBarChart("Prueba", "Empleados", "Paga", data, 
                PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panel = new ChartPanel(graphic);
        return panel;
    }
}
