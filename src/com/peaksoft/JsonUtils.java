package com.peaksoft;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class JsonUtils {
   public static String readFile(Path path){
       StringBuilder result = new StringBuilder();
       try (FileReader fileReader = new FileReader(String.valueOf(path))){
           int a;
           while ((a = fileReader.read()) != -1){
               result.append((char) a);
           }
       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
       return result.toString();
   }
   public static void write(String obj, Path path){
       try {
           Files.writeString(Paths.get(String.valueOf(path)), obj,
                   StandardOpenOption.CREATE, StandardOpenOption.WRITE);
       }catch (IOException e){
           System.out.println(e.getMessage());
       }
   }
}
