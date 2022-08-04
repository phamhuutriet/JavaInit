package JavaInitFactories;

import JavaInitEnums.RecipeTypeEnums;
import JavaInitInterface.JavaInitRecipe;

public class JavaInitRecipeFactory {
  
  public static JavaInitRecipe genRecipe(RecipeTypeEnums recipeType) throws Exception{
    switch (recipeType) {
      default:
        throw new Exception("Recipe Type not found");
    }
  }
}
