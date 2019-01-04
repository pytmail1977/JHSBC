package org.iscas.tj2.pyt.springboot_mybatis.service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.iscas.tj2.pyt.springboot_mybatis.Const;
import org.iscas.tj2.pyt.springboot_mybatis.SceneType;
import org.iscas.tj2.pyt.springboot_mybatis.SubScene;
import org.iscas.tj2.pyt.springboot_mybatis.domain.FuncStatement;
import org.iscas.tj2.pyt.springboot_mybatis.domain.User;
import org.iscas.tj2.pyt.springboot_mybatis.scene_state.State;
import org.iscas.tj2.pyt.springboot_mybatis.scene_state.StateStack;
import org.iscas.tj2.pyt.springboot_mybatis.scene_state.StateTransfer;
import org.iscas.tj2.pyt.springboot_mybatis.util.DbCommonUtil;

/* 2018-11-18
 * 新建一个StateService，将StateTransfer和StateStack都作为它的成员变量
 */
public class StateService {
	//数据库操作对象
	public DbService db = new DbService();
	//状态转移对象
	////2018-11-18 取消StateServiceOnUserLogin（）方法中“并用该状态初始化stateTransfer”的操作，改在StateService声明stateTransfer就进行初始化
	//private StateTransfer stateTransfer = null;	
	private StateTransfer stateTransfer = new StateTransfer();	
	
	
	public StateService() {
		// TODO Auto-generated constructor stub
	}

	//2018-11-17 传入reqContent参数给transferState
	//2018-11-17 将返回值由void改为String
	//public String StateProccedue(String reqContent) {
	//2018-12-07 在参数中增加int idUser
	public String StateProccedue(int idUser,String reqContent) {
		System.out.println("Current state is: "+stateTransfer.stateStacks[idUser].getContext());

		//2018-11-18 原来按空格分为多个子串，取前前三个作为transferState的输入，现改为在第一个空格处将整个串分成两部分，第一部分作为命令，后一部分整体作为参数
/*		String[] strArray = reqContent.split(" ");
		String strOrder = strArray[0];
		String strArg1 = (strArray.length>1?strArray[1]:null);
		String strArg2 = (strArray.length>2?strArray[2]:null);*/
		
		String strOrder = null;
		String strArgs = null;
		int index = reqContent.indexOf(' ');
		if (index>0) {
			strOrder = reqContent.substring(0,reqContent.indexOf(' ')); 
			strArgs = reqContent.substring(reqContent.indexOf(' ')+1); // "tocirah sneab"
		}else {
			//用户只输入了单个词
			strOrder = reqContent;
		}
		
		//2018-11-18 直接从stateTransfer.transferState（）的返回值获取应当返回用户的提示语
		strOrder = strOrder.toLowerCase();
		//2018-12-24不再区分common空间和home空间
		//2018-12-11 如果是home指令，则直接操作
/*		if(stateTransfer.stateStacks[idUser].sizeof() == 1 && strOrder.equals("home")) {
			State state = new State(idUser,Const.tablename_User,1,"用户："+idUser,SceneType.STUser);
			
			stateTransfer.stateStacks[idUser].push(state);	
			return "进入用户空间";
		}*/
		
		//2018-12-14 增加处理，如果是处在属性编辑或函数语句编辑子状态中，就进行相关处理，不进入总的状态机
		//如果是当前处于编辑属性状态
		if(SubScene.SSAttr == stateTransfer.stateStacks[idUser].getCurrentState().getSubState()) {
			String strReturn = substateTransferOfAttr(idUser,reqContent);
			return strReturn;
		}
		
		//如果是当前处于添加函数语句状态
		if(SubScene.SSFuncStatement == stateTransfer.stateStacks[idUser].getCurrentState().getSubState()) {
			String strReturn = substateTransferOfFuncStatement(idUser,reqContent);
			return strReturn;
		}
		
		String strReturn = stateTransfer.transferState(idUser,strOrder, strArgs);
		/*stateTransfer.transferState(reqContent,strOrder, strArg1, strArg2);
		String strReturn = stateTransfer.getNowState().getRespContent();*/
		return strReturn;
	}
	
	
	
