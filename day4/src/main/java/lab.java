import joinery.DataFrame;

import java.io.IOException;

public class lab {
    public static void main(String[] args) {
        //load the Titanic data set provided as a csv file
        try {
            DataFrame<Object> df= DataFrame.readCsv ("src/main/resources/titanic.csv");
            //columns are:
            System.out.println("pclass,survived,name,sex,age,sibsp,parch,ticket,fare,cabin,embarked,boat,body,home.dest");
            //values are:
            df.iterrows ().forEachRemaining (System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
