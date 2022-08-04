package JavaInitFactories;

import java.util.Map;
import JavaInitEnums.RecipeTypeEnums;

public class JavaInitParametersFactory {
  
  public static Map<String, String> genParameters(String recipeType, String[] args) throws Exception{
    RecipeTypeEnums recipeTypeEnum = JavaInitRecipeTypeEnumFactory.genRecipeTypeEnum(recipeType);
    
    switch (recipeTypeEnum) {
      case HELLO_WORLD:
        return Map.ofEntries(Map.entry("classname", args[1]), Map.entry("message", args[2]));
      default:
        throw new Exception("Recipe Type not found");
    }
  }
}
