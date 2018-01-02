package ru.geekbrains.engine.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.engine.math.Rect;
import ru.geekbrains.engine.utils.Regions;

/**
 * Суперкласс для графических объектов
 */
public class Sprite extends Rect {

    protected float angle;
    protected float scale = 1f;
    protected TextureRegion[] regions;
    protected Texture texture;
    protected int frame;

    private boolean isDestroyed;

    public Sprite() {

    }

    public Sprite(Texture texture) {
        this.texture = texture;
    }

    public Sprite(TextureRegion region) {
        if (region == null) {
            throw new NullPointerException();
        }
        regions = new TextureRegion[1];
        this.regions[0] = region;
    }

    public Sprite(TextureRegion region, int rows, int cols, int frames) {
        this.regions = Regions.split(region, rows, cols, frames);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(
                regions[frame], // текущий регион
                getLeft(), getBottom(), //точка отрисовки
                halfWidth, halfHeight, // точка вращения
                getWidth(), getHeight(), // ширина и высота
                scale, scale, // масштаб по x и y
                angle // угол вращения
        );
    }
    public void drawT(SpriteBatch batch) {
        batch.draw(
                texture, // текущий регион
                getLeft(), getBottom() //точка отрисовки

        );
    }
    public void draw(SpriteBatch batch, int percent) {
        batch.draw(
                texture, // текущий регион
                getLeft(), getBottom(), //точка отрисовки
                halfWidth, halfHeight, // точка вращения
                getWidth(), getHeight(), // ширина и высота
                scale, scale, // масштаб по x и y
                angle, // угол вращения
                (int) getLeft(), (int) getBottom(),
                (int) getWidth() * percent / 100, (int) getHeight(), false, false
        );

    }

    public void setWidthProportion(float width) {
        setWidth(width);
        float aspect = regions[frame].getRegionWidth() / (float) regions[frame].getRegionHeight();
        setHeight(width / aspect);
    }

    public void setHeightProportion(float height) {
        setHeight(height);
        float aspect = regions[frame].getRegionWidth() / (float) regions[frame].getRegionHeight();
        setWidth(height * aspect);
    }

    public void resize(Rect worldBounds) {

    }

    public boolean touchDown(Vector2 touch, int pointer) {
        return false;
    }

    public boolean touchUp(Vector2 touch, int pointer) {
        return false;
    }

    public boolean touchDragged(Vector2 touch, int pointer) {
        return false;
    }

    public void update(float deltaTime) {

    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public void destroy() {
        this.isDestroyed = true;
    }

    public void flushDestroy() {
        this.isDestroyed = false;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }
}
