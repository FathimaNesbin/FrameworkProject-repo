package api.utils;

import api.enumClass.signup;
import api.payload.Signup;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;

public class DataProviders {

    @DataProvider(name = "signup")
    public Object[][] provideSignupData() throws IOException{

        Signup signupPayload = Signup.builder()
                .phone(signup.USER_SIGNUP.getPhone())
                .otp(signup.USER_SIGNUP.getOtp())
                .authenticateDevice(signup.USER_SIGNUP.getAuthenticateDevice())
                .isPhysical(signup.USER_SIGNUP.getIsPhysical())
                .appVersion(signup.USER_SIGNUP.getAppVersion())
                .build();
        return new Object[][]{{signupPayload}};

    }



    @DataProvider(name = "excelData")
    public static Object[][] getExcelData() {
        String filePath = "path/to/your/excel/file.xlsx";
        String sheetName = "Sheet1";

        try {
            ExcelUtility excelUtils = new ExcelUtility(filePath, sheetName);

            // Read data from Excel
            List<List<String>> data = excelUtils.readData();

            // Convert the data into an Object array
            Object[][] dataArray = new Object[data.size()][];
            for (int i = 0; i < data.size(); i++) {
                List<String> rowData = data.get(i);
                dataArray[i] = rowData.toArray();
            }

            return dataArray;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
