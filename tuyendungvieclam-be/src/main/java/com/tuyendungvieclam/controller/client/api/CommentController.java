package com.tuyendungvieclam.controller.client.api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tuyendungvieclam.common.Constants;
import com.tuyendungvieclam.dto.CommentDTO;
import com.tuyendungvieclam.request.client.comment.CommentRequest;
import com.tuyendungvieclam.response.CommonResponse;
import com.tuyendungvieclam.response.client.comment.CommentInfo;
import com.tuyendungvieclam.service.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping(value = "/api/comment")
	public ResponseEntity<CommonResponse<String>> bookTour(@RequestBody CommentRequest request) {
		CommentDTO commentDTO = commentService.addComment(request);
		CommonResponse<String> response = new CommonResponse<>();
		if (commentDTO == null) {
			response.setMessage(Constants.FAIL);
			response.setData("Them binh laun khong thanh cong!!!");
			return ResponseEntity.ok(response);
		}
		response.setMessage(Constants.SUCCESS);
		response.setData("Them binh luan thanh cong.");
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/api/comment")
	public ResponseEntity<List<CommentInfo>> getAllCommentByNewId(@RequestParam(name = "newId") String newId) {
		List<CommentDTO> commentDTOs = commentService.findAllByNewId(newId);
		List<CommentInfo> result = new ArrayList<>();
		for (CommentDTO commentDTO : commentDTOs) {
			result.add(CommentInfo.copy(commentDTO));
		}
		return ResponseEntity.ok(result);
	}

}
