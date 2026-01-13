import java.util.ArrayList;
public class Re {
    public static void main(String[] args){
        //part1
        String re="\\d{3}-\\d{2}-\\d{4}";
        String text="616-33-4565";
        boolean r=text.matches(re);  
        System.out.println(r);
           //part2
        String re2="#[A-Za-z]+";
        String text2="ABBBBBBBBA";
        boolean r2=text.matches(re);  
        //read posts.txt
        //Step 1 File Operator obj
        ArrayList<String> posts= FileOperator.getStringList("data-analysis-fators22/posts.txt");
      
        System.out.println(posts);
        //iterate each post and find #\w
        for(String post : posts ){
            boolean result=post.matches(re2);  
            System.out.println(result);
        }

    }
    
}
