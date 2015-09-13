package com.ivo.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ivo.domain.FollowUpRequisition;

@Repository
public class FollowUpRequisitionDaoImpl extends HibernateDaoSupport implements IFollowUpRequisitionDao {

	@Resource
	public void setSessionFacory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	/*保存任务需求单*/
	@Override
	public void saveFollowUpRequisition(FollowUpRequisition followUpRequisition) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(followUpRequisition);
	}

	@Override
	public FollowUpRequisition findFollowUpRequisitionById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateFollowUpRequisition(
			FollowUpRequisition followUpRequisition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFollowUpRequisition(Long id) {
		// TODO Auto-generated method stub

	}

}
