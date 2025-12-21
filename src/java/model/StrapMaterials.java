
package model;

public class StrapMaterials {
    private int strap_id;
    private String strap_name;

    public StrapMaterials() {
    }

    public StrapMaterials(int strap_id, String strap_name) {
        this.strap_id = strap_id;
        this.strap_name = strap_name;
    }

    public int getStrap_id() {
        return strap_id;
    }

    public void setStrap_id(int strap_id) {
        this.strap_id = strap_id;
    }

    public String getStrap_name() {
        return strap_name;
    }

    public void setStrap_name(String strap_name) {
        this.strap_name = strap_name;
    }
    
    
}
