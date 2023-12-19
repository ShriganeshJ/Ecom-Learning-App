package com.ecom.query;

public class AccountData {
    public static final String GET_PULSE_USER_QUERY = """
            
            [
              { $match : { platform : 'pulse' } }
            ]
            
            """;
}
