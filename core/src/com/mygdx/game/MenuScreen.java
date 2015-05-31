package com.mygdx.game;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;



import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import aStar.*;

public class MenuScreen implements Screen{
	

	ShapeRenderer shapeRenderer = new ShapeRenderer();
	private Stage stage;
	private Texture pi1,pi2,pi3,pi4,pi5,pidefault, fundo;
	private Skin skin;
	private SpriteBatch batch;
	Stage stages;
	TextButton button;
	TextButtonStyle textButtonStylePlay, textButtonStyleExit;
	BitmapFont font;
	Skin skins;
	TextureAtlas buttonAtlas;
	Star star = new Star();
	OrthographicCamera camera = new OrthographicCamera(Gdx.app.getGraphics().getWidth(), Gdx.app.getGraphics().getHeight());

	public MenuScreen() throws FileNotFoundException, IOException{
		
		stages = new Stage();
		Gdx.input.setInputProcessor(stages);
		font = new BitmapFont();
		font.setColor(Color.YELLOW);
		skins = new Skin();
		buttonAtlas = new TextureAtlas(Gdx.files.internal("buttons.pack"));
		skins.addRegions(buttonAtlas);
		textButtonStylePlay = new TextButtonStyle();
		textButtonStylePlay.font = font;
		textButtonStylePlay.up = skins.getDrawable("back");
		textButtonStylePlay.down = skins.getDrawable("back");
		textButtonStylePlay.checked = skins.getDrawable("back");
		textButtonStylePlay.over = skins.getDrawable("back");

		textButtonStyleExit = new TextButtonStyle();
		textButtonStyleExit.font = font;
		textButtonStyleExit.up = skins.getDrawable("next");
		textButtonStyleExit.down = skins.getDrawable("next");
		textButtonStyleExit.checked = skins.getDrawable("next");
		textButtonStyleExit.over = skins.getDrawable("next");

		skin = new Skin();
		stage = new Stage();
		batch = new SpriteBatch();
		pi1 = new Texture("Pi1.png");
		pi2 = new Texture("Pi2.png");
		pi3 = new Texture("Pi3.png");
		pi4 = new Texture("Pi4.png");
		pi5 = new Texture("Pi5.png");
		pidefault = new Texture("pi.png");
		fundo = new Texture("FundoMapa.png");
		
		Gdx.input.setInputProcessor(stage);

		final TextButton playButton=new TextButton("",textButtonStylePlay);
		playButton.setPosition(10, 5);
		playButton.setHeight(35);
		playButton.setWidth(102);
		stage.addActor(playButton);

		final TextButton exitButton = new TextButton("",textButtonStyleExit);
		exitButton.setPosition(135,5);
		exitButton.setHeight(35);
		exitButton.setWidth(91);
		stage.addActor(exitButton);

		playButton.addListener( new ClickListener() {              
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Star.decreaseDay();
				try {
					((Game)Gdx.app.getApplicationListener()).setScreen(new MenuScreen());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		});
		exitButton.addListener( new ClickListener() {              
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Star.increaseDay();
				try {
					((Game)Gdx.app.getApplicationListener()).setScreen(new MenuScreen());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		});
	}

	@Override
	public void show() {

	}



	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ShapeRenderer sr = new ShapeRenderer();
	    sr.setColor(Color.RED);
	
	    sr.setProjectionMatrix(camera.combined);
	    sr.begin(ShapeType.Filled);
	    
	    
	   
		batch.begin();
		batch.draw(fundo,0 , 0,Gdx.app.getGraphics().getWidth(),Gdx.app.getGraphics().getHeight());
		font.draw(batch, "Dia "+ Star.getnDays(),  20, 480);
		ArrayList<Node> pathNodes = new ArrayList<Node>();
		pathNodes = Star.getAstar().getPath().getPathNodes();
		
		ArrayList<Node> allNodes = new ArrayList<Node>();
		allNodes = Star.graph.getNodes();
	
		for(int i = 0; i < allNodes.size(); i++){
			Texture Pi;
			for(int h = 0; h < pathNodes.size()-1; h++){
			
			sr.rectLine((pathNodes.get(h).getX()*800)/Star.graph.getBiggerX()-435, (pathNodes.get(h).getY()*450)/Star.graph.getBiggerY()-235,(pathNodes.get(h+1).getX()*800)/Star.graph.getBiggerX()-435, (pathNodes.get(h+1).getY()*450)/Star.graph.getBiggerY()-235, 2);
			}
			if(allNodes.get(i).getImportance() == -5)Pi=pi5;
			else if(allNodes.get(i).getImportance() == -4)Pi=pi4;
			else if(allNodes.get(i).getImportance() == -3)Pi=pi3;
			else if(allNodes.get(i).getImportance() == -2)Pi=pi2;
			else if(allNodes.get(i).getImportance() == -1)Pi=pi1;
			else Pi=pidefault;
			
			batch.draw(Pi,(allNodes.get(i).getX()*800)/Star.graph.getBiggerX() , (allNodes.get(i).getY()*450)/Star.graph.getBiggerY(),30,30);
			font.draw(batch, allNodes.get(i).getName(), (allNodes.get(i).getX()*800)/Star.graph.getBiggerX(),  (allNodes.get(i).getY()*450)/Star.graph.getBiggerY());
			
			
			
		}
		
		batch.end();
		sr.end();
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
		stage.dispose();
		skin.dispose();
	}

}
