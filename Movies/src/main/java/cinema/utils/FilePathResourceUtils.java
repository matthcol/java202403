package cinema.utils;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePathResourceUtils {

    /**
     * create Path object from a resource file
     * @param aClass class to obtain resource directory from
     * @param resource file placed in resource directory
     * @return Path object representing resource file
     * @throws RuntimeException if resource cannot be converted into URI
     * @throws NullPointerException if resource is not found
     */
    public static Path pathFromResource(Class<?> aClass, String resource){
        try {
            return Paths.get(aClass.getResource(resource).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException("URI Syntax incorrect", e);
        }
    }

    /**
     * create File object from a resource file
     * @param aClass class to obtain resource directory from
     * @param resource file placed in resource directory
     * @return File object representing resource file
     * @throws NullPointerException if resource is not found
     */
    public static File fileFromResource(Class<?> aClass, String resource){
        return new File(aClass.getResource(resource).getFile());
    }
}
