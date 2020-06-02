package com.yevhensuturin;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class DirectoriesMain {
    public static void main(String[] args) {
//        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
//            @Override
//            public boolean accept(Path entry) throws IOException {
//                return (Files.isRegularFile(entry));
//            }
//        };

        DirectoryStream.Filter<Path> filter = entry->Files.isRegularFile(entry);

        Path directory1 = FileSystems.getDefault().getPath("Examples" + File.separator + "Dir2");
//        Path directory1 = FileSystems.getDefault().getPath("Examples\\Dir2");
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory1, filter)){
            for(Path file: contents){
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\n==========================================\n");

        Path directory = FileSystems.getDefault().getPath("Examples\\Dir2");
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, "*.dat")){
            for(Path file: contents){
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e){
            System.out.println(e.getMessage());
        }

        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        try {
            Path tmpFile = Files.createTempFile("myapp", ".appext");
            System.out.println("Temporary file path = " + tmpFile.toAbsolutePath());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\n==========================================\n");
        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        try {
            for (FileStore store : stores) {
                System.out.println("Volume name drive letter:" + store);
                System.out.println("File store: " + store.name() + " : " + store.getTotalSpace());
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\n==========================================\n");
        Iterable<Path> rootPath = FileSystems.getDefault().getRootDirectories();
        for(Path path: rootPath){
            System.out.println(path);
        }

        System.out.println("-------------Walking Tree for Dir2-------------------");
        Path dir2Path = FileSystems.getDefault().getPath("Examples" + File.separator + "Dir2");

        try{
            Files.walkFileTree(dir2Path, new PrintNames());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println("------Copy Dir2 to Dir4--------------");
        Path copyPath = FileSystems.getDefault().getPath("Examples" + File.separator + "Dir4" + File.separator + "Dir2Copy");
        try {
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, copyPath));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }


        File file = new File("\\Examples\\file.txt");   // C:\\Examples\file.txt
        Path convertedPath = file.toPath();
        System.out.println("convertedPath = " + convertedPath);

        File parent = new File("\\Examples");  // C:\\Examples
        File resolvedFile = new File(parent, "dir/file.txt");  // dir\\file.txt
        System.out.println(resolvedFile.toPath());

        resolvedFile = new File("\\Examples", "dir\\file.txt");  // C:\\Examples   dir\\file.txt
        System.out.println(resolvedFile.toPath());

        Path parentPath = Paths.get("\\Examples");  // C:\\Examples
        Path childRelativePath = Paths.get("dir/file.txt");  // dir\\file.txt
        System.out.println(parentPath.resolve(childRelativePath));

        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println("Working directory = " + workingDirectory.getAbsolutePath());

        System.out.println("--- print Dir2 contents using list() ---");
        File dir2File = new File(workingDirectory, "/Examples/Dir2");   // \\FileTree\Dir2
        String[] dir2Contents = dir2File.list();
        for(int i=0; i< dir2Contents.length; i++) {
            System.out.println("i= " + i + ": " + dir2Contents[i]);
        }

        System.out.println("--- print Dir2 contents using listFiles() ---");
        File[] dir2Files = dir2File.listFiles();
        for(int i=0; i< dir2Files.length; i++) {
            System.out.println("i= " + i + ": " + dir2Files[i].getName());
        }

    }
}
