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
            for (int i = -1;i<employeeDetails.size();i++) {
                List<String> data = null;
                if(i == -1){
                    data = Arrays.asList(
                            "employee_id",
                            "employee_name",
                            "employee_email",
                            "employee_mobile",
                            "employee_city",
                            "is_employee_permanent",
                            "employee_hire_date",
                            "employee_department");
                }else{
                    EmployeeDetails details = employeeDetails.get(i);
                    data = Arrays.asList(
                            String.valueOf(details.getEmployeeId()),
                            details.getFullName(),
                            details.getEmail(),
                            details.getMobile(),
                            details.getCity(),
                            getIsPermanent(details.isPermanent()),
                            String.valueOf(details.getHireDate()),
                            getDepartment(details.getDepartment())
                    );
                }
                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }

    public static String getIsPermanent(boolean isPerm){
        if(isPerm)
            return "Permanent";
        else
            return "Temporary";
    }

    public static String getDepartment(int deptId){
        switch(deptId) {
            case 1:
                return "IT";
            case 2:
                return "HR";
            default:
                return "ACCOUNTS";
        }
    }
}