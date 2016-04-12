package com.company.graphics;

import java.awt.image.BufferedImage;

import com.company.enums.ImageAlbum;

public class Assets {
	 public static BufferedImage background;
	 public static SpriteSheet rabbit;
	 public static SpriteSheet duck;
	 public static SpriteSheet fox;
	 
	 
	 public static void init() {
		 background = ImageLoader.loadImage(ImageAlbum.Background.getPath());
		 rabbit = new SpriteSheet(ImageLoader.loadImage(ImageAlbum.Rabbit.getPath()));
		 duck = new SpriteSheet(ImageLoader.loadImage(ImageAlbum.Duck.getPath()));
		 fox = new SpriteSheet(ImageLoader.loadImage(ImageAlbum.Fox.getPath()));
	 }
}
