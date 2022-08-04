package JavaInitFactories;

import java.util.Map;

import JavaInitEnums.RecipeTypeEnums;
import JavaInitInterface.JavaInitRecipe;
import JavaInitRecipes.DemoRecipe;

public class JavaInitRecipeFactory {
  
  public static JavaInitRecipe genRecipe(String recipeType, Map<String, String> parameters) throws Exception{
    RecipeTypeEnums recipeTypeEnum = JavaInitRecipeTypeEnumFactory.genRecipeTypeEnum(recipeType);

    switch (recipeTypeEnum) {
      case HELLO_WORLD:
        return new DemoRecipe(parameters.get("classname"), parameters.get("message"));
      default:
        throw new Exception("Recipe Type not found");
    }
  }
}
