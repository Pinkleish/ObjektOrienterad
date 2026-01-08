package model;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class FileManager
{

    public String[] readFile(String filename)
    {
        List<String> list = new ArrayList<String>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            try{
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            } catch (IOException e){
                System.out.println("IOException caught");
            }
        }catch (FileNotFoundException e){
            System.out.println("Caught 'File not found' exception");
        }

            // Convert ArrayList to Array
            String[] array = list.toArray(new String[0]);

            return array;

    }
 }