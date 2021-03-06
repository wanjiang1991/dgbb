package com.dglt.bb.service.impl;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dglt.comm.base.BaseServiceImpl;
import com.dglt.base.util.ClassUtil;
import com.dglt.bb.pojo.SqlPara;
import com.dglt.bb.service.Turnover2GBizcsService;
import com.dglt.bb.service.Turnover2GService;

@Service(value = "Turnover2GBizcsService")
public class Turnover2GBizcsServiceImpl extends BaseServiceImpl implements Turnover2GBizcsService {
	@Override
	public List getTurnover2GBizcsArea(String period, String profess, String branch,
	      String bizcs,String productCode) {
		  Calendar ca = Calendar.getInstance();
	      int year = ca.get(Calendar.YEAR);//获取年份
	      int month=ca.get(Calendar.MONTH)+1;//获取月份
	      int monthId = 0;
	      month--;
	      if(month==0){
    		  year --;
    		  month=12;
    	  }
    	
    	  if (period==null||"".equals(period)){
    		  monthId= year*100+month;
        	 // monthId = 201201;  
    	  }else  {
    		  monthId=Integer.parseInt(period) ; 
    		  
    	  }
    	  
	   //拼接SQL   
		StringBuffer sql = new StringBuffer("");
		sql.append(SqlPara.turnover2gBizcsMap) ;
		sql.append("and t.Month_Id = ");
		sql.append(monthId) ;
		if(profess!=null&&!"".equals(profess)){
			sql.append("and t.Sp_Code = '");
			sql.append(profess) ;	
			sql.append("'");
		}
		if(branch!=null&&!"".equals(branch)){
			sql.append("and t.District_Branch_Code = '");
			sql.append(branch) ;		
			sql.append("'");
	     }
		if(bizcs!=null&&!"".equals(bizcs)){
			sql.append("and t.Busi_Sc_Code = '");
			sql.append(bizcs) ;
			sql.append("'");
		}
		if(productCode!=null&&!"".equals(productCode)){
			sql.append("and t.Product_Code = '");
			sql.append(productCode) ;
			sql.append("'");
		}
		sql.append(" group by t.Busi_Sc_Code,t.Busi_Sc_Name");
		String [] arry = SqlPara.arr12gBizcsMap ;
		List l = this.findByNativeQuery(sql.toString());
		//报表查询，返回数据不是持久化对象时，进行转换
		ArrayList<HashMap> al = ClassUtil.getReturnListArea(l, arry);
		return al;
	}

	@Override
	public List getTurnover2GBizcsForm(String period, String profess, String branch,
			String bizcs, int monthId,String productCode) {
		 Calendar ca = Calendar.getInstance();
	      int year = ca.get(Calendar.YEAR);//获取年份
	      int month=ca.get(Calendar.MONTH)+1;//获取月份
	        monthId = 0;
	      month--;
	      if(month==0){
   		  year --;
   		  month=12;
   	  }
   	
   	  if (period==null||"".equals(period)){
   		  monthId= year*100+month;
   	  }else  {
   		  monthId=Integer.parseInt(period) ; 
   		  
   	  }
   	  
	   //拼接SQL   
		StringBuffer sql = new StringBuffer("");
		sql.append(SqlPara.turnover2gBizcsTabe) ;
		sql.append("and t.Month_Id = ");
		sql.append(monthId) ;
		if(profess!=null&&!"".equals(profess)){
			sql.append("and t.Sp_Code = '");
			sql.append(profess) ;	
			sql.append("'");
		}
		if(branch!=null&&!"".equals(branch)){
			sql.append("and t.District_Branch_Code = '");
			sql.append(branch) ;		
			sql.append("'");
	     }
		if(bizcs!=null&&!"".equals(bizcs)){
			sql.append("and t.Busi_Sc_Code = '");
			sql.append(bizcs) ;
			sql.append("'");
		}
		if(productCode!=null&&!"".equals(productCode)){
			sql.append("and t.Product_Code = '");
			sql.append(productCode) ;
			sql.append("'");
		}
	 	String [] arry = SqlPara.arr12gBizcsTable ;
		List l = this.findByNativeQuery(sql.toString());
		//报表查询，返回数据不是持久化对象时，进行转换
		ArrayList<HashMap> al = ClassUtil.getReturnList(l, arry);
		return al;
	}

	@Override
	public List getTurnover2GBizcsLine(String period, String profess, String branch,
			String bizcs,  int monthId ,String productCode) {
		StringBuffer sql = new StringBuffer("");
		sql.append(SqlPara.turnover2gBizcsLine) ;
		sql.append(" and  MONTH_ID in( ") ;
	    sql.append(ClassUtil.getMonthIdStr(ClassUtil.getMonthId(monthId)));
	    sql.append(") ") ;
	    if(profess!=null&&!"".equals(profess)){
			sql.append("and t.Sp_Code = '");
			sql.append(profess) ;	
			sql.append("'");
		}
		if(branch!=null&&!"".equals(branch)){
			sql.append("and t.District_Branch_Code = '");
			sql.append(branch) ;	
			sql.append("'");
	     }
		if(bizcs!=null&&!"".equals(bizcs)){
			sql.append("and t.Busi_Sc_Code = '");
			sql.append(bizcs) ;
			sql.append("'");
		}
		
		if(productCode!=null&&!"".equals(productCode)){
			sql.append("and t.Product_Code = '");
			sql.append(productCode) ;
			sql.append("'");
		}
		
		sql.append(" group by t.Month_Id,t.Month_Dsc ORDER BY  t.Month_Id ");
        String [] arry = SqlPara.arr12gBizcsLine ;
		System.out.println(sql.toString());
	    List l = this.findByNativeQuery(sql.toString());
        //报表查询，返回数据不是持久化对象时，进行转换
		ArrayList<HashMap> al = ClassUtil.getReturnList(l, arry);
				return al;
	}

}
