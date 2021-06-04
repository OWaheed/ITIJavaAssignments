import joinery.DataFrame;

import java.io.IOException;
import java.util.Date;

public class joineryDemo {
    public static void main(String[] args) {
        try {
            DataFrame<Object> df= DataFrame.readCsv ("src/main/resources/titanic.csv");
            System.out.println("\ncolumns are:");
            System.out.println(df.columns());
            System.out.println("\nfirst 5 rows in data :");
            System.out.println(df.head(5));
            //df.iterrows ().forEachRemaining (System.out::println);
            System.out.println(df.groupBy(row ->row.get(3)).groupBy(row ->row.get(1))
                    .describe ());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
