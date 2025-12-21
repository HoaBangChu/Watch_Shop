
package model;

public class MovementTypes {
    private int movement_id;
    private String movement_name;

    public MovementTypes() {
    }

    public MovementTypes(int movement_id, String movement_name) {
        this.movement_id = movement_id;
        this.movement_name = movement_name;
    }

    public int getMovement_id() {
        return movement_id;
    }

    public void setMovement_id(int movement_id) {
        this.movement_id = movement_id;
    }

    public String getMovement_name() {
        return movement_name;
    }

    public void setMovement_name(String movement_name) {
        this.movement_name = movement_name;
    }   
}
