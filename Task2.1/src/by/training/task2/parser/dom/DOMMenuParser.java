package by.training.task2.parser.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.training.task2.entity.Dish;
import by.training.task2.entity.Menu;
import by.training.task2.entity.Kind;
import by.training.task2.entity.interfaces.TagNames;

public class DOMMenuParser implements TagNames {
	private static final String xmlFileURI = "src\\by\\training\\task2\\xml\\Menu.xml";

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

		Menu menu = new Menu();
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(xmlFileURI);

		Element menuElement = document.getDocumentElement();

		 NodeList kindElements = menuElement.getElementsByTagName(KIND_TAG);

		for (int i = 0; i <  kindElements.getLength(); i++) {
			Element kindElement = (Element)  kindElements.item(i);
			Kind kind = new Kind();
			kind.setName(kindElement.getElementsByTagName(KIND_NAME_TAG).item(0).getTextContent());
			menu.addKind(kind);

			NodeList dishElements = kindElement.getElementsByTagName(DISH_TAG);
			for (int j = 0; j < dishElements.getLength(); j++) {
				Element dishElement = (Element) dishElements.item(j);
				Dish dish = new Dish();
				dish.setPhoto(dishElement.getElementsByTagName(PHOTO_TAG).item(0).getTextContent());
				dish.setName(dishElement.getElementsByTagName(NAME_TAG).item(0).getTextContent());
				dish.setDescription(dishElement.getElementsByTagName(DESCRIPTION_TAG).item(0).getTextContent());
				dish.setPortion(dishElement.getElementsByTagName(PORTION_TAG).item(0).getTextContent());
				dish.setPrice(Integer.parseInt(dishElement.getElementsByTagName(PRICE_TAG).item(0).getTextContent()));
				kind.addDish(dish);

			}
		}
		System.out.println("Меню:\n");
		for (Kind type : menu.getKinds()) {
			System.out.println(type.getName());
			for (Dish dish : type.getDishes()) {
				System.out.println("Фото: " + dish.getPhoto() + " Название: " + dish.getName() + " Описание: "
						+ dish.getDescription() + " Порция: " + dish.getPortion() + " Цена: " + dish.getPrice());
			}
		}
	}

}
