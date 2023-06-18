package services.Account;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class JoinAccount implements Account {
    public JoinAccount(){}
    @Override
    public String getJsonAccountInfo() {
        return null;
    }
}
