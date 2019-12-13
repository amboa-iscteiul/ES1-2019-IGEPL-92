package Project92.Project92;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import junit.framework.TestCase;

public class BarChartTest extends TestCase {
	
	BarChartGraph b;
	
	Stage s;
	public void setUp() throws Exception {
		this.b =new BarChartGraph();
	}

	@SuppressWarnings("restriction")
	public void testStart() {
		assertNotNull(this.b);
		
		CategoryAxis xAxis = null;
		assertNull(xAxis);
		
		NumberAxis yAxis = null;
		assertNull(yAxis);
		
		BarChart<String,Number> bc=null;
		assertNull(bc);
		String s=null;
		assertNull(s);
		Number n = null;
		assertNull(n);
		XYChart.Series series1 =null;
		assertNull(series1);
		
		yAxis = new NumberAxis();
		assertNotNull(yAxis);
		
		bc=new BarChart<String,Number>(xAxis,yAxis);
		assertNotNull(bc);
		
		
		
		try {
			this.b.start(new Stage());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
