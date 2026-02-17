
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class ArticleAnalyzer {

    private ArrayList<String> stopWords; //load from FileOperators
    private static ArrayList<String> words; 
    private static ArrayList<Double> values; 
    private ArrayList<Article> articles; //load from FileOperators json 

    public ArticleAnalyzer(){
        stopWords=FileOperator.getStringList("stopwords.txt");
        System.out.println("Stop Word count"+stopWords.size());
        articles=new ArrayList<>();
        words=new ArrayList<>();
        values=new ArrayList<>();
        System.out.println("Articles count"+articles.size());



    }
    public static void main(String[] args) {
       ArticleAnalyzer riano = new ArticleAnalyzer();
       ArrayList<String> lines= FileOperator.getStringList("data.txt");
        ArrayList<String> sentiments= FileOperator.getStringList("sentiments.txt");


        for(String sentiment : sentiments){
            Pattern l = Pattern.compile( "((?i)[a-z0-9]+),(-?\\d+.\\d+)");  
            Matcher lm =l.matcher(sentiment); //parameter - line of text
            boolean found = lm.find(); 
            String word = found ? lm.group(1) : ""; 
            Double value = found ? Double.parseDouble(lm.group(2)) : 0.0;
            System.out.println(word+"   ----  "+value);
            words.add(word);
            values.add(value);


        }



        for(String line : lines){
    
                Article a=riano.parseJson(line);
                String clean=riano.removeStopWords(a.getDescription());
                a.setDescription(clean);
                System.out.println(a);
                riano.addArticle(a);
        }

       


    }

    public void addStopWord(String word){

    }

    public void addArticle(Article article){
        articles.add(article);

    }

    public Article parseJson(String jsonLine){
 
        Article result;
        Pattern l = Pattern.compile("\"link\":\\s*\"([^\"]+)\"");  //regex to extract words
        Matcher lm =l.matcher(jsonLine); //parameter - line of text
        String lt = lm.find() ? lm.group(1) : ""; //extract the destined part

        
        Pattern h = Pattern.compile("\"headline\":\\s*\"([^\"]+)\"");  //regex to extract words
        Matcher hm =h.matcher(jsonLine); //parameter - line of text
        String ht = hm.find() ? hm.group(1) : ""; //extract the destined part
        
        Pattern c = Pattern.compile("\"category\":\\s*\"([^\"]+)\"");  //regex to extract words
        Matcher cm =c.matcher(jsonLine); //parameter - line of text
        String ct = cm.find() ? cm.group(1) : ""; //extract the destined part

        Pattern d = Pattern.compile("\"short_description\": \"([^\"]+)\"");  //regex to extract words
        Matcher dm =d.matcher(jsonLine); //parameter - line of text
        String dt = dm.find() ? dm.group(1) : ""; 
        //System.out.println(dt);//extract the destined part


         Pattern a = Pattern.compile("\"authors\":\\s*\"([^\"]+)\"");  //regex to extract words
        Matcher am =a.matcher(jsonLine); //parameter - line of text
        String at = am.find() ? am.group(1) : ""; //extract the destined part

         Pattern t = Pattern.compile("\"date\":\\s*\"([^\"]+)\"");  //regex to extract words
        Matcher tm =t.matcher(jsonLine); //parameter - line of text
        String tt = tm.find() ? tm.group(1) : ""; //extract the destined part

        
        result=new Article(lt, ht, ct, dt, at, tt);

    return result;
}

 
    public String removeStopWords(String text){
         
        for(String word :  stopWords){

            text=text.replaceAll("\\b"+word+"\\b", " " );

        }   
        return text;


    } //remove stop words from Description


}