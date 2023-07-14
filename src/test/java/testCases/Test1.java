//package testCases;
//
//
//
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import static api.helpers.APIHelper.getRequest;
//import static api.helpers.APIHelper.postRequest;
//import static api.utils.NumberGeneration.generateRandom5DigitNumber;
//
//
//public class Test1 {
//    String numString;
//    String token;
//    String id;
//
//    @Test (priority =1)
//    public void gettingToken()  {
//       int n = generateRandom5DigitNumber();
//        numString = "+9198765"+n;
//      token =  postRequest("USER_SIGN_UP",null,numString,null);
//        System.out.println("This is the token:"+token);
//    }
//    @Test(priority =2)
//   public void gettingMerchant()  {
//      id= getRequest("MERCHANT_DETAILS",token);
//        System.out.println("This is the merchant id :"+id);
//   }
//
//    @Test(priority =3)
//    public void onboardingMerchant()  {
//       String message =  postRequest("MERCHANT_ONBOARDING",token, id,numString);
//        System.out.println("THis is the message:"+message);
//    }
//}
