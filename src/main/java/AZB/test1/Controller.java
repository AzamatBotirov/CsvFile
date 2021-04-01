package AZB.test1;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

@RestController
public class Controller {
    @GetMapping
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");

        Customer customer = new Customer();
        customer.setId("885.1");
        customer.setName("dsds");
        customer.setDoc_date(ZonedDateTime.now());


        String[] csvHeader = {" ID", "Name", "doc_date" };
        String[] mapHeader = {"id", "name", "doc_date" };

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=doc_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);


        try {
            ICsvBeanWriter csvWriter = new CsvBeanWriter(new FileWriter("exaple.csv"), CsvPreference.STANDARD_PREFERENCE);
            csvWriter.writeHeader(csvHeader);
            csvWriter.write(customer, mapHeader);
            csvWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
