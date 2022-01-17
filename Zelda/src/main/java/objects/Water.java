package objects;

import board.Vector2d;

public class Water implements IBoardObject{
    private final boolean penetrable = false;
    private final Vector2d location;

    public Water(Vector2d vector2d){
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
