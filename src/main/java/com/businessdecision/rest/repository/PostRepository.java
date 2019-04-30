/**
 * 
 */
package com.businessdecision.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.businessdecision.rest.domain.Post;

/**
 * @author bernard.adanlessossi
 *
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	//
}
