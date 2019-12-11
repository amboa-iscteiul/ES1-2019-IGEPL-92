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

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ObservableList<PieChart.Data> listOfData = FXCollections.observableArrayList(
				new PieChart.Data("Section 1", 2000), 
				new PieChart.Data("Section 2", 500),
				new PieChart.Data("Section 3", 100));

		PieChart chart = new PieChart(listOfData);

		Group group = new Group(chart);
		Scene scene = new Scene(group, 500, 500);
		primaryStage.setTitle("Pie Chart Example");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
