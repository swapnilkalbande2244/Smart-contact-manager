package com.first.firstproj.Repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.first.firstproj.entities.contacts;

public interface ContactRepo extends JpaRepository<contacts,Integer> {
    @Query("from contacts as c where c.user.id =:userid")
    public Page<contacts> findbyuserID(@Param("userid")int cid, Pageable pageable);
}
