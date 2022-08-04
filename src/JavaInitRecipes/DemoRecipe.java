package JavaInitRecipes;
import java.util.Map;
import CodegenUtils.JavaInitReplacer;
import JavaInitInterface.JavaInitRecipe;
import CodegenUtils.JavaCodegen;


public class DemoRecipe implements JavaInitRecipe{
  String classname, message;

  public DemoRecipe(String classname, String message) {
    this.classname = classname;
    this.message = message;
  }

  private String HelloWorldDestinePath() {
    return String.format("/Users/littlepanda312/JavaInit/JavaInit/src/CodegenExample/%s.java", this.classname);
  }

  private String HelloWorldTemplatePath() {
    return "/Users/littlepanda312/JavaInit/JavaInit/src/CodegenExample/HelloWorld/JavaInitHelloWorldTemplate.txt";
  }

  private String helloWorldCodegenContent() throws Exception{
    return JavaInitReplacer.replace(this.HelloWorldTemplatePath(),
        Map.ofEntries(Map.entry("__CLASS_NAME__", this.classname), Map.entry("__MESSAGE__", this.message)));
  }
  
  @Override
  public void genRun() throws Exception {
    JavaCodegen.writeFile(this.helloWorldCodegenContent(), this.HelloWorldDestinePath());
  }
}
