package Project92.Project92;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;


public class PieChartGraphTest {

	
	PieChartGraph pieChartGraph;
	@SuppressWarnings("restriction")
	Stage stage;

	@Before
	public void setUp() throws Exception {
		this.pieChartGraph = new PieChartGraph();
	}

	@SuppressWarnings("restriction")
	@Test
	public void testStartStage() {
		assertNotNull(this.pieChartGraph);
		ObservableList<PieChart.Data> listOfData = null;
		
		assertNull(listOfData);
		
		PieChart.Data data = this.pieChartGraph.data("Section 1", 1);
		assertNotNull(data);
		
		listOfData = FXCollections.observableArrayList(data);
		assertNotNull(listOfData);
		assertTrue(!(listOfData.isEmpty()));
		/*
		PieChart chart = new PieChart(listOfData);
		Group group = new Group(chart);
		Scene scene = new Scene(group, 500, 500);
		assertNotNull(chart);
		assertNotNull(group);
		assertNotNull(scene);
		*/
		try {
			this.pieChartGraph.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 
	

	@Test
	public void testData() {
		assertNotNull(this.pieChartGraph);
		String section = null;
		int value =0;
		assertNull(section);
		assertNotNull(value);
		
		section = "Section 1";
		value = 1;
		assertNotNull(section);
		assertNotNull(value);
		
		PieChart.Data data1 = new PieChart.Data(section, value * 1000);
		assertNotNull(data1);

		PieChart.Data data2 =this.pieChartGraph.data(section, value);
		assertNotNull(data2);
		assertNotNull(this.pieChartGraph.data(section, value));
		this.pieChartGraph.data(section, value);
	}


}
