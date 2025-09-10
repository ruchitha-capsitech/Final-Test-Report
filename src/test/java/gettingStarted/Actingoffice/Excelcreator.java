package gettingStarted.Actingoffice;

    import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

    public class Excelcreator {

        public static void createExcelWithHeaders(String filePath) throws IOException {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("TestResults");

            Row headerRow = sheet.createRow(0);
            String[] headers = {
                    "Section", "Scenario", "Preconditions", "Steps",
                    "Expected Results", "Actual Result", "Created by", "Status","notes"
            };

            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                workbook.write(fos);
            }

            workbook.close();
        }
    }


