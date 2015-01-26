package com.dglt.statement.vo;

public class ReportName1 {
	// 报表ID 3001 本地调度——调度基本台帐报表 对应localDispatchLedger.jspp页面
	public final static String sql_3001 = "select distinct t2.form_no,t1.form_title,t2.bss_customer_name,t1.send_user_id,t2.biz_type,t2.customer_type from t_form_main t1,T_FORM_LOCAL_DISPATCH  t2 where t2.parent_form_id=t1.pk_id";

	public final static String[] arr_3001 = { "form_no", "form_title",
			"bss_customer_name", "send_user_id", "biz_type", "customer_type" };

	// 售前工单查询 3002
	public final static String sql_3002 = "";

	public final static String[] arr_3002 = { "req_type","prcs_Inst_Id", "form_main_id",
			"workitemid", "activityinstid", "form_seq", "send_time",
			"form_title", "assessment_score", "user_name", "partiname",
			"dept_name", "assessment_time", "enum_value_meaning" };
	
public final static String sql_90013 ="select  distinct tfm.req_type,tfm.prcs_inst_id,tfm.pk_id,wi.workitemid,wi.activityinstid,tfm.form_seq,tfld.form_no form_no,tfm.form_title form_title,tfld.bss_customer_name bss_customer_name,ip.user_name applicant,taev1.enum_value_meaning bizType,taev2.enum_value_meaning customerType,tfld.circuit_no ciruit_no,tfld.Wire_Speed wire_speed,tfld.WIRE_SPEED_UNIT wire_speed_unit,tfld.PORTA_TYPE porta_type,tfld.portb_type portb_type,tfld.OTHER_RESOURCE other_resource,tfld.TRANS_RESOURCE_ROUTE trans_resource_route,tfld.trans_resource_circuit trans_resource_circuit,tfld.Trans_Resource trans_resource,tfld.switch_resource switch_resource,tfld.DATA_RESOURCE data_resource,tfld.Disform_Desc disform_desc,tfld.BSS_PRODUCT_NO bss_product_no,tfld.CUSTOMER_ADDRESS customer_address,tfld.CUSTOMER_CONTACT customer_contact from t_form_main tfm,T_FORM_LOCAL_DISPATCH  tfld,info_person ip,T_APP_ENUM_VALUE taev1,T_APP_ENUM_VALUE taev2,wfworkitem wi where tfld.parent_form_id=tfm.pk_id and tfm.send_user_id=ip.user_id and (taev1.enum_item_code(+)='businessType' and taev1.enum_value_num(+)=tfld.biz_type) and(taev2.enum_item_code(+)='customerType' and taev2.enum_value_num(+)=tfld.customer_type) and wi.processinstid=tfm.prcs_inst_id and tfm.form_status!=1 and wi.activitydefid= case when tfld.attribute1 is null then 'DraftActivity' else 'planMakeActivity' end";
	
	
	
public final static String sql_90014 ="select distinct tfm.req_type,tfm.prcs_inst_id,tfm.pk_id,wi.workitemid,wi.activityinstid,tfm.form_seq,tfbd.form_no form_no,tfm.form_title form_title,tc.user_name customer_name,ip.user_name applicant, taev2.enum_value_meaning biztype,taev2.enum_value_meaning customertype,tfbd.circuit_code ciruit_no,tfbd.attribute2 wire_speed,tfbd.attribute2 other_resource,tfbd.attribute2 trans_resource,tfbd.attribute2 switch_resource,tfbd.attribute2 data_resource,tfbd.form_context form_context,tfbd.product_num bss_product_no,tfbd.RELATED_CUSTOMER customer_address,tfbd.tel_num customer_contactfrom from T_FORM_MAIN tfm,T_FORM_BSS_DISA tfbd,t_Form_Customer tfc,t_customer tc,T_APP_ENUM_VALUE taev2,info_person ip,wfworkitem wi where tfm.form_status!=1 and (tfbd.product_type(+)=taev2.enum_value and taev2.enum_item_code(+)='prdCategoryBss') and tfm.send_user_id=ip.user_id and tfc.main_pk_id=tfbd.parent_form_id and tfbd.parent_form_id=tfm.pk_id and tfc.cust_pk_id=tc.pk_id and wi.processinstid=tfm.prcs_inst_id and wi.activitydefid= 'DraftActivity'";


public final static String sql_90016 =
									"select w1.req_type,w1.prcs_inst_id,w1.pk_id,w1.workitemid,w1.activityinstid,w1.form_seq,w1.form_no,w1.form_title,w1.form_type,w1.applicant,w1.send_time,w1.cust_level,taev.enum_value_meaning forms_tatus,w1.user_name participantname,w1.bizType,w1.customer_address,w1.disformType from ("
									+"select w.req_type,w.prcs_inst_id,w.pk_id,w.workitemid,w.activityinstid,w.form_seq,w.form_no,w.form_title,w.form_type,w.applicant,w.send_time,w.cust_level,w.formstatus,ip.user_name,w.bizType,w.customer_address,w.disformType,w.row_id from(select  distinct tfm.req_type,tfm.prcs_inst_id,tfm.pk_id,ww.workitemid,ww.activityinstid,tfm.form_seq,tfld.form_no,tfm.form_title form_title,taev1.enum_value_meaning form_type,ip.user_name applicant,tfm.send_time,tc.cust_level,case when (ww.activitydefid = 'DraftActivity' and ww.currentstate = 10 and ww.partiintype = 'EXE') then '11' else  tfm.form_status end formstatus,case when ww.participantname is null then (select itu.user_id from info_team_user itu where itu.team_id=ww.participantid ) else ww.participantid end participantid,taev2.enum_value_meaning bizType,tfld.CUSTOMER_ADDRESS customer_address,taev3.enum_value_meaning disformType,1 row_id  from t_form_main tfm,T_FORM_LOCAL_DISPATCH  tfld,info_person ip,T_APP_ENUM_VALUE taev1,T_APP_ENUM_VALUE taev2,T_APP_ENUM_VALUE taev3,t_customer tc,t_Form_Customer tfc,WFWIPARTICIPANT ww where tc.pk_id = tfc.cust_pk_id and tfc.main_pk_id=tfm.pk_id and tfld.parent_form_id=tfm.pk_id and  tfm.send_user_id=ip.user_id and  tfm.req_type=taev1.enum_value and (taev2.enum_item_code(+)='businessType'and tfld.biz_type =taev2.enum_value(+) )and(tfld.disform_type(+)=taev3.enum_value and taev3.enum_item_code(+)='disformType') and ww.processinstid = tfm.prcs_inst_id and ((ww.currentstate='10' and ww.partiintype='EXE') or (ww.currentstate='4' and ww.partiintype='GET') )  and 1=1)w,info_person ip where w.participantid=ip.user_id"
									+" union "
									+ "select * FROM (select w.*,row_number() OVER (PARTITION BY w.prcs_inst_id order by workitemid desc) row_id   from"                 
																		+"(select  distinct tfm.req_type,tfm.prcs_inst_id,tfm.pk_id,ww.workitemid,ww.activityinstid,tfm.form_seq,tfld.form_no,tfm.form_title form_title,taev1.enum_value_meaning,  ip.user_name applicant,tfm.send_time,tc.cust_level,case when (ww.activitydefid = 'DraftActivity' and ww.currentstate = 10 and ww.partiintype = 'EXE') then '11' else  tfm.form_status end form_status,null participantname,taev2.enum_value_meaning bizType,tfld.CUSTOMER_ADDRESS customer_address,taev3.enum_value_meaning disformType from t_form_main tfm,T_FORM_LOCAL_DISPATCH  tfld,info_person ip,T_APP_ENUM_VALUE taev1,T_APP_ENUM_VALUE taev2,T_APP_ENUM_VALUE taev3,t_customer tc,t_Form_Customer tfc,wf_h_wiparticipant ww  where tfm.form_status!='1' and tc.pk_id = tfc.cust_pk_id and tfc.main_pk_id=tfm.pk_id and tfld.parent_form_id=tfm.pk_id and  tfm.send_user_id=ip.user_id and  tfm.req_type=taev1.enum_value and (taev2.enum_item_code(+)='businessType'and tfld.biz_type =taev2.enum_value(+) )and(tfld.disform_type(+)=taev3.enum_value and taev3.enum_item_code(+)='disformType') and ww.processinstid = tfm.prcs_inst_id and ww.partiintype='EXE' and (ww.currentstate='12'or ww.currentstate='13') and 1=1) w )where row_id=1"
									+")w1,T_APP_ENUM_VALUE taev where (taev.enum_item_code(+)='reportFormStatus' and w1.formstatus=taev.enum_value(+)) order by w1.form_seq desc";		

