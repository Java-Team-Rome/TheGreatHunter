package com.company.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.company.graphics.Assets;
import com.company.models.Button;
import com.company.models.Hunter;
import com.company.models.Market;
import com.company.utils.Constants;

public class MarketState extends State {

	private Hunter currentHunter;
	public static Button sellButton = new Button(570, 530, Assets.sellButton);
	
	public MarketState(Hunter hunter) {
		this.currentHunter = hunter;
	}
	
	@Override
	public void display(Graphics graphics) {
		graphics.drawImage(Assets.marketBackground, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
		graphics.drawImage(Assets.receipt, 460, 170, null);
		graphics.drawImage(Assets.gold, 380, 380, null);
		
		Font textFont = new Font("Comic Sans MS", Font.ITALIC, 14);
        graphics.setFont(textFont);
        graphics.setColor(Color.black);
		
        graphics.drawString(String.format("%.2fkg. x %.2f$", 
        		this.currentHunter.getInventory().getMeat(), Market.getInstance().getPriceMeatPerUnit()), 
        		565, 274);
        
        graphics.drawString(String.format("%.2fkg. x %.2f$", 
        		this.currentHunter.getInventory().getLeather(), Market.getInstance().getPriceLeatherPerUnit()), 
        		590, 325);
        
        graphics.drawString(String.format("%.2fkg. x %.2f$", 
        		this.currentHunter.getInventory().getFeather(), Market.getInstance().getPriceFeatherPerUnit()), 
        		610, 385);
        
        double totalAmount = this.currentHunter.getInventory().getMeat() * Market.getInstance().getPriceMeatPerUnit() +
        		this.currentHunter.getInventory().getLeather() * Market.getInstance().getPriceLeatherPerUnit() +
        		this.currentHunter.getInventory().getFeather() * Market.getInstance().getPriceFeatherPerUnit();
        
        Font font = new Font("Comic Sans MS", Font.ITALIC, 20);
        graphics.setFont(font);
        graphics.setColor(Color.black);
        
        graphics.drawString(String.format("%.2f$", totalAmount), 617, 472);
        		
        sellButton.display(graphics);
	}

	@Override
	public void update() {
	}
	
	public Hunter getCurrentHunter() {
		return this.currentHunter;
	}
}
