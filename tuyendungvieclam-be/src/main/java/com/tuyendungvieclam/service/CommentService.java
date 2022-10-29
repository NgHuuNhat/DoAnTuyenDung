package com.tuyendungvieclam.service;

import java.util.List;
import com.tuyendungvieclam.dto.CommentDTO;
import com.tuyendungvieclam.request.client.comment.CommentRequest;

public interface CommentService {
	
	public CommentDTO addComment(CommentRequest request);
	
	public List<CommentDTO> findAllByNewId(String newId);
	
	

}
