package it.skinjobs.newsfeed;

public class News {
    private String title;
    private String imageUrl;
    private String url;

    public News(String title, String imageUrl, String url) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() { return imageUrl; }

    public String getUrl() { return url; }

}
