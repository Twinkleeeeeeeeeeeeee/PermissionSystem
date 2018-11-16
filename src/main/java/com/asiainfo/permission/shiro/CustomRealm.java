package com.asiainfo.permission.shiro;

import com.asiainfo.permission.domain.Permission;
import com.asiainfo.permission.domain.User;
import com.asiainfo.permission.domain.UserVo;
import com.asiainfo.permission.service.PermissionService;
import com.asiainfo.permission.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CustomRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;

	@Autowired
	private PermissionService permissionService;
	/**
	 * 设置realm的名称
	 * @return
	 */
	@Override
	public String getName() {
		return "customRealm";
	}
	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		UserVo userVo = (UserVo)principals.getPrimaryPrincipal();
		List<String> list = permissionService.permissionPerCode(userVo.getId());
		//查到权限数据，返回授权信息(要包括 上边的permissions)
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		//将上边查询到授权信息填充到simpleAuthorizationInfo对象中
		simpleAuthorizationInfo.addStringPermissions(list);
		return simpleAuthorizationInfo;
	}

	/**
	 * 认证的函数
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userCode = (String)token.getPrincipal();
		System.out.println(userCode);
		User user = null;
		try {
			user = userService.getByUserCode(userCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 如果查询不到返回null
		if(user == null){
			return null;
		}
		UserVo userVo = new UserVo();
		userVo.setId(user.getId());
		userVo.setUsercode(user.getUsercode());
		userVo.setUsername(user.getUsername());
		userVo.setPassword(user.getPassword());
		List<Permission> menuList = permissionService.getMenuList(user.getId());
		userVo.setMenuList(menuList);
		userVo.setPermissionPerCode(permissionService.permissionPerCode(user.getId()));
		return new SimpleAuthenticationInfo(userVo,userVo.getPassword(),this.getName());
	}

}
