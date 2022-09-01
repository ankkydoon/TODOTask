package com.dbdemo.demo.repo;

import com.dbdemo.demo.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class NotesRepo implements JpaRepository<Notes,Long> {
}
