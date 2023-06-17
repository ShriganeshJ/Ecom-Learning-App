package org.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import services.Account.Account;
import services.Account.Factory.IAccountFactory;


@Controller
public class WebController {
@Autowired
IAccountFactory iAccountFactory;
@GetMapping
public String getAccountInformation()
{
return iAccountFactory.getAccountType("current").getJsonAccountInfo();
}

}
