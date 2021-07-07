package com.lcomputerstudy.example.service;

import java.util.List;

import com.lcomputerstudy.example.domain.Board;
import com.lcomputerstudy.example.domain.Pagination;
import com.lcomputerstudy.example.domain.Search;


public interface BoardService {
	public List<Board> selectBoardList(Pagination pagination);
	
	public Board selectBoardDetail(int bId);
	
	public void deleteBoard(int bId);
	
	public void writeBoard(Board board);

	public void modifyBoard(Board board);
	
	public int getBoards();

}
