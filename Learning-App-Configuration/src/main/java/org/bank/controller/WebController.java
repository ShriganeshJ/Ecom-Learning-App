package org.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import services.Account.Factory.IAccountFactory;


@Controller
public class WebController {
@Autowired
IAccountFactory iAccountFactory;
@GetMapping("/ecom/account")
@ResponseBody
public String getAccountInformation()
{
    return iAccountFactory.getAccountType("join").getJsonAccountInfo();
}

}
