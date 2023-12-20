package com.ezen.www.service;

import org.springframework.stereotype.Service;

import com.ezen.www.repository.CommentDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class CommentServiceImpl implements CommentService{

	private CommentDAO cdao;
}
