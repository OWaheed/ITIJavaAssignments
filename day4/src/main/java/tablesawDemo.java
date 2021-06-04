

import tech.tablesaw.api.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class tablesawDemo {
    Table titanicData;
    String dataPath = "src/main/resources/titanic.csv";

    public tablesawDemo() {
    }

    public static void main(String[] args) {
        tablesawDemo tda = new tablesawDemo();
        try {
            tda.titanicData = tda.loadDataFromCVS (tda.dataPath);
            //getting the Structure of the data
            String structure = tda.getDataInfoStructure (tda.titanicData);
            System.out.println (structure);
            //getting Data summery

            String summary = tda.getDataSummary (tda.titanicData);
            System.out.println (summary);

            // Adding date Column
            Table dataWithDate = tda.addDateColumnToData (tda.titanicData);
            System.out.println ("=====================================================================================");
            System.out.println (dataWithDate.structure ());

            //Sorting on the added Date Field
            Table sortedData = dataWithDate.sortAscendingOn ("Fake Date");

            //getting the first 10 rows
            System.out.println ("Printing the first rows of the table");

            Table firstTenRows = sortedData.first (50);

            System.out.println (firstTenRows);
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Table mappedData = tda.mapTextColumnToNumber (tda.titanicData);
            Table firstFiveRows = mappedData.first (5);
            System.out.println ("=====================================================================================");
            System.out.println (firstFiveRows);
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///  Load Data From CSV File
    public Table loadDataFromCVS(String path) throws IOException {
        Table titanicData = Table.read ().csv (path);
        return titanicData;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// get the structure of the data
    public String getDataInfoStructure(Table data) {
        Table dataStructure = data.structure ();
        return dataStructure.toString ();
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //get Data Summary
    public String getDataSummary(Table data) {
        Table summary = data.summary ();
        return summary.toString ();
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Adding Columns
    public Table addDateColumnToData(Table data) {
        int rowCount = data.rowCount ();
        List<LocalDate> dateList = new ArrayList<LocalDate> ();
        for (int i = 0; i < rowCount; i++) {
            dateList.add (LocalDate.of (2021, 3, i % 31 == 0 ? 1 : i % 31));
        }
        DateColumn dateColumn = DateColumn.create ("Fake Date", dateList);
        data.insertColumn (data.columnCount (), dateColumn);
        return data;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // mapping text data to numeric values on the sex field female=1,male=0 and adding a column named gender
    public Table mapTextColumnToNumber(Table data) {
        NumberColumn mappedGenderColumn = null;
        StringColumn gender = (StringColumn) data.column ("Sex");
        List<Number> mappedGenderValues = new ArrayList<Number> ();
        for (String v : gender) {
            if ((v != null) && (v.equals ("female"))) {
                mappedGenderValues.add (new Double (1));
            } else {
                mappedGenderValues.add (new Double (0));
            }
        }
        mappedGenderColumn = DoubleColumn.create ("gender", mappedGenderValues);
        data.addColumns (mappedGenderColumn);
        return data;
    }
}

