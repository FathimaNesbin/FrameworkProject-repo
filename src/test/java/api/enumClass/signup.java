package api.enumClass;

import api.utils.NumberGeneration;
import lombok.Getter;

@Getter
public enum signup {
    USER_SIGNUP ("1234",false,"","","","","",false,"");
    private String phone = "+9198765"+ NumberGeneration.generateRandom5DigitNumber();
    private final String otp;
    private final Boolean authenticateDevice;
    private final String appsFlyerId;
    private final String timezone;
    private final String device;
    private final String ipAddress;
    private final String androidId;
    private final Boolean isPhysical;
    private final String appVersion;

    signup(String otp, Boolean authenticateDevice, String appsFlyerId, String timezone, String device, String ipAddress, String androidId, Boolean isPhysical, String appVersion) {
        this.otp = otp;
        this.authenticateDevice = authenticateDevice;
        this.appsFlyerId = appsFlyerId;
        this.timezone = timezone;
        this.device = device;
        this.ipAddress = ipAddress;
        this.androidId = androidId;
        this.isPhysical = isPhysical;
        this.appVersion = appVersion;
    }
}
