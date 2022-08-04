package CodegenUtils;
///Library/Java/JavaVirtualMachines/jdk-16.0.1.jdk/Contents/Home/bin/java --source 11

import java.io.FileOutputStream;

public class JavaCodegen {

    public static void writeFile(String codeToAdd, String filePath) throws Exception {
        FileOutputStream file = new FileOutputStream(filePath);
        file.write(codeToAdd.getBytes());
        file.close();
    }
}