///Library/Java/JavaVirtualMachines/jdk-16.0.1.jdk/Contents/Home/bin/java --source 11

import JavaInitInterface.JavaInitRecipe;
import java.io.FileOutputStream;

public class JavaCodegen {
    public static void main(String[] args) throws Exception {
        String recipeType = args[0];

        JavaInitRecipe recipe = JavaInitRecipeFactory.genRecipe(recipeType);

        String codeToAdd = recipe.genFileContent();

        String filePath = recipe.genFilePath();

        FileOutputStream file = new FileOutputStream(filePath);
        file.write(codeToAdd.getBytes());
        file.close();

    }
}