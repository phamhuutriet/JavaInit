package CodegenUtils.__tests__;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

import org.junit.Test;

import CodegenUtils.JavaInitReplacer;
import junit.framework.*;

public class JavaInitReplacerTest extends TestCase {

    @Test
    public void testFindAndReplaceParameterLocationPerLine1() {
        String line = "abcde__CLASS_NAME__fgeD";
        String parameter = "__CLASS_NAME__";
        assertEquals(new HashSet<>(Arrays.asList(5)), JavaInitReplacer.findParameterLocationPerLine(line, parameter));

        String realValue = "HelloWorld";
        assertEquals("abcdeHelloWorldfgeD", JavaInitReplacer.replaceOneParemeterPerLine(line, parameter, realValue));

    }

    @Test
    public void testFindAndReplaceParameterLocationPerLine2() {
        String line = "abcde__CLASS__fgeD";
        String parameter = "__CLASS__";
        assertEquals(new HashSet<>(Arrays.asList(5)), JavaInitReplacer.findParameterLocationPerLine(line, parameter));

        String realValue = "ClassName";
        assertEquals("abcdeClassNamefgeD", JavaInitReplacer.replaceOneParemeterPerLine(line, parameter, realValue));
    }

    @Test
    public void testFindAndReplaceParameterLocationPerLine3() {
        String line = "   __CLASS_NAME__fgeD__CLASS_NAME__";
        String parameter = "__CLASS_NAME__";
        assertEquals(new HashSet<>(Arrays.asList(3, 21)),
                JavaInitReplacer.findParameterLocationPerLine(line, parameter));

        String realValue = "ClassName";
        assertEquals("   ClassNamefgeDClassName",
                JavaInitReplacer.replaceOneParemeterPerLine(line, parameter, realValue));
    }

    @Test
    public void testReplaceOneLineWithParameterDict1() {
        String line = "abcde__CLASS_NAME__fgeD";
        Map<String, String> parametersDict = Map.ofEntries(Map.entry("__CLASS_NAME__", "HelloWorld"));

        assertEquals("abcdeHelloWorldfgeD", JavaInitReplacer.replaceOneLine(line, parametersDict));
    }

    @Test
    public void testReplaceOoneLineWithParemeterDict2() {
        String line = "__CLASS_NAME__ do __ACTION__";
        Map<String, String> parametersDict = Map.ofEntries(Map.entry("__CLASS_NAME__", "Dog"),
                Map.entry("__ACTION__", "bark"));

        assertEquals("Dog do bark", JavaInitReplacer.replaceOneLine(line, parametersDict));
    }

    @Test
    public void testReplaceAllText1() throws Exception {
        String filePath = "/Users/littlepanda312/JavaInit/JavaInit/src/CodegenUtils/__tests__/testText1.txt";
        String answerPath = "/Users/littlepanda312/JavaInit/JavaInit/src/CodegenUtils/__tests__/testText1Ans.txt";
        Map<String, String> parametersDict = Map.ofEntries(Map.entry("__CLASS_NAME__", "TestClass"),
                Map.entry("__PARAMETER_NAME__", "testString"));

        assertEquals(this.readTextFile(answerPath), JavaInitReplacer.replace(filePath, parametersDict));
    }

    private String readTextFile(String filePath) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line = reader.readLine();
        String ans = "";

        while (line != null) {
            ans += line + "\n";
            line = reader.readLine();
        }
        reader.close();

        return ans;
    }
}
