package services.Account.Factory;

import org.springframework.beans.factory.annotation.Autowired;
import services.Account.Account;
import services.Account.CurrentAccount;
import services.Account.IndividualAccount;
import services.Account.JoinAccount;
import services.Account.Util.AccountType;

public class AccountFactory implements IAccountFactory {
    @Autowired
    IndividualAccount individualAccount;
    @Autowired
    CurrentAccount currentAccount;

    JoinAccount joinAccount;

    @Override
    public Account getAccountType(String accountType) {
  if(accountType.equalsIgnoreCase(String.valueOf(AccountType.CURRENT)))
  {
   return  this.currentAccount;
  }
  else if(accountType.equalsIgnoreCase(String.valueOf(AccountType.INDIVIDUAL)))
  {
        return this.individualAccount;
    }
  else if(accountType.equalsIgnoreCase(String.valueOf(AccountType.JOIN))) {
     return this.joinAccount;
        }
   throw new IllegalArgumentException("Illegal Argument Passed");
}
}