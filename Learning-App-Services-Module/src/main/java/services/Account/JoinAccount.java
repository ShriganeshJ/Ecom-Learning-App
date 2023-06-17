package services.Account;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("joinaccount")
public class JoinAccount implements Account {
    @Override
    public String getJsonAccountInfo() {
        return null;
    }
}
