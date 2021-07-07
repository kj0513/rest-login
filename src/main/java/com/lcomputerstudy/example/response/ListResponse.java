package com.lcomputerstudy.example.response;

import java.util.List;

import com.lcomputerstudy.example.domain.Pagination;

public class ListResponse<T> {
	List<T> list;
	Pagination pagination;
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

}
