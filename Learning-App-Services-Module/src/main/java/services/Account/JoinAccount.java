package services.Account;
import org.springframework.stereotype.Service;

@Service
public class JoinAccount implements Account {
    @Override
    public String getJsonAccountInfo() {
        return "{JoinAccount}";
    }
}
