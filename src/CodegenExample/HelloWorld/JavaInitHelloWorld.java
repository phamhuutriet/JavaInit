package CodegenExample.HelloWorld;

import java.util.Map;

import CodegenUtils.JavaInitReplacer;
import JavaInitInterface.JavaInitRecipe;

public class JavaInitHelloWorld implements JavaInitRecipe {
    final String DESTINE_PATH = "/Users/macos/LearningSpace/JavaCodegen/src/CodegenExample/HelloWorld/HelloWord.java";
    final String TEMPLATE_PATH = "/Users/macos/LearningSpace/JavaCodegen/src/CodegenExample/HelloWorld/JavaInitHelloWorldTemplate.txt";

    @Override
    public String genFileContent() throws Exception {
        return JavaInitReplacer.replace(TEMPLATE_PATH,
                Map.ofEntries(Map.entry("__CLASS_NAME__", "HelloWorld"), Map.entry("__MESSAGE__", "Hello World!")));
    }

    @Override
    public String genFilePath() {
        return this.DESTINE_PATH;
    }
}
