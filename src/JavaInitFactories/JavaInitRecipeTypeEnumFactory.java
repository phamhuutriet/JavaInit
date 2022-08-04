package JavaInitFactories;

import JavaInitEnums.RecipeTypeEnums;

public class JavaInitRecipeTypeEnumFactory {
  
  public static RecipeTypeEnums genRecipeTypeEnum(String recipeType) throws Exception{
    switch (recipeType) {
      case "HELLO_WORLD":
        return RecipeTypeEnums.HELLO_WORLD;
      default:
        throw new Exception("Recipe Type Not found");
    }
  }
}
