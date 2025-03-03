package org.example;

import java.io.*;

public class FileService {


    public boolean copyFileConsideringExtension (File oldDirectory, File newDIrectory, String extention) {
       if(checkIsDirectory(oldDirectory)||checkIsDirectory(newDIrectory)){
         return false;
       }
       MyFileFilter myFileFilter = new MyFileFilter(oldDirectory,extention);
       String[] listFilesForCopy = oldDirectory.list(myFileFilter);
        for (String str:listFilesForCopy) {
            copyFile(str,newDIrectory);
        }




       return false;


    }

    private boolean checkIsDirectory (File oldDirectory ){
        return oldDirectory.isDirectory();
    }
    private void copyFile(String file, File newDirectory){
        File fileForCopy = new File(file);
        File newFileInnewDirectory= new File(newDirectory.getName()+"////"+file);
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileForCopy));
            BufferedWriter bufferedWriter =new BufferedWriter( new FileWriter(newFileInnewDirectory))){
             String strRead=null;
           while (( strRead = bufferedReader.readLine())!=null) {
               bufferedWriter.write(strRead+"\n");
           }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }


}
