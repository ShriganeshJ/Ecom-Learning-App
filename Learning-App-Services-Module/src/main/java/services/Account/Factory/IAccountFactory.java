package services.Account.Factory;

import services.Account.Account;

public interface IAccountFactory {
    abstract Account getAccountType(String accountType);
}
