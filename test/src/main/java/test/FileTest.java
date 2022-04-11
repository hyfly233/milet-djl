package test;

import ai.djl.ndarray.NDArray;
import ai.djl.ndarray.NDManager;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {

        String path = "E:\\workspace\\data\\";
        String fileName = path + "house_tiny.csv";

        File file = new File(fileName);
        file.createNewFile();

        try (FileWriter writer = new FileWriter(fileName)) {
            // Column names
            writer.write("NumRooms,Alley,Price\n");
            // Each row represents a data example
            writer.write("NA,Pave,127500\n");
            writer.write("2,NA,106000\n");
            writer.write("4,NA,178100\n");
            writer.write("NA,NA,140000\n");

            Table data = Table.read().file(fileName);
            System.out.println(data);

            Table inputs = Table.create(data.columns());
            inputs.removeColumns("Price");
            Table outputs = data.select("Price");

            Column col = inputs.column("NumRooms");
            col.set(col.isMissing(), (int) inputs.nCol("NumRooms").mean());
            System.out.println(inputs);

            NDManager nd = NDManager.newBaseManager();
            NDArray x = nd.create(inputs.as().doubleMatrix());
            NDArray y = nd.create(outputs.as().intMatrix());
            System.out.println(x);
            System.out.println(y);
        }
    }
}
