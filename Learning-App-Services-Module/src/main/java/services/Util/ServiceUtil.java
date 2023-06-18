package services.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ServiceUtil {
    private  static  ObjectMapper objectMapper = new ObjectMapper();
    public static String getJsonObject(Object type) throws JsonProcessingException {
        return objectMapper.writeValueAsString(type);
    }
}
