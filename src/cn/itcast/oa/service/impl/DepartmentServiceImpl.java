package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class DepartmentServiceImpl extends DaoSupportImpl<Department> implements DepartmentService {

	@Resource
	private SessionFactory sessionFactory;

	public List<Department> findTopList() {
		return sessionFactory.getCurrentSession().createQuery(//
				"FROM Department d WHERE d.parent IS NULL")//
				.list();
	}

	public List<Department> findChildren(Long parentId) {
		return sessionFactory.getCurrentSession().createQuery(//
				"FROM Department d WHERE d.parent.id=?")//
				.setParameter(0, parentId)//
				.list();
	}

	// @Resource
	// private DepartmentDao departmentDao;
	//
	// public void delete(Long id) {
	// departmentDao.delete(id);
	// }
	//
	// public List<Department> findAll() {
	// return departmentDao.findAll();
	// }
	//
	// public Department getById(Long id) {
	// return departmentDao.getById(id);
	// }
	//
	// public void save(Department model) {
	// departmentDao.save(model);
	// }
	//
	// public void update(Department department) {
	// departmentDao.update(department);
	// }

}
