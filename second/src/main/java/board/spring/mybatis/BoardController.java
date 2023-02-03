package board.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	@Autowired
	@Qualifier("boardservice")
	BoardService service;

	@GetMapping("/boardlist")
	public ModelAndView boardlist(
			@RequestParam(required = false, defaultValue = "1") int page) {
		int totalboard = service.getTotalBoard();
		int limit = (page - 1) * 3;
		List<BoardDTO> list = service.getBoardList(limit);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("totalboard", totalboard);
		mv.addObject("list", list);
		mv.setViewName("board/list");
		return mv;
	}
	
	@GetMapping("/oneboard")
	public ModelAndView oneboard(@RequestParam int seq) {
		BoardDTO dto = service.getOneBoard(seq);
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		mv.setViewName("board/oneboard");
		return mv; 
	}
	
	// 게시글 작성으로 이동 -> 구현하기
	@GetMapping("/insertboard")
	public ModelAndView insertboardform(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
}
