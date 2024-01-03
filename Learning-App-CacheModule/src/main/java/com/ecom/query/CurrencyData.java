package com.ecom.query;

public class CurrencyData {
    public static final String GET_CURRENCY_$MATCH = """
            
            [
               {$match: {"$or": [{ Exchange : 'BSE' }, { Exchange : 'NSE' }]}}
            ]
            
            """;


    public static final String GET_MaxSymbol_Trade_NSE_BSE= """
            
            [
               {$match: {"$or": [{ Exchange : 'BSE' }, { Exchange : 'NSE' },{Exchange :'DOW'},{Exchange :'NYE'}]}},
               {$group: { _id: {symbol :"$tradeInfo.symbol"},totalSymbolTrade:{$sum:1}}}
            ]
            
            """;


    //Group By Exchange and get min profit book by client
    public static final String GET_MIN_PROFIT_BOOK_Exchange= """
            
            [
               {$match: {"$or": [{ Exchange : 'BSE' }, { Exchange : 'NSE' },{Exchange :'DOW'},{Exchange :'NYE'}]}},
               {$group: { _id: {ExchangeName:"$Exchange"},minProfitBook:{$min:"$tradeInfo.takeProfit"},
                                                          maxProfitBook:{$max:"$tradeInfo.takeProfit"},
                                                          avgProfitBook:{$avg:"$tradeInfo.takeProfit"},
                                                        totalProfitBook:{$sum:"$tradeInfo.takeProfit"} }},
               {$sort:{totalProfitBook:-1}}                                       
                                                          
            ]
            
            """;

    public static final String  EXCLUDE_USERINFO= """  
           
            [
              {
                $project: {
                  
                  userInfo: 0 
                }
              }
            ]
           
            """;


    public static final String  CONDITION_AGG= """  
           
            [
              {
                $project: {
                  category: {
                    $cond: {
                      if: { $gte: ["$tradeInfo.takeProfit", 10] },
                      then: "non volatile",
                      else: "volatile"
                    }
                  }
                }
              }
            ]
           
            """;








}
