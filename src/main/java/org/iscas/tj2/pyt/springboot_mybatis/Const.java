package org.iscas.tj2.pyt.springboot_mybatis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Const {
	public static final int maxStackDepth = 10;
	public static final int maxUserNumber = 1000;
	public static final int UserIdOfAdmin = 1;
	//记录管理员用户的微信id
	public static final String AdminUserWeixinId = "ocaDy1CWp497l5Kq21mkw3HflzaY";
	//表名
	public static final String tablename_User = "User";
	public static final String tablename_Role = "Role";
	public static final String tablename_FuncProjectRelation = "FuncProjectRelation";
	public static final String tablename_FuncStatement = "FuncStatement";
	public static final String tablename_Macro = "Macro";
	public static final String tablename_MacroProjectRelation = "MacroProjectRelation";
	public static final String tablename_Function = "Function";
	public static final String tablename_FuncVar = "FuncVar";
	public static final String tablename_FuncVarItem = "FuncVarItem";
	//public static final String tablename_NameSpace = "NameSpace";
	public static final String tablename_Permission = "Permission";
	public static final String tablename_Project = "Project";
	public static final String tablename_RolePRMSRelation = "RolePRMSRelation";
	/*public static final String tablename_Struct = "Struct";
	public static final String tablename_StructItem = "StructItem";
	public static final String tablename_StructUserRelation = "StructUserRelation";*/
	public static final String tablename_Type = "Type";
	public static final String tablename_TypeItem = "TypeItem";
	public static final String tablename_TypeProjectRelation = "TypeProjectRelation";
	//public static final String tablename_TypeUserRelation = "TypeUserRelation";
	//public static final String tablename_Type = "Type";

	public static final String tablename_UserMessage = "UserMessage";
	public static final String tablename_UserMessageTemplet = "UserMessageTemplet";
	public static final String tablename_UserRoleRelation = "UserRoleRelation";
	public static final String tablename_Var = "Var";
	public static final String tablename_VarItem = "VarItem";
	public static final String tablename_VarProjectRelation = "VarProjectRelation";

	//2019-12-24 按照新的命令结构新增
	public static final String STRoot_HELP = ""//"根场景下可用的命令：\n"
			//+ "help   -列出此帮助信息\n"
			+ "ls   -列出当前的工程\n"
			+ "cd  id -进入指定的工程\n"
			+ "new name   -新增一个工程\n"
			+ "grant id_User id_Project -授予用户id_User权限访问工程id_Project\n";

	public static final String STProject_HELP = ""//"工程场景下您可用的命令：\n"
			//+ "help   -列出此帮助信息\n"
			+ "ls   -列出可查看的对象\n"
			+ "cd object -进入指定的对象列表\n"
			+ "dc   -退回到上一层";

	public static final String STMacroList_HELP = ""//"宏定义列表场景下可用的命令：\n"
			//+ "help   -列出此帮助信息\n"
			+ "ls   -显示宏定义列表\n"
			+ "more   -显示剩余部分\n"
			+ "new name=value   -新增一个宏定义\n"
			+ "cat id   -显示指定宏定义的内容\n"
			+ "cd id -进入指定id的宏\n"
			+ "dc   -退回到上一层";

	public static final String STMacro_HELP = ""//"宏定义场景下可用的命令：\n"
			//+ "help   -列出此帮助信息\n"
			+ "set   -显示宏的属性\n"
			+ "set key=value   -设置宏定义的属性\n"
			+ "dc   -退回到上一层";
	
	public static final String STTypeList_HELP = ""//"类型定义列表场景下可用的命令：\n"
			//+ "help   -列出此帮助信息\n"
			+ "ls   -显示类型定义列表\n"
			+ "more   -显示剩余部分\n"
			+ "new [struct/uion/enum] name   -新增一个类型定义\n"
			+ "cat id   -显示指定类型定义的内容\n"
			+ "cd id -进入指定id的类型\n"
			+ "dc   -退回到上一层";

	public static final String STType_HELP = ""//"类型定义场景下可用的命令：\n"
			//+ "help   -列出此帮助信息\n"
			+ "set   -显示类型的属性\n"
			+ "set key=value   -设置类型定义的属性\n"
			+ "dc   -退回到上一层";	
	
	public static final String STFuncList_HELP = ""//"变量定义列表场景下可用的命令：\n"
			//+ "help   -列出此帮助信息\n"
			+ "ls   -显示变量定义列表\n"
			+ "more   -显示剩余部分\n"
			+ "new name   -新增一个变量定义\n"
			+ "cat id   -显示指定变量定义的内容\n"
			+ "cd id -进入指定id的变量定义\n"
			+ "dc   -退回到上一层";

	public static final String STFunc_HELP = ""//"变量定义场景下可用的命令：\n"
			//+ "help   -列出此帮助信息\n"
			+ "set   -显示变量定义的属性\n"
			+ "set key=value   -设置变量定义的属性\n"
			+ "dc   -退回到上一层";	

	public static final String STVarList_HELP = ""//"变量定义列表场景下可用的命令：\n"
			//+ "help   -列出此帮助信息\n"
			+ "ls   -显示变量定义列表\n"
			+ "more   -显示剩余部分\n"
			+ "new name   -新增一个变量定义\n"
			+ "cat id   -显示指定变量定义的内容\n"
			+ "cd id -进入指定id的变量定义\n"
			+ "dc   -退回到上一层";

	public static final String STVar_HELP = ""//"变量定义场景下可用的命令：\n"
			//+ "help   -列出此帮助信息\n"
			+ "set   -显示变量定义的属性\n"
			+ "set key=value   -设置变量定义的属性\n"
			+ "dc   -退回到上一层";	
	
	//用于查询在不同的场景下应当显示什么帮助内容
	public static final Map<SceneType, String> mapHelpInfo = new HashMap<SceneType, String>(){{
			put(SceneType.STRoot, STRoot_HELP);
			put(SceneType.STProject, STProject_HELP);
			put(SceneType.STMacroList, STMacroList_HELP);
			put(SceneType.STMacro, STMacro_HELP);
			put(SceneType.STTypeList, STTypeList_HELP);
			put(SceneType.STType, STType_HELP);
			put(SceneType.STFuncList, STFuncList_HELP);
			put(SceneType.STFunc, STFunc_HELP);
			put(SceneType.STVar, STVar_HELP);
			put(SceneType.STVarList, STVarList_HELP);		
	}};
	//2019-12-24 因为大幅度修改命令结构，所以注释掉以下内容
/*	public static final String STCommonUser_HELP = "您可用的命令：\n"
			//+ "help   -列出此帮助信息\n"
			+ "pwd   -显示当前所处的场景\n"
			+ "lsf   -列出所有函数\n"
			+ "lst   -列出所有type\n"
			+ "lss   -列出所有struct\n"
			+ "cdf id   -进入指定的函数\n"
			+ "cdt id   -进入指定的type\n"
			+ "cds id   -进入指定的struct\n"
			+ "home   -回到用户场景";

	
	public static final String STCommonAdmin_HELP = "您可用的命令：\n"
			//+ "help   -列出此帮助信息\n"
			+ "pwd   -显示当前所处的场景\n"
			+ "lsp   -列出所有project\n"
			+ "lst   -列出所有type\n"
			+ "lss   -列出所有struct\n"
			+ "cdp id   -进入指定的project\n"
			+ "cdt id   -进入指定的type\n"
			+ "cds id   -进入指定的struct\n"
			+ "addp name   -新增一个project\n"
			+ "addt name   -新增一个type\n"
			+ "adds name   -新增一个struct\n"
			+ "delp id   -删除一个project\n"
			+ "delt id   -删除一个type\n"
			+ "dels id   -删除一个struct\n"
			+ "home   -回到用户场景";

	
	//各状态下的帮助信息字符串
	public static final String STUser_HELP = "您可用的命令：\n"
			//+ "help   -列出此帮助信息\n"
			+ "pwd   -显示当前所处的场景\n"
			+ "whoami   -显示当前操作的对象\n"
			//+ "attr key=value   -修改当前对象的属性值\n"
			+ "attr key=value   -修改当前对象的属性值\n"
			+ "newattr   -进入属性编辑模式\n"
			+ "lsp   -列出所有project\n"
			+ "lst   -列出所有type\n"
			+ "lss   -列出所有struct\n"
			+ "cdp id   -进入指定的project\n"
			+ "cdt id   -进入指定的type\n"
			+ "cds id   -进入指定的struct\n"
			+ "addp name   -新增一个project\n"
			+ "addt name   -新增一个type\n"
			+ "adds name   -新增一个struct\n"
			+ "delp id   -删除一个project\n"
			+ "delt id   -删除一个type\n"
			+ "dels id   -删除一个struct\n"
			+ "grant id_User id_Project -授予用户id_User权限访问工程id_Project\n"
			+ "common   -查看共用对象";

	public static final String STStruct_HELP = "结构体场景下可用的命令：\n"
			//+ "help   -列出此帮助信息\n"
			+ "pwd   -显示当前所处的场景\n"
			+ "whoami   -显示当前操作的对象\n"
			//+ "attr key=value   -修改当前对象的属性值\n"
			+ "attr key=value   -修改当前对象的属性值\n"
			+ "newattr   -进入属性编辑模式\n"
			+ "lssi   -列出struct item\n"
			+ "cdsi id   -进入struct item\n"
			+ "addsi type name   -新增struct item\n"
			+ "delsi id   -删除struct item\n"
			+ "dc   -退回到上一层";
		public static final String STStructItem_HELP = "结构体字段场景下可用的命令：\n"
				//+ "help   -列出此帮助信息\n"
				+ "pwd   -显示当前所处的场景\n"
				+ "whoami   -显示当前操作的对象\n"
				//+ "attr key=value   -修改当前对象的属性值\n"
			+ "attr key=value   -修改当前对象的属性值\n"
			+ "newattr   -进入属性编辑模式\n"
				+ "dc   -退回到上一层";
	public static final String STType_HELP = "类型场景下可用的命令：\n"
			//+ "help   -列出此帮助信息\n"
			+ "pwd   -显示当前所处的场景\n"
			+ "whoami   -显示当前操作的对象\n"
			//+ "attr key=value   -修改当前对象的属性值\n"
			+ "attr key=value   -修改当前对象的属性值\n"
			+ "newattr   -进入属性编辑模式\n"
			+ "dc   -退回到上一层";
	public static final String STProject_HELP = "工程场景下可用的命令：\n"
			//+ "help   -列出此帮助信息\n"
			+ "pwd   -显示当前所处的场景\n"
			+ "whoami   -显示当前操作的对象\n"
			//+ "attr key=value   -修改当前对象的属性值\n"
			+ "attr key=value   -修改当前对象的属性值\n"
			+ "newattr   -进入属性编辑模式\n"
			+ "lsf   -列出function\n"
			+ "lsv   -列出全局变量var\n"
			+ "cdf id   -进入function\n"
			+ "cdv id   -进入var\n"
			+ "addf name   -新增function\n"
			+ "addv name   -新增var\n"
			+ "delf id   -删除function\n"
			+ "delv id   -删除var\n"
			+ "dc   -退回到上一层";
		public static final String STFunc_HELP = "函数场景下可用的命令：\n"
				//+ "help   -列出此帮助信息\n"
				+ "pwd   -显示当前所处的场景\n"
				+ "whoami   -显示当前操作的对象\n"
				//+ "attr key=value   -修改当前对象的属性值\n"
			+ "attr key=value   -修改当前对象的属性值\n"
			+ "newattr   -进入属性编辑模式\n"
				+ "lsfs   -列出函数语句function statement\n"
				+ "lsfv   -列出函数局部变量fuction var\n"
				+ "cdfs id   -进入指定的函数语句function statement\n"
				+ "cdfv id   -进入指定的函数局部变量fuction var\n"
				+ "addfs content   -增加一条函数语句function statement\n"
				+ "newaddfs    -进入函数语句录入模式\n"
				+ "addfv name   -增加一个函数局部变量fuction var\n"
				+ "delfs id   -删除一条函数语句function statement\n"
				+ "delfv id   -删除一个函数局部变量fuction var\n"
				+ "dc   -退回到上一层";
			public static final String STFuncStatement_HELP = "函数语句场景下可用的命令：\n"
					//+ "help   -列出此帮助信息\n"
					+ "pwd   -显示当前所处的场景\n"
					+ "whoami   -显示当前操作的对象\n"
					//+ "attr key=value   -修改当前对象的属性值\n"
			+ "attr key=value   -修改当前对象的属性值\n"
			+ "newattr   -进入属性编辑模式\n"
					+ "dc   -退回到上一层";
			public static final String STFuncVar_HELP = "函数局部变量场景下可用的命令：\n"
					//+ "help   -列出此帮助信息\n"
					+ "pwd   -显示当前所处的场景\n"
					+ "whoami   -显示当前操作的对象\n"
					//+ "attr key=value   -修改当前对象的属性值\n"
			+ "attr key=value   -修改当前对象的属性值\n"
			+ "newattr   -进入属性编辑模式\n"
					+ "lsfvi   -列出函数局部变量字段Function Var Item\n"
					+ "cdfvi  -进入函数局部变量字段Function Var Item\n"
					+ "addfvi   -新增函数局部变量字段Function Var Item\n"
					+ "delfvi   -删除函数局部变量字段Function Var Item\n"
					+ "dc   -退回到上一层";
				public static final String STFuncVarItem_HELP = "函数局部变量字段场景下可用的命令：\n"
						//+ "help   -列出此帮助信息\n"
						+ "pwd   -显示当前所处的场景\n"
						+ "whoami   -显示当前操作的对象\n"
						//+ "attr key=value   -修改当前对象的属性值\n"
			+ "attr key=value   -修改当前对象的属性值\n"
			+ "newattr   -进入属性编辑模式\n"
						+ "dc   -退回到上一层";
		public static final String STVar_HELP = "全局变量场景下可用的命令：\n"
				//+ "help   -列出此帮助信息\n"
				+ "pwd   -显示当前所处的场景\n"
				+ "whoami   -显示当前操作的对象\n"
				//+ "attr key=value   -修改当前对象的属性值\n"
			+ "attr key=value   -修改当前对象的属性值\n"
			+ "newattr   -进入属性编辑模式\n"
				+ "lsvi   -列出全局变量字段Var Item\n"
				+ "cdvi   -进入全局变量字段Var Item\n"
				+ "addvi  -新增全局变量字段Var Item\n"
				+ "delvi  -删除全局变量字段Var Item\n"
				+ "dc   -退回到上一层";
			public static final String STVarItem_HELP = "全局变量字段场景下可用的命令：\n"
					//+ "help   -列出此帮助信息\n"
					+ "pwd   -显示当前所处的场景\n"
					+ "whoami   -显示当前操作的对象\n"
					//+ "attr key=value   -修改当前对象的属性值\n"
			+ "attr key=value   -修改当前对象的属性值\n"
			+ "newattr   -进入属性编辑模式\n"
					+ "dc   -退回到上一层";
	
	//用于查询在不同的场景下应当显示什么帮助内容
	public static final Map<SceneType, String> mapHelpInfo = new HashMap<SceneType, String>(){{
			put(SceneType.STCommonAdmin, STCommonAdmin_HELP);
			put(SceneType.STCommonUser, STCommonUser_HELP);	
			put(SceneType.STUser, STUser_HELP);
			put(SceneType.STStruct, STStruct_HELP);
			put(SceneType.STStructItem, STStructItem_HELP);
			put(SceneType.STType, STType_HELP);
			put(SceneType.STProject, STProject_HELP);
			put(SceneType.STFunc, STFunc_HELP);
			put(SceneType.STFuncStatement, STFuncStatement_HELP);
			put(SceneType.STFuncVar, STFuncVar_HELP);
			put(SceneType.STFuncVarItem, STFuncVarItem_HELP);
			put(SceneType.STVar, STVar_HELP);
			put(SceneType.STVarItem, STVarItem_HELP);
	}};*/
	
	//DbCommonUtil用来初始化数据库连接的
	//jdbc
	public static final String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/java?useUnicode=true&characterEncoding=utf-8";
	//数据库用户名
	public static final String dbUser = "root";
	//数据库用户密码
	public static final String dbPwd = "pyt999";
	//数据库名
	public static final String dbSchema = "java";
	
	//各表名对应的id的字段名
	public static final HashMap<String,String> mapTableId= new HashMap<String,String>(){{
		put(tablename_User,"Id_User");
			put(tablename_Project,"Id_Project");
				put(tablename_Function,"Id_Function");
					put(tablename_FuncStatement,"Id_FuncStatement");
					put(tablename_FuncVar,"Id_FuncVar");
						put(tablename_FuncVarItem,"Id_FuncVarItem");
				put(tablename_Var,"Id_Var");
					put(tablename_VarItem,"Id_VarItem");
		put(tablename_Type,"Id_Type");
			put(tablename_TypeItem,"Id_TypeItem");
		//put(tablename_Type,"Id_Type");
		put(tablename_Macro,"Id_Macro");
		put(tablename_MacroProjectRelation ,"Id_MacroProjectRelation");
	}
	};
	
	//各场景不同数字代表的命令名
	HashSet alias_help = new HashSet() {{add("help");add("h");}};
	HashSet alias_pwd = new HashSet() {{add("pwd");add("p");}};
	HashSet alias_whoami = new HashSet() {{add("whoami");add("w");}};
	HashSet alias_lsp = new HashSet() {{add("lsp");add("lp");}};
	HashSet alias_lss = new HashSet() {{add("lss");add("ls");}};
	HashSet alias_lst = new HashSet() {{add("lst");add("lt");}};
	HashSet alias_cdp = new HashSet() {{add("cdp");add("cp");}};
	HashSet alias_cds = new HashSet() {{add("cds");add("cs");}};
	HashSet alias_cdt = new HashSet() {{add("cdt");add("ct");}};
	HashSet alias_delp = new HashSet() {{add("delp");add("dp");}};
	HashSet alias_dels = new HashSet() {{add("dels");add("ds");}};
	HashSet alias_delt = new HashSet() {{add("delt");add("dt");}};
	HashSet alias_addp = new HashSet() {{add("addp");add("ap");}};
	HashSet alias_adds = new HashSet() {{add("adds");add("as");}};
	HashSet alias_addt = new HashSet() {{add("addt");add("at");}};
	HashSet alias_lssi = new HashSet() {{add("lssi");add("lsi");}};
	HashSet alias_cdsi = new HashSet() {{add("cdsi");add("csi");}};
	HashSet alias_delsi = new HashSet() {{add("delsi");add("dsi");}};
	HashSet alias_addsi = new HashSet() {{add("addsi");add("asi");}};
	HashSet alias_lsfs = new HashSet() {{add("lsfs");add("lfs");}};
	HashSet alias_cdfs = new HashSet() {{add("cdfs");add("cfs");}};
	HashSet alias_delfs = new HashSet() {{add("delfs");add("dfs");}};
	HashSet alias_addfs = new HashSet() {{add("addfs");add("afs");}};
	HashSet alias_lsfv = new HashSet() {{add("lsfv");add("lfv");}};
	HashSet alias_cdfv = new HashSet() {{add("cdfv");add("cfv");}};
	HashSet alias_delfv = new HashSet() {{add("delfv");add("dfv");}};
	HashSet alias_addfv = new HashSet() {{add("addfv");add("afv");}};
	HashSet alias_lsfvi = new HashSet() {{add("lsfvi");add("lfvi");}};
	HashSet alias_cdfvi = new HashSet() {{add("cdfvi");add("cfvi");}};
	HashSet alias_delfvi = new HashSet() {{add("delfvi");add("dfvi");}};
	HashSet alias_addfvi = new HashSet() {{add("addfvi");add("afvi");}};
	HashSet alias_lsv = new HashSet() {{add("lsv");add("lv");}};
	HashSet alias_cdv = new HashSet() {{add("cdv");add("cv");}};
	HashSet alias_delv = new HashSet() {{add("delv");add("dv");}};
	HashSet alias_addv = new HashSet() {{add("addv");add("av");}};
	HashSet alias_lsvi = new HashSet() {{add("lsvi");add("lvi");}};
	HashSet alias_cdvi = new HashSet() {{add("cdvi");add("cvi");}};
	HashSet alias_delvi = new HashSet() {{add("delvi");add("dvi");}};
	HashSet alias_addvi = new HashSet() {{add("addvi");add("avi");}};	
	
	
	
	public static final HashMap<String,String> mapOrderIndex_STUser= new HashMap<String,String>(){{
		put(tablename_User,"Id_User");
			put(tablename_Project,"Id_Project");
				put(tablename_Function,"Id_Function");
					put(tablename_FuncStatement,"Id_FuncStatement");
					put(tablename_FuncVar,"Id_FuncVar");
						put(tablename_FuncVarItem,"Id_FuncVarItem");
				put(tablename_Var,"Id_Var");
					put(tablename_VarItem,"Id_VarItem");
				put(tablename_Type,"Id_Type");
					put(tablename_TypeItem,"Id_TypeItem");
		put(tablename_Type,"Id_Type");
		put(tablename_Macro,"Id_Macro");
		put(tablename_MacroProjectRelation ,"Id_MacroProjectRelation");
	}
	};

	
	//2018-12-20
	public static final String STProjectObject_LIST = "macro,func,type,var\n";

	
	
			
	
	public Const() {
		// TODO Auto   -generated constructor stub	
	}
	
	

}
