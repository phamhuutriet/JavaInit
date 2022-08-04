
import java.util.Map;

import JavaInitFactories.JavaInitParametersFactory;
import JavaInitFactories.JavaInitRecipeFactory;
import JavaInitInterface.JavaInitRecipe;

public class JavaMain {

  public static void main(String[] args) throws Exception{
    String recipeType = args[0];
    Map<String, String> parameters = JavaInitParametersFactory.genParameters(recipeType, args);
    JavaInitRecipe recipe = JavaInitRecipeFactory.genRecipe(recipeType, parameters);
    recipe.genRun();
  }

}
