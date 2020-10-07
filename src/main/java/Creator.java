//import org.aspectj.weaver.ast.Test;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.net.URLDecoder;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class Creator {
//    static final String service="service";
//    static final String controller="controller";
//    static final String repo="repo";
//    public static void main(String[] args) throws IOException {
//        File file = new File( System.getProperty("user.dir"));
//        String serviceDir=findDir(file, "service");
//        String controllerDir=findDir(file, "controller");
//        String repoDir = findDir(file, "repo");
//        String entityDir = findDir(file, "entity");
//        List<File> entities = getFiles(entityDir);
//        createFiles();
//    }
//
//    static private void createFiles(List<File> entities, String path) {
//        for (File f : entities) {
//            String name = f.getName();
//            String sub = name.substring(0,name.length()-5);
//            File file1;
//            if(controller.equals(path) || service.equals(path))
//                file1 = new File(path+sub+".java");
//            else if(repo.equals(path))
//                file1 = new File(path+)
//        }
//    }
//
//    static private void writeFile(File file) throws IOException {
//        FileWriter myWriter = new FileWriter(file);
//
//    }
//
//    static private List<File> getFiles(String path) throws IOException {
//        return Files.walk(Paths.get(path))
//                .filter(Files::isRegularFile)
//                .map(Path::toFile)
//                .collect(Collectors.toList());
//    }
//
//    static private String findDir(File root, String name) {
//        if (root.getName().equals(name)) {
//            return root.getAbsolutePath();
//        }
//
//        File[] files = root.listFiles();
//
//        if (files != null) {
//            for (File f : files) {
//                if (f.isDirectory()) {
//                    String myResult = findDir(f, name);
//                    if (myResult != null) {
//                        return myResult;
//                    }
//                }
//            }
//        }
//        return null;
//    }
//}
//
//
