package board;
import characters.PlayerCharacter;
import objects.IBoardObject;
import objects.Path;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final int height = 12;
    private final int width = 17;
    private final Map<Vector2d, IBoardObject> boardObjects = new HashMap<>();
    private PlayerCharacter player;
    public Board(PlayerCharacter player){
        this.player = player;
        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                System.out.println(i + "," + j);
                boardObjects.put(new Vector2d(i,j),new Path(new Vector2d(i,j)));
            }
        }
    }

   public void addObject(Vector2d location, IBoardObject object){
        boardObjects.put(location,object);
   }

   public boolean boardContainsKey(Vector2d location) {
       return boardObjects.containsKey(location);
   }

    public IBoardObject ObjectAt(Vector2d location) {
        return boardObjects.get(location);
    }
}
