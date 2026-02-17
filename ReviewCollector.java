import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReviewCollector {
    private ArrayList<ProductReview> reviewList;
   private ArrayList<String> productList;

   public ReviewCollector(){
    reviewList=new ArrayList<>();
    productList = new ArrayList<>();
   }
   public void addReview(ProductReview prodReview){
    reviewList.add(prodReview);
    System.out.println(reviewList.size());

   }  
   public int getNumGoodReviews(String prodName){
     int goodCount=0;
     //iterate on this list ArrayList<ProductReview> reviewList;
    for (   ProductReview elem : reviewList) {
           if ( elem.getName().equals(prodName) ) {
               String review=elem.getReview();
               //split into tokens
               String[] words=review.split(" ");
               double total=0.0;
               for (   String word : words) {
                       total=total+getSentiments(word);
               }
               if(total>1){
                goodCount+=1;
               }

    
               
           }

    }



    return goodCount;
   }
      public static void main(String[] args){

    ReviewCollector reviewCollector= new ReviewCollector(); 
    ArrayList<String> lines =FileOperator.getStringList("reviews.txt");
    Pattern productPattern = Pattern.compile("Product:\\s*(.+)");
    Pattern reviewPattern = Pattern.compile("Review:\\s*(.+)");

    String productName = null;
    String review =null;
    for (String line : lines) {
        Matcher productMatcher = productPattern.matcher(line);
        Matcher reviewMatcher = reviewPattern.matcher(line);
        
        if (productMatcher.find()) 
        {
            productName = productMatcher.group(1);
             } else if (reviewMatcher.find()) {
            review= reviewMatcher.group(1);
           
        }
        if(productName!=null &review!=null )
        {
              ProductReview product=new ProductReview(productName,review);
              reviewCollector.addReview(product);
              System.out.println(product);

        }
    }
}

      
   
     public double getSentiments(String wordSearch) {
        // Read lines from sentiments.txt
        ArrayList<String> lines = FileOperator.getStringList("sentiments.txt");

        // Regex pattern to match word,decimal pairs
        Pattern pattern = Pattern.compile("([a-zA-Z0-9]+),(-?\\d+\\.\\d+)");


        // Process each line
        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String word = matcher.group(1); // Extract the word
                Double value = Double.parseDouble(matcher.group(2)); // Extract the value

             
                // Print the result
                System.out.println(word + "   ----  " + value);
                   if(wordSearch.equals(word)){
                    return value;
                }
   
            }
           
        }
         return 0.0;
    }

    
}
