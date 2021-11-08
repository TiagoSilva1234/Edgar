package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try{
            readFilesNames();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    //  --------  --------  --------  --------  --------  --------  --------  --------  --------  --------  --------  --------

    public static String readInputFromUser() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    //  --------  --------  --------  --------  --------  --------  --------  --------  --------  --------  --------  --------

    public static String getFilesOnDirectory() {
        File folder = new File("src/");
        File[] listOfFiles = folder.listFiles();
        String content = "";
        for (int i=0;i<listOfFiles.length;i++){
            content += listOfFiles[i].getName() +"\n";
        }


    return content;}
    //  --------  --------  --------  --------  --------  --------  --------  --------  --------  --------  --------  --------

    public static boolean checkIfFileIsOnDirectory(String name) {
        File folder = new File("src/");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
    //  --------  --------  --------  --------  --------  --------  --------  --------  --------  --------  --------  --------

    public static void createFileIfNotExist(String name) {
        File file = new File("src/" + name);
    }

    //  --------  --------  --------  --------  --------  --------  --------  --------  --------  --------  --------  --------
    public static void writeOnFile(String name, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/"+ name));
        writer.write(content);
        writer.close();

    }
    //  --------  --------  --------  --------  --------  --------  --------  --------  --------  --------  --------  --------

    public static void readFilesNames() throws IOException{

        System.out.println("Introduza nome do ficheiro");

        String name = readInputFromUser();

        String filesName = getFilesOnDirectory();

        if (!checkIfFileIsOnDirectory(name)) createFileIfNotExist(name);

        writeOnFile(name, filesName);

    }

}
