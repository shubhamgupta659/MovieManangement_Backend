package com.vmo.backendservices.utility;

import com.vmo.backendservices.persistance.Domain.EmployeeDetails;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {

    public static ByteArrayInputStream tutorialsToCSV(List<EmployeeDetails> employeeDetails) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format)) {
            for (EmployeeDetails details : employeeDetails) {
                List<String> data = Arrays.asList(
                        String.valueOf(details.getEmployeeId()),
                        details.getFullName(),
                        details.getEmail(),
                        details.getMobile(),
                        details.getCity(),
                        String.valueOf(details.isPermanent()),
                        String.valueOf(details.getHireDate()),
                        String.valueOf(details.getDepartment())
                );

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}