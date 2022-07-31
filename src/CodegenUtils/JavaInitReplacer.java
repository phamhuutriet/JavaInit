package CodegenUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class JavaInitReplacer {

    public static String replace(String filePath, Map<String, String> parametersDict) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line = reader.readLine();
        String ans = "";

        while (line != null) {
            ans += replaceOneLine(line, parametersDict);
            ans += "\n";
            line = reader.readLine();
        }

        reader.close();

        return ans;
    }

    public static String replaceOneLine(String line, Map<String, String> parametersDict) {
        String ans = line;

        for (Map.Entry<String, String> entry : parametersDict.entrySet()) {
            String parameter = entry.getKey();
            String realValue = entry.getValue();
            ans = replaceOneParemeterPerLine(ans, parameter, realValue);
        }

        return ans;
    }

    public static String replaceOneParemeterPerLine(String line, String parameter, String realValue) {
        Set<Integer> parameterLocations = findParameterLocationPerLine(line, parameter);
        String ans = "";
        int i = 0;

        while (i < line.length()) {
            if (parameterLocations.contains(i)) {
                ans += realValue;
                i += parameter.length();
            } else {
                ans += line.charAt(i);
                i++;
            }
        }

        return ans;
    }

    public static Set<Integer> findParameterLocationPerLine(String line, String parameter) {
        Queue<Integer> toVisit = new ArrayDeque<>();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == parameter.charAt(0)) {
                toVisit.add(i);
            }
        }

        int parameterIndex = 1;
        Set<Integer> ans = new HashSet<>();

        while (toVisit.size() > 0) {
            int n = toVisit.size();
            for (int i = 0; i < n; i++) {
                int index = toVisit.remove();
                if (parameterIndex == parameter.length()) {
                    ans.add(index - parameter.length() + 1);
                }
                if (index + 1 < line.length() && parameterIndex < parameter.length()
                        && line.charAt(index + 1) == parameter.charAt(parameterIndex)) {
                    toVisit.add(index + 1);
                }
            }
            parameterIndex++;
        }

        return ans;
    }
}
