package org.iscas.tj2.pyt.springboot_mybatis.scene_state;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.iscas.tj2.pyt.springboot_mybatis.Const;
import org.iscas.tj2.pyt.springboot_mybatis.SceneType;
import org.iscas.tj2.pyt.springboot_mybatis.SubScene;
import org.iscas.tj2.pyt.springboot_mybatis.domain.FuncStatement;
import org.iscas.tj2.pyt.springboot_mybatis.domain.FuncVar;
import org.iscas.tj2.pyt.springboot_mybatis.domain.FuncVarItem;
import org.iscas.tj2.pyt.springboot_mybatis.domain.Function;
import org.iscas.tj2.pyt.springboot_mybatis.domain.Project;
import org.iscas.tj2.pyt.springboot_mybatis.domain.Struct;
import org.iscas.tj2.pyt.springboot_mybatis.domain.StructItem;
import org.iscas.tj2.pyt.springboot_mybatis.domain.Type;
import org.iscas.tj2.pyt.springboot_mybatis.domain.Var;
import org.iscas.tj2.pyt.springboot_mybatis.domain.VarItem;
import org.iscas.tj2.pyt.springboot_mybatis.service.DbService;
import org.iscas.tj2.pyt.springboot_mybatis.util.DbCommonUtil;



public class FuncBase {

	//数据库操作对象
	private static DbService db = new DbService();
	
	//数据库通用工具类对象
	private static DbCommonUtil dbUtil = new DbCommonUtil();
	
	
	
	
	public FuncBase() {
		// TODO Auto(StateStack stateStack, String str) {
	}//generated constructor stub
	

	
	//2018-11-17 新增以下内容
	
	//多个场景的共用功能///////////////////////////////////////////////////////////////////////////
	

	/*
	 * 列出此帮助信息
	 * 根据当前状态所属场景从Const类的mapHelpInfo中查找对应的help字符串，设置到当前状态state的的respContent中
	 */
	public static String help(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("help: arg=" + str);
		
		//2018-11-18 修改现有的两个转移处理函数help和pwd，取消对state.respContent的写入
		//state.setRespContent(Const.mapHelpInfo.get(state.getSceneType()));
		//return state.getRespContent();
		
		return "当前位置: " + stateStack.getPwd() + "\n" + Const.mapHelpInfo.get(state.getSceneType());
	}

	public static String pwd(StateStack stateStack, String str) {
		//State state = stateStack.getCurrentState();
		System.out.println("pwd: arg=" + str);
		
		//2018-11-18 修改现有的两个转移处理函数help和pwd，取消对state.respContent的写入
		//state.setRespContent(stateStack.getContext());
		//return state.getRespContent();
		
		//2018-11-18 修改pwd，不使用stateStack.getContext();而使用stateStack.getPwd();
		//return stateStack.getContext();
		
		return stateStack.getPwd();
	}// 显示当前所处的场景

	public static String whoami(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("whoami: arg=" + str);

		String strReturn = state.getStrComment() + "\n";
		String strTable = state.getStrTable();
		int intId = state.getIntId();

		String select = "select * from "
				+ strTable
				+ " Where "
				+ Const.mapTableId.get(strTable)
				+ " = ? ;";
		
        List<Object> params = new ArrayList<Object>();
        params.add(intId);
        java.sql.ResultSet result = dbUtil.executeQuery(select, params);
        
        try {
        	while(result.next()) {
				for (int i = 0; i < result.getMetaData().getColumnCount(); i++) {
					strReturn += result.getMetaData().getColumnName(i+1) + " = ";
					Object objTmp = result.getObject(i+1);
					if(null == objTmp) {
						strReturn += "null" + "\n";
					}else {
						strReturn += objTmp.toString() + "\n";
					}//if(null == objTmp) {
				}//for (int i = 0; i < result.getMetaData().getColumnCount(); i++) {
        	}//while(result.next()) {
        	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "查询属性失败";
		}
    	
		return strReturn;
		
		
	}// 显示当前操作的对象

	public static String attr(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("attr: arg=" + str);
		//将str从“=”分割为key和value两部分
		String[] strArray = str.split("=");
		String strKey = strArray[0];
		String strValue = (strArray.length>1?strArray[1]:null);
		String strTable = state.getStrTable();
		int intId = state.getIntId();
		
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
        List<Object> params = new ArrayList<Object>();
        params.add(strValue);
        int result = dbUtil.executeUpdate(update, params);
        
        if(result>0) {
        	return "属性"+strKey+"已被更新为"+strValue;
        }else {
        	return "属性更新失败";
        }

	}// 修改当前对象的属性
	
	//2018-12-14 新增一个newattr（）函数，只是设置当前状态的子状态为SubScene.SSAttr，并返回一句提示语，请用户直接编辑，输入":q"退出编辑状态
	public static String newattr(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("newAttrForContinueEdit: arg=" + str);
		
		//将当前状态的子状态设置为
		state.setSubState(SubScene.SSAttr);
		return "您已进入属性编辑模式，请逐行以key=value形式修改属性，输入\":q\"退出编辑模式"; 
	}// 进入属性修改模式
	
	public static String dc(StateStack stateStack, String str) {
		
		System.out.println("dc: arg=" + str);
		
		String strReturn = null;
		if(stateStack.sizeof()>1) {
			stateStack.pop();
			State state = stateStack.getCurrentState();
			strReturn = "dc到 "+ state.getSceneType().toString() + ": ";
			strReturn += state.getStrComment() +"\n";
			//2018-12-11 dc后不输出help信息（太乱）
			//strReturn += Const.mapHelpInfo.get(state.getSceneType());
		}else {
			strReturn = "无法进行dc操作，你已经在根路径";
		}
		return strReturn;
	}// 退回到上一层

	//以上是多个场景的共用功能///////////////////////////////////////////////////////////////////////////
	//以下是场景STCommonAdmin所涉及操作，部分为场景STCommonUser所共用///////////////////////////////////////////////////////////////////////////


	public static String clsp(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("clsp: arg=" + str);
				
		System.out.println("查询用户的工程信息：");
		List<Project> projects = db.getProjectsInfoByUserId(Const.UserIdOfAdmin);
		String strReturn = "您的工程:";
		Iterator <Project> iter= projects.iterator();
		int i=0;
		while(iter.hasNext()) {
			i++;
			strReturn += "\n工程"+i+":\n";
			Project proj = iter.next();
			strReturn += "工程id:" + proj.getIdProject() + "; 工程名:"+proj.getNameProject(); 
		}

		return strReturn;
	}// 列出所有project

