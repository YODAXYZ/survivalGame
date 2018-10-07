package com.godworm.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.godworm.game.Main;

public class PreferencesScreen extends MainScreen {
    public PreferencesScreen(Main main) {
        super(main);
    }

    public void show() {
        super.show();
        Skin skin = assetManager.get("skin/craftacular-ui.json", Skin.class);
        Slider musicVolume  = new Slider(0, 100, 1, false, skin);
        Slider soundVolume  = new Slider(0, 100, 1, false, skin);
        TextButton back = new TextButton("Back", skin);
        Table table = new Table(skin);
        table.setBackground("dirt");
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);
        table.pad(120,0,0,0);
        table.add(new Label("Music volume:",skin)).pad(0,0,50,20);
        table.add(musicVolume).width(330).fillX().uniformX().pad(0, 0, 50, 0).row();
        table.pad(50,0,50,0);
        table.add(new Label("Music volume:",skin)).pad(0,0,0,20);
        table.add(soundVolume).width(330).fillX().uniformX().row();
        table.add(back).fillX().uniformX(); // misdirection
        back.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                main.setScreen(new StartingMenuScreen(main));
            }
        });
        

    }


}
