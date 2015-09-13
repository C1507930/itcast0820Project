package com.ivo.service;

import javax.annotation.Resource;

import com.ivo.dao.IFollowUpRequisitionDao;
import com.ivo.domain.FollowUpRequisition;

public class FollowUpRequisitionServiceImpl implements IFollowUpRequisitionService {

	private IFollowUpRequisitionDao followUpRequisitionDao;
	
	@Resource
	public void setFollowUpRequisitionDao(
			IFollowUpRequisitionDao followUpRequisitionDao) {
		this.followUpRequisitionDao = followUpRequisitionDao;
	}


	@Override
	public void saveFollowUpRequisition(FollowUpRequisition followUpRequisition) {
		// TODO Auto-generated method stub
		this.followUpRequisitionDao.saveFollowUpRequisition(followUpRequisition);
	}

}
