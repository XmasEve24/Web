package crawling;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {

	public static void main(String[] args) {
		String url="https://lolchess.gg/meta";
		// 크롤링대상 url지정
		
		try {
			Document doc = Jsoup.connect(url).get();
//			System.out.println(doc);
			
			Elements ele = doc.select("div.guide-meta__deck-box");
//			System.out.println(ele);
			
			Iterator<Element> itr_deck = ele.select("div.guide-meta__deck > div.guide-meta__deck__column.name.mr-3").iterator();
			Iterator<Element> itr_champ = ele.select("div.guide-meta__deck > div.guide-meta__deck__column.champions.mr-2  ").iterator();
			Iterator<Element> itr_gold = ele.select("div.guide-meta__deck > div.guide-meta__deck__column.cost.mr-2").iterator();
			Iterator<Element> itr_item = ele.select("div.guide-meta__deck > div.tft-champion-box > div.tft-items").iterator();
			
			while(itr_deck.hasNext()) {
				System.out.println("추천덱: " + itr_deck.next().text());
				System.out.println("덱구성: " + itr_champ.next().text());
				System.out.println("필요 골드: " + itr_gold.next().text());
//				System.out.println("추천 아이템: " + itr_item.next().text());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
