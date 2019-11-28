package cn.sp.appinfo.dao;

import org.apache.ibatis.annotations.Param;

import cn.sp.appinfo.entity.DevUser;

public interface DevUserDao {
	//根据用户名和密码获得开发信息
	public DevUser getByDevCodeAndDevPassword(@Param("devCode") String devCode,@Param("devPassword") String devPassword);
	
}
