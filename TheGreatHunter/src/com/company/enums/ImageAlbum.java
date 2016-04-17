package com.company.enums;

public enum ImageAlbum {
    GameBackground("/green.jpg"),
    MainMenuBackground("/main-menu.png"),
    MarketBackground("/market.png"),
    HighScoresBackground("/high-scores.png"),
    WoodenBackground("/wood.jpg"),
    Rabbit("/rabbit.png"),
    Duck("/duck.png"),
    Fox("/fox.png"),
    Wolf("/wolf.png"),
    Deer("/deer.png"),
    Boar("/boar.png"),
    Eagle("/eagle.png"),
	Sight("/sight.png"),
	StickyNote("/note.png"),
	PlayButton("/button-play.png"),
	ExitButton("/button-exit.png"),
	EnterButton("/button-enter.png"),
	ScoresButton("/button-scores.png"),
	MenuButton("/button-menu.png"),
	SellButton("/button-sell.png");

    private String path;

    ImageAlbum(String path) {
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
}
