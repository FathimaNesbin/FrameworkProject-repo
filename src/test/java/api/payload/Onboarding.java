package api.payload;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Onboarding {

    private String teamId;
    private String profession;
    private String firstName;
    private String middleName;
    private String businessName;
    private String lastName;
    private String email;
    private String yelpNumber;
    private String numberOfEmployees;
    private String website;
    private String yelp;
    private String facebook;
    private String otherOnlineReferrence;
    private Boolean fetchYelpData;
    private String submitRoute;
    private Boolean confirmData;

}
