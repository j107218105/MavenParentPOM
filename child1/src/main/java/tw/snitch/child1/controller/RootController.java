package tw.snitch.child1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@RequestMapping(value = "/", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	protected String index() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Keyword keyword : keywordRepository.findAll()) {
			stringBuilder.append(keyword.getWord()).append("\n");
		}
		return stringBuilder.toString();
	}
}
