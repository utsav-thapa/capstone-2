import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptsFileManager {

    public void saveReceipt(Order order){
        LocalDateTime rightNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String now = rightNow.format(formatter);

        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/"+ now + ".txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(order.processOrder(order));

            bufferedWriter.close();

            System.out.println("Order Saved at " + now +".txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
