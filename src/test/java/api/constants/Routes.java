package api.constants;

import static config.properties.base_uri;

public class Routes {

    public static final String user_sign_up = base_uri+"/v1/auth/sign-up";
    public static final String merchant_details = base_uri+"/v1/merchants/teams";
    public static final String merchant_onboarding = base_uri+"/v2/merchants/onboarding/basic-details";

}
