
package model;

public class Watch {
    private int watch_id;
    private String product_name;
    private double price;
    private Brand brand;
    private int movement_id;
    private int strap_id;
    private String image_url;
    private String description;
    private int quantity;
    private String new_product;
    private String gender;
    public Watch() {
    }


    public Watch(int watch_id, String product_name, double price, Brand brand, int movement_id, int strap_id, String image_url, String description, int quantity, String new_product, String gender) {
        this.watch_id = watch_id;
        this.product_name = product_name;
        this.price = price;
        this.brand = brand;
        this.movement_id = movement_id;
        this.strap_id = strap_id;
        this.image_url = image_url;
        this.description = description;
        this.quantity = quantity;
        this.new_product = new_product;
        this.gender = gender;
    }

    public int getWatch_id() {
        return watch_id;
    }

    public void setWatch_id(int watch_id) {
        this.watch_id = watch_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getMovement_id() {
        return movement_id;
    }

    public void setMovement_id(int movement_id) {
        this.movement_id = movement_id;
    }

    public int getStrap_id() {
        return strap_id;
    }

    public void setStrap_id(int strap_id) {
        this.strap_id = strap_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }  

    public String getNew_product() {
        return new_product;
    }

    public void setNew_product(String new_product) {
        this.new_product = new_product;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
}
