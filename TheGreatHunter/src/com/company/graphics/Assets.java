package com.company.graphics;

import java.awt.image.BufferedImage;

import com.company.enums.ImageAlbum;

public class Assets {
	 public static BufferedImage background;
	 public static SpriteSheet rabbit;
	 
	 
	 public static void init() {
		 background = ImageLoader.loadImage(ImageAlbum.Background.getPath());
		 rabbit = new SpriteSheet(ImageLoader.loadImage(ImageAlbum.Rabbit.getPath()));
	 }
}
