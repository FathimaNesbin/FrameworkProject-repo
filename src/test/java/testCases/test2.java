package testCases;

import api.constants.EndPoints;
import api.payload.Signup;
import config.properties;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static api.utils.NumberGeneration.generateRandom5DigitNumber;

public class test2 {

    Signup signupPayload;
//    String numString;

    @BeforeClass
    public void setupData(){
        signupPayload = new Signup();
        int n = generateRandom5DigitNumber();
        String numString = "+9198765"+n;
        signupPayload.setPhone(numString);
        signupPayload.setOtp("1234");
        signupPayload.setAuthenticateDevice(false);
        signupPayload.setIsPhysical(false);
    }

    @Test(priority=1)
    public void testUserSignup(){
        Response response = EndPoints.userSignup(signupPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        properties.token = response.jsonPath().getString("token.idToken");
    }
    @Test(priority=2)
    public void testGetMerchantDetails(){
        Response response = EndPoints.merchantDetails();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }
}
