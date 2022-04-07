package kr.ac.kopo.polycms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.polycms.model.Article;
import kr.ac.kopo.polycms.model.ArticleCount;
import kr.ac.kopo.polycms.service.ArticleService;
import kr.ac.kopo.polycms.util.Pager;

@Controller
@RequestMapping("/board/{boardId}/article")
public class ArticleController {
	final String path = "article/";
	
	@Autowired
	ArticleService service;
	
	@RequestMapping("/dummy")
	public String dummy(@PathVariable Long boardId) {
		
		service.dummy(boardId);
		
		return "redirect:list";
	}
	@RequestMapping("/init")
	public String init(@PathVariable Long boardId) {
		service.init(boardId);
		return "redirect:list";
	}
	
	
	@PostMapping("/view/{articleId}")
	@ResponseBody 
	
	public ArticleCount view(@PathVariable Long boardId, @PathVariable Long articleId, @RequestBody ArticleCount item) {
		   //@RequestBody->json->ArticleCount-> 
		item.setBoardId(boardId);
		item.setArticleId(articleId);
		
		service.updateCount(item);
		
		return item;
	   

	}
	
	@GetMapping("/view/{articleId}")
	public String view(@PathVariable Long boardId, @PathVariable Long articleId, Model model) {
		Article item = service.item(boardId, articleId);
	
		model.addAttribute("item", item);
		
		return path + "view";
	}
	
	@GetMapping("/list")
	public String list(@PathVariable Long boardId,Pager pager, Model model) {
		
		List<Article> list = service.list(pager,boardId);
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	@GetMapping("/add")
	public String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	public String add(@PathVariable Long boardId, Article item) {
		System.out.println(item.getContents());
		
		item.setBoardId(boardId);
		
		service.add(item);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{articleId}")
	public String update(@PathVariable Long boardId, @PathVariable Long articleId, Model model) {
		Article item = service.item(boardId, articleId);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	@PostMapping("/update/{articleId}")
	public String update(@PathVariable Long boardId, @PathVariable Long articleId, Article item) {
		item.setBoardId(boardId);
		item.setArticleId(articleId);
		
		service.update(item);
		
		return "redirect:../list";
	}
	
	@GetMapping("delete/{articleId}")
	public String delete(@PathVariable Long boardId, @PathVariable Long articleId) {
		service.delete(boardId, articleId);
		
		return "redirect:../list";
	}
}
