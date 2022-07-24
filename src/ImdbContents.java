public class ImdbContents {
    private final String title;
    private final String imageUrl;
    private final String imDbRating;
    
    public ImdbContents(String title, String imageUrl, String imDbRating) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.imDbRating = imDbRating;
    }
    public String getTitle() {
        return title;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public String getImDbRating() {
        return imDbRating;
    }

}
