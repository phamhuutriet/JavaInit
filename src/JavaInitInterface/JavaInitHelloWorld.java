package JavaInitInterface;

public class JavaInitHelloWorld implements JavaInitRecipe {

    final String DESTINE_PATH = "/Users/macos/LearningSpace/JavaCodegen/src/CodegenExample/HelloWord.java";

    @Override
    public String genFileContent() {
        return "package CodegenExample; class HelloWorld {" +
                "public static void printAll(String[] args) {" +
                "System.out.println(\"Hello World!\");" +
                "}" +
                "}";
    }

    @Override
    public String genFilePath() {
        return this.DESTINE_PATH;
    }

}
