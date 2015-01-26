package com.dglt.bb.service;


import java.util.List;

import com.dglt.comm.base.BaseService;
//3g 营服 流失率
public interface Turnover3GBizcsService  extends BaseService {

	//2g流失率--地域分布显示
	public List getTurnover3GBizcsArea(String period,String profess,String branch,String bizcs ,String productName);
	
	//3GBizcs流失率--曲线显示
	public List getTurnover3GBizcsLine(String period,String profess,String branch,String bizcs,int monthId ,String productName);
	
	//3GBizcs流失率--表格显示
	public List getTurnover3GBizcsForm(String period,String profess,String branch,String bizcs,int monthId ,String productName);
	
}
