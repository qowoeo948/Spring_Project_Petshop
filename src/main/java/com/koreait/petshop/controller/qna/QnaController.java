package com.koreait.petshop.controller.qna;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.petshop.model.common.Pager;
import com.koreait.petshop.model.domain.Board;
import com.koreait.petshop.model.domain.Comments;
import com.koreait.petshop.model.qna.service.BoardService;
import com.koreait.petshop.model.qna.service.CommentsService;

@Controller
public class QnaController {

		@Autowired
		private BoardService boardService;
		
		@Autowired
		private CommentsService commentsService;
		
		@Autowired
		private Pager pager;
	
	// board
	
	@RequestMapping(value="/shop/qna/list",method=RequestMethod.GET)
	public ModelAndView getList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("shop/qna/qnalist");
		List boardList = boardService.selectAll();
		pager.init(request, boardList);
		mav.addObject("pager",pager);
		
		return mav;
	}
	
	@RequestMapping(value="/shop/qna/qnaregistForm",method=RequestMethod.GET)
	public ModelAndView getRegistForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shop/qna/qnaregistForm");
		
		return mav;
	}
	
	@PostMapping("/shop/qna/regist")
	public ModelAndView RegistQna(Board board, HttpServletRequest request) {
		boardService.insert(board);
		ModelAndView mav = new ModelAndView("redirect:/shop/qna/list");
		return mav;
	}
	
	@GetMapping("/shop/qna/detail")
	public ModelAndView detailBoard(Board board, HttpServletRequest request) {
		boardService.updateHit(board.getBoard_id());
		ModelAndView mav = new ModelAndView();
		board = boardService.select(board.getBoard_id());
		mav.addObject("board",board);
		mav.setViewName("shop/qna/qnadetail");
		return mav;
	}
	

	
	@PostMapping("/shop/qna/edit")
	public ModelAndView editBoard(Board board, HttpServletRequest request) {
		boardService.update(board);
		ModelAndView mav = new ModelAndView("redirect:/shop/qna/list");
		return mav;
	}
	
	@GetMapping("/shop/qna/delete")
	public String deleteBoard(int board_id, HttpServletRequest request) {
		boardService.delete(board_id);
		return "redirect:/shop/qna/list";
	}
	
	//comment
	@RequestMapping(value="/shop/qna/comments/list",method=RequestMethod.POST, produces="application/json;charset=utf-8")
	@ResponseBody
	public List getCommentsList(int board_id, HttpServletRequest request) {
		List<Comments> commentsList = commentsService.selectAll(board_id);

		return commentsList;
	}
	
	@RequestMapping(value="/shop/qna/comment/regist",method=RequestMethod.POST, produces="text/html;charset=utf8")
	@ResponseBody
	public String CommentRegist(Comments comments, HttpServletRequest request) {
		commentsService.insert(comments);

	      StringBuffer sb = new StringBuffer();
	      sb.append("{");
	      sb.append(" \"result\":1, ");
	      sb.append(" \"msg\":\"회원가입 성공\"");
	      sb.append("}");
	      
	      return sb.toString();
	}
	
	
	
	
}
