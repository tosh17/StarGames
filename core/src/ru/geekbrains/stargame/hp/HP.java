package ru.geekbrains.stargame.hp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.engine.math.Rect;
import ru.geekbrains.engine.sprite.Sprite;

/**
 * Created by shcherbakov on 02.01.2018.
 */

public class HP extends Sprite {
    int count;
    public Vector2 pos;
    protected Rect worldBounds;
    public HP(Rect worldBounds) {
        super(new Texture(Gdx.files.internal("hps.png")));
        this.worldBounds = worldBounds;
        pos=new Vector2();

    }

    public void setHp(int count) {
        this.count = count;
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch,count);
    }

    public void setToNewGame() {
        count=100;
        pos.x = worldBounds.pos.x;
        pos.y= worldBounds.getHalfHeight();

    }
    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
    }
}
