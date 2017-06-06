package com.ysgj.ssm.service;

import java.util.List;

import com.ysgj.ssm.entity.User;

public interface UserService {

	List<User> getUserList(int offset, int limit);

}
