package aufrichtig.nasaimages;

import com.google.gson.annotations.SerializedName;

import java.util.*;


public class NasaImageFeed {
    Collection collection;

    public Data getFirstDatum() {
        return collection.items.get(0).data.get(0);
    }
    public Link getFirstLink() {
        return collection.items.get(0).links.get(0);
    }

    class Collection {
        ArrayList<Item> items = new ArrayList();
    }

    class Item {
        ArrayList<Data> data = new ArrayList();
        ArrayList<Link> links = new ArrayList();
    }

    class Data {
        String title;
        String description;
    }

    class Link {
        @SerializedName("href")
        String imageLink;
    }
}