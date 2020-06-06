package aufrichtig.nasaimages;

import com.google.gson.annotations.SerializedName;

import java.util.*;


public class NasaImageFeed {
    Collection collection;

    public Item getFirstImage() {
        return collection.items.get(0);
    }
}
 class Collection {
    ArrayList<Item> items = new ArrayList();
}

class Item{
    ArrayList <Data> data = new ArrayList();
    ArrayList <Link> links = new ArrayList();
}

class Data{
    String title;
    String description;
}

class Link{
    @SerializedName("href")
    String imageLink;
}
