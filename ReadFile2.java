import java.io.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;

public class ReadFile2 {
    private static int level;

    public static String pathToXml(String path) {
        File directory = new File(path);
        String xml = "\n" + "<directory name = " + "\"" + directory.getName() + "\"" + ">";

        for (File fileEntry : directory.listFiles()) {
            if (fileEntry.isFile()) {
                xml = xml + "\n" + "\t" + "<file name = " + "\"" + fileEntry.getName() + "\"" + "/>\n";
            } else if (fileEntry.isDirectory()) {
                xml = xml + pathToXml(fileEntry.getAbsolutePath());
            }
        }

        xml = xml + "</directory> \n";
        return xml;

    }

    public static Element xmlToDoc(String xmlString) throws ParserConfigurationException, SAXException, IOException {

        String xmlStr = "<?xml version=\"1.0\"?>" + xmlString;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        StringBuilder xmlStringBuilder = new StringBuilder();
        xmlStringBuilder.append(xmlStr);
        ByteArrayInputStream input = new ByteArrayInputStream(xmlStringBuilder.toString().getBytes("UTF-8"));
        Document doc = builder.parse(input);
        Element element = doc.getDocumentElement();

        return element;

    }

    public static Component InitialilseComponent(Element e) {

        Directory folder = new Directory(e.getAttribute("name"), level);
        NodeList nodes = e.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) nodes.item(i);
                if (el.getNodeName().equals("name")) {
                    Component file = new File2(el.getNodeName(), folder.getLevel() + 1);
                    folder.add(file);
                } else if (el.getNodeName().equals("directory")) {
                    level = folder.getLevel() + 1;
                    folder.add(InitialilseComponent(el));
                    level--;
                }
            }
        }

        return folder;
    }

}