	//2018-12-07 此文件一直没有纳入git，导致删除StateServiceOnUserLogin（）函数后，需要手动恢复
	//将返回值由String改为int，让调用者获得用户id，异常情况返回负数
	public int StateServiceOnUserLogin(String fromUserName) {
		
		String strReturn = "获取用户信息失败";
		// 反馈用户信息
		System.out.println("从数据库查询用户信息：---------\n");
		if (null == db) {
			System.out.println("db 是空指针");
			return -1;
		}		
		User user = null;
		user = db.getUserInfo(fromUserName);
		
		int idUser = 0;
		//如果没有查到此用户，就插入一条记录，
		if(null == user) {
			user = new User();
			user.setWeixinId_User(fromUserName);
			db.insertNewUser(user);
			//
			
			
		}
		
		idUser = user.getId_User();
		
		//如果插入失败，就返回
		if(0 == idUser) {
			System.out.println("新增用户失败");
			return -2;
		}
		
		//如果该用户id过大就报错
		if(idUser > Const.maxUserNumber) {
			System.out.println("用户（id="+idUser+"）超出最大用户数%d！"+Const.maxUserNumber);
			System.out.println("用户Id过大，请联系管理员！id="+idUser);
			return -3;
		}
		
		//如果该用户对应的状态栈尚未初始化就初始化
		if(null == stateTransfer.stateStacks[idUser]) {
			stateTransfer.stateStacks[idUser] = new StateStack(Const.maxStackDepth);
			
			//2018-12-10 增加下面两行
/*			State state = new State(Const.UserIdOfAdmin,Const.tablename_User,0,"根用户",SceneType.STCommon);
			stateTransfer.stateStacks[idUser].push(state);
*/			
			//2018-12-11 以上2行改为如下处理
/*			State state = new State(Const.UserIdOfAdmin,Const.tablename_User,0,"根用户",SceneType.STCommon);
			//增加下面判断，如果是管理员用户，在state中做记录
			if(fromUserName.equals(Const.AdminUserWeixinId) ) {
				state.setIsAdmin(true);
			}
			stateTransfer.stateStacks[idUser].push(state);*/
			
			//2018-12-11 以上一段改为如下处理，当用户是admin时，第一个状态节点的场景定为STCommonAdmin
			State state;
			//2018-12-24 不再使用common用户空间，一开始就进入用户根场景
/*			if(fromUserName.equals(Const.AdminUserWeixinId)) {
				state = new State(Const.UserIdOfAdmin,Const.tablename_User,0,"根用户",SceneType.STCommonAdmin);
			}else{
				state = new State(Const.UserIdOfAdmin,Const.tablename_User,0,"根用户",SceneType.STCommonUser);
			}*/
			state = new State(idUser,Const.tablename_User,0,"/",SceneType.STRoot,"");
			
			stateTransfer.stateStacks[idUser].push(state);
		}
		
		//2018-12-10为了在用户退回公共空间后不回因为以下语句再次直接回到用户空间注销以下语句
		/*
		
		//如果用户对应的状态栈为空就把当前状态压入栈		
		if(stateTransfer.stateStacks[idUser].sizeof() == 1 ) {
			State state = new State(idUser,Const.tablename_User,1,"用户："+fromUserName,SceneType.STUser);
			stateTransfer.stateStacks[idUser].push(state);			
		}
		*/
		
				
		return idUser;
				
	}

	//TODO
	private String substateTransferOfAttr(int idUser,String reqContent) {
		State state = stateTransfer.stateStacks[idUser].getCurrentState();
		if(reqContent.equals(":q")) {
			state.setSubState(SubScene.SSNone);
			return "您已退出属性编辑模式";
		}
        DbCommonUtil dbUtil = new DbCommonUtil();
        
		//获取字段序号和字段名
		String strTable = state.getStrTable();
		int intId = state.getIntId();
		String select = "select * from "
				+ strTable
				+ " Where "
				+ Const.mapTableId.get(strTable)
				+ " = ? ;";
		
        List<Object> params1 = new ArrayList<Object>();
        params1.add(intId);
        java.sql.ResultSet result1 = dbUtil.executeQuery(select, params1);
        HashMap<String, String> columnMap = new HashMap<String, String>();
        try {
        	while(result1.next()) {
				for (int i = 0; i < result1.getMetaData().getColumnCount(); i++) {
					columnMap.put(Integer.toString(i), result1.getMetaData().getColumnName(i+1));			
				}//for (int i = 0; i < result.getMetaData().getColumnCount(); i++) {
        	}//while(result.next()) {
        	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//将str从“=”分割为key和value两部分
		String[] strArray = reqContent.split("=");
		String strKey = strArray[0];
		
		//如果是数字且在字段数量范围你就转化为相应的字段名
		Pattern pattern = Pattern.compile("[0-9]*");
		if (pattern.matcher(strArray[0]).matches()) {
			if(Integer.parseInt(strKey) < columnMap.size() )
				strKey = columnMap.get(strKey);
	    }
		
		
		String strValue = (strArray.length>1?strArray[1]:null);
		//String strTable = state.getStrTable();
		//int intId = state.getIntId();
		
        String update = "update "
        		+ strTable
        		+ " set "
        		+ strKey
        		+ " = "
        		+ "?"
        		+ " where "
        		+ Const.mapTableId.get(strTable)
        		+ " = "
        		+ intId
        		+ ";";
        List<Object> params2 = new ArrayList<Object>();
        params2.add(strValue);

        int result2 = dbUtil.executeUpdate(update, params2);
        
        if(result2>0) {
        	return "属性"+strKey+"已被更新为"+strValue;
        }else {
        	return "属性更新失败";
        }
	}
	
	//TODO
	private String substateTransferOfFuncStatement(int idUser,String reqContent) {
		State state = stateTransfer.stateStacks[idUser].getCurrentState();

		if(reqContent == null ) {
			return "未指定语句内容";
		}
		
		if(reqContent.equals(":q")) {
			state.setSubState(SubScene.SSNone);
			return "您已退出函数语句录入模式";
		}
		
		System.out.println("按用户指定的内容增加新的函数语句：");
		FuncStatement funcStatement = new FuncStatement();
		funcStatement.setContentFuncstatement(reqContent);		
		funcStatement.setIdFunction(state.getIntId());
		int ret = db.createFuncStatement(state.getIntId(),funcStatement);
				
		String strReturn = "";		
		if (0 != ret) {
			strReturn = "函数语句创建失败";}
		else {
			int idFuncStatement = funcStatement.getIdFuncstatement();
			strReturn = "函数语句已成功创建" + "函数语句Id：" + idFuncStatement;				
		}	
		return strReturn;
	}
}
