package com.ecom.query;

public class CurrencyData {
    public static final String GET_CURRENCY_$MATCH = """
            
            [
              { $match : { Exchange : 'BSE' } }
            ]
            
            """;
}
