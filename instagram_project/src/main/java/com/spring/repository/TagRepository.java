package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.domain.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {

}
