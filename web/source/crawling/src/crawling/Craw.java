package crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Craw {

	public static void main(String[] args) {
		ArrayList<DeckVO> dl = new ArrayList<DeckVO>();
		String url = "https://lolchess.gg/meta";
		// 크롤링대상 url지정
		Document doc = null;
		Elements tmp;
		String deck_temp = null;
		String champ_temp = null;
		String gold_temp = null;

		try {
			doc = Jsoup.connect(url).get();

//			Iterator<Element> itr_deck = ele.select("div.guide-meta__deck > div.guide-meta__deck__column.name.mr-3").iterator();
//			Iterator<Element> itr_champ = ele.select("div.guide-meta__deck > div.guide-meta__deck__column.champions.mr-2  ").iterator();
//			Iterator<Element> itr_gold = ele.select("div.guide-meta__deck > div.guide-meta__deck__column.cost.mr-2").iterator();
//			Iterator<Element> itr_item = ele.select("div.guide-meta__deck > div.tft-champion-box > div.tft-items").iterator();
//			while(itr_deck.hasNext()) {
//				System.out.println("추천덱: " + itr_deck.next().text());
//				System.out.println("덱구성: " + itr_champ.next().text());
//				System.out.println("필요 골드: " + itr_gold.next().text());
//				System.out.println("추천 아이템: " + itr_item.next().text());
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements ele = doc.select("div.guide-meta__deck-box");

		for (int i = 0; i < 15; i++) {
			tmp = ele.select("div.guide-meta__deck > div.guide-meta__deck__column.name.mr-3");
			deck_temp = tmp.get(i).text();
			tmp = ele.select("div.guide-meta__deck > div.guide-meta__deck__column.champions.mr-2");
			champ_temp = tmp.get(i).text();
			tmp = ele.select("div.guide-meta__deck > div.guide-meta__deck__column.cost.mr-2");
			gold_temp = tmp.get(i).text();
			dl.add(new DeckVO(deck_temp, champ_temp, gold_temp));
		}
		System.out.println(dl.toString());

	}

}
