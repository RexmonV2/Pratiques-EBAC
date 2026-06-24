import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class GeradorXML {

    public void gerarXML(List<Cliente> clientes) {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element rootElement = document.createElement("Clientes");
            document.appendChild(rootElement);

            for(int i = 0; i < clientes.size(); i++) {
                Element clienteElement = document.createElement(clientes.get(i).getClass().getSimpleName());
                rootElement.appendChild(clienteElement);

                Element id = document.createElement("ID");
                id.appendChild(document.createTextNode(clientes.get(i).getId()));
                clienteElement.appendChild(id);

                Element nome = document.createElement("Nome");
                nome.appendChild(document.createTextNode(clientes.get(i).getNome()));
                clienteElement.appendChild(nome);

                Element idade = document.createElement("Idade");
                idade.appendChild(document.createTextNode(clientes.get(i).getIdade()));
                clienteElement.appendChild(idade);

                Element empresa = document.createElement("Empresa");
                empresa.appendChild(document.createTextNode(clientes.get(i).getEmpresa()));
                clienteElement.appendChild(empresa);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult gerar = new StreamResult(new File(Arquivo.CAMINHO_PASTA + "/Clientes.xml"));
            transformer.transform(source, gerar);

            StreamResult console = new StreamResult(System.out);
            transformer.transform(source, console);

            System.out.println("\nArquivo XML Exibido e gerado com sucesso na pasta: " + Arquivo.CAMINHO_PASTA);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
