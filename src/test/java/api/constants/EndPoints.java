package api.constants;


import api.payload.Onboarding;
import api.payload.Signup;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static api.constants.Routes.*;
import static config.properties.content_type;
import static config.properties.token;
import static io.restassured.RestAssured.given;

//CRUD operations
public class EndPoints {

    //method created for getting data from env file
//   static ResourceBundle getData(){
//        ResourceBundle routes = ResourceBundle.getBundle("env");
//        return routes;
//
//        // in the required method, give : String env = getData.getString("environment");  ->this will return the value of environment
//    }


    public static Response userSignup(Signup payload){
        Response response = given()
                .contentType(content_type)
                .body(payload)
        .when()
                .post(user_sign_up);
        return response;
    }

    public static Response merchantDetails(){
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .contentType(content_type)
        .when()
                .get(merchant_details);
        return response;
    }

    public static Response merchantOnboarding(Onboarding payload, String id, String phNo){
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .body(payload)
                .contentType(content_type)
        .when()
                .post(merchant_onboarding);
        return response;
    }

}
