import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// handles saving the order receipts into text files
public class ReceiptsFileManager {

    // saves the receipt of an order into a timestamped text file

    public void saveReceipt(Order order){
        LocalDateTime rightNow = LocalDateTime.now();

        // defines the format of the receipt file name

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

        // converts the current date/time into a formatted ring

        String now = rightNow.format(formatter);

        try {

            // creates a FileWriter and BufferedWriter with the file name to save into

            FileWriter fileWriter = new FileWriter("src/main/resources/Receipts"+ now + ".txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(order.processOrder(order));

            bufferedWriter.close();

            System.out.println("Order Saved at " + now +".txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
