import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangyue on 16/4/19.
 */
public class Zhihu {
    public String question;// the question title
    public String questionDescription;// the description of question
    public String zhihuUrl;//  the page url
    public ArrayList<String> answers;// for store answers;


    public Zhihu() {
        this.question = "";
        this.zhihuUrl = "";
        this.questionDescription = "";
        this.answers = new ArrayList<String>();
    }

    @Override
    public String toString() {
        return "QUESTION:"+this.question+"\tDESCRIPTION:"+
                "\tURL:"+this.zhihuUrl+"\tANSWERS:"+answers+"\n";
    }

    public boolean getRealUrl(String url){
        Pattern pattern = Pattern.compile("question/(.*?)/");
        Matcher matcher = pattern.matcher(url);
        if(matcher.find()){
            zhihuUrl = "http://www.zhihu.com/question/"+matcher.group(1);
        }else{
            return false;
        }
        return true;
    }
}
