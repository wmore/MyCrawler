import javafx.scene.effect.ImageInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    static String sendGet(String url){
        String result = "";
        BufferedReader in = null;

        try {
            URL realUrl  = new URL(url);
            URLConnection  connection = realUrl.openConnection();
            connection.connect();
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"UTF-8"));
            String line;
            while((line = in.readLine())!=null){
                result += line;
            }
        }catch (Exception e) {
            System.out.println("发送GET请求出现异常!"+e);
            e.printStackTrace();
        } finally {
            try{
                if(in != null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    static ArrayList<String> regexString(String targetStr, String patternStr){
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(targetStr);
        if(matcher.find()){
            return matcher.group(1);
        }
        return "Nothing";
    }

    public static void main(String[] args) {
        String url = "http://www.zhihu.com/explore/recommendations";
        String result = sendGet(url);
        String imgSrc = regexString(result,"question_link.+?>(.+?)<");
        System.out.println(imgSrc);


    }




}
