package com.woniu.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.woniu.pojo.Role;
import com.woniu.pojo.User;
import com.woniu.service.RoleService;
import com.woniu.service.UserService;
import com.woniu.tools.PageBean;

@Controller // UserAction被Spring进行管理
@Scope("prototype") // 因为spring中管理的Bean默认都是单例，struts中action要求是多例，则做这个配置
public class UserAction {
	// 将IUserService注入
	@Autowired
	private UserService us;
	@Autowired
	private RoleService rs;

	public UserAction() {
		// TODO Auto-generated constructor stub
		System.out.println("UserAction.UserAction()");
	}

	// 声明表单提交的用户对象
	private User user;
	private Role role;
	private PageBean pageBean = new PageBean();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	// 声明转发到页面的list对象
	private List<User> userList;
	private List<Role> roleList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	// 游客注册
	public String save() {
		us.save(user);
		return "success";
	}

	// 登录
	public String login() {
		User loginUser = us.login(user);
		// 判断登录是否成功
		if (loginUser != null) {
			// 将登录用户的信息存入Session
			// HttpSession session = ServletActionContext.getRequest().getSession();
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("loginUser", loginUser);
			return "success";
		}
		return "login";
	}

	// 展示所有用户信息
	public String list() {
		userList = us.findByPage(pageBean);
		return "success";
	}

	// 普通用户修改密码
	public String revisePwd() {
		User u = us.findOne(user.getUid());
		u.setUpwd(user.getUpwd());
		System.out.println(u);
		us.update(u);
		return "success";
	}

	// 管理员操作增加数据页面,将角色信息传递给页面,做下拉菜单
	public String addUserFrom() {
		roleList = rs.findAll();
		return "success";
	}

	// 管理员 添加用户信息,带角色
	public String addUser() {
		role = rs.findOne(role.getRid());
		user.setRole(role);
		us.save(user);
		return "success";
	}

	// 管理员重置密码
	public String resetPwd() {
		user = us.findOne(user.getUid());
		user.setUpwd("888888");
		us.update(user);
		return "success";
	}

	// 管理员修改用户权限页面,做下拉菜单
	public String reviseRoleFrom() {
		roleList = rs.findAll();
		user = us.findOne(user.getUid());
		return "success";
	}

	// 管理员修改用户权限
	public String reviseRole() {
		roleList = rs.findAll();
		user = us.findOne(user.getUid());
		role = rs.findOne(role.getRid());
		user.setRole(role);
		us.update(user);
		return "success";
	}

}