  public final static String sql_90015 =
										" select * from ( "
												+" select w1.*,taev5.enum_value_meaning formstatus from ( select w.*,row_number() OVER (PARTITION BY w.processinstid order by w.endtime desc) row_id from ( select distinct tfm.req_type,tfm.prcs_inst_id,tfm.pk_id,wp.workitemid,wp.activityinstid,tfm.form_seq,tfld.form_no,  wp.processinstid, case when((select count(*) from WFWIParticipant wp1 where  wp1.currentstate=10 and wp1.activityinstname  in ('本地调度单提交','调度方案制定','负责人审核','业务管理部门审批','业务管理部门经理审批','集客部领导审批','调度审核','调度审核与反馈') and wp1.processinstid = wp.processinstid)>0) then null else  to_char(wp.endtime,'yyyy-mm-dd hh24:mi:ss') end endtime,tfm.form_title, taev2.enum_value_meaning customertype,taev3.enum_value_meaning bizType,tfld.BSS_PRODUCT_NO product_no, ip.user_name,ip.dept_name, case when (select count(*) from WFWIParticipant wp2 where  wp2.currentstate=10 and wp2.activitydefid = 'DraftActivity' and wp2.partiintype = 'EXE' and  wp2.processinstid=wp.processinstid )>0 then '11' else  tfm.form_status  end form_status,tfm.send_time,(select count(*) from t_form_step tfp where  tfp.opt_type='rejectToStart' and tfp.prcs_inst_id= tfm.prcs_inst_id )  RetsCount     ,case when (   (select count(*) from t_form_step tfp1 where  tfp1.opt_type='rejectToStart' and tfp1.prcs_inst_id = tfm.prcs_inst_id )>0) then tfp.opt_comment  else null    end   reason from t_form_main tfm,info_person ip,WFWIPARTICIPANT wp,t_form_local_dispatch tfld,T_APP_ENUM_VALUE taev2,T_APP_ENUM_VALUE taev3,t_form_step tfp  where  tfm.form_status!=1 and  tfm.prcs_inst_id=tfp.prcs_inst_id  and tfld.parent_form_id=tfm.pk_id and (taev2.enum_item_code(+)='customerType' and taev2.enum_value_num(+)=tfld.customer_type) and (taev3.enum_item_code(+)='businessType' and taev3.enum_value_num(+)=tfld.biz_type) and tfp.opt_type='rejectToStart' and  wp.processinstid = tfm.prcs_inst_id and tfm.send_user_id=ip.user_id   and (wp.currentstate = 10 or wp.currentstate = 12 or wp.currentstate = 13) and wp.partiintype='EXE' and wp.activityinstname  in ('本地调度单提交','调度方案制定','负责人审核','业务管理部门审批','业务管理部门经理审批','集客部领导审批','调度审核','调度审核与反馈','资源使用情况回复')  and 1=1 ) w)w1,T_APP_ENUM_VALUE taev5 where  (taev5.enum_item_code(+)='reportFormStatus' and taev5.enum_value(+)=w1.form_status)and w1.row_id=1 "
												+" union"
												+" select w1.*,taev5.enum_value_meaning formstatus from ( select w.*,row_number() OVER (PARTITION BY w.processinstid order by w.endtime desc) row_id from ( select distinct  tfm.req_type,tfm.prcs_inst_id,tfm.pk_id,wp.workitemid,wp.activityinstid,tfm.form_seq,tfld.form_no,  wp.processinstid, case when((wp.activityinstname  in ('本地调度单提交','调度方案制定','负责人审核','业务管理部门审批','业务管理部门经理审批','集客部领导审批','调度审核','调度审核与反馈') )) then null else  to_char(wp.endtime,'yyyy-mm-dd hh24:mi:ss') end  endtime,tfm.form_title, taev2.enum_value_meaning customertype,taev3.enum_value_meaning bizType,tfld.BSS_PRODUCT_NO product_no, ip.user_name,ip.dept_name, tfm.form_status  form_status,tfm.send_time,0  RetsCount, null  reason from t_form_main tfm,info_person ip,WFWIPARTICIPANT wp,t_form_local_dispatch tfld,T_APP_ENUM_VALUE taev2,T_APP_ENUM_VALUE taev3  where  tfm.form_status!=1 and   tfld.parent_form_id=tfm.pk_id and (taev2.enum_item_code(+)='customerType' and taev2.enum_value_num(+)=tfld.customer_type) and(taev3.enum_item_code(+)='businessType' and  taev3.enum_value_num(+)=tfld.biz_type) and  wp.processinstid = tfm.prcs_inst_id and tfm.send_user_id=ip.user_id   and ( (wp.currentstate = 12 and wp.partiintype='EXE' ))and '13' not in (select wp1.currentstate from WFWIPARTICIPANT wp1 where  wp1.processinstid=wp.processinstid ) and wp.activityinstname  in ('本地调度单提交','调度方案制定','负责人审核','业务管理部门审批','业务管理部门经理审批','集客部领导审批','调度审核','调度审核与反馈','资源使用情况回复') and 1=1  ) w)w1,T_APP_ENUM_VALUE taev5 where  (taev5.enum_item_code(+)='reportFormStatus' and taev5.enum_value(+)=w1.form_status)and w1.row_id=1 "
												+" union"
												+" select w1.*,taev5.enum_value_meaning formstatus from ( select w.*,row_number() OVER (PARTITION BY w.processinstid order by w.endtime desc) row_id from ( select distinct  tfm.req_type,tfm.prcs_inst_id,tfm.pk_id,wp.workitemid,wp.activityinstid,tfm.form_seq,tfld.form_no,  wp.processinstid, case when((select count(*) from wf_h_wiparticipant wp1 where  wp1.currentstate=10 and wp1.activityinstname  in ('本地调度单提交','调度方案制定','负责人审核','业务管理部门审批','业务管理部门经理审批','集客部领导审批','调度审核','调度审核与反馈') and wp1.processinstid = wp.processinstid)>0) then null else  to_char(wp.endtime,'yyyy-mm-dd hh24:mi:ss') end endtime,tfm.form_title, taev2.enum_value_meaning customertype,taev3.enum_value_meaning bizType,tfld.BSS_PRODUCT_NO product_no, ip.user_name,ip.dept_name, tfm.form_status  form_status,tfm.send_time,(select count(*) from t_form_step tfp where  tfp.opt_type='rejectToStart' and tfp.prcs_inst_id= tfm.prcs_inst_id )  RetsCount, (select tfp1.opt_comment from t_form_step tfp1 where  tfp1.opt_type='stopProcess' and tfp1.prcs_inst_id = tfm.prcs_inst_id ) reason from t_form_main tfm,info_person ip,wf_h_wiparticipant wp,t_form_local_dispatch tfld,T_APP_ENUM_VALUE taev2,T_APP_ENUM_VALUE taev3,t_form_step tfp  where  tfm.form_status!=1 and tfm.prcs_inst_id=tfp.prcs_inst_id  and tfld.parent_form_id=tfm.pk_id and (taev2.enum_item_code(+)='customerType' and taev2.enum_value_num(+)=tfld.customer_type) and (taev3.enum_item_code(+)='businessType' and taev3.enum_value_num(+)=tfld.biz_type) and tfp.opt_type='stopProcess' and  wp.processinstid = tfm.prcs_inst_id and tfm.send_user_id=ip.user_id  and wp.partiintype='EXE' and wp.activityinstname  in ('本地调度单提交','调度方案制定','负责人审核','业务管理部门审批','业务管理部门经理审批','集客部领导审批','调度审核','调度审核与反馈','资源使用情况回复') and 1=1 and tfm.form_status=4 and (wp.currentstate = 12 or wp.currentstate = 13)) w)w1,T_APP_ENUM_VALUE taev5 where  (taev5.enum_item_code(+)='reportFormStatus' and taev5.enum_value(+)=w1.form_status)and w1.row_id=1 "
												+" union"
												+" select w1.*,taev5.enum_value_meaning formstatus from ( select w.*,row_number() OVER (PARTITION BY w.processinstid order by w.endtime desc) row_id from ( select distinct  tfm.req_type,tfm.prcs_inst_id,tfm.pk_id,wp.workitemid,wp.activityinstid,tfm.form_seq,tfld.form_no,  wp.processinstid, case when((select count(*) from wf_h_wiparticipant wp1 where  wp1.currentstate=10 and wp1.activityinstname  in ('本地调度单提交','调度方案制定','负责人审核','业务管理部门审批','业务管理部门经理审批','集客部领导审批','调度审核','调度审核与反馈') and wp1.processinstid = wp.processinstid)>0) then null else  to_char(wp.endtime,'yyyy-mm-dd hh24:mi:ss') end endtime,tfm.form_title, taev2.enum_value_meaning customertype,taev3.enum_value_meaning bizType,tfld.BSS_PRODUCT_NO product_no, ip.user_name,ip.dept_name, case when (select count(*) from wf_h_wiparticipant wp2 where  wp2.currentstate=10 and wp2.activitydefid = 'DraftActivity' and wp2.partiintype = 'EXE' and  wp2.processinstid=wp.processinstid )>0 then '11' else  tfm.form_status    end form_status,tfm.send_time,(select count(*) from t_form_step tfp where  tfp.opt_type='rejectToStart' and tfp.prcs_inst_id= tfm.prcs_inst_id )  RetsCount     ,case when (  (select count(*) from t_form_step tfp1 where  tfp1.opt_type='rejectToStart' and tfp1.prcs_inst_id = tfm.prcs_inst_id )>0) then tfp.opt_comment else null   end   reason from t_form_main tfm,info_person ip,wf_h_wiparticipant wp,t_form_local_dispatch tfld,T_APP_ENUM_VALUE taev2,T_APP_ENUM_VALUE taev3,t_form_step tfp  where  tfm.form_status!=1 and  tfm.prcs_inst_id=tfp.prcs_inst_id  and tfld.parent_form_id=tfm.pk_id and (taev2.enum_item_code(+)='customerType' and taev2.enum_value_num(+)=tfld.customer_type) and (taev3.enum_item_code(+)='businessType' and taev3.enum_value_num(+)=tfld.biz_type) and  wp.processinstid = tfm.prcs_inst_id and tfm.send_user_id=ip.user_id  and wp.partiintype='EXE' and wp.activityinstname  in ('本地调度单提交','调度方案制定','负责人审核','业务管理部门审批','业务管理部门经理审批','集客部领导审批','调度审核','调度审核与反馈','资源使用情况回复') and 1=1 and tfm.form_status!=4 and  (wp.currentstate = 12 or wp.currentstate = 13)) w)w1,T_APP_ENUM_VALUE taev5 where  (taev5.enum_item_code(+)='reportFormStatus' and taev5.enum_value(+)=w1.form_status)and w1.row_id=1  "
												+" union"
												+" select w1.*,taev5.enum_value_meaning formstatus from ( select w.*,row_number() OVER (PARTITION BY w.processinstid order by w.endtime desc) row_id from ( select distinct tfm.req_type,tfm.prcs_inst_id,tfm.pk_id,wp.workitemid,wp.activityinstid,tfm.form_seq,tfld.form_no,  wp.processinstid, case when((select count(*) from WFWIParticipant wp1 where  wp1.currentstate=10 and wp1.activityinstname  in   ('发单人申请','分管领导/总结审批','集客部审核','国际业务中心审核','一站式系统受阻','BSS系统操作拆机','处理环节','调度数据拆除资源回收')  and wp1.processinstid = wp.processinstid)>0) then null  else  to_char(wp.endtime,'yyyy-mm-dd hh24:mi:ss') end endtime,tfm.form_title, taev3.enum_value_meaning customertype,taev3.enum_value_meaning biztype,tfld.product_num product_no, ip.user_name,ip.dept_name, case when (select count(*) from WFWIParticipant wp2 where  wp2.currentstate=10 and wp2.activitydefid = 'DraftActivity' and wp2.partiintype = 'EXE' and  wp2.processinstid=wp.processinstid )>0 then '11' else  tfm.form_status    end form_status,tfm.send_time,(select count(*) from t_form_step tfp where  tfp.opt_type='rejectToStart' and tfp.prcs_inst_id= tfm.prcs_inst_id )  RetsCount     ,case when (   (select count(*) from t_form_step tfp1 where  tfp1.opt_type='rejectToStart' and tfp1.prcs_inst_id = tfm.prcs_inst_id )>0) then tfp.opt_comment  else null    end    reason from t_form_main tfm,info_person ip,WFWIPARTICIPANT wp,t_form_bss_disa tfld,T_APP_ENUM_VALUE taev2, T_APP_ENUM_VALUE taev3,t_form_step tfp  where  tfm.form_status!=1 and  tfm.prcs_inst_id=tfp.prcs_inst_id and tfld.parent_form_id=tfm.pk_id and  (tfld.product_type=taev2.enum_value(+) and taev2.enum_item_code(+)='prdCategoryBss') and (tfld.product_type(+)=taev3.enum_value and taev3.enum_item_code(+)='prdCategoryBss')  and tfp.opt_type='rejectToStart'  and  wp.processinstid = tfm.prcs_inst_id and tfm.send_user_id=ip.user_id   and (wp.currentstate = 10 or wp.currentstate = 12 or wp.currentstate = 13) and wp.partiintype='EXE' and wp.activityinstname  in  ('发单人申请','分管领导/总监审批','集客部审核','国际业务中心审核','一站式系统受阻','BSS系统操作拆机','处理环节','调度数据拆除资源回收','外线拆除资产回收') and 1=1 ) w)w1,T_APP_ENUM_VALUE taev5 where  (taev5.enum_item_code(+)='reportFormStatus' and taev5.enum_value(+)=w1.form_status)and w1.row_id=1 "
												+" union"
												+" select w1.*,taev5.enum_value_meaning formstatus from ( select w.*,row_number() OVER (PARTITION BY w.processinstid order by w.endtime desc) row_id from ( select distinct  tfm.req_type,tfm.prcs_inst_id,tfm.pk_id,wp.workitemid,wp.activityinstid,tfm.form_seq,tfld.form_no,  wp.processinstid, case when((wp.activityinstname  in   ('发单人申请','分管领导/总结审批','集客部审核','国际业务中心审核','一站式系统受阻','BSS系统操作拆机','处理环节','调度数据拆除资源回收') )) then null  else  to_char(wp.endtime,'yyyy-mm-dd hh24:mi:ss') end endtime,tfm.form_title, taev3.enum_value_meaning customertype,taev3.enum_value_meaning biztype,tfld.product_num product_no,  ip.user_name,ip.dept_name,  tfm.form_status  form_status,tfm.send_time,0  RetsCount, null  reason from t_form_main tfm,info_person ip,WFWIPARTICIPANT wp,t_form_bss_disa tfld,T_APP_ENUM_VALUE taev2,T_APP_ENUM_VALUE taev3 where  tfm.form_status!=1 and   tfld.parent_form_id=tfm.pk_id and  (tfld.product_type=taev2.enum_value(+) and taev2.enum_item_code(+)='prdCategoryBss') and (tfld.product_type(+)=taev3.enum_value and taev3.enum_item_code(+)='prdCategoryBss') and  wp.processinstid = tfm.prcs_inst_id and tfm.send_user_id=ip.user_id   and ( (wp.currentstate = 12 and wp.partiintype='EXE' ))and '13' not in (select wp1.currentstate from WFWIPARTICIPANT wp1 where  wp1.processinstid=wp.processinstid ) and wp.activityinstname  in  ('发单人申请','分管领导/总结审批','集客部审核','国际业务中心审核','一站式系统受阻','BSS系统操作拆机','处理环节','调度数据拆除资源回收','外线拆除资产回收')  and 1=1 ) w)w1,T_APP_ENUM_VALUE taev5 where  (taev5.enum_item_code(+)='reportFormStatus' and taev5.enum_value(+)=w1.form_status)and w1.row_id=1 "
												+" union"
												+"  select w1.*,taev5.enum_value_meaning formstatus from ( select w.*,row_number() OVER (PARTITION BY w.processinstid order by w.endtime desc) row_id from ( select distinct  tfm.req_type,tfm.prcs_inst_id,tfm.pk_id,wp.workitemid,wp.activityinstid,tfm.form_seq,tfld.form_no,  wp.processinstid, case when((select count(*) from wf_h_wiparticipant wp1 where  wp1.currentstate=10 and wp1.activityinstname  in  ('发单人申请','分管领导/总结审批','集客部审核','国际业务中心审核','一站式系统受阻','BSS系统操作拆机','处理环节','调度数据拆除资源回收') and wp1.processinstid = wp.processinstid)>0) then null else  to_char(wp.endtime,'yyyy-mm-dd hh24:mi:ss') end endtime,tfm.form_title, taev3.enum_value_meaning customertype,taev3.enum_value_meaning biztype,tfld.product_num product_no, ip.user_name,ip.dept_name, tfm.form_status  form_status,tfm.send_time,(select count(*) from t_form_step tfp where  tfp.opt_type='rejectToStart' and tfp.prcs_inst_id= tfm.prcs_inst_id )  RetsCount,(select tfp1.opt_comment from t_form_step tfp1 where  tfp1.opt_type='stopProcess' and tfp1.prcs_inst_id = tfm.prcs_inst_id ) reason from t_form_main tfm,info_person ip,wf_h_wiparticipant wp,t_form_bss_disa tfld,T_APP_ENUM_VALUE taev2, T_APP_ENUM_VALUE taev3,t_form_step tfp  where  tfm.form_status!=1 and tfm.prcs_inst_id=tfp.prcs_inst_id  and tfld.parent_form_id=tfm.pk_id and  (tfld.product_type=taev2.enum_value(+) and taev2.enum_item_code(+)='prdCategoryBss') and (tfld.product_type(+)=taev3.enum_value and taev3.enum_item_code(+)='prdCategoryBss') and tfp.opt_type='stopProcess' and  wp.processinstid = tfm.prcs_inst_id and tfm.send_user_id=ip.user_id   and tfm.form_status=4 and wp.partiintype='EXE' and wp.activityinstname  in  ('发单人申请','分管领导/总结审批','集客部审核','国际业务中心审核','一站式系统受阻','BSS系统操作拆机','处理环节','调度数据拆除资源回收','外线拆除资产回收')  and 1=1 ) w)w1,T_APP_ENUM_VALUE taev5 where  (taev5.enum_item_code(+)='reportFormStatus' and taev5.enum_value(+)=w1.form_status)and w1.row_id=1 "
												+" union"
												+"  select w1.*,taev5.enum_value_meaning formstatus from ( select w.*,row_number() OVER (PARTITION BY w.processinstid order by w.endtime desc) row_id from ( select distinct  tfm.req_type,tfm.prcs_inst_id,tfm.pk_id,wp.workitemid,wp.activityinstid,tfm.form_seq,tfld.form_no,  wp.processinstid, case when((select count(*) from wf_h_wiparticipant wp1 where  wp1.currentstate=10 and wp1.activityinstname  in  ('发单人申请','分管领导/总结审批','集客部审核','国际业务中心审核','一站式系统受阻','BSS系统操作拆机','处理环节','调度数据拆除资源回收') and wp1.processinstid = wp.processinstid)>0) then  null else  to_char(wp.endtime,'yyyy-mm-dd hh24:mi:ss') end endtime,tfm.form_title, taev3.enum_value_meaning customertype,taev3.enum_value_meaning biztype,tfld.product_num product_no, ip.user_name,ip.dept_name, case when (select count(*) from wf_h_wiparticipant wp2 where  wp2.currentstate=10 and wp2.activitydefid = 'DraftActivity' and wp2.partiintype = 'EXE' and  wp2.processinstid=wp.processinstid )>0 then '11' else  tfm.form_status    end form_status,tfm.send_time,(select count(*) from t_form_step tfp where  tfp.opt_type='rejectToStart' and tfp.prcs_inst_id= tfm.prcs_inst_id )  RetsCount     ,case when (   (select count(*) from t_form_step tfp1 where  tfp1.opt_type='rejectToStart' and tfp1.prcs_inst_id = tfm.prcs_inst_id )>0) then tfp.opt_comment  else null   end   reason from t_form_main tfm,info_person ip,wf_h_wiparticipant wp,t_form_bss_disa tfld, T_APP_ENUM_VALUE taev2,T_APP_ENUM_VALUE taev3,t_form_step tfp  where  tfm.form_status!=1 and  tfm.prcs_inst_id=tfp.prcs_inst_id  and tfld.parent_form_id=tfm.pk_id and  (tfld.product_type=taev2.enum_value(+) and taev2.enum_item_code(+)='prdCategoryBss') and (tfld.product_type(+)=taev3.enum_value and taev3.enum_item_code(+)='prdCategoryBss')  and  wp.processinstid = tfm.prcs_inst_id and tfm.send_user_id=ip.user_id   and tfm.form_status!=4 and wp.partiintype='EXE' and wp.activityinstname  in  ('发单人申请','分管领导/总结审批','集客部审核','国际业务中心审核','一站式系统受阻','BSS系统操作拆机','处理环节','调度数据拆除资源回收','外线拆除资产回收')  and 1=1 ) w)w1,T_APP_ENUM_VALUE taev5 where  (taev5.enum_item_code(+)='reportFormStatus' and taev5.enum_value(+)=w1.form_status)and w1.row_id=1 "
												+" ) order by form_seq desc";


