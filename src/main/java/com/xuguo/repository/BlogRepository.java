package com.xuguo.repository;

import com.xuguo.model.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xuxu on 12/3/16.
 */
@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Integer> {

}
