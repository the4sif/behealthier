// CustomItem.java
public class CustomItem {
    private int imageResource;
    private String title;
    private String subtitle;

    public CustomItem(int imageResource, String title, String subtitle) {
        this.imageResource = imageResource;
        this.title = title;
        this.subtitle = subtitle;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }
}
