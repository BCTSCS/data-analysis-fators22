public class Article {
    private String link;
    private String headline;
    private String category;
    private String description;
    private String author;
    private String date;
    
    @Override
    public String toString() {
        return  "HeadLine"+ headline + ", description " + description;
    }
    public Article(String link, String headline, String category, String description, String author, String date) {
        this.link = link;
        this.headline = headline;
        this.category = category;
        this.description = description;
        this.author = author;
        this.date = date;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public String getHeadline() {
        return headline;
    }
    public void setHeadline(String headline) {
        this.headline = headline;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
                

    
}
