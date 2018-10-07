package com.godworm.game.screens;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.godworm.game.Main;

public class LoadingScreen extends MainScreen {

    public LoadingScreen(Main main) {
        super(main);
    }

    @Override
    public void show() {
        super.show();
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

}
