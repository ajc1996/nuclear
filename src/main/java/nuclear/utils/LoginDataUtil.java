package nuclear.utils;

import java.util.HashMap;
import java.util.Map;

public class LoginDataUtil {

    private static Map<Integer, String> sessionIDMap = new HashMap<Integer, String>();

    public static Map<Integer, String> getSessionIDMap() {
        return sessionIDMap;
}

    public static void setSessionIDMap(Map<Integer, String> sessionIDMap) {
        LoginDataUtil.sessionIDMap = sessionIDMap;
}

}
