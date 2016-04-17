package com.company.graphics;

import java.awt.image.BufferedImage;

import com.company.enums.ImageAlbum;

public class Assets {
	 public static BufferedImage mainMenuBackground;
	 public static BufferedImage marketBackground;
	 public static BufferedImage highscoresBackground;
	 public static BufferedImage gameBackground;
	 public static BufferedImage woodenBackground;
	 
	 public static BufferedImage playButton;
	 public static BufferedImage enterButton;
	 public static BufferedImage exitButton;
	 public static BufferedImage menuButton;
	 public static BufferedImage scoresButton;
	 public static BufferedImage sellButton;
	 
	 public static BufferedImage sight;
	 public static BufferedImage stickyNote;
	 public static SpriteSheet rabbit;
	 public static SpriteSheet duck;
	 public static SpriteSheet fox;
	 public static SpriteSheet wolf;
	 public static SpriteSheet deer;
	 public static SpriteSheet boar;
	 public static SpriteSheet eagle;

    public static void init() {
        gameBackground = ImageLoader.loadImage(ImageAlbum.GameBackground.getPath());
        mainMenuBackground = ImageLoader.loadImage(ImageAlbum.MainMenuBackground.getPath());
        marketBackground = ImageLoader.loadImage(ImageAlbum.MarketBackground.getPath());
        highscoresBackground = ImageLoader.loadImage(ImageAlbum.HighScoresBackground.getPath());
        woodenBackground = ImageLoader.loadImage(ImageAlbum.WoodenBackground.getPath());
        
        playButton = ImageLoader.loadImage(ImageAlbum.PlayButton.getPath());
        enterButton = ImageLoader.loadImage(ImageAlbum.EnterButton.getPath());
        scoresButton = ImageLoader.loadImage(ImageAlbum.ScoresButton.getPath());
        exitButton = ImageLoader.loadImage(ImageAlbum.ExitButton.getPath());
        sellButton = ImageLoader.loadImage(ImageAlbum.SellButton.getPath());
        menuButton = ImageLoader.loadImage(ImageAlbum.MenuButton.getPath());
        
        stickyNote = ImageLoader.loadImage(ImageAlbum.StickyNote.getPath());
        sight = ImageLoader.loadImage(ImageAlbum.Sight.getPath());
        
        rabbit = new SpriteSheet(ImageLoader.loadImage(ImageAlbum.Rabbit.getPath()));
        duck = new SpriteSheet(ImageLoader.loadImage(ImageAlbum.Duck.getPath()));
        fox = new SpriteSheet(ImageLoader.loadImage(ImageAlbum.Fox.getPath()));
        wolf = new SpriteSheet(ImageLoader.loadImage(ImageAlbum.Wolf.getPath()));
        deer = new SpriteSheet(ImageLoader.loadImage(ImageAlbum.Deer.getPath()));
        boar = new SpriteSheet(ImageLoader.loadImage(ImageAlbum.Boar.getPath()));
        eagle = new SpriteSheet(ImageLoader.loadImage(ImageAlbum.Eagle.getPath()));
    }
}
