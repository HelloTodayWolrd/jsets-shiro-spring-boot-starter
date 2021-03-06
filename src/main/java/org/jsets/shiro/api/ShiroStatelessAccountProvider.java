/*
 * Copyright 2017-2018 the original author(https://github.com/wj596)
 * 
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */
package org.jsets.shiro.api;

import java.util.Set;
import org.apache.shiro.authc.AuthenticationException;

/**
 * 无状态账号信息提供者接口<br>
 * 应用系统实现这个接口为无状态鉴权提供必要的账号信息。
 * 
 * @author wangjie (https://github.com/wj596) 
 * @date 2016年6月24日 下午2:55:15
 */ 
public interface ShiroStatelessAccountProvider {
	/**
	 * 检查账号是否正常
	 * <br>如果返回false或抛出AuthenticationException则不予通过认证
	 * @param account 账号
	 */
	boolean checkAccount(String account) throws AuthenticationException;
	
	/**
	 * 获取客户端的签名私钥
	 * <br>如果客户端没有私钥返回空，则使用全局秘钥
	 * @param account 账号
	 */
	String loadAppKey(String account);
	/**
	 * 根据客户标识加载持有角色
	 * @param account 账号
	 * @return 角色列表
	 */
	
	Set<String> loadRoles(String account);
	
	/**
	 * 根据客户标识加载持有权限
	 * @param account 账号
	 * @return 角色列表
	 */
	Set<String> loadPermissions(String account);	
}