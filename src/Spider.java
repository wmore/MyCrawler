import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangyue on 16/4/19.
 */
public class Spider {

    public String sendGet(String url){
        String result = "";
        BufferedReader in = null;

        try {
            URL realUrl  = new URL(url);
            URLConnection connection = realUrl.openConnection();
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

    public ArrayList<Zhihu> getZhihu(String content){
        ArrayList<Zhihu> results = new ArrayList<Zhihu>();
        // compile question title
        Pattern questionPattern = Pattern.compile("question_link.+?>(.+?)<");
        Matcher questionMatcher = questionPattern.matcher(content);
        // compile url
        Pattern urlPattern = Pattern.compile("question_link.+?href=\"(.+?)\"");
        Matcher urlMatcher = urlPattern.matcher(content);

        boolean isFind = questionMatcher.find()&&urlMatcher.find();

        while(isFind){
            Zhihu zhihuTemp = new Zhihu();
            zhihuTemp.question = questionMatcher.group(1);
            zhihuTemp.zhihuUrl = "http://www.zhihu.com"+urlMatcher.group(1);

            results.add(zhihuTemp);
            isFind = questionMatcher.find()&&urlMatcher.find();
        }
        return results;
    }
}
