
package model;
/**
 * CREATE TABLE Brands (
    brand_id INT PRIMARY KEY IDENTITY(1,1),
    brand_name NVARCHAR(50) NOT NULL,
	images VARCHAR(20)
);
 * @author DELL P5530
 */
public class Brand {
    private int brand_id;
    private String brand_name;
    private String images;

    public Brand() {
    }

    public Brand(int brand_id, String brand_name, String images) {
        this.brand_id = brand_id;
        this.brand_name = brand_name;
        this.images = images;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
    
    
}
