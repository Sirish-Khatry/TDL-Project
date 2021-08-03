package com.qa.tdl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.tdl.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
