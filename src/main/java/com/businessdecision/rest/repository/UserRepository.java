/**
 * 
 */
package com.businessdecision.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.businessdecision.rest.domain.User;

/**
 * @author bernard.adanlessossi
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	//
}
