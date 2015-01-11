package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception , IOException {
        Window w = new Window();
        w.Window();
        Window.ReadFile ReadFile;
      /*/  try{
            String file_name = "E:/text.txt";
           Window.ReadFile file = new Window.ReadFile(file_name);
            String[] aryLines = file.OpenFile();
            int i;
            for(i=0;i<aryLines.length; i++){
                System.out.println(aryLines[i]);

            }
        }
        catch (IOException e){
            System.out.println("Coś się popsuło w pliczkach :<");
        }
/*/
    }
}