package im.bcs.aspirelogics.NewsApp.Fragments_MVP.Model;

/**
 * Created by Opriday on 6/28/2018.
 */

public class News_Model {

    String imageUrl, newsUrl, title, Source, time;

    public News_Model(String imageUrl, String newsUrl, String title, String Source, String time) {
        this.imageUrl = imageUrl;
        this.newsUrl = newsUrl;
        this.title = title;
        this.Source = Source;
        this.time = time;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String Source) {
        this.Source = Source;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
