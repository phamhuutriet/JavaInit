package JavaInitInterface;

public interface JavaInitCodegen {
  
  public String genFileContent(JavaInitRecipe recipe) throws Exception;

  public String genFilePath(JavaInitRecipe recipe);
}
