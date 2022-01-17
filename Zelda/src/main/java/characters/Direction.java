package characters;

import board.Vector2d;

public enum Direction {
    UP,
    DOWN,
    RIGHT,
    LEFT;

    public Direction turnRight(){
        return switch (this){
            case UP -> RIGHT;
            case RIGHT -> DOWN;
            case DOWN -> LEFT;
            case LEFT -> UP;
        };
    }

    public Direction turnLeft(){
        return switch (this){
            case UP -> LEFT;
            case RIGHT -> UP;
            case DOWN -> RIGHT;
            case LEFT -> DOWN;
        };
    }

    public Vector2d toUnitVector(){
        return switch (this){
            case UP -> new Vector2d(1,0);
            case RIGHT -> new Vector2d(0,1);
            case LEFT -> new Vector2d(0,-1);
            case DOWN -> new Vector2d(-1,0);
        };
    }

    public String PictureFilePath(){
        return switch (this){
            case UP -> "src/main/resources/up.jpg";
            case RIGHT -> "src/main/resources/right.jpg";
            case LEFT -> "src/main/resources/left.png";
            case DOWN -> "src/main/resources/down.png";
        };
    }
}


