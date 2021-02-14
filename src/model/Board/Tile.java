package model.Board;

import view.Backgrounds.Image;

public class Tile extends Image { ;
    private boolean isSelected = false;
    private int position;

    public Tile(String filename, int position){
        super(filename);
        this.position = position;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected=isSelected;
    }
    public boolean isSelected() {
        return isSelected;
    }
    public int getPosition() {
        return position;
    }

}
