package testCases;

import api.constants.EndPoints;
import api.payload.Signup;
import api.utils.DataProviders;
import config.properties;
import dev.failsafe.Failsafe;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static api.utils.NumberGeneration.generateRandom5DigitNumber;


public class merchantOnboarding {
   // Signup signupPayload;
//    String numString;
    public Logger logger;
    @BeforeClass ()
    public void setup(){
//      // Signup signupPayload = Signup.builder().phone("+9198765"+generateRandom5DigitNumber().build();
//               //.authenticateDevice(false).isPhysical(false)).build();
//        signupPayload = new Signup();
//        signupPayload.setPhone("+9198765"+generateRandom5DigitNumber());
//        signupPayload.setOtp("1234");
//        signupPayload.setAuthenticateDevice(false);
//        signupPayload.setIsPhysical(false);


        //logs
        logger = LogManager.getLogger(this.getClass());

    }


    @Test(priority=1,dataProvider = "signup",dataProviderClass = DataProviders.class)
    public void testUserSignup(Signup signupPayload){

        Response response = EndPoints.userSignup(signupPayload);
        response.then().log().all();

//        Failsafe.with(retry).run(()->
//        Assert.assertEquals(response.getStatusCode(),200));
        Assert.assertEquals(response.getStatusCode(),200);

        properties.token = response.jsonPath().getString("token.idToken");
        logger.info("-----User SignUp is complete------");
    }
    @Test(priority=2)
    public void testGetMerchantDetails(){
        Response response = EndPoints.merchantDetails();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }
}
