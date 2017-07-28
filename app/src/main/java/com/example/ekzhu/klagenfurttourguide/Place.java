package com.example.ekzhu.klagenfurttourguide;

public class Place {

    private String mName;
    private String mDescription;
    private String mUrl;
    private String mPrice;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Constructs a new {@link Place} object.
     *
     * @param name is the name of the place
     * @param description description of the place
     * @param url is the website address of the place
     * @param price is the cost of the place
     */

    public Place(String name, String description, String url, int imageResourceId, String price) {
        mName = name;
        mDescription = description;
        mUrl = url;
        mImageResourceId = imageResourceId;
        mPrice = price;
    }

    public String getName() { return mName; }
    public String getDescription() {return mDescription; }
    public String getUrl() {return mUrl; }
    public int getmImageResourceId() { return mImageResourceId; }
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
    public String getPrice() {return mPrice; }

}