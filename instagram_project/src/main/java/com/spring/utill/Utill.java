package com.spring.utill;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.spring.domain.Images;
import com.spring.domain.Tag;

public class Utill {

public static List<Tag> tagParser(String tags, Images images){
		
		String temp[] = tags.split("#"); //#을 기준으로 문자열을 나눔
		List<Tag> tagList = new ArrayList<>();
		
		int length = temp.length;
		
		for(int i=1; i<length; i++) {
			
			Tag tag = Tag.builder()
					.name(temp[i].trim())
					.image(images)
					.build();
		
			tagList.add(tag);
		}
		
		return tagList;
	}
	
}
