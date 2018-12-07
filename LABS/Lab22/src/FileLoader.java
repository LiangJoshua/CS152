import java.io.File;
import javax.script.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileFilter;

import static java.lang.System.out;

public class FileLoader {
    /**
     * List out all subdirectories of the specified directory.
     * Use a lambda rather than a FileFilter
     */
    public static void listSubdirectoriesLambda(String dirName) {
        out.println("List subdirectories, using a lambda (instead of FileFilter");
        File myDir = new File(dirName);
        File[] subDirs = myDir.listFiles((file) -> {
            return file.isDirectory();
        });
        for (File file : subDirs) {
            System.out.println(file.getName());
        }

    }

    /**
     * List out all subdirectories of the specified directory.
     * For this version, use a method reference.
     */
    public static void listSubdirectoriesMethodRef(String dirName) {
        out.println("List subdirectories using a method reference");
        File myDir = new File(dirName);
        File[] subDirs = myDir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        for (File file : subDirs) {
            System.out.println(file.getName());
        }
    }

    /**
     * List out all files in the specified directory that have the specified extension.
     * Use a lambda rather than a FilenameFilter.
     */
    public static void listFiles(String dirName, String extension) {
        out.println("Listing all " + extension + " files");
        File dir = new File(dirName);
        String[] files = dir.list((File dirToFilter, String filename) -> {
            return filename.endsWith(extension);
        });
        for (String file : files) {
            System.out.println(file);
        }
    }

    /**
     * List all files in the specified directory,
     * using the specified script (run through Nashorn)
     * to filter out the list.
     * The script will assume that the list of files
     * is stored in the Nashorn engine in a '$files' variable.
     */
    public static void listFilesByScript(String dirName, String script) {
        out.println("Listing all files, specified by the script");
        File dir = new File(dirName);
        File[] $files = dir.listFiles((file) -> {
            return file.isFile();
        });
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        try {
            engine.put("$files", $files);
            engine.eval(script);
            for (int i = 0; i < $files.length; i++){
                engine.put("i", i);
                File file = (File) engine.eval("$files[i]");
                System.out.println(file.getName());
                
            }



        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        listSubdirectoriesLambda("/Users/macadmin/Desktop/GitHub/CS152/LABS/Lab22");
        System.out.println();
        listSubdirectoriesMethodRef("/Users/macadmin/Desktop/GitHub/CS152/LABS/Lab22");
        System.out.println();
        listFiles("src", "java");
        System.out.println();
        listFilesByScript("src", "var s=''; for (var i in $files) { f = $files[i]; s+= f.getName() + '\\n'; }; s");

    }

}