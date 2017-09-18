package nuclear.utils;

import java.util.HashMap;
import java.util.Map;

public class LoginDataUtil {

    private static Map<String, String> sessionIDMap = new HashMap<String, String>();

    public static Map<String, String> getSessionIDMap() {
        return sessionIDMap;
}

    public static void setSessionIDMap(Map<String, String> sessionIDMap) {
        LoginDataUtil.sessionIDMap = sessionIDMap;
}

}