	public static String clst(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("clst: arg=" + str);
		
		System.out.println("查询用户定义的类型：");
		List<Type> types = db.getTypesInfoByUserId(Const.UserIdOfAdmin);
		String strReturn = "您定义的类型:";
		Iterator <Type> iter= types.iterator();
		int i=0;
		while(iter.hasNext()) {
			i++;
			strReturn += "\n类型"+i+":\n";
			Type type = iter.next();
			strReturn += "类型id:" + type.getIdType() + "; 类型名:"+type.getNameType(); 
		}

		return strReturn;
	}// 列出所有type

	public static String clss(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("lss: arg=" + str);
		
		System.out.println("查询用户定义的结构体：");
		List<Struct> structs = db.getStructsInfoByUserId(Const.UserIdOfAdmin);
		String strReturn = "您定义的结构体:";
		Iterator <Struct> iter= structs.iterator();
		int i=0;
		while(iter.hasNext()) {
			i++;
			strReturn += "\n结构体"+i+":\n";
			Struct struct = iter.next();
			strReturn += "结构体id:" + struct.getIdStruct() + "; 结构体名称:"+struct.getNameStruct(); 
		}

		return strReturn;

	}// 列出所有struct

	public static String ccdp(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("cdp: arg="+str);
		
		if(str == null ) {
			return "未指定参数";
		}
		
		System.out.println("查询用户指定的工程信息：");
		
		try {
			int id = Integer.parseInt(str);
			Project project = db.getProjectByProjectId(id);
			
			//2018-12-03
			//查询相应的dao对象后，先做是否为空的判断
			if (project == null ) {
				return "cd失败，查询不到您指定的对象";			
			}
			
			String strReturn = "进入您的工程:";
			strReturn += "工程id:" + project.getIdProject() + "; 工程名:"+project.getNameProject(); 
			
			int depth = state.getIntDepth();
			State newState = new State(project.getIdProject(),Const.tablebame_Project,depth+1,"工程："+project.getNameProject(),SceneType.STProject);
			stateStack.push(newState);	
			
			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
	}// 进入指定的project

	public static String ccdt(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("ccdt: arg="+str);
		
		if(str == null ) {
			return "未指定参数";
		}
		
		System.out.println("查询用户指定的类型信息：");
		
		try {
			int id = Integer.parseInt(str);
			Type type = db.getTypeByTypeId(id);
			
			//2018-12-03
			//查询相应的dao对象后，先做是否为空的判断
			if (type == null ) {
				return "cd失败，查询不到您指定的对象";			
			}
			
			String strReturn = "进入您的类型:";
			strReturn += "类型id:" + type.getIdType() ; 
			
			int depth = state.getIntDepth();
			State newState = new State(type.getIdType(),Const.tablebame_Type,depth+1,"类型："+type.getIdType(),SceneType.STType);
			stateStack.push(newState);	
			
			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
	}// 进入指定的type

	public static String ccds(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("ccds: arg="+str);
		
		if(str == null ) {
			return "未指定参数";
		}
		
		System.out.println("查询用户指定的结构信息：");
		
		try {
			int id = Integer.parseInt(str);
			Struct struct = db.getStructByStructId(id);
					
			//2018-12-03
			//查询相应的dao对象后，先做是否为空的判断
			if (struct == null ) {
				return "cd失败，查询不到您指定的对象";			
			}
			
			String strReturn = "进入您的结构:";
			strReturn += "结构id:" + struct.getIdStruct() + "; 结构名:" +struct.getNameStruct(); 
			
			int depth = state.getIntDepth();
			State newState = new State(struct.getIdStruct(),Const.tablebame_Struct,depth+1,"结构："+struct.getIdStruct(),SceneType.STStruct);
			stateStack.push(newState);	
			
			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
	}// 进入指定的struct

	
	public static String caddp(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("caddp: arg="+str);
		
		if(str == null ) {
			return "未指定工程名";
		}
		
		System.out.println("按用户指定的工程名增加新的工程：");
		Project project = new Project();
		project.setNameProject(str);
		
		int ret = db.createProject(Const.UserIdOfAdmin,project);
		
		
		String strReturn = "";		
		if (0 != ret) {
			strReturn = "工程创建失败";}
		else {
			int idProject = project.getIdProject();
			strReturn = "工程已成功创建" + "工程Id：" + idProject;				
		}		
		return strReturn;
	}// 新增一个project

	public static String caddt(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("addt: arg="+str);
		if(str == null ) {
			return "未指定类型名";
		}
		System.out.println("按用户指定的类型名增加新的类型：");
		Type type = new Type();
		type.setNameType(str);
		
		int ret = db.createType(Const.UserIdOfAdmin,type);
		
		
		String strReturn = "";		
		if (0 != ret) {
			strReturn = "类型创建失败";}
		else {
			int idType = type.getIdType();
			strReturn = "类型已成功创建" + "类型Id：" + idType;			
		}		
		return strReturn;
	}// 新增一个type

	public static String cadds(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("adds: arg="+str);
		
		if(str == null ) {
			return "未指定结构体名";
		}
		
		System.out.println("按用户指定的结构名增加新的结构：");
		Struct struct = new Struct();
		struct.setNameStruct(str);
		
		int ret = db.createStruct(Const.UserIdOfAdmin,struct);
		
		
		String strReturn = "";		
		if (0 != ret) {
			strReturn = "结构创建失败";}
		else {
			int idStruct = struct.getIdStruct();
			strReturn = "结构已成功创建" + "结构Id：" + idStruct;			
		}		
		return strReturn;
	}// 新增一个struct

	public static String cdelp(StateStack stateStack, String str) {
		System.out.println("delp: arg="+str);
		
		if(str == null ) {
			return "未指定参数";
		}
		
		System.out.println("按用户指定的工程Id删除一个工程：");

		try {
			int id = Integer.parseInt(str);
			int ret = db.deleteProjectByProjectId(id);
			
			
			String strReturn = "";		
			if (0 == ret) {
				strReturn = "工程删除失败；" + "工程Id：" + str;}
			else {
				strReturn = "工程删除成功；" + "工程Id：" + str;	
			}	

			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
	}// 删除一个project

	public static String cdelt(StateStack stateStack, String str) {
		System.out.println("delt: arg="+str);
		
		if(str == null ) {
			return "未指定参数";
		}
		
		System.out.println("按用户指定的类型Id删除一个类型：");

		try {
			int id = Integer.parseInt(str);
			int ret = db.deleteTypeByTypeId(id);
			
			
			String strReturn = "";		
			if (0 == ret) {
				strReturn = "类型删除失败；" + "类型Id：" + str;}
			else {
				strReturn = "类型删除成功；" + "类型Id：" + str;	
			}	

			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
	}// 删除一个type

	public static String cdels(StateStack stateStack, String str) {
	
		System.out.println("dels: arg="+str);
		
		if(str == null ) {
			return "未指定参数";
		}
		
		System.out.println("按用户指定的结构Id删除一个结构：");

		
		try {
			int id = Integer.parseInt(str);
			int ret = db.deleteStructByStructId(id);
			
			
			String strReturn = "";		
			if (0 == ret) {
				strReturn = "结构删除失败；" + "结构Id：" + str;}
			else {
				strReturn = "结构删除成功；" + "结构Id：" + str;	
			}	

			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
	}// 删除一个struct";
	
	public static String cgrant(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("grant: arg=" + str);
				
		if(str == null ) {
			return "未指定参数";
		}
		
		String[] strArray = str.split(" ");
		if(strArray.length<2) {
			return "参数数目不够";
		}

		String strArg1 = strArray[0];// (strArray.length>0?strArray[0]:null);
		String strArg2 = strArray[1];// (strArray.length>1?strArray[1]:null);
		
		int idProject = -1;
		int idUser = -1;
		
		try {
			if(null != strArg1) {
				idUser  = Integer.parseInt(strArg1);
			}
			
			if(null != strArg2) {
				idProject  = Integer.parseInt(strArg2);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数格式不正确";
					
		}
		
		if(idUser <0 || idProject<0) {
			return "参数格式不正确";
		}
		
		Project  project = db.getProjectByProjectId(idProject);
		if(null == project) {
			return "指定工程不存在";
		}
		
		System.out.println("指定工程存在，id="+project.getIdProject());
		
		System.out.println("查询用户创建（非仅被授权）的工程信息：");
		List<Project> projects = db.getSelfCreatedProjectsInfoByUserId(Const.UserIdOfAdmin);
		

		boolean hasProj = false;
		Iterator <Project> iter= projects.iterator();
		int i=0;
		while(iter.hasNext()) {
			i++;
			Project proj = iter.next();
			if(idProject == proj.getIdProject()) {
				hasProj = true;
				break;
			}
		}
		
		if(! hasProj) {
			return "您对指定的工程"+idProject+"没有权限";
		}
		
		int ret = db.grantProjectToUser(idUser,idProject);
		if (ret == 0 ) {
			return "已将工程："+idProject+"授予用户"+idUser;
		}else {
			return "授权失败";
		}
	}// 列出所有project
	
	
/*	public static String my(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("my: arg="+str);
		
		
		System.out.println("查询用户指定的函数语句信息：");
		
		FuncStatement funcStatement;
		try {
			int id = Integer.parseInt(str);
			funcStatement = db.getFuncStatementByFuncStatementId(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
				
		//2018-12-03
		//查询相应的dao对象后，先做是否为空的判断
		if (funcStatement == null ) {
			return "cd失败，查询不到您指定的对象";			
		}
		
		String strReturn = "进入您的函数语句:";
		strReturn += "函数语句id:" + funcStatement.getIdFuncstatement() + "; 函数语句行号:" +funcStatement.getLinenoFuncstatement();
		
		int depth = state.getIntDepth();
		State newState = new State(funcStatement.getIdFuncstatement(),Const.tablebame_FuncStatement,depth+1,"函数语句："+funcStatement.getIdFuncstatement(),SceneType.STFuncStatement);
		stateStack.push(newState);	
		
		return strReturn;

	}// 进入当前用户
*/	
	
	
	//以上是场景STCommonAdmin所涉及操作，部分为场景STCommonUser所共用///////////////////////////////////////////////////////////////////////////
	//以下是场景STCommonUser所涉及操作///////////////////////////////////////////////////////////////////////////
	public static String clsf(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("clsf: arg=" + str);		
				
		String strReturn = "共用函数:";
		
		System.out.println("查询属于当前用户的工程：");
		int idUser = Const.UserIdOfAdmin;
		List<Project> projects = db.getProjectsInfoByUserId(Const.UserIdOfAdmin);
		
		Iterator <Project> iterProject= projects.iterator();
		int i=0;
		while(iterProject.hasNext()) {
			i++;
			Project proj = iterProject.next();
			int idProject = proj.getIdProject(); 
			System.out.println("查询属于当前用户的函数：");
			List<Function> functions = db.getFunctionsInfoByProjectId(idProject);
			Iterator<Function> iterFunction= functions.iterator();
			int j=0;
			while(iterFunction.hasNext()) {
				j++;
				strReturn += "\n函数"+i+":\n";
				Function function = iterFunction.next();
				strReturn += "函数id:" + function.getIdFunction() + "; 函数名:"+function.getNameFunction(); 
			}
		}

		return strReturn;
	}// 列出共用function
	
	public static String ccdf(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("ccdf: arg="+str);
				
		if(str == null ) {
			return "未指定参数";
		}
		
		System.out.println("查询用户指定的函数信息：");
		
		Function function;
		
		try {
			int id = Integer.parseInt(str);
			function = db.getFunctionByFunctionId(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
		
		//查询相应的dao对象后，先做是否为空的判断
		if (function == null ) {
			return "cd失败，查询不到您指定的对象";			
		}
		
		String strReturn = "进入共用函数:";
		strReturn += "函数id:" + function.getIdFunction() + "; 函数名:" +function.getNameFunction(); 
		
		int depth = state.getIntDepth();
		State newState = new State(function.getIdFunction(),Const.tablebame_Function,depth+1,"函数："+function.getIdFunction(),SceneType.STFunc);
		stateStack.push(newState);	
		
		return strReturn;
	}//进入共用函数
		 
	//以上是场景STCommonUser所涉及操作///////////////////////////////////////////////////////////////////////////
	//以下是场景STUser所涉及操作///////////////////////////////////////////////////////////////////////////


	public static String lsp(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("lsp: arg=" + str);
				
		System.out.println("查询用户的工程信息：");
		List<Project> projects = db.getProjectsInfoByUserId(state.getIntId());
		String strReturn = "您的工程:";
		Iterator <Project> iter= projects.iterator();
		int i=0;
		while(iter.hasNext()) {
			i++;
			strReturn += "\n工程"+i+":\n";
			Project proj = iter.next();
			strReturn += "工程id:" + proj.getIdProject() + "; 工程名:"+proj.getNameProject(); 
		}

		return strReturn;
	}// 列出所有project

	public static String lst(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("lst: arg=" + str);
		
		System.out.println("查询用户定义的类型：");
		List<Type> types = db.getTypesInfoByUserId(state.getIntId());
		String strReturn = "您定义的类型:";
		Iterator <Type> iter= types.iterator();
		int i=0;
		while(iter.hasNext()) {
			i++;
			strReturn += "\n类型"+i+":\n";
			Type type = iter.next();
			strReturn += "类型id:" + type.getIdType() + "; 类型名:"+type.getNameType(); 
		}

		return strReturn;
	}// 列出所有type

	public static String lss(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("lss: arg=" + str);
		
		System.out.println("查询用户定义的结构体：");
		List<Struct> structs = db.getStructsInfoByUserId(state.getIntId());
		String strReturn = "您定义的结构体:";
		Iterator <Struct> iter= structs.iterator();
		int i=0;
		while(iter.hasNext()) {
			i++;
			strReturn += "\n结构体"+i+":\n";
			Struct struct = iter.next();
			strReturn += "结构体id:" + struct.getIdStruct() + "; 结构体名称:"+struct.getNameStruct(); 
		}

		return strReturn;

	}// 列出所有struct

	public static String cdp(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("cdp: arg="+str);
		
		if(str == null ) {
			return "未指定参数";
		}
		
		System.out.println("查询用户指定的工程信息：");
		
		try {
			int id = Integer.parseInt(str);
			Project project = db.getProjectByProjectId(id);
			
			//2018-12-03
			//查询相应的dao对象后，先做是否为空的判断
			if (project == null ) {
				return "cd失败，查询不到您指定的对象";			
			}
			
			String strReturn = "进入您的工程:";
			strReturn += "工程id:" + project.getIdProject() + "; 工程名:"+project.getNameProject(); 
			
			int depth = state.getIntDepth();
			State newState = new State(project.getIdProject(),Const.tablebame_Project,depth+1,"工程："+project.getNameProject(),SceneType.STProject);
			stateStack.push(newState);	
			
			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
	}// 进入指定的project

	public static String cdt(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("cdt: arg="+str);
		
		if(str == null ) {
			return "未指定参数";
		}
		
		System.out.println("查询用户指定的类型信息：");
		
		try {
			int id = Integer.parseInt(str);
			Type type = db.getTypeByTypeId(id);
			
			//2018-12-03
			//查询相应的dao对象后，先做是否为空的判断
			if (type == null ) {
				return "cd失败，查询不到您指定的对象";			
			}
			
			String strReturn = "进入您的类型:";
			strReturn += "类型id:" + type.getIdType() ; 
			
			int depth = state.getIntDepth();
			State newState = new State(type.getIdType(),Const.tablebame_Type,depth+1,"类型："+type.getIdType(),SceneType.STType);
			stateStack.push(newState);	
			
			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
	}// 进入指定的type

	public static String cds(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("cds: arg="+str);
		
		if(str == null ) {
			return "未指定参数";
		}
		
		System.out.println("查询用户指定的结构信息：");
		
		try {
			int id = Integer.parseInt(str);
			Struct struct = db.getStructByStructId(id);
					
			//2018-12-03
			//查询相应的dao对象后，先做是否为空的判断
			if (struct == null ) {
				return "cd失败，查询不到您指定的对象";			
			}
			
			String strReturn = "进入您的结构:";
			strReturn += "结构id:" + struct.getIdStruct() + "; 结构名:" +struct.getNameStruct(); 
			
			int depth = state.getIntDepth();
			State newState = new State(struct.getIdStruct(),Const.tablebame_Struct,depth+1,"结构："+struct.getIdStruct(),SceneType.STStruct);
			stateStack.push(newState);	
			
			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
	}// 进入指定的struct

	
	public static String addp(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("addp: arg="+str);
		
		if(str == null ) {
			return "未指定工程名";
		}
		
		System.out.println("按用户指定的工程名增加新的工程：");
		Project project = new Project();
		project.setNameProject(str);
		
		int ret = db.createProject(state.getIntId(),project);
		
		
		String strReturn = "";		
		if (0 != ret) {
			strReturn = "工程创建失败";}
		else {
			int idProject = project.getIdProject();
			strReturn = "工程已成功创建" + "工程Id：" + idProject;				
		}		
		return strReturn;
	}// 新增一个project

	public static String addt(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("addt: arg="+str);
		if(str == null ) {
			return "未指定类型名";
		}
		System.out.println("按用户指定的类型名增加新的类型：");
		Type type = new Type();
		type.setNameType(str);
		
		int ret = db.createType(state.getIntId(),type);
		
		
		String strReturn = "";		
		if (0 != ret) {
			strReturn = "类型创建失败";}
		else {
			int idType = type.getIdType();
			strReturn = "类型已成功创建" + "类型Id：" + idType;			
		}		
		return strReturn;
	}// 新增一个type

	public static String adds(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("adds: arg="+str);
		
		if(str == null ) {
			return "未指定结构体名";
		}
		
		System.out.println("按用户指定的结构名增加新的结构：");
		Struct struct = new Struct();
		struct.setNameStruct(str);
		
		int ret = db.createStruct(state.getIntId(),struct);
		
		
		String strReturn = "";		
		if (0 != ret) {
			strReturn = "结构创建失败";}
		else {
			int idStruct = struct.getIdStruct();
			strReturn = "结构已成功创建" + "结构Id：" + idStruct;			
		}		
		return strReturn;
	}// 新增一个struct

	public static String delp(StateStack stateStack, String str) {
		System.out.println("delp: arg="+str);
		
		if(str == null ) {
			return "未指定参数";
		}
		
		System.out.println("按用户指定的工程Id删除一个工程：");

		try {
			int id = Integer.parseInt(str);
			int ret = db.deleteProjectByProjectId(id);
			
			
			String strReturn = "";		
			if (0 == ret) {
				strReturn = "工程删除失败；" + "工程Id：" + str;}
			else {
				strReturn = "工程删除成功；" + "工程Id：" + str;	
			}	

			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
	}// 删除一个project

	public static String delt(StateStack stateStack, String str) {
		System.out.println("delt: arg="+str);
		
		if(str == null ) {
			return "未指定参数";
		}
		
		System.out.println("按用户指定的类型Id删除一个类型：");

		try {
			int id = Integer.parseInt(str);
			int ret = db.deleteTypeByTypeId(id);
			
			
			String strReturn = "";		
			if (0 == ret) {
				strReturn = "类型删除失败；" + "类型Id：" + str;}
			else {
				strReturn = "类型删除成功；" + "类型Id：" + str;	
			}	

			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
	}// 删除一个type

	public static String dels(StateStack stateStack, String str) {
	
		System.out.println("dels: arg="+str);
		
		if(str == null ) {
			return "未指定参数";
		}
		
		System.out.println("按用户指定的结构Id删除一个结构：");

		
		try {
			int id = Integer.parseInt(str);
			int ret = db.deleteStructByStructId(id);
			
			
			String strReturn = "";		
			if (0 == ret) {
				strReturn = "结构删除失败；" + "结构Id：" + str;}
			else {
				strReturn = "结构删除成功；" + "结构Id：" + str;	
			}	

			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
	}// 删除一个struct";
	
	public static String grant(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("grant: arg=" + str);
				
		if(str == null ) {
			return "未指定参数";
		}
		
		String[] strArray = str.split(" ");
		if(strArray.length<2) {
			return "参数数目不够";
		}

		String strArg1 = strArray[0];// (strArray.length>0?strArray[0]:null);
		String strArg2 = strArray[1];// (strArray.length>1?strArray[1]:null);
		
		int idProject = -1;
		int idUser = -1;
		
		try {
			if(null != strArg1) {
				idUser  = Integer.parseInt(strArg1);
			}
			
			if(null != strArg2) {
				idProject  = Integer.parseInt(strArg2);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数格式不正确";
					
		}
		
		if(idUser <0 || idProject<0) {
			return "参数格式不正确";
		}
		
		Project  project = db.getProjectByProjectId(idProject);
		if(null == project) {
			return "指定工程不存在";
		}
		
		System.out.println("指定工程存在，id="+project.getIdProject());
		
		System.out.println("查询用户创建（非仅被授权）的工程信息：");
		List<Project> projects = db.getSelfCreatedProjectsInfoByUserId(state.getIntId());
		

		boolean hasProj = false;
		Iterator <Project> iter= projects.iterator();
		int i=0;
		while(iter.hasNext()) {
			i++;
			Project proj = iter.next();
			if(idProject == proj.getIdProject()) {
				hasProj = true;
				break;
			}
		}
		
		if(! hasProj) {
			return "您对指定的工程"+idProject+"没有权限";
		}
		
		int ret = db.grantProjectToUser(idUser,idProject);
		if (ret == 0 ) {
			return "已将工程："+idProject+"授予用户"+idUser;
		}else {
			return "授权失败";
		}
	}// 列出所有project
	
	public static String common(StateStack stateStack, String str) {
		
		System.out.println("common: arg=" + str);
		
		String strReturn = null;
		if(stateStack.sizeof()>1) {
			stateStack.pop();
			State state = stateStack.getCurrentState();
			strReturn = "进入共用空间 ";//+ state.getSceneType().toString() + ": ";
			//2018-12-11 不直接输出help信息
			//strReturn += Const.mapHelpInfo.get(state.getSceneType());
		}else {
			strReturn = "无法操作，你已经在根路径";
		}
		return strReturn;
	}// 进入到公共空间
	
	
	//以上是场景STUser所涉及操作///////////////////////////////////////////////////////////////////////////
	//以下是场景STStruct所涉及操作///////////////////////////////////////////////////////////////////////////

	public static String lssi(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("lssi: arg="+str);
		
		int idStruct = state.getIntId();
				
		System.out.println("查询用户定义的结构体字段：");
		List<StructItem> structItems = db.getStructItemsInfoByStructId(idStruct);
		String strReturn = "您定义的结构体字段:";
		Iterator <StructItem> iter= structItems.iterator();
		int i=0;
		while(iter.hasNext()) {
			i++;
			strReturn += "\n结构体字段"+i+":\n";
			StructItem structItem = iter.next();
			strReturn += "结构体字段id:" + structItem.getIdStructitem() + "; 结构体字段名:"+structItem.getNameStructitem(); 
		}

		return strReturn;
	}// 列出struct item

	public static String cdsi(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("cdsi: arg="+str);
		
		if(str == null ) {
			return "未指定参数";
		}
		
		System.out.println("查询用户指定的结构字段信息：");
		
		try {
			int id = Integer.parseInt(str);
			StructItem structItem = db.getStructItemByStructItemId(id);
					
			//2018-12-03
			//查询相应的dao对象后，先做是否为空的判断
			if (structItem == null ) {
				return "cd失败，查询不到您指定的对象";			
			}
			
			String strReturn = "进入您的结构字段:";
			strReturn += "结构字段id:" + structItem.getIdStructitem() + "; 结构字段名:" +structItem.getNameStructitem(); 
			
			int depth = state.getIntDepth();
			State newState = new State(structItem.getIdStructitem(),Const.tablebame_StructItem,depth+1,"结构字段："+structItem.getIdStructitem(),SceneType.STStructItem);
			stateStack.push(newState);	
			
			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}

	}// 进入struct item

	public static String addsi(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("addsi: arg=" + str);
		
		if(str == null ) {
			return "未指定结构体字段名";
		}
		
		System.out.println("按用户指定的结构字段名增加新的结构字段：");
		StructItem struct = new StructItem();
		struct.setNameStructitem(str);
		struct.setIdStruct(state.getIntId());
		
		int ret = db.createStructItem(struct);
		
		
		String strReturn = "";		
		if (0 != ret) {
			strReturn = "结构字段创建失败";}
		else {
			int idStructItem = struct.getIdStructitem();
			strReturn = "结构字段已成功创建" + "结构字段Id：" + idStructItem;			
		}		
		return strReturn;
	}// 新增struct item

	public static String delsi(StateStack stateStack, String str) {
		//State state = stateStack.getCurrentState();
		System.out.println("delsi: arg="+str);
		
		System.out.println("按用户指定的结构字段Id删除一个结构字段：");

		if(str == null ) {
			return "未指定参数";
		}
		
		try {
			int id = Integer.parseInt(str);
			int ret = db.deleteStructItemByStructItemId(id);
			
			
			String strReturn = "";		
			if (0 == ret) {
				strReturn = "结构字段删除失败；" + "结构字段Id：" + str;}
			else {
				strReturn = "结构字段删除成功；" + "结构字段Id：" + str;	
			}	

			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
	}

	//以上是场景STStruct所涉及操作///////////////////////////////////////////////////////////////////////////
	//以下是场景STStructItem所涉及操作///////////////////////////////////////////////////////////////////////////
	//无操作
	
	//以上是场景STStructItem所涉及操作///////////////////////////////////////////////////////////////////////////
	//以下是场景STType所涉及操作///////////////////////////////////////////////////////////////////////////
	//无操作
	
	//以上是场景STType所涉及操作///////////////////////////////////////////////////////////////////////////
	//以下是场景STProject所涉及操作///////////////////////////////////////////////////////////////////////////
	
	public static String lsf(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("lsf: arg=" + str);		
		
		int idProject = state.getIntId();
				
		System.out.println("查询属于当前工程的函数：");
		List<Function> functions = db.getFunctionsInfoByProjectId(idProject);
		String strReturn = "当前工程的函数:";
		Iterator<Function> iter= functions.iterator();
		int i=0;
		while(iter.hasNext()) {
			i++;
			strReturn += "\n函数"+i+":\n";
			Function function = iter.next();
			strReturn += "函数id:" + function.getIdFunction() + "; 函数名:"+function.getNameFunction(); 
		}

		return strReturn;
	}// 列出function

	public static String lsv(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("lsv: arg=" + str);
		
		int idProject = state.getIntId();
		
		System.out.println("查询属于当前工程的变量：");
		List<Var> vars = db.getVarsInfoByProjectId(idProject);
		String strReturn = "当前工程的变量:";
		Iterator<Var> iter= vars.iterator();
		int i=0;
		while(iter.hasNext()) {
			i++;
			strReturn += "\n变量"+i+":\n";
			Var var = iter.next();
			strReturn += "变量id:" + var.getIdVar() + "; 变量名:"+var.getNameVar(); 
		}

		return strReturn;
	}// 列出全局变量var

	public static String cdf(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("cdf: arg="+str);
		
		
		if(str == null ) {
			return "未指定参数";
		}
		
		System.out.println("查询用户指定的函数信息：");
		
		Function function;
		
		try {
			int id = Integer.parseInt(str);
			function = db.getFunctionByFunctionId(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
				
		//2018-12-03
		//查询相应的dao对象后，先做是否为空的判断
		if (function == null ) {
			return "cd失败，查询不到您指定的对象";			
		}
		
		String strReturn = "进入您的函数:";
		strReturn += "函数id:" + function.getIdFunction() + "; 函数名:" +function.getNameFunction(); 
		
		int depth = state.getIntDepth();
		State newState = new State(function.getIdFunction(),Const.tablebame_Function,depth+1,"函数："+function.getIdFunction(),SceneType.STFunc);
		stateStack.push(newState);	
		
		return strReturn;
	}// 进入function

	public static String cdv(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("cdv: arg="+str);
		
		if(str == null ) {
			return "未指定参数";
		}
		
		System.out.println("查询用户指定的变量信息：");
		
		Var var;
		try {
			int id = Integer.parseInt(str);
			var = db.getVarByVarId(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
				
		//2018-12-03
		//查询相应的dao对象后，先做是否为空的判断
		if (var == null ) {
			return "cd失败，查询不到您指定的对象";			
		}
		
		String strReturn = "进入您的变量:";
		strReturn += "变量id:" + var.getIdVar() + "; 变量名:" +var.getNameVar(); 
		
		int depth = state.getIntDepth();
		State newState = new State(var.getIdVar(),Const.tablebame_Var,depth+1,"变量："+var.getIdVar(),SceneType.STVar);
		stateStack.push(newState);	
		
		return strReturn;

	}// 进入var

	public static String addf(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("addf: arg="+str);
		
		if(str == null ) {
			return "未指定函数名";
		}
		
		System.out.println("按用户指定的函数名增加新的函数：");
		Function function = new Function();
		function.setNameFunction(str);
		
		int ret = db.createFunction(state.getIntId(),function);
		
		
		String strReturn = "";		
		if (0 != ret) {
			strReturn = "函数创建失败";}
		else {
			int idFunction = function.getIdFunction();
			strReturn = "函数已成功创建" + "函数Id：" + idFunction;				
		}	
		return strReturn;
				 
	}// 新增function

	public static String addv(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("addv: arg="+str);
		if(str == null ) {
			return "未指定全局变量名";
		}
		System.out.println("按用户指定的变量名增加新的变量：");
		Var var = new Var();
		var.setNameVar(str);
		
		int ret = db.createVar(state.getIntId(),var);
		
		
		String strReturn = "";		
		if (0 != ret) {
			strReturn = "变量创建失败";}
		else {
			int idVar = var.getIdVar();
			strReturn = "变量已成功创建" + "变量Id：" + idVar;				
		}	
		return strReturn;
	}// 新增var

	public static String delf(StateStack stateStack, String str) {
		//State state = stateStack.getCurrentState();
		System.out.println("delf: arg="+str);

		
		System.out.println("按用户指定的函数Id删除一个函数：");

		if(str == null ) {
			return "未指定参数";
		}
		
		try {
			int id = Integer.parseInt(str);
			int ret = db.deleteFunctionByFunctionId(id);
			
			
			String strReturn = "";		
			if (0 == ret) {
				strReturn = "函数删除失败；" + "函数Id：" + str;}
			else {
				strReturn = "函数删除成功；" + "函数Id：" + str;	
			}	

			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
	}// 删除function

	public static String delv(StateStack stateStack, String str) {
		System.out.println("delv: arg="+str);

		
		System.out.println("按用户指定的变量Id删除一个变量：");

		if(str == null ) {
			return "未指定参数";
		}
		
		try {
			int id = Integer.parseInt(str);
			int ret = db.deleteVarByVarId(id);
			
			
			String strReturn = "";		
			if (0 == ret) {
				strReturn = "变量删除失败；" + "变量Id：" + str;}
			else {
				strReturn = "变量删除成功；" + "变量Id：" + str;	
			}	

			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
	}// 删除var

		
	//以上是场景STProject所涉及操作///////////////////////////////////////////////////////////////////////////
	//以下是场景STFunc所涉及操作///////////////////////////////////////////////////////////////////////////

/*	public static String lsfs(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("lsfs: arg=" + str);
		return null;
	}// 列出函数语句function statement



	public static String cdfs(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("cdfs: arg="+str);
		return null;
	}// 进入指定的函数语句function statement



	public static String addfs(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("addfs: arg="+str);
		return null;
	}// 增加一条函数语句function statement"



	public static String delfs(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("delfs: arg="+str);
		return null;
	}// 删除一条函数语句function statement
*/

	public static String lsfs(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("lsfs: arg=" + str);
		
		int idFunction = state.getIntId();
		
		System.out.println("查询属于当前工程的函数语句：");
		List<FuncStatement> funcStatements = db.getFuncStatementsInfoByFunctionId(idFunction);
		String strReturn = "当前工程的函数语句:";
		Iterator<FuncStatement> iter= funcStatements.iterator();
		int i=0;
		while(iter.hasNext()) {
			i++;
			strReturn += "\n函数语句"+i+":\n";
			FuncStatement funcStatement = iter.next();
			//strReturn += "函数语句id:" + funcStatement.getIdFuncstatement() + "; 函数语句行号:"+funcStatement.getLinenoFuncstatement(); 
			strReturn += "函数语句id:" + funcStatement.getIdFuncstatement() + "; 函数语句:"+funcStatement.getContentFuncstatement(); 
		}

		return strReturn;
	}// 列出全局函数语句funcStatement


	public static String cdfs(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("cdfs: arg="+str);
		
		if(str == null ) {
			return "未指定参数";
		}
		
		System.out.println("查询用户指定的函数语句信息：");
		
		FuncStatement funcStatement;
		try {
			int id = Integer.parseInt(str);
			funcStatement = db.getFuncStatementByFuncStatementId(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
				
		//2018-12-03
		//查询相应的dao对象后，先做是否为空的判断
		if (funcStatement == null ) {
			return "cd失败，查询不到您指定的对象";			
		}
		
		String strReturn = "进入您的函数语句:";
		strReturn += "函数语句id:" + funcStatement.getIdFuncstatement() + "; 函数语句行号:" +funcStatement.getLinenoFuncstatement();
		
		int depth = state.getIntDepth();
		State newState = new State(funcStatement.getIdFuncstatement(),Const.tablebame_FuncStatement,depth+1,"函数语句："+funcStatement.getIdFuncstatement(),SceneType.STFuncStatement);
		stateStack.push(newState);	
		
		return strReturn;

	}// 进入funcStatement


	public static String addfs(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("addfs: arg="+str);
		
		if(str == null ) {
			return "未指定语句内容";
		}
		
		System.out.println("按用户指定的内容增加新的函数语句：");
		FuncStatement funcStatement = new FuncStatement();
		funcStatement.setContentFuncstatement(str);		
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
	}// 新增funcStatement

	public static String newaddfs(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("newaddfs: arg="+str);
		
		state.setSubState(SubScene.SSFuncStatement);
		
		return "您已进入函数语句录入模式，请逐行录入，输入\":q\"退出录入模式"; 		

	}// 进入函数语句录入模式

	public static String delfs(StateStack stateStack, String str) {
		System.out.println("delfs: arg="+str);

		
		System.out.println("按用户指定的函数语句Id删除一个函数语句：");

		if(str == null ) {
			return "未指定参数";
		}
		
		try {
			int id = Integer.parseInt(str);
			int ret = db.deleteFuncStatementByFuncStatementId(id);
			
			
			String strReturn = "";		
			if (0 == ret) {
				strReturn = "函数语句删除失败；" + "函数语句Id：" + str;}
			else {
				strReturn = "函数语句删除成功；" + "函数语句Id：" + str;	
			}	

			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
	}// 删除funcStatement
	
	////sdfsdfs//////////////
	
	public static String lsfv(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("lsfv: arg=" + str);
		
		int idFunction = state.getIntId();
		
		System.out.println("查询属于当前工程的函数变量：");
		List<FuncVar> funcFuncVars = db.getFuncVarsInfoByFunctionId(idFunction);
		String strReturn = "当前工程的函数变量:";
		Iterator<FuncVar> iter= funcFuncVars.iterator();
		int i=0;
		while(iter.hasNext()) {
			i++;
			strReturn += "\n函数变量"+i+":\n";
			FuncVar funcFuncVar = iter.next();
			strReturn += "函数变量id:" + funcFuncVar.getIdFuncvar() + "; 函数变量名:"+funcFuncVar.getNameFuncvar(); 
		}

		return strReturn;
	}// 列出全局函数变量funcFuncVar


	public static String cdfv(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("cdfv: arg="+str);
		
		if(str == null ) {
			return "未指定参数";
		}
		
		System.out.println("查询用户指定的函数变量信息：");
		
		FuncVar funcFuncVar;
		try {
			int id = Integer.parseInt(str);
			funcFuncVar = db.getFuncVarByFuncVarId(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
				
		//2018-12-03
		//查询相应的dao对象后，先做是否为空的判断
		if (funcFuncVar == null ) {
			return "cd失败，查询不到您指定的对象";			
		}
		
		String strReturn = "进入您的函数变量:";
		strReturn += "函数变量id:" + funcFuncVar.getIdFuncvar() + "; 函数变量名:" +funcFuncVar.getNameFuncvar(); 
		
		int depth = state.getIntDepth();
		State newState = new State(funcFuncVar.getIdFuncvar(),Const.tablebame_FuncVar,depth+1,"函数变量："+funcFuncVar.getIdFuncvar(),SceneType.STFuncVar);
		stateStack.push(newState);	
		
		return strReturn;

	}// 进入funcFuncVar


	public static String addfv(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("addfv: arg="+str);
		
		if(str == null ) {
			return "未指定局部变量名";
		}
		
		
		System.out.println("按用户指定的函数变量名增加新的函数变量：");
		FuncVar funcFuncVar = new FuncVar();
		funcFuncVar.setNameFuncvar(str);
		funcFuncVar.setIdFunction(state.getIntId());
		
		int ret = db.createFuncVar(state.getIntId(),funcFuncVar);
		
		
		String strReturn = "";		
		if (0 != ret) {
			strReturn = "函数变量创建失败";}
		else {
			int idFuncVar = funcFuncVar.getIdFuncvar();
			strReturn = "函数变量已成功创建" + "函数变量Id：" + idFuncVar;				
		}	
		return strReturn;
	}// 新增funcFuncVar


	public static String delfv(StateStack stateStack, String str) {
		System.out.println("delfv: arg="+str);

		
		System.out.println("按用户指定的函数变量Id删除一个函数变量：");

		if(str == null ) {
			return "未指定参数";
		}
		
		try {
			int id = Integer.parseInt(str);
			int ret = db.deleteFuncVarByFuncVarId(id);
			
			
			String strReturn = "";		
			if (0 == ret) {
				strReturn = "函数变量删除失败；" + "函数变量Id：" + str;}
			else {
				strReturn = "函数变量删除成功；" + "函数变量Id：" + str;	
			}	

			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
	}// 删除funcFuncVar
	

	//以上是场景STFunc所涉及操作///////////////////////////////////////////////////////////////////////////
	//以下是场景STFuncStatement所涉及操作///////////////////////////////////////////////////////////////////////////
	//无操作
	
	//以上是场景STFuncStatement所涉及操作///////////////////////////////////////////////////////////////////////////
	//以下是场景STFuncVar所涉及操作///////////////////////////////////////////////////////////////////////////


	public static String lsfvi(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("lsfvi: arg="+str);
		
		int idFuncVar = state.getIntId();
				
		System.out.println("查询用户定义的函数变量字段：");
		List<FuncVarItem> funcFuncVarItems = db.getFuncVarItemsInfoByFuncVarId(idFuncVar);
		String strReturn = "您定义的函数变量字段:";
		Iterator <FuncVarItem> iter= funcFuncVarItems.iterator();
		int i=0;
		while(iter.hasNext()) {
			i++;
			strReturn += "\n函数变量字段"+i+":\n";
			FuncVarItem funcFuncVarItem = iter.next();
			strReturn += "函数变量字段id:" + funcFuncVarItem.getIdFuncvaritem() + "; 函数变量字段名:"+funcFuncVarItem.getNameFuncvaritem(); 
		}

		return strReturn;
	}// 列出函数变量字段FuncVar Item

	public static String cdfvi(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("cdfvi: arg="+str);
		
		if(str == null ) {
			return "未指定参数";
		}
		
		System.out.println("查询用户指定的函数变量字段信息：");
		
		try {
			int id = Integer.parseInt(str);
			FuncVarItem funcFuncVarItem = db.getFuncVarItemByFuncVarItemId(id);
					
			//2018-12-03
			//查询相应的dao对象后，先做是否为空的判断
			if (funcFuncVarItem == null ) {
				return "cd失败，查询不到您指定的对象";			
			}
			
			String strReturn = "进入您的函数变量字段:";
			strReturn += "函数变量字段id:" + funcFuncVarItem.getIdFuncvaritem() + "; 函数变量字段名:" +funcFuncVarItem.getNameFuncvaritem(); 
			
			int depth = state.getIntDepth();
			State newState = new State(funcFuncVarItem.getIdFuncvaritem(),Const.tablebame_FuncVarItem,depth+1,"函数变量字段："+funcFuncVarItem.getIdFuncvaritem(),SceneType.STFuncVarItem);
			stateStack.push(newState);	
			
			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}

	}// 新增函数变量字段FuncVar Item

	public static String addfvi(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("addfvi: arg=" + str);
		
		if(str == null ) {
			return "未指定局部变量字段名";
		}
		
		System.out.println("按用户指定的函数变量字段名增加新的函数变量字段：");
		FuncVarItem funcFuncVar = new FuncVarItem();
		funcFuncVar.setNameFuncvaritem(str);
		funcFuncVar.setIdFuncvar(state.getIntId());
		
		int ret = db.createFuncVarItem(funcFuncVar);
		
		
		String strReturn = "";		
		if (0 != ret) {
			strReturn = "函数变量字段创建失败";}
		else {
			int idFuncVarItem = funcFuncVar.getIdFuncvaritem();
			strReturn = "函数变量字段已成功创建" + "函数变量字段Id：" + idFuncVarItem;			
		}		
		return strReturn;
	}// 新增funcFuncVar item

	public static String delfvi(StateStack stateStack, String str) {
		//State state = stateStack.getCurrentState();
		System.out.println("delfvi: arg="+str);
		
		System.out.println("按用户指定的函数变量字段Id删除一个函数变量字段：");

		if(str == null ) {
			return "未指定参数";
		}
		
		try {
			int id = Integer.parseInt(str);
			int ret = db.deleteFuncVarItemByFuncVarItemId(id);
			
			
			String strReturn = "";		
			if (0 == ret) {
				strReturn = "函数变量字段删除失败；" + "函数变量字段Id：" + str;}
			else {
				strReturn = "函数变量字段删除成功；" + "函数变量字段Id：" + str;	
			}	

			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
	}// 删除函数变量字段FuncVar Item

	//以上是场景STFuncVar所涉及操作///////////////////////////////////////////////////////////////////////////
	//以下是场景STFuncVarItem所涉及操作///////////////////////////////////////////////////////////////////////////
	//无操作
	
	//以上是场景STFuncVarItem所涉及操作///////////////////////////////////////////////////////////////////////////
	//以下是场景STVar所涉及操作///////////////////////////////////////////////////////////////////////////
	
	public static String lsvi(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("lsvi: arg="+str);
		
		int idVar = state.getIntId();
				
		System.out.println("查询用户定义的变量字段：");
		List<VarItem> varItems = db.getVarItemsInfoByVarId(idVar);
		String strReturn = "您定义的变量字段:";
		Iterator <VarItem> iter= varItems.iterator();
		int i=0;
		while(iter.hasNext()) {
			i++;
			strReturn += "\n变量字段"+i+":\n";
			VarItem varItem = iter.next();
			strReturn += "变量字段id:" + varItem.getIdVaritem() + "; 变量字段注释:"+varItem.getMemoVaritem(); 
		}

		return strReturn;
	}// 列出全局变量字段Var Item

	public static String cdvi(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("cdvi: arg="+str);
		
		if(str == null ) {
			return "未指定参数";
		}
		
		System.out.println("查询用户指定的变量字段信息：");
		
		try {
			int id = Integer.parseInt(str);
			VarItem varItem = db.getVarItemByVarItemId(id);
					
			//2018-12-03
			//查询相应的dao对象后，先做是否为空的判断
			if (varItem == null ) {
				return "cd失败，查询不到您指定的对象";			
			}
			
			String strReturn = "进入您的变量字段:";
			strReturn += "变量字段id:" + varItem.getIdVaritem() + "; 变量字段注释:" +varItem.getMemoVaritem(); 
			
			int depth = state.getIntDepth();
			State newState = new State(varItem.getIdVaritem(),Const.tablebame_VarItem,depth+1,"变量字段："+varItem.getIdVaritem(),SceneType.STVarItem);
			stateStack.push(newState);	
			
			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}

	}// 新增全局变量字段Var Item

	public static String addvi(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("addvi: arg=" + str);
		if(str == null ) {
			return "未指定全局变量字段名";
		}
		System.out.println("按用户指定的变量字段名增加新的变量字段：");
		VarItem var = new VarItem();
		//var.setNameVarItem(str);
		var.setIdVar(state.getIntId());
		
		int ret = db.createVarItem(var);
		
		
		String strReturn = "";		
		if (0 != ret) {
			strReturn = "变量字段创建失败";}
		else {
			int idVarItem = var.getIdVaritem();
			strReturn = "变量字段已成功创建" + "变量字段Id：" + idVarItem;			
		}		
		return strReturn;
	}// 新增var item

	public static String delvi(StateStack stateStack, String str) {
		//State state = stateStack.getCurrentState();
		System.out.println("delvi: arg="+str);
		
		System.out.println("按用户指定的变量字段Id删除一个变量字段：");

		if(str == null ) {
			return "未指定参数";
		}
		
		try {
			int id = Integer.parseInt(str);
			int ret = db.deleteVarItemByVarItemId(id);
			
			
			String strReturn = "";		
			if (0 == ret) {
				strReturn = "变量字段删除失败；" + "变量字段Id：" + str;}
			else {
				strReturn = "变量字段删除成功；" + "变量字段Id：" + str;	
			}	

			return strReturn;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "参数不正确";
		}
	}// 删除全局变量字段Var Item

	//以上是场景STVar所涉及操作///////////////////////////////////////////////////////////////////////////
	//以下是场景STVSTVarItemar所涉及操作///////////////////////////////////////////////////////////////////////////
	//无操作
	
	//2018-11-17 重新梳理每个场景可做的操作后注释掉以下内容
/*
	public static String cd(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("cd: arg="+str);
		if(str1.equalsIgnoreCase("1")) {
			return null;
		}else if("2" == str1) {
			return null;
		}else {
			return state;
		}
	}
	
	public static String dc(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("dc: arg="+str);
		return null;
	}
	
	public static String newItem(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("new: arg="+str);
		return null;
	}
	
	public static String ls(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("ls: arg="+str);
		return null;
	}
	
	public static String add(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("add: arg="+str);
		return null;
	}
	
	public static String del(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("del: arg="+str);
		return null;
	}
	
	public static String whoami(StateStack stateStack, String str) {
		State state = stateStack.getCurrentState();
		System.out.println("whoami: arg="+str);
		return null;
	}
	*/
	}
