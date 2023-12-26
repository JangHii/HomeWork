package com.ezen.www.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class BoardDTO {

	private BoardVO bvo;
	private List<FileVO> flist; //list를 대문자로 쓰면안된다. (첫번째 세번째는 가능하지만 두번째는 인지를못한다.)
	
}
