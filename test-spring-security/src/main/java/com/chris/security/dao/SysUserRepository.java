package com.chris.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chris.security.domain.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {

	public SysUser findByUsername(String username);

}
