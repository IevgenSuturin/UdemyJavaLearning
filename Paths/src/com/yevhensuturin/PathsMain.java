package com.yevhensuturin;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class PathsMain {
    public static void main(String[] args) {
        try {
            Path fileToCreate =FileSystems.getDefault().getPath("Examples",  "file1.txt");
            long size = Files.size(fileToCreate);
            System.out.println("Last modified = "+ Files.getLastModifiedTime(fileToCreate));
            System.out.println(size);

            BasicFileAttributes attributes = Files.readAttributes(fileToCreate, BasicFileAttributes.class);
            System.out.println("Size = " + attributes.size() +","+ attributes.lastAccessTime() +", " +attributes.creationTime());
//            Files.createFile(fileToCreate);
//            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.createDirectories(dirToCreate);

//            Path dirToCreate =FileSystems.getDefault().getPath("Examples",  "Dir2\\Dir3\\Dir4\\Dir5\\Dir6");
//            Path dirToCreate =FileSystems.getDefault().getPath("Examples\\Dir2\\Dir3\\Dir4\\Dir5\\Dir6\\Dir7");
//            Files.createDirectories(dirToCreate);

//            Path fileToDelete =FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
//            Files.deleteIfExists(fileToDelete);

//             Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1.txt");
//             Path destination = FileSystems.getDefault().getPath("Examples", "file2.txt");
//             Files.move(fileToMove, destination);

//             Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//             Path destination = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
//             Files.move(fileToMove, destination);

//            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//
//            sourceFile = FileSystems.getDefault().getPath("Examples", "Dir1");
//            copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e){
            System.out.println(e.getMessage());
        }


//        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
//        printFile(path);
////        Path filePath = FileSystems.getDefault().getPath("files", "SubdirectoryFile.txt");
//        Path filePath = Paths.get(".","files", "SubdirectoryFile.txt");
//        printFile(filePath);
////        filePath = Paths.get("C:\\Users\\h241705\\IdeaProjects\\OutDirectory.txt");
//        filePath = Paths.get("C:\\","Users", "h241705", "IdeaProjects", "OutDirectory.txt");
//        printFile(filePath);
//
//        filePath = Paths.get(".");
//        System.out.println(filePath.toAbsolutePath());
//
//        Path path2 = FileSystems.getDefault().getPath(".", "files", "..", "files", "SubdirectoryFile.txt");
//        System.out.println(path2.toAbsolutePath());
//        System.out.println(path2.normalize().toAbsolutePath());
//        printFile(path2.normalize());
//
//        Path path3 = FileSystems.getDefault().getPath("thisFileDoesNotExist.txt");
//        System.out.println(path3.toAbsolutePath());
//
//        Path path4 = Paths.get("C:\\Users\\h241705\\IdeaProjects\\NGN", "weather.txt");
//        System.out.println(path4.toAbsolutePath());
//
//        filePath = FileSystems.getDefault().getPath("files");
//        System.out.println("Exists = " + Files.exists(filePath));
//        System.out.println("Exists = " + Files.exists(path4));
    }

//    private static void printFile(Path path){
//        try (BufferedReader fileReader = Files.newBufferedReader(path)) {
//            String line;
//            while( (line = fileReader.readLine()) != null){
//                System.out.println(line);
//            }
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }
}
