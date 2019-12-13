package Project92.Project92;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
@SuppressWarnings("restriction")
public class LineChartGraph extends Application {
	public static Avaliacao_Ferramentas Avaliacao_Ferramentas = new Avaliacao_Ferramentas();
	
    @Override public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
             
        
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Long-Method.xlsx");
                                
        XYChart.Series series = new XYChart.Series();
        series.setName("");
        
        series.getData().add(new XYChart.Data("DCI PMD", Avaliacao_Ferramentas.dci("PMD")));
        series.getData().add(new XYChart.Data("DCI iPlasma", Avaliacao_Ferramentas.dci("iPlasma")));
        series.getData().add(new XYChart.Data("DII PMD", Avaliacao_Ferramentas.dii("PMD")));
        series.getData().add(new XYChart.Data("DII iPlasma", Avaliacao_Ferramentas.dii("iPlasma")));
        series.getData().add(new XYChart.Data("ADCI PMD", Avaliacao_Ferramentas.adci("PMD")));
        series.getData().add(new XYChart.Data("ADCI iPlasma", Avaliacao_Ferramentas.adci("iPlasma")));
        series.getData().add(new XYChart.Data("ADII PMD", Avaliacao_Ferramentas.adii("PMD")));
        series.getData().add(new XYChart.Data("ADII iPlasma", Avaliacao_Ferramentas.adii("iPlasma")));
        
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
       
        stage.setScene(scene);
        stage.show();
    }
 
    public static void display(String[] args) {
        launch(args);
    }
}

