import JavaInitInterface.JavaInitHelloWorld;
import JavaInitInterface.JavaInitRecipe;

public class JavaInitRecipeFactory {

    public static JavaInitRecipe genRecipe(String recipeType) throws Exception {
        switch (recipeType) {
            case "HelloWorld":
                return new JavaInitHelloWorld();
            default:
                throw new Exception("Invalid recipe type");
        }
    }
}
