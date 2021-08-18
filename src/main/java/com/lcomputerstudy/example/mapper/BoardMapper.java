package com.lcomputerstudy.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lcomputerstudy.example.domain.Board;
import com.lcomputerstudy.example.domain.Comment;
import com.lcomputerstudy.example.domain.Pagination;
import com.lcomputerstudy.example.domain.Search;

@Mapper
public interface BoardMapper {
	public List<Board> selectBoardList(Pagination pagination);
	
	public Board selectBoardDetail(int bId);
	
	public void deleteBoard(int bId);
	
	public void writeBoard(Board board);
	
	public void modifyBoard(Board board);
	
	public int getBoards(Search search);
	
	public void writeComment(Comment comment);

	public List<Comment> selectCommentList(Comment comment);

	public void deleteComment(int cId);

	
	
}
