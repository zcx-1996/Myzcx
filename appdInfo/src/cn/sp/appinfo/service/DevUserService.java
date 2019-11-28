package cn.sp.appinfo.service;

import org.apache.ibatis.annotations.Param;

import cn.sp.appinfo.entity.DevUser;

public interface DevUserService {
	//根据用户名和密码获得开发信息
	public DevUser Login(@Param("devCode") String devCode,@Param("devPassword") String devPassword);
}
