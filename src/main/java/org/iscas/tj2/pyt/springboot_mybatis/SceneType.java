package org.iscas.tj2.pyt.springboot_mybatis;

public enum SceneType {
	/**
	 * 根据数据库整理各对象的层次关系
	 * 属于用户的有Struct、Type、Project
	 * 	属于Project的有Func、Var（全局变量）
	 * 		属于Func的有FuncStatement
	 * 		属于Func的有FuncVar（局部变量）
	 * 		   属于FuncVar的有FuncVarItem
	 * 		属于Var的有VarItem
	 * 属于Struct的有StructItem
	 * 		
	 */
	/*
	STUser,
		STStruct,
			STStructItem,
		STType,
		STProject,	
			STFunc,
				STFuncStatement,
				STFuncVar,
					STFuncVarItem,
			STVar,
				STVarItem,
				*/
	//2018-11-17新增注释信息
	STUser, //help,pwd,attr,lsp,lst,lss,cdp,cdt,cds,addp,addt,adds,delp,delt,dels
	STStruct,//help,pwd,attr,lssi(ls),cdsi(cd),addsi(add),delsi(del),dc
		STStructItem,//help,pwd,attr,dc
	STType,//help,pwd,attr,dc
	STProject,	//help,pwd,attr,lsf,lsv,cdf,cdv,addf,addv,delf,delv,dc
		STFunc, //help,pwd,attr,lsfs,lsfv,cdfs,cdfv,addfs,addfv,delfs,delfv,dc
			STFuncStatement,//help,pwd,attr,dc
			STFuncVar,//help,pwd,attr,lsfvi(ls),cdfvi(cd),addfvi(add),delfvi(del),dc
				STFuncVarItem,//help,pwd,attr,dc
		STVar,//help,pwd,attr,lsvi(ls),cdvi(cd),addvi(add),delvi(del),dc
			STVarItem,//help,pwd,attr,dc
		
	STCommonUser,
	STCommonAdmin,
}
