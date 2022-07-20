import java.io.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;

public class SamaTree {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        String path = "/Users/raki/Desktop/React";

        String xmlString = ReadFile2.pathToXml(path);
        System.out.println(xmlString);

        Element element = ReadFile2.xmlToDoc(xmlString);

        Component folder = ReadFile2.InitialilseComponent(element);
        folder.show();
    }

}

/*
 * String pathToXml(String path) method that returns the xml code for that path
 * 
 * xmlToDoc(String xmlDoc) that takes de string returned by pathToXml() to
 * create Document object
 * that respect its tree structure
 * 
 * use a Xml parser for help
 */