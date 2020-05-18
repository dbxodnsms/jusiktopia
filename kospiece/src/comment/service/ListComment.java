package comment.service;

import java.util.List;

import dto.FreeCommentVO;

public class ListComment {
	private int total; // 전체 댓글 수
	private int currentPage; // 현재 페이지
	private List<FreeCommentVO> content; //
	private int totalPages;
	private int startPage;
	private int endPage;
	private int page = 10; // 한 화면에 보여지는 페이지 수 (현재 10로 설정)

public ListComment(int total, int pageNo, int size, List<FreeCommentVO> content) {
	this.total = total;
	this.currentPage = pageNo; //사용자가 선택한 페이지를 현재 페이지로 설정(default=1)
	this.content = content;
	
	if(total == 0) {
		totalPages = 0;
		startPage = 0;
		endPage = 0;
	}else {
		totalPages = total / size; //전체 페이지 수 리턴
		if (total % size > 0) {
			totalPages++;
		}
	}
	
	int modVal = currentPage % page; 
	startPage = currentPage / page * page + 1;
	if(modVal ==0) startPage -= page;
	
	endPage = startPage + (page-1);
	if( endPage > totalPages) endPage = totalPages;
}

	public int getTotal() {
		return total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public List<FreeCommentVO> getContent() {
		return content;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getPage() {
		return page;
	}

	public boolean hasNoArticles() {
		return total == 0;
	}

	public boolean hasArticles() {
		return total > 0;
	}
}
