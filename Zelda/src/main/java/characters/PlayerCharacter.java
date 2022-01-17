package characters;

import board.Vector2d;

public class PlayerCharacter {
    private Vector2d location;
    private Direction direction;

    public PlayerCharacter(){
        location = new Vector2d(8,11);
        direction = Direction.UP;
    }

    public void changeLocation(Direction direction){
        location.add(direction.toUnitVector());
    }

    public Vector2d getLocation(){
        return location;
    }


    public String getPictureFilePath(){
        return direction.PictureFilePath();
    }
}
