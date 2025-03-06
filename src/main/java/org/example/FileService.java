package org.example;

import java.io.*;

public class FileService {


    public boolean copyFileConsideringExtension (File oldDirectory, File newDIrectory, String extention) {
       if(!(checkIsDirectory(oldDirectory)) || !(checkIsDirectory(newDIrectory))){
         return false;
       }
       MyFileFilter myFileFilter = new MyFileFilter(extention);

       File[] listFilesForCopy = oldDirectory.listFiles(myFileFilter);
       if ( listFilesForCopy== null){
           return false;
       }else {
           for (File file:listFilesForCopy) {
               copyFile(file,newDIrectory);
           }
           return true;
       }
    }

    private boolean checkIsDirectory (File oldDirectory ){
        return oldDirectory.isDirectory();
    }
    private void copyFile(File fileForCopy, File newDirectory){
        File newFileInNewDirectory = new File(newDirectory, fileForCopy.getName());
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileForCopy.getAbsolutePath()));
            BufferedWriter bufferedWriter =new BufferedWriter( new FileWriter(newFileInNewDirectory))){
             String strRead=null;
           while (( strRead = bufferedReader.readLine())!=null) {
               bufferedWriter.write(strRead+"\n");
           }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
