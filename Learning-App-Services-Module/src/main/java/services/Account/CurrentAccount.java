package services.Account;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("currentaccount")
public class CurrentAccount implements Account {

    @Override
    public String getJsonAccountInfo() {
        return null;
    }
}