	public final static String[] arr_90013 = {"req_type","prcs_Inst_Id","form_main_id","workitemid","activityinstid","form_seq","form_no","form_title","bss_customer_name", 
		"applicant", "biztype", "customertype", "ciruit_no", "wire_speed",  
		"wire_speed_unit","porta_type", "portb_type", "other_resource", 
		"trans_resource_route", "trans_resource_circuit", "trans_resource", 
		"switch_resource", "data_resource", "disform_desc", 
		"bss_product_no", "customer_address", 
		"customer_contact"};
	
	
	
	public final static String[] arr_90014 = {"req_type","prcs_Inst_Id","form_main_id","workitemid","activityinstid","form_seq","form_no","form_title","customer_name", 
		"applicant", "biztype", "customertype", "ciruit_no", "wire_speed",  
		 "other_resource", 
		"trans_resource",
		"switch_resource", "data_resource", "form_context", 
		"bss_product_no", "customer_address", 
		"customer_contact"};
	
	public final static String[] arr_90015 ={"req_type","prcs_Inst_Id","form_main_id","workitemid","activityinstid","form_seq","form_no","processinstid","endtime","form_title","customertype",
		"biztype","product_no","user_name","dept_name","form_status","send_time","retcount", "reason","row_id", "form_status"};
	
	
	public final static String[] arr_90016 ={"req_type","prcs_Inst_Id","form_main_id","workitemid","activityinstid","form_seq","form_no","form_title","form_type",
		"applicant", "send_time", "cust_level","form_status", "participantname", "bizType",
		"customer_address","disformType"};
	
	
	

}
