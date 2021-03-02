/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pathediter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Vector;



/**
 *
 * @author DELL
 */
public class Path {
    private String name;
    private String id;
    private String css;
    private String xpath;

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder("'");
        sb.append(name);
        sb.append("':{'id':'");
        sb.append(id);
        sb.append("','css':'");
        sb.append(css);
        sb.append("','xpath':'");
        sb.append(xpath);
        sb.append("'}");
        return sb.toString();
    }
    public Path(){
    }
    /**
     * 
     * @param name 变量名
    */
    public Path(String name){
       this.name=name;
    }
    /**
     * 
     * 
     */
    public Vector toVector(){
        Vector v=new Vector();
        v.add(this.name);
        v.add(this.id);
        v.add(this.css);
        v.add(this.xpath);
        return v;
    }
            
    public void complete(String id,String css,String xpath){
        this.id=id;
        this.css=css;
        this.xpath=xpath;
    }
    
    public Path(String name, String id, String css, String xpath) {
        this.name = name;
        this.id = id;
        this.css = css;
        this.xpath = xpath;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }
    
    
}
