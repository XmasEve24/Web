package day07;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test2 {

	// �ֱ� ���� ��ȭ
	// �α� ��ȭ
	// ��������Ʈ
	// ����
	// Ŀ�´�Ƽ
	// ���� �ȼ�
	// 1. �� ũ�Ѹ�
	// 2. DB�� ����
	// 3. DB�� ����� ������ Java���� console�� ���
	public static void main(String[] args) {
		
		String url="https://lolchess.gg/meta";
		// ũ�Ѹ���� url����
		
		try {
			Document doc = Jsoup.connect(url).get();
			System.out.println(doc);
			
			Elements ele = doc.select("h6.title");
//			System.out.println(ele);
			
//			Iterator<Element> itr = ele.select("a > span").iterator();
//			while(itr.hasNext()) {
//				System.out.println(itr.next().text());
//			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
