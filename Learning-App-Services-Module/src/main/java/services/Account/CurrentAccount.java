package services.Account;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.dao.account.CurrentAccountDAO;
import org.dao.tx.AccountStaement;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import services.Util.ServiceUtil;

import java.util.logging.Logger;

@Service
public class CurrentAccount implements Account {
public CurrentAccount(){}
    @Override
    public String getJsonAccountInfo()  {
        CurrentAccountDAO currentAccountDAO = new CurrentAccountDAO();
        currentAccountDAO.setAccountStatement(new AccountStaement());
        currentAccountDAO.setCcBalance(12.3);
        currentAccountDAO.setApprovedAccAmount(50000);

        try {
            return ServiceUtil.getJsonObject(currentAccountDAO);
        } catch (JsonProcessingException e) {
            e.getMessage();
            return "{}";
        }
    }
}
