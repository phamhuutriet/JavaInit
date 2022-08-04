package JavaInitFactories;

import java.util.List;

import JavaInitEnums.RecipeTypeEnums;

public class JavaInitParametersFactory {
  
  public static List<String> genParameters(RecipeTypeEnums recipeType) throws Exception{
    switch (recipeType) {
      default:
        throw new Exception("Recipe Type not found");
    }
  }
}
