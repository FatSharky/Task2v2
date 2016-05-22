package by.training.task2.parser.dom;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.training.task2.entity.Food;


public class DOMMenuParser {
	public static Food parse(){
		
		return null;
		
	}
	public static void main(String[] args) throws SAXException, IOException {
		DOMParser parser = new DOMParser();
		parser.parse("Menu.xml");
		Document document = parser.getDocument();
		
		Element root = document.getDocumentElement();
		List<Food> menu = new ArrayList<Food>();
		
		NodeList menuNodes = root.getElementsByTagName("food");
		Food food = null;
		for (int i = 0; i < menuNodes.getLength(); i++) {
			food = new Food();
			Element foodElement = (Element) menuNodes.item(i);
			food.setId(foodElement.getAttribute("ID"));
			food.setPhoto(getSingleChild(foodElement, "photo").getTextContent().trim());
			food.setType(getSingleChild(foodElement, "type").getTextContent().trim());
			food.setName(getSingleChild(foodElement, "name").getTextContent().trim());
			food.setDescription(getSingleChild(foodElement, "description").getTextContent().trim());
			food.setPortion(getSingleChild(foodElement, "portion").getTextContent().trim());
			food.setPrice(Integer.parseInt(getSingleChild(foodElement, "price").getTextContent().trim()));
			menu.add(food);
		}
		for (Food f:menu) {
			System.out.println("id="+f.getId()+
							"\nтип="+ f.getType()+
							"\nназвание="+f.getName()+
							"\nфото= "+f.getPhoto()+
							"\nописание="+f.getDescription()+
							"\nпорция="+f.getPortion()+
							"\nцена="+f.getPrice()+"\n");
			
		}

	}
	private static Element getSingleChild(Element element, String childName){
		NodeList nlist= element.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child;
	}

}
