package services.Account;
import org.springframework.stereotype.Service;

@Service
public class IndividualAccount implements Account {
    public IndividualAccount(){}
    @Override
    public String getJsonAccountInfo() {
        return "{IndividualAccount}";
    }
}
