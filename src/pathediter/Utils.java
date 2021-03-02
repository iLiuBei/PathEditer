/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathediter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Utils {

    public static List<Path> readStirng2Paths(String s) {
        try {

            //先获取{}内容
            List<Integer> start=new ArrayList();
            List<Integer> end=new ArrayList();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='{'){
                    start.add(i);
                }else if(s.charAt(i)=='}'){
                    end.add(i);
                }
            }
            if(start.size()!=end.size()||start.get(0)>end.get(0)||start.get(start.size())>end.get(end.size())){
                System.err.println("文件内容有误");
                return null; 
            }
            System.out.println("start.get(0):"+start.get(0));
            System.out.println("end.get(end.size())"+end.get(end.size()));
            HashMap map = JSON.parseObject(s.substring(start.get(0), end.get(end.size())), HashMap.class);//先清除PARAMS=
            List<Path> paths = new ArrayList();
            //System.out.print(map.keySet());
            for (Object key : map.keySet()) {
                Path path=new Path(key.toString());//获取名称并新建一个path
        
                JSONObject json = (JSONObject) map.get(key);
                path.complete(json.get("id").toString(), json.get("css").toString(), json.get("xpath").toString());
                paths.add(path);
            }
            return paths;
        } catch (Exception e) {

        }
        return null;
    }

    public static String readFile2String(String fileName) throws IOException {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            return null;
        }
    }

    public static boolean writeFile(String path, String s) {
        if (null == path) {
            return false;
        }
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(path));
            out.write(s);
            out.close();
            System.out.println("文件创建成功！");
            return true;

        } catch (IOException e) {
            return false;
        }
    }
}
