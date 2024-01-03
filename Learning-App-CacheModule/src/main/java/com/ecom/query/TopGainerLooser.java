package com.ecom.query;

public class TopGainerLooser {

    public static final String TOP_GAINER ="""
            
          [
                        
                        {
                          $project: {
                            symbol: 1,
                        
                            percentageChange: {
                              $divide: [
                                { $subtract: ["$open", "$LTP"] },
                                { $cond: { if: { $eq: ["$open", 0] }, then: 1, else: "$open" } }
                              ]
                            }
                          }
                        },
                       
                        {
                          $group: {
                            _id: "$symbol",
                            topGainer: { $max: { percentageChange: "$percentageChange"} }
                          
                          }
                        },
                        
                        {
                          $project: {
                            _id: 0,
                            symbol: "$_id",
                            topGainer: { percentageChange: "$topGainer.percentageChange" }
                      
                          }
                        }
                      ]  
            
""";
}
