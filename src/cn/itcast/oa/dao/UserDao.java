package cn.itcast.oa.dao;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.User;

@Deprecated
public interface UserDao extends DaoSupport<User> {

	// List<User> findByNameLike(String namePart);
}
