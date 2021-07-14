package com.lcomputerstudy.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcomputerstudy.example.domain.Board;
import com.lcomputerstudy.example.domain.Comment;
import com.lcomputerstudy.example.domain.Pagination;
import com.lcomputerstudy.example.domain.Search;
import com.lcomputerstudy.example.mapper.BoardMapper;



@Service("BoardServiceImple")
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardMapper;
	
	
	@Override
	public List<Board> selectBoardList(Pagination pagination) {
		return boardMapper.selectBoardList(pagination);
	}


	@Override
	public Board selectBoardDetail(int bId) {
		return boardMapper.selectBoardDetail(bId);
	}
	
	@Override
	public void deleteBoard(int bId){
		boardMapper.deleteBoard(bId);
	}
	
	@Override
	public void writeBoard(Board board) {
		boardMapper.writeBoard(board);
	}


	@Override
	public void modifyBoard(Board board) {
		boardMapper.modifyBoard(board);
		
	};
	
	public int getBoards(Search search) {
		return boardMapper.getBoards(search);
	};
	
	@Override
	public void writeComment(Comment comment) {
		boardMapper.writeComment(comment);
	}
	
	
	

}
