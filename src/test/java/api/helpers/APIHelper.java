//package api.helpers;
//
//import api.payload.Onboarding;
//import api.payload.Signup;
//import io.restassured.RestAssured;
//import io.restassured.filter.log.LogDetail;
//import io.restassured.path.json.JsonPath;
//import io.restassured.specification.RequestSpecification;
//import io.restassured.specification.ResponseSpecification;
//import org.testng.annotations.BeforeTest;
//
//import static config.properties.*;
//
//import static api.utils.NumberGeneration.generateRandom5DigitNumber;
//import static io.restassured.RestAssured.given;
//
//public class APIHelper {
//    //all functions : GET,POST,PUT,Delete , Patch etc
//    static RequestSpecification requestSpecification;
//    static ResponseSpecification responseSpecification;
//@BeforeTest
//    public static void beforeTest() {
//        requestSpecification = given().baseUri(base_uri)
//                .header("Content-Type", content_type)
//                .header("Cookie", cookie)
//                .log().all();
//        responseSpecification = RestAssured.expect()
//                .contentType(content_type)
//                .logDetail(LogDetail.ALL);
//    }
//
//    public static String postRequest(String function,String token,String variable1,String variable2) {
//        beforeTest();
//        if (function == "USER_SIGN_UP") {
//
//            int n = generateRandom5DigitNumber();
//            Signup user = new Signup(variable1, "1234", true, null, null, null, null, null, false, null);
//            JsonPath jsonPath = given(requestSpecification)
//                    .body(user)
//                    .when()
//                    .post(user_sign_up_endpoint)
//                    .then()
//                    .spec(responseSpecification)
//                    .extract().jsonPath();
//           String  path = "token.idToken";
//            return jsonPath.getString(path);
//        }
//        else if(function == "MERCHANT_ONBOARDING"){
//            Onboarding user = new Onboarding(
//                    variable1, "Automotive", "dev", "Digital",
//                    "QA busop",  "Tester", "Test@mail.com", variable2,
//                    "1", "www.google.com",null,null,null,
//                    false,"P4",false);
//            JsonPath jsonPath = given(requestSpecification)
//                    .header("Authorization", "Bearer " + token)
//                    .body(user)
//                    .when()
//                    .post(merchant_onboarding_endpoint)
//                    .then()
//                    .extract().jsonPath();
//            String  path = "messsage";
//            return jsonPath.getString(path);
//        }
//        else {
//            return null;
//        }
//
//    }
//        public static String getRequest(String function,String token) {
//            beforeTest();
//            if (function == "MERCHANT_DETAILS") {
//
//                JsonPath jsonPath = given(requestSpecification)
//                        .header("Authorization", "Bearer " + token)
//                        .when()
//                        .get(merchant_details_endpoint)
//                        .then()
//                        .spec(responseSpecification)
//                        .extract().jsonPath();
//                String path = "merchantTeams.id";
//                return jsonPath.getString(path);
//            } else {
//                return null;
//            }
//        }
//
//
//    }

