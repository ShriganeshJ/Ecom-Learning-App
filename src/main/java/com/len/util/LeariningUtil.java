package com.len.util;

import java.util.HashMap;
import java.util.List;

public class LeariningUtil {
    private static LearingDAO dao;
   private static HashMap<String,String> cacheMap;

    public static List<LearingDAO> getLearingDetails()
    {
        cacheMap = new HashMap<>();
        dao = new LearingDAO();
        //set value to learing dao
        cacheMap.put("sk8796","{}");
        dao.setCache(cacheMap);
        dao.setId(7172);
        dao.setUser("aa7172");
        return List.of(dao);
    }

}
