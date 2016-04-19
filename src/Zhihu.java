import java.util.ArrayList;

/**
 * Created by wangyue on 16/4/19.
 */
public class Zhihu {
    public String question;// the question title
    public String zhihuUrl;//  the page url
    public ArrayList<String> answers;// for store answers;


    public Zhihu() {
        this.question = "";
        this.zhihuUrl = "";
        this.answers = new ArrayList<String>();
    }

    @Override
    public String toString() {
        return "QUESTION:"+this.question+"\tURL:"+this.zhihuUrl+"\tANSWERS:"+answers+"\n";
    }
}
