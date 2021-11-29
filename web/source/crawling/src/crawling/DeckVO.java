package crawling;

import java.util.ArrayList;

public class DeckVO {

	private String deck;
	private String champ;
	private String gold;
	
	public DeckVO(String deck, String champ, String gold) {
		this.deck = deck;
		this.champ = champ;
		this.gold = gold;
	}
	
	public String getDeck() {
		return deck;
	}
	public void setDeck(String deck) {
		this.deck = deck;
	}
	public String getChamp() {
		return champ;
	}
	public void setChamp(String champ) {
		this.champ = champ;
	}
	public String getGold() {
		return gold;
	}
	public void setGold(String gold) {
		this.gold = gold;
	}
	@Override
	public String toString() {
		return "DeckVO [deck=" + deck + ", champ=" + champ + ", gold=" + gold + "] \n";
	}

}
