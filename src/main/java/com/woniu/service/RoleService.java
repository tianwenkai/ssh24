package com.woniu.service;

import java.util.List;

import com.woniu.pojo.Role;

public interface RoleService {
	
	List<Role> findAll();

	Role findOne(int rid);

}
