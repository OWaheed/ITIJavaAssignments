import joinery.DataFrame;
import tech.tablesaw.api.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DataSet {

        Table titanicData;
        String PATH = "src/main/resources/titanic.csv";

        public static void main(String[] args){
            Tablesaw tablesaw = new Tablesaw();

            try {
                tablesaw.titanicData = tablesaw.loadDataFromCVS(tablesaw.PATH);

                // Get the structure of data
                System.out.println("Structure of Data");
                String structure = tablesaw.getDataInfoStructure(tablesaw.titanicData);
                System.out.println(structure);

                System.out.println("\n");

                // Get summary of data
                System.out.println("Summary of Data");
                String summary = tablesaw.getDataSummary(tablesaw.titanicData);
                System.out.println(summary);

                System.out.println("\n");

                //Add new random numbers column
                System.out.println("Adding new Random Numbers column");
                Table dataWithRandomNumbers = tablesaw.addRandomNumbersColumnToData(tablesaw.titanicData);
                System.out.println(dataWithRandomNumbers.structure());

                System.out.println("\n");

                System.out.println("Mapping Sex column from String to Double");
                Table mappedData = tablesaw.mapTextColumnToNumber (tablesaw.titanicData);
                System.out.println(mappedData.structure());

                System.out.println("\n");

                // Join tables on "name"
                System.out.println("Inner Joining tables");
                Table survived = tablesaw.titanicData.copy().retainColumns("pclass", "name", "survived");
                Table person = tablesaw.titanicData.copy().retainColumns("name", "age", "sex");

                Table survivedPerson = survived.joinOn("name").inner(person);
                System.out.println(survivedPerson.structure());
                System.out.println(survivedPerson.summary());

                System.out.println("\n");


            } catch (IOException ioException){
                ioException.printStackTrace();
            }
        }

        // Load data from SCV file.
        public Table loadDataFromCVS(String path) throws IOException {
            Table titanicData = Table.read ().csv (path);
            return titanicData;
        }

        // Get the structure of data
        public String getDataInfoStructure(Table data){
            Table dataStructure= data.structure();
            return dataStructure.toString();
        }

        // Get summary of data
        public String getDataSummary(Table data){
            Table summary = data.summary();
            return summary.toString();
        }

        // Adding Random Numbers column to data
        public  Table addRandomNumbersColumnToData(Table data){
            int rowCount = data.rowCount();
            int [] randomNumbers = new int[rowCount];
            for (int i=0; i<rowCount; i++)
                randomNumbers[i] = new Random().nextInt(1000);
            data.insertColumn(data.columnCount(), IntColumn.create("Fake Random Numbers", randomNumbers));
            return data;
        }

        // Mapping a text column to a numeric valued column
        public Table mapTextColumnToNumber(Table data) {
            NumberColumn mappedGenderColumn = null;
            StringColumn gender = (StringColumn) data.column ("Sex");
            List<Number> mappedGenderValues = new ArrayList<Number>();
            for (String v : gender) {
                if ((v != null) && (v.equals ("female"))) {
                    mappedGenderValues.add (Double.valueOf(1));
                } else {
                    mappedGenderValues.add (Double.valueOf(0));
                }
            }
            mappedGenderColumn = DoubleColumn.create ("gender", mappedGenderValues);
            data.addColumns (mappedGenderColumn);
            return data;
        }
}
