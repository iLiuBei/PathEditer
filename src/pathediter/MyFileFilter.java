/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathediter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class MyFileFilter extends javax.swing.filechooser.FileFilter {

    List<String> extentions = new ArrayList();
    StringBuffer sb = null;

    public MyFileFilter() {

    }

    public MyFileFilter(String s[]) {
        for (String ss : s) {
            extentions.add(ss);
        }
    }

    public MyFileFilter(List<String> s) {
        for (String ss : s) {
            extentions.add(ss);
        }
    }

    public void add(String s[]) {
        for (String ss : s) {
            extentions.add(ss);
        }
    }

    public void add(List<String> s) {
        for (String ss : s) {
            extentions.add(ss);
        }
    }

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        for (String s : extentions) {
            if (f.toString().endsWith(s)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getDescription() {
        sb = new StringBuffer();//在这里初始化，以便再次调用时内容正确
        sb.append("文件格式（");
        for (int i = 0; i < extentions.size(); i++) {
            sb.append(extentions.get(i));
            if (i < extentions.size() - 1) {
                sb.append("|");
            }
        }
        sb.append("）");
        return sb.toString();

    }

}
