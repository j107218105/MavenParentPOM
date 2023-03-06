package tw.snitch.child2.controller;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.*;
import tw.snitch.entity.Keyword;
import tw.snitch.repository.KeywordRepository;

/**
 *
 * @author	P-C Lin (a.k.a 高科技黑手)
 */
@org.springframework.stereotype.Controller
@RequestMapping("/")
public class RootController {

	@Autowired
	private KeywordRepository keywordRepository;

	@RequestMapping(value = "/", produces = "text/xml;charset=UTF-8")
	protected void index(HttpServletResponse response) throws Exception {
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element documentElement = document.createElement("document");

		for (Keyword keyword : keywordRepository.findAll()) {
			Element keywordElement = document.createElement("keyword");
			keywordElement.setAttribute("id", keyword.getId().toString());
			keywordElement.setTextContent(keyword.getWord());
			documentElement.appendChild(keywordElement);
		}

		document.appendChild(documentElement);
		TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document), new StreamResult(response.getOutputStream()));
	}
}
