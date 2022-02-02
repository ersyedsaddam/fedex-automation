package Utility;

import model.User;
import model.UserType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataInitializer {

    public static final Map<UserType, User> usersMap;

    static {
        usersMap = fetchUsers();
    }
    public static void main(String[] args) {
        System.out.println(usersMap);
    }

    private static Map<UserType, User> fetchUsers() {

        Map<UserType, User> userMap = new HashMap<>();

        try {
            File file = new File("C:\\Users\\ersye\\IdeaProjects\\Fedex\\src\\main\\resources\\FedexData.xlsx");
            FileInputStream inputstream = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(inputstream);
            XSSFSheet sheet = wb.getSheet("LoginDetails");

            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {

                XSSFRow row = sheet.getRow(rowIndex);
                String userType = row.getCell(0).getStringCellValue();
                String userName = row.getCell(1).getStringCellValue();
                String password = row.getCell(2).getStringCellValue();

                User user = new User();

                user.setUsername(userName);
                user.setPassword(password);
                userMap.put(UserType.valueOf(userType), user);
            }
        }
        catch(IOException exp) {
            exp.printStackTrace();
        }
        return userMap;
    }

    public void trackingid() throws Exception {
        File file = new File("C:\\Users\\ersye\\Downloads");
        FileInputStream inputstream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(inputstream);
        XSSFSheet sheet = wb.getSheet("TrackingId");


        XSSFRow row = null;
        XSSFCell cell = null;
        String trackId = null;


        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);

        }

        System.out.println(trackId);


    }
}
