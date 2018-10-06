package door.gamemanager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import door.gameobject.DoorClass;

public class GameManager {
    static Array <DoorClass> doors;
    static Texture doorTexture;
    private static final float DOOR_RESIZE_FACTOR = 2500f;
    private static final float DOOR_VERT_POSITION_FACTOR = 3f;
    private static final float DOOR1_HORIZ_POSITION_FACTOR = 7.77f;
    private static final float DOOR2_HORIZ_POSITION_FACTOR = 2.57f;
    private static final float DOOR3_HORIZ_POSITION_FACTOR = 1.52f;
    static float width, height;

    public static void initialize(float width, float height){
        GameManager.width = width;
        GameManager.height = height;
        doorTexture = new Texture(Gdx.files.internal("door_close.png"));
        initDoors();
    }
    public static void renderGame(SpriteBatch batch){
        //Отобразить(нарисовать) каждую дверь
        for(DoorClass door : doors)
            door.render(batch);
    }
    public static void dispose(){
        //Уничтожение нарисованной двери
        doorTexture.dispose();
    }
    public static void initDoors(){
        doors = new Array<DoorClass>();

        //создать экземляр каждой двери и добавить их в массив doors
        for(int i=0;i<3;i++){
            doors.add(new DoorClass());
        //установить позиции для отображения каждой двери
        doors.get(0).position.set(width/DOOR1_HORIZ_POSITION_FACTOR,height/DOOR_VERT_POSITION_FACTOR);
        doors.get(1).position.set(width/DOOR2_HORIZ_POSITION_FACTOR,height/DOOR_VERT_POSITION_FACTOR);
        doors.get(2).position.set(width/DOOR3_HORIZ_POSITION_FACTOR,height/DOOR_VERT_POSITION_FACTOR);

        for(DoorClass door : doors){
            // создаём для каждой двери нашего массива спрайт для её отображения
            door.closeSprite = new Sprite(doorTexture);
            door.width = door.closeSprite.getWidth()* (width/DOOR_RESIZE_FACTOR);
            door.height = door.closeSprite.getHeight()* (width/DOOR_RESIZE_FACTOR);
            door.closeSprite.setSize(door.width, door.height);
            door.closeSprite.setPosition(door.position.x,door.position.y);
        }
    }
}
