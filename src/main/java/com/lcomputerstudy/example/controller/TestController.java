package com.lcomputerstudy.example.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lcomputerstudy.example.domain.Board;
import com.lcomputerstudy.example.domain.Pagination;
import com.lcomputerstudy.example.domain.User;
import com.lcomputerstudy.example.request.JoinRequest;
import com.lcomputerstudy.example.response.ListResponse;
import com.lcomputerstudy.example.service.BoardService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BoardService boardService;
	
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("permitAll")
	public ResponseEntity<?>  userAccess(@RequestParam("page") int page) {
		
		logger.debug("page: " + page);
		
		int boardcount = boardService.getBoards();
		
		Pagination pagination = new Pagination(page,boardcount);
		List<Board> boardList = boardService.selectBoardList(pagination);
//		logger.debug("listboard:" + );
		
		ListResponse<Board> listRes = new ListResponse<>();	
		listRes.setList(boardList);
		listRes.setPagination(pagination);
		return ResponseEntity.ok(listRes);
		
//		return ResponseEntity.ok(boardList);
	}
			
	
//	@GetMapping("/user")
//	@PreAuthorize("permitAll")
//	public ResponseEntity<?>  user(@RequestParam int page) {
//		
//		int boardcount = boardService.getBoards();
//		
//		Pagination pagination = new Pagination(page,boardcount);
//		List<Board> boardList = boardService.selectBoardList();
//		
//		ListResponse<Board> listRes = new ListResponse<>();	
//		listRes.setList(boardList);
//		listRes.setPagination(pagination);
//		
//		return ResponseEntity.ok(listRes);
//	}
	
	
	
//	@GetMapping({"/BoardList"})
//	@PreAuthorize("permitAll")
//	public ResponseEntity<?>  BoardgetList(@RequestParam int page) {
//		
//		int boardcount = boardService.getBoards();
////		Pagination pagination = new Pagination(page, boardcount,search);
//		List<Board> boardList = boardService.selectBoardList();
////		logger.info("boardcount"+boardcount);
//		return ResponseEntity.ok(boardList);
//	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String adminAccess() {
		return "Admin Content.";
	}
	
	@GetMapping("/boardDetail")
	@PreAuthorize("permitAll")
	public ResponseEntity<?>  boardDetail(@RequestParam int bId) {
		
		logger.info("///"+bId);
		
		Board board = boardService.selectBoardDetail(bId);
		return ResponseEntity.ok(board);
	}
	
	
	
	@PostMapping("/boardWrite")
	@PreAuthorize("permitAll")
	public ResponseEntity<?>  boardWrite(@RequestBody Board board) {
		 if (board.getbId() != 0) {
//			  board = new Board();	
//			  board.setB_group(b_group);
			  	
				board.setbOrder(board.getbOrder()+1);
				board.setbDepth(board.getbDepth()+1);
			}
		boardService.writeBoard(board);
		
		return ResponseEntity.ok(board);
	}
	
	
	
	@DeleteMapping("/boardDelete/{bId}")
	@PreAuthorize("permitAll")
	public ResponseEntity<?>  boardDelete(@PathVariable(value = "bId") int bId) {
		
		logger.info("delete"+bId);
		boardService.deleteBoard(bId);
	
		return ResponseEntity.ok(bId);
	}
	
	@GetMapping("/boardModify/{bId}")
	@PreAuthorize("permitAll")
	public ResponseEntity<?>  boardModify(@PathVariable(value = "bId") int bId) {
		
		logger.info("modify"+bId);
		Board board = boardService.selectBoardDetail(bId);
		return ResponseEntity.ok(board);
	}
	
	@PostMapping("/boardModifyProcess")
	@PreAuthorize("permitAll")
	public ResponseEntity<?>  boardModifyProcess(@RequestBody Board board) {
		
		boardService.modifyBoard(board);
		
		return ResponseEntity.ok(board);
	}
	

}
