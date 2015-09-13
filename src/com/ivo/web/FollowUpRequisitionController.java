package com.ivo.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ivo.service.IFollowUpRequisitionService;

@Controller
@RequestMapping("/fur")
public class FollowUpRequisitionController extends BaseController{

	private IFollowUpRequisitionService followUpRequisitionService;

	@Resource
	public void setFollowUpRequisitionService(
			IFollowUpRequisitionService followUpRequisitionService) {
		this.followUpRequisitionService = followUpRequisitionService;
	}
	
	public String saveFUR(){
		return "";
	}
	
	
}
