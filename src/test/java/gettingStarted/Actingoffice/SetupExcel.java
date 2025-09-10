package gettingStarted.Actingoffice;
import java.io.IOException;

public class SetupExcel {
    public static void main(String[] args) {
        try {
            Excelcreator.createExcelWithHeaders("Test_Results.xlsx");
            System.out.println("Excel file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
