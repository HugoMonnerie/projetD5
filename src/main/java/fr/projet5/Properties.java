package fr.projet5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Properties
{
        private FileWriter myWriter;

    public void createFile()
        {
            try {
                myWriter = new FileWriter("autoConnect.log",true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void writeFile(String message)
        {
            try {
                myWriter.write(message + "\n");
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public  ArrayList readFile()
        {
            try {
                File f = new File("autoConnect.log");
                Scanner myReader;
                myReader = new Scanner(f);
                ArrayList<String> listData = new ArrayList<>();
                while (myReader.hasNextLine())
                {
                    listData.add(myReader.nextLine());
                }
                myReader.close();
                return listData;
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        public void removeAll()
        {
            try {
                myWriter = new FileWriter("autoConnect.log");
                myWriter.write("");
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


}
