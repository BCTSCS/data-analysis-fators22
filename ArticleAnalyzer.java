
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class ArticleAnalyzer {

    private ArrayList<String> stopWords; //load from FileOperators
    private ArrayList<Article> articles; //load from FileOperators json 

    public ArticleAnalyzer(){
        stopWords=FileOperator.getStringList("stopwords.txt");
        System.out.println("Stop Word count"+stopWords.size());
        articles=new ArrayList<>();
        System.out.println("Articles count"+articles.size());



    }
    public static void main(String[] args) {
        ArticleAnalyzer analyzer = new ArticleAnalyzer();
        ArrayList<String> content= FileOperator.getStringList("data.txt");
        for(String line : content){

          analyzer.addArticle(analyzer.parseJson(line));
        }

    }

    public void addStopWord(String word){

    }

    public void addArticle(Article article){

    }

    public Article parseJson(String jsonLine){
 
        Article result;
         Pattern l = Pattern.compile("\"link\":\\s*\"([^\"]+)\"");
    Pattern c = Pattern.compile("\"category\":\\s*\"([^\"]+)\"");
    Pattern h = Pattern.compile("\"headline\":\\s*\"([^\"]+)\"");
    Pattern d = Pattern.compile("\"short_description\":\\s*\"([^\"]+)\"");
    Pattern a = Pattern.compile("\"authors\":\\s*\"([^\"]+)\"");
    Pattern t = Pattern.compile("\"date\":\\s*\"([^\"]+)\"");

    Matcher lm = l.matcher(jsonLine);
    Matcher cm = c.matcher(jsonLine);
    Matcher hm = h.matcher(jsonLine);
    Matcher dm = d.matcher(jsonLine);
    Matcher am = a.matcher(jsonLine);
    Matcher tm = t.matcher(jsonLine);

    // matcher.group(1) now retrieves the text inside the parentheses
    String link = lm.find() ? lm.group(1) : " ";
    String cat  = cm.find() ? cm.group(1) : " ";
    String he   = hm.find() ? hm.group(1) : " ";
    String dsc  = dm.find() ? dm.group(1) : " ";
    String au   = am.find() ? am.group(1) : " ";
    String time = tm.find() ? tm.group(1) : " ";

     result = new Article(link, cat, dsc, he, au, time);
      System.out.println(he + "---- " + dsc);
    return result;
}

 
    public String removeStopWords(String text){
        String result="";


        return result;
    } //remove stop words from Description


}

