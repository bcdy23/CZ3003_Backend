/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author Bryden
 */
public class CFileFactory {

    private CFileFactory() {

    }

    public static boolean isHiddenFile(Path pObjFilePath) {
        try {
            return Files.isHidden(pObjFilePath);
        } catch (IOException ex) {
            return false;
        }
    }

    public static void createFile(Path pObjFilePath, String pStrContents) throws IOException {
        Files.write(pObjFilePath, pStrContents.getBytes());
    }

    public static void createFolder(Path pObjFilePath) throws IOException {
        Files.createDirectory(pObjFilePath);
    }

    public static void renameFile(Path pObjFilePath, String pStrNewName) throws IOException {
        Files.move(pObjFilePath, pObjFilePath.resolveSibling(pStrNewName), StandardCopyOption.ATOMIC_MOVE);
    }

    public static void renameFolder(Path pObjFilePath, String pStrNewName) throws IOException {
        Files.move(pObjFilePath, pObjFilePath.resolveSibling(pStrNewName), StandardCopyOption.ATOMIC_MOVE);
    }

    public static void updateFile(Path pObjFilePath, String pStrContents) throws IOException {
        Files.write(pObjFilePath, pStrContents.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static void deleteFile(Path pObjFilePath) throws IOException {
        Files.deleteIfExists(pObjFilePath);
    }

    public static void deleteFolder(Path pObjFilePath) throws IOException {
        Files.walkFileTree(pObjFilePath, new FileVisitor<Path>() {

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc)
                    throws IOException {

                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir,
                                                     BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file,
                                             BasicFileAttributes attrs) throws IOException {

                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc)
                    throws IOException {
                System.out.println(exc.toString());
                return FileVisitResult.CONTINUE;
            }
        });

    }

    public static InputStream getFile_InputStream(String pStrPath) throws IOException {
        return getFile_InputStream(Paths.get(pStrPath));
    }

    private static InputStream getFile_InputStream(Path pObjPath) throws IOException {
        return Files.newInputStream(pObjPath, StandardOpenOption.READ);
    }

}
