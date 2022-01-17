package objects;

import board.Board;
import board.Vector2d;

public interface IBoardObject {
    String getPictureFilePath();
    Boolean getPenetrable();
    Vector2d getLocation();
}
