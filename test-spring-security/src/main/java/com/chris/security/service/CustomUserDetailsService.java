package com.chris.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.chris.security.dao.SysUserRepository;
import com.chris.security.domain.SysUser;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private SysUserRepository sysUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		SysUser sysUser = sysUserRepository.findByUsername(username);

		if (sysUser == null) {
			throw new UsernameNotFoundException("Username is not existed!");
		}

		return sysUser;
	}

}
