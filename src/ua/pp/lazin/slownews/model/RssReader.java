package ua.pp.lazin.slownews.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Laz on 30.08.2016.
 */
public class RssReader {
    public static void main(String[] args) {

        String url = "http://feeds.bbci.co.uk/news/rss.xml";
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(url);

            document.getDocumentElement().normalize();

            // loop through each item
            NodeList items = document.getElementsByTagName("item");
            for (int i = 0; i < items.getLength(); i++) {
                Node n = items.item(i);
                if (n.getNodeType() != Node.ELEMENT_NODE)
                    continue;
                Element xmlNewsItem = (Element) n;

                NewsItem newsItem = new NewsItem();

                Element titleElem = (Element) xmlNewsItem.getElementsByTagName("title").item(0);
                if (titleElem != null) {
                    newsItem.setTitle(titleElem.getChildNodes().item(0).getNodeValue());
                }

                Element descriptionElem = (Element) xmlNewsItem.getElementsByTagName("description").item(0);
                if (descriptionElem != null) {
                    newsItem.setDescription(descriptionElem.getChildNodes().item(0).getNodeValue());
                }

                Element linkElem = (Element) xmlNewsItem.getElementsByTagName("link").item(0);
                if (linkElem != null) {
                    newsItem.setLink(linkElem.getChildNodes().item(0).getNodeValue());
                }

                Element pubDateElem = (Element) xmlNewsItem.getElementsByTagName("pubDate").item(0);
                if (pubDateElem != null) {
                    newsItem.setPubDate(pubDateElem.getChildNodes().item(0).getNodeValue());
                }

                Element pathToImageElem = (Element) xmlNewsItem.getElementsByTagName("media:thumbnail").item(0);
                if (pathToImageElem != null) {
                    newsItem.setPathToImage(pathToImageElem.getAttribute("url"));
                }
                System.out.println(newsItem.getTitle());
                System.out.println(newsItem.getDescription());
                System.out.println(newsItem.getLink());
                System.out.println(newsItem.getPubDate());
                System.out.println(newsItem.getPathToImage());
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
