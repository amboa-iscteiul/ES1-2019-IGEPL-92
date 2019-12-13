package Project92.Project92;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class PieChartGraph extends Application {

	public void display(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		ObservableList<PieChart.Data> listOfData = FXCollections.observableArrayList(
				data("DCI PMD", Avaliacao_Ferramentas.dci("PMD")),
				data("DCI iPlasma", Avaliacao_Ferramentas.dci("iPlasma")),
				data("DII PMD", Avaliacao_Ferramentas.dii("PMD")),
				data("DII iPlasma", Avaliacao_Ferramentas.dii("iPlasma")),
				data("ADCI PMD", Avaliacao_Ferramentas.adci("PMD")),
				data("ADCI iPlasma", Avaliacao_Ferramentas.adci("iPlasma")),
				data("ADII PMD", Avaliacao_Ferramentas.adii("PMD")),
				data("ADII iPlasma", Avaliacao_Ferramentas.adii("iPlasma")));

		PieChart chart = new PieChart(listOfData);

		Group group = new Group(chart);
		Scene scene = new Scene(group, 500, 500);
		primaryStage.setTitle("Gráfico de Indicadores");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public PieChart.Data data(String section, int value) {
		PieChart.Data data = new PieChart.Data(section, value * 1000);
		return data;
	}
}
