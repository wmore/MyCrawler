import javafx.scene.effect.ImageInput;
import sun.security.provider.ConfigFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {



    public static void main(String[] args) {
        String url = "http://www.zhihu.com/explore/recommendations";
        Spider spider = new Spider();
        String content = spider.sendGet(url);
        ArrayList<Zhihu> myzhihu = spider.getZhihu(content);
        System.out.println(myzhihu);
    }




}
