package cn.sp.appinfo.service;

import org.apache.ibatis.annotations.Param;

import cn.sp.appinfo.entity.BackendUser;

public interface BackendUserService {
	public BackendUser Login(@Param("userCode")String userCode,@Param("userPassword")String userPassword);
}
