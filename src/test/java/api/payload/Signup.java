package api.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Signup {

    private String phone;
    private String otp;
    private Boolean authenticateDevice;
    private String appsFlyerId;
    private String timezone;
    private String device;
    private String ipAddress;
    private String androidId;
    private Boolean isPhysical;
    private String appVersion;


}
