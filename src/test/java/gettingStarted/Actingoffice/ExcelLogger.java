package gettingStarted.Actingoffice;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelLogger {

    private static final String FILE_PATH = "TestResults.xlsx";

    public static void logResult(
            String section, String scenario, String preconditions, String steps,
            String expected, String actual, String createdBy, String status, String notes
    ) {
        Workbook workbook;
        Sheet sheet;

        File file = new File(FILE_PATH);
        if (file.exists()) {
            // Load existing workbook
            try (FileInputStream fis = new FileInputStream(file)) {
                workbook = new XSSFWorkbook(fis);
                sheet = workbook.getSheetAt(0);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        } else {
            // Create new workbook and sheet
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Test Results");

            // Create header row
            Row headerRow = sheet.createRow(0);
            String[] headers = {
                    "Section", "Scenario", "Preconditions", "Steps",
                    "Expected Results", "Actual Result", "Created by", "Status", "notes"
            };
            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }
        }

        // Write new data row
        int lastRow = sheet.getLastRowNum();
        Row newRow = sheet.createRow(lastRow + 1);

        newRow.createCell(0).setCellValue(section);
        newRow.createCell(1).setCellValue(scenario);
        newRow.createCell(2).setCellValue(preconditions);
        newRow.createCell(3).setCellValue(steps);
        newRow.createCell(4).setCellValue(expected);
        newRow.createCell(5).setCellValue(actual);
        newRow.createCell(6).setCellValue(createdBy);
        newRow.createCell(7).setCellValue(status);
        newRow.createCell(8).setCellValue(notes);

        // Save workbook
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
            workbook.write(fos);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}