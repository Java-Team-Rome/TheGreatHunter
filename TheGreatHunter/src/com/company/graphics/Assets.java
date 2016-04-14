package com.company.graphics;

import java.awt.image.BufferedImage;

import com.company.enums.ImageAlbum;

public class Assets {
	 public static BufferedImage background;
	 public static BufferedImage button;
	 public static SpriteSheet rabbit;
	 public static SpriteSheet duck;
	 public static SpriteSheet fox;
	 public static SpriteSheet wolf;
	 public static SpriteSheet deer;
	 
	 public static void init() {
		 background = ImageLoader.loadImage(ImageAlbum.Background.getPath());
		 
		 button = ImageLoader.loadImage(ImageAlbum.Button.getPath());
		 
		 rabbit = new SpriteSheet(ImageLoader.loadImage(ImageAlbum.Rabbit.getPath()));
		 duck = new SpriteSheet(ImageLoader.loadImage(ImageAlbum.Duck.getPath()));
		 fox = new SpriteSheet(ImageLoader.loadImage(ImageAlbum.Fox.getPath()));
		 wolf = new SpriteSheet(ImageLoader.loadImage(ImageAlbum.Wolf.getPath()));
		 deer = new SpriteSheet(ImageLoader.loadImage(ImageAlbum.Deer.getPath()));
	 }
}
