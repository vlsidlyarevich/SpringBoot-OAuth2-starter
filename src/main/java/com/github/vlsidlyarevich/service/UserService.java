package com.github.vlsidlyarevich.service;

import com.github.vlsidlyarevich.domain.User;

import java.util.List;

public interface UserService {

    User create(User object);

    User findByUsername(String userName);

}
