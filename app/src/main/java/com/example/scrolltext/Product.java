package com.example.scrolltext;

public class Product {
    private String title;
    private String desc;
    private String price;
    private int image;

    public Product(int image, String title, String desc, String price)
    {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}
