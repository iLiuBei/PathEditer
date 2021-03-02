/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathediter;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DataSourceEditer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Path path = new Path("用户名", "一个username", "一个css", "一个xpath");

        String PARAMS = "{'username':{'id':'userName','css':'','xpath':''},'password':{'id':'password','css':'','xpath':''},'login':{'id':'','css':'.ant-btn','xpath':''}}";
        String filename="D:\\temp\\text.py.txt";
        String s=Utils.readFile2String(filename);
        List<Path> ll=Utils.readStirng2Paths(s);
        for(Path p :ll){
            System.out.println(p);
        }
    }

}
