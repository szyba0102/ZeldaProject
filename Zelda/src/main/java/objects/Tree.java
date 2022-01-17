package objects;

import board.Vector2d;

public class Tree implements IBoardObject{
    private final boolean penetrable = false;
    private final Vector2d location;

    public Tree(Vector2d vector2d){
        location = vector2d;
    }

    @Override
    public String getPictureFilePath() {
        return null;
    }

    @Override
    public Boolean getPenetrable() {
        return penetrable;
    }

    @Override
    public Vector2d getLocation() {
        return location;
    }
}
