package com.ivo.dao;

import com.ivo.domain.FollowUpRequisition;

public interface IFollowUpRequisitionDao {
	void saveFollowUpRequisition(FollowUpRequisition followUpRequisition);
	
	FollowUpRequisition findFollowUpRequisitionById(Long id);
	
	void updateFollowUpRequisition(FollowUpRequisition followUpRequisition);
	
	void deleteFollowUpRequisition(Long id);
}
