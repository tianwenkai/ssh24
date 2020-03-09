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

@Controller // UserAction��Spring���й���
@Scope("prototype") // ��Ϊspring�й����BeanĬ�϶��ǵ�����struts��actionҪ���Ƕ����������������
public class UserAction {
	// ��IUserServiceע��
	@Autowired
	private UserService us;
	@Autowired
	private RoleService rs;

	public UserAction() {
		// TODO Auto-generated constructor stub
		System.out.println("UserAction.UserAction()");
	}

	// �������ύ���û�����
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

	// ����ת����ҳ���list����
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

	// �ο�ע��
	public String save() {
		us.save(user);
		return "success";
	}

	// ��¼
	public String login() {
		User loginUser = us.login(user);
		// �жϵ�¼�Ƿ�ɹ�
		if (loginUser != null) {
			// ����¼�û�����Ϣ����Session
			// HttpSession session = ServletActionContext.getRequest().getSession();
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("loginUser", loginUser);
			return "success";
		}
		return "login";
	}

	// չʾ�����û���Ϣ
	public String list() {
		userList = us.findByPage(pageBean);
		return "success";
	}

	// ��ͨ�û��޸�����
	public String revisePwd() {
		User u = us.findOne(user.getUid());
		u.setUpwd(user.getUpwd());
		System.out.println(u);
		us.update(u);
		return "success";
	}

	// ����Ա������������ҳ��,����ɫ��Ϣ���ݸ�ҳ��,�������˵�
	public String addUserFrom() {
		roleList = rs.findAll();
		return "success";
	}

	// ����Ա ����û���Ϣ,����ɫ
	public String addUser() {
		role = rs.findOne(role.getRid());
		user.setRole(role);
		us.save(user);
		return "success";
	}

	// ����Ա��������
	public String resetPwd() {
		user = us.findOne(user.getUid());
		user.setUpwd("888888");
		us.update(user);
		return "success";
	}

	// ����Ա�޸��û�Ȩ��ҳ��,�������˵�
	public String reviseRoleFrom() {
		roleList = rs.findAll();
		user = us.findOne(user.getUid());
		return "success";
	}

	// ����Ա�޸��û�Ȩ��
	public String reviseRole() {
		roleList = rs.findAll();
		user = us.findOne(user.getUid());
		role = rs.findOne(role.getRid());
		user.setRole(role);
		us.update(user);
		return "success";
	}

}
