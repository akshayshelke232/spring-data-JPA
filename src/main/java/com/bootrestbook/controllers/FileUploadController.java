package com.bootrestbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bootrestbook.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
	{
		System.out.println(file.getOriginalFilename());
		
		try {
			boolean f = fileUploadHelper.uploadFile(file);
			if(f)
			{
				return ResponseEntity.ok("file uploaded successfully !!!");
//				return ResponseEntity.ok();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
