package com.app.dto.board;

import java.util.List;

public class Post {  //게시글

	List<Comment> commentList; //댓글이 여러개
	int boardId; //어떤 게시판에 작성된 글  게시판pk
}

