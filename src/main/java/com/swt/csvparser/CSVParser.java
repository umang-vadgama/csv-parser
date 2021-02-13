package com.swt.csvparser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class CSVParser {


    static int counter = 0;
    static int nested = 0;



    public List<File> getFiles(String csvPath) {

        File file = new File(csvPath);
        List<File> fileList = new ArrayList<>();

        if (file.isDirectory()) {
            if (file.listFiles() != null) {



                return Arrays.stream(Objects.requireNonNull(file.listFiles())).filter(e -> {
                    if(e.isDirectory()){


                        getFiles(e.getAbsolutePath());

                        return true;
                    }else{

                    }

                    //String fileType = e.getAbsolutePath().substring(e.getAbsolutePath().lastIndexOf(".") + 1);
                    //return fileType.equals("csv");

                }).collect(Collectors.toList());

            } else {

                CSVParser.counter++;
                return null;
            }

        }else{
            return null;
        }



    }

    public static void main(String[] args) {
        //System.out.println(CSVParser.counter);

        //System.out .println("Nested : "+CSVParser.nested+" || "+CSVParser.counter+"|| files :"+f.size());

        new CSVParser().getFiles(args[0]).forEach(System.out::println);
    }
}
