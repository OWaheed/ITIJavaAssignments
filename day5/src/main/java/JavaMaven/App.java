package day5.Smile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {

    // Read json file and return a list containing TitanicPassengerObjects
    public List<TitanicPassenger> getPassengersFromJsonFile() {
        List<TitanicPassenger> allPassengers= new ArrayList<TitanicPassenger>();
        ObjectMapper objectMapper= new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try (InputStream input = new FileInputStream("src/main/resources/titanic_csv.json")) {
            //Read JSON file
            allPassengers= objectMapper.readValue(input, new TypeReference<List<TitanicPassenger>>() { });
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return allPassengers;
    }

    public void graphPassengerAges(List<TitanicPassenger> passengerList) {
        //filter to get an array of passenger ages
        List<Float> pAges = passengerList.stream().map(TitanicPassenger::getAge).limit(8).collect(Collectors.toList());
        List<String> pNames = passengerList.stream().map(TitanicPassenger::getName).limit(8).collect(Collectors.toList());
        String[] names = new String[pNames.size()];
        Float ages[] = new Float[pAges.size()];
        ages = pAges.toArray(ages);
        names = pNames.toArray(names);
        //Using XChart to graph the Ages
        // Create Chart
        CategoryChart chart = new CategoryChartBuilder().width (1024).height (768).title ("Age Histogram")
                .xAxisTitle("Names").yAxisTitle("Age").build ();
        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setStacked(true);
        // Series
        chart.addSeries("Passenger's Ages", pNames, pAges);
        // Show it
        new SwingWrapper(chart).displayChart();
    }


    public void graphPassengerClass(List<TitanicPassenger> passengerList) {
        //filter to get a map of passenger class and total number of passengers in each class
        Map<String, Long> result = passengerList.stream()
                .collect(Collectors.groupingBy(TitanicPassenger::getPclass, Collectors.counting()));
        // Create Chart
        PieChart chart = new PieChartBuilder().width(800).height(600).title("Passenger Class").build();
        // Customize Chart
        Color[] sliceColors = new Color[]{new Color(180, 68, 50), new Color(130, 105, 120), new Color(80, 143, 160)};
        chart.getStyler().setSeriesColors(sliceColors);
        // Series
        chart.addSeries("First Class", result.get("1"));
        chart.addSeries("Second Class", result.get("2"));
        chart.addSeries("Third Class", result.get("3"));
        // Show it
        new SwingWrapper(chart).displayChart();
    }

    public void graphPassengerSurvived(List<TitanicPassenger> passengerList){
        // filter to check whether passenger had survived or not
        Map<String, Long> result = passengerList.stream()
                .collect(Collectors.groupingBy(TitanicPassenger::getSurvived,Collectors.counting()));
        // Create Chart
        PieChart chart = new PieChartBuilder().width(800).height(600).title("Survived Passengers").build();
        // Customize Chart - Donut Chart
        Color[] sliceColors = new Color[]{new Color(130, 105, 120), new Color(80, 143, 160)};
        chart.getStyler().setSeriesColors(sliceColors);
        chart.getStyler().setDefaultSeriesRenderStyle(PieSeries.PieSeriesRenderStyle.Donut);
        // Series
        chart.addSeries("Survived", result.get("1"));
        chart.addSeries("Died", result.get("0"));
        // Show it
        new SwingWrapper(chart).displayChart();
    }

    public static void main( String[] args) {
        App app = new App();
        List<TitanicPassenger> titanicPassengers = app.getPassengersFromJsonFile();
        //System.out.println(titanicPassengers);

        // Histogram Chart
        app.graphPassengerAges(titanicPassengers);

        // Pie Chart
        app.graphPassengerClass(titanicPassengers);

        // Donut Chart
        app.graphPassengerSurvived(titanicPassengers);
    }
}
