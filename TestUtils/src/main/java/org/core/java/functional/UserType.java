package org.core.java.functional;

public enum UserType  {

    ADMIN("ADMIN"),
    AGENT("AGENT"),
    CLIENT("CLIENT"),
    TPA("TPA");
   public String USER;
    UserType(String USER)
    {

       this.USER=USER;

    }




}
