package Project92.Project92;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * 
 * @author ES1-2019-IGEPL-92
 *
 */
 
@SuppressWarnings("restriction")
public class BarChartGraph extends Application {
	public static Avaliacao_Ferramentas Avaliacao_Ferramentas = new Avaliacao_Ferramentas();
 
    @Override public void start(Stage stage) {
        stage.setTitle("Bar Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Long-Method.xlsx");
        xAxis.setLabel("Ferramenta");       
        yAxis.setLabel("Value");
 
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("");   
        series1.getData().add(new XYChart.Data("DCI PMD", Avaliacao_Ferramentas.dci("PMD")));
        series1.getData().add(new XYChart.Data("DCI iPlasma", Avaliacao_Ferramentas.dci("iPlasma")));
        series1.getData().add(new XYChart.Data("DII PMD", Avaliacao_Ferramentas.dii("PMD")));
        series1.getData().add(new XYChart.Data("DII iPlasma", Avaliacao_Ferramentas.dii("iPlasma")));
        series1.getData().add(new XYChart.Data("ADCI PMD", Avaliacao_Ferramentas.adci("PMD")));
        series1.getData().add(new XYChart.Data("ADCI iPlasma", Avaliacao_Ferramentas.adci("iPlasma")));
        series1.getData().add(new XYChart.Data("ADII PMD", Avaliacao_Ferramentas.adii("PMD")));
        series1.getData().add(new XYChart.Data("ADII iPlasma", Avaliacao_Ferramentas.adii("iPlasma")));     
        
       
        Scene scene  = new Scene(bc,300,300);
        bc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void display(String[] args) {
        launch(args);
    }
}