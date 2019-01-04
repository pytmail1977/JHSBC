package org.iscas.tj2.pyt.springboot_mybatis.scene_state;

import java.util.HashMap;

import org.iscas.tj2.pyt.springboot_mybatis.Const;
import org.iscas.tj2.pyt.springboot_mybatis.SceneType;

public class StateTransfer {
	
	//2018-11-18 取消StateTransfer中的属性nowState
	//当前状态
	//private State nowState;
	
	//状态转移矩阵
	//private HashMap<String, HashMap<String ,Func<StateStack,String> > > stateMap = new HashMap<String ,HashMap<String ,Func<StateStack,String> > >();
	//2018-11-11 将“HashMap<String”改为“HashMap<SceneType”
	private HashMap<SceneType, HashMap<String ,Func<StateStack,String> > > stateMap = new HashMap<SceneType ,HashMap<String ,Func<StateStack,String> > >();

	//状态
	//2018-12-07取消以下定义
	//public StateStack stateStack = new StateStack(Const.maxStackDepth);

	//2018-12-07新增以下定义
	public StateStack[] stateStacks = new StateStack[Const.maxUserNumber];


	/*
	*//**
	 * 设置当前状态
	 * @param strNowState
	 *//*
    public void setNowState(State nowState) {
    	this.nowState = nowState;
    }
    
    *//**
     * 取得当前状态
     * @return
     *//*
    public State getNowState() {
    	return this.nowState;
    }
	*/
    
	
    /**
     * 构造函数，按给定的参数设定初始状态初始化类对象，初始化状态转移矩阵
     *
     */
	//2018-11-18 取消构造函数中对nowState的初始化
	//public StateTransfer(State nowState) {
	public StateTransfer() {
		// TODO Auto-generated constructor stub
		//2018-11-18 取消构造函数中对nowState的初始化
		//初始化当前状态
		//this.nowState = nowState;
		
		for(int i=0;i<Const.maxUserNumber;i++) {
			stateStacks[i] = null;
		}
		
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
		
		//2018-12-24新增
		//初始化SceneType.STRoot场景的转移出口，包括help、ls、cd、new、grant********************
		HashMap<String, Func<StateStack,String> > transferMapSTRoot = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneType.STRoot场景的转移出口help
		transferMapSTRoot.put("help", FuncBase::help);
		//新增SceneType.STRoot场景的转移出口ls
		transferMapSTRoot.put("ls", FuncBase::lsProjects);
		// 新增SceneType.STRoot场景的转移出口cd
		transferMapSTRoot.put("cd", FuncBase::cdProject);
		// 新增SceneType.STRoot场景的转移出口new
		transferMapSTRoot.put("new", FuncBase::addProject);
		// 新增SceneType.STCommonAdmin场景的转移出口grant
		transferMapSTRoot.put("grant", FuncBase::grantProject);
		//所有STRoot状态下的转移都put到transferMapSTRoot中，最后把transferMapSTRoot加入stateMap
		stateMap.put(SceneType.STRoot, transferMapSTRoot);
		
		//初始化SceneType.STProject场景的转移出口，包括help、ls、cd、dc********************
		HashMap<String, Func<StateStack,String> > transferMapSTProject = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneType.STProject场景的转移出口help
		transferMapSTProject.put("help", FuncBase::help);
		//新增SceneType.STProject场景的转移出口ls
		transferMapSTProject.put("ls", FuncBase::lsProjectObjects);
		// 新增SceneType.STProject场景的转移出口cd
		transferMapSTProject.put("cd", FuncBase::cdProjectObject);
		// 新增SceneType.STProject场景的转移出口dc
		transferMapSTProject.put("dc", FuncBase::dc);
		//所有STProject状态下的转移都put到transferMapSTProject中，最后把transferMapSTProject加入stateMap
		stateMap.put(SceneType.STProject, transferMapSTProject);		
	
		//初始化SceneType.STMacroList场景的转移出口，包括help、ls、cd、new、，more、dc、cat********************
		HashMap<String, Func<StateStack,String> > transferMapSTMacroList = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneType.STMacroList场景的转移出口help
		transferMapSTMacroList.put("help", FuncBase::help);
		//新增SceneType.STMacroList场景的转移出口ls
		transferMapSTMacroList.put("ls", FuncBase::lsMacros);
		//新增SceneType.STMacroList场景的转移出口more
		transferMapSTMacroList.put("more", FuncBase::more);
		//新增SceneType.STMacroList场景的转移出口cat
		transferMapSTMacroList.put("cat", FuncBase::cat);
		// 新增SceneType.STMacroList场景的转移出口new
		transferMapSTMacroList.put("new", FuncBase::addMacro);
		// 新增SceneType.STMacroList场景的转移出口cd
		transferMapSTMacroList.put("cd", FuncBase::cdMacro);
		// 新增SceneType.STMacroList场景的转移出口dc
		transferMapSTMacroList.put("dc", FuncBase::dc);
		//所有STMacroList状态下的转移都put到transferMapSTMacroList中，最后把transferMapSTMacroList加入stateMap
		stateMap.put(SceneType.STMacroList, transferMapSTMacroList);
		
		//初始化SceneType.STMacro场景的转移出口，包括help、set、dc********************
		HashMap<String, Func<StateStack,String> > transferMapSTMacro = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneType.STMacro场景的转移出口help
		transferMapSTMacro.put("help", FuncBase::help);
		//新增SceneType.STMacro场景的转移出口set
		transferMapSTMacro.put("set", FuncBase::set);
		// 新增SceneType.STMacro场景的转移出口dc
		transferMapSTMacro.put("dc", FuncBase::dc);
		//所有STMacro状态下的转移都put到transferMapSTMacro中，最后把transferMapSTMacro加入stateMap
		stateMap.put(SceneType.STMacro, transferMapSTMacro);		

		
		//初始化SceneType.STFuncList场景的转移出口，包括help、ls、cd、new、，more、dc、cat********************
		HashMap<String, Func<StateStack,String> > transferMapSTFuncList = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneType.STFuncList场景的转移出口help
		transferMapSTFuncList.put("help", FuncBase::help);
		//新增SceneType.STFuncList场景的转移出口ls
		transferMapSTFuncList.put("ls", FuncBase::lsFuncs);
		//新增SceneType.STFuncList场景的转移出口more
		transferMapSTFuncList.put("more", FuncBase::more);
		//新增SceneType.STFuncList场景的转移出口cat
		transferMapSTFuncList.put("cat", FuncBase::cat);
		// 新增SceneType.STFuncList场景的转移出口new
		transferMapSTFuncList.put("new", FuncBase::addFunc);
		// 新增SceneType.STFuncList场景的转移出口cd
		transferMapSTFuncList.put("cd", FuncBase::cdFunc);
		// 新增SceneType.STFuncList场景的转移出口dc
		transferMapSTFuncList.put("dc", FuncBase::dc);
		//所有STFuncList状态下的转移都put到transferMapSTFuncList中，最后把transferMapSTFuncList加入stateMap
		stateMap.put(SceneType.STFuncList, transferMapSTFuncList);
		
		//初始化SceneType.STFunc场景的转移出口，包括help、set、dc********************
		HashMap<String, Func<StateStack,String> > transferMapSTFunc = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneType.STFunc场景的转移出口help
		transferMapSTFunc.put("help", FuncBase::help);
		//新增SceneType.STFunc场景的转移出口set
		transferMapSTFunc.put("set", FuncBase::set);
		// 新增SceneType.STFunc场景的转移出口dc
		transferMapSTFunc.put("dc", FuncBase::dc);
		//所有STFunc状态下的转移都put到transferMapSTFunc中，最后把transferMapSTFunc加入stateMap
		stateMap.put(SceneType.STFunc, transferMapSTFunc);	
		
		//初始化SceneType.STVarList场景的转移出口，包括help、ls、cd、new、，more、dc、cat********************
		HashMap<String, Func<StateStack,String> > transferMapSTVarList = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneType.STVarList场景的转移出口help
		transferMapSTVarList.put("help", FuncBase::help);
		//新增SceneType.STVarList场景的转移出口ls
		transferMapSTVarList.put("ls", FuncBase::lsVars);
		//新增SceneType.STVarList场景的转移出口more
		transferMapSTVarList.put("more", FuncBase::more);
		//新增SceneType.STVarList场景的转移出口cat
		transferMapSTVarList.put("cat", FuncBase::cat);
		// 新增SceneType.STVarList场景的转移出口new
		transferMapSTVarList.put("new", FuncBase::addVar);
		// 新增SceneType.STVarList场景的转移出口cd
		transferMapSTVarList.put("cd", FuncBase::cdVar);
		// 新增SceneType.STVarList场景的转移出口dc
		transferMapSTVarList.put("dc", FuncBase::dc);
		//所有STVarList状态下的转移都put到transferMapSTVarList中，最后把transferMapSTVarList加入stateMap
		stateMap.put(SceneType.STVarList, transferMapSTVarList);
		
		//初始化SceneType.STVar场景的转移出口，包括help、set、dc********************
		HashMap<String, Func<StateStack,String> > transferMapSTVar = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneType.STVar场景的转移出口help
		transferMapSTVar.put("help", FuncBase::help);
		//新增SceneType.STVar场景的转移出口set
		transferMapSTVar.put("set", FuncBase::set);
		// 新增SceneType.STVar场景的转移出口dc
		transferMapSTVar.put("dc", FuncBase::dc);
		//所有STVar状态下的转移都put到transferMapSTVar中，最后把transferMapSTVar加入stateMap
		stateMap.put(SceneType.STVar, transferMapSTVar);	
		
		
		//初始化SceneType.STTypeList场景的转移出口，包括help、ls、cd、new、，more、dc、cat********************
		HashMap<String, Func<StateStack,String> > transferMapSTTypeList = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneType.STTypeList场景的转移出口help
		transferMapSTTypeList.put("help", FuncBase::help);
		//新增SceneType.STTypeList场景的转移出口ls
		transferMapSTTypeList.put("ls", FuncBase::lsTypes);
		//新增SceneType.STTypeList场景的转移出口more
		transferMapSTTypeList.put("more", FuncBase::more);
		//新增SceneType.STTypeList场景的转移出口cat
		transferMapSTTypeList.put("cat", FuncBase::cat);
		// 新增SceneType.STTypeList场景的转移出口new
		transferMapSTTypeList.put("new", FuncBase::addType);
		// 新增SceneType.STTypeList场景的转移出口cd
		transferMapSTTypeList.put("cd", FuncBase::cdType);
		// 新增SceneType.STTypeList场景的转移出口dc
		transferMapSTTypeList.put("dc", FuncBase::dc);
		//所有STTypeList状态下的转移都put到transferMapSTTypeList中，最后把transferMapSTTypeList加入stateMap
		stateMap.put(SceneType.STTypeList, transferMapSTTypeList);
		
		//初始化SceneType.STType场景的转移出口，包括help、set、dc********************
		HashMap<String, Func<StateStack,String> > transferMapSTType = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneType.STType场景的转移出口help
		transferMapSTType.put("help", FuncBase::help);
		//新增SceneType.STType场景的转移出口set
		transferMapSTType.put("set", FuncBase::set);
		// 新增SceneType.STType场景的转移出口dc
		transferMapSTType.put("dc", FuncBase::dc);
		//所有STType状态下的转移都put到transferMapSTType中，最后把transferMapSTType加入stateMap
		stateMap.put(SceneType.STType, transferMapSTType);	
		
		
				
//2018-12-24新增此注释，以下无用
/*		
		//初始化SceneType.STCommonUser场景的转移出口，包括help、pwd、whoami、attr********************
		HashMap<String, Func<StateStack,String> > transferMapSTCommonUser = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneType.STCommonUser场景的转移出口help
		transferMapSTCommonUser.put("help", FuncBase::help);
		//新增SceneType.STCommonUser场景的转移出口help
		transferMapSTCommonUser.put("pwd", FuncBase::pwd);
		//新增SceneType.STCommonUser场景的转移出口lsf
		transferMapSTCommonUser.put("lsf", FuncBase::clsf);
		//新增SceneType.STCommonUser场景的转移出口lst
		transferMapSTCommonUser.put("lst", FuncBase::clst);
		// 新增SceneType.STCommonUser场景的转移出口lss
		transferMapSTCommonUser.put("lss", FuncBase::clss);
		// 新增SceneType.STCommonUser场景的转移出口cdp
		transferMapSTCommonUser.put("cdf", FuncBase::ccdf);
		// 新增SceneType.STCommonUser场景的转移出口cdt
		transferMapSTCommonUser.put("cdt", FuncBase::ccdt);
		// 新增SceneType.STCommonUser场景的转移出口cds
		transferMapSTCommonUser.put("cds", FuncBase::ccds);		


		//所有STCommonUser状态下的转移都put到transferMapSTCommonUser中，最后把transferMapSTCommonUser加入stateMap
		stateMap.put(SceneType.STCommonUser, transferMapSTCommonUser);
		
		//初始化SceneType.STCommonAdmin场景的转移出口，包括help、pwd、whoami、attr********************
		HashMap<String, Func<StateStack,String> > transferMapSTCommonAdmin = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneType.STCommonAdmin场景的转移出口help
		transferMapSTCommonAdmin.put("help", FuncBase::help);
		//新增SceneType.STCommonAdmin场景的转移出口help
		transferMapSTCommonAdmin.put("pwd", FuncBase::pwd);
		//新增SceneType.STCommonAdmin场景的转移出口lsp
		transferMapSTCommonAdmin.put("lsp", FuncBase::clsp);
		//新增SceneType.STCommonAdmin场景的转移出口lst
		transferMapSTCommonAdmin.put("lst", FuncBase::clst);
		// 新增SceneType.STCommonAdmin场景的转移出口lss
		transferMapSTCommonAdmin.put("lss", FuncBase::clss);
		// 新增SceneType.STCommonAdmin场景的转移出口addp
		transferMapSTCommonAdmin.put("addp", FuncBase::caddp);
		// 新增SceneType.STCommonAdmin场景的转移出口addt
		transferMapSTCommonAdmin.put("addt", FuncBase::caddt);
		// 新增SceneType.STCommonAdmin场景的转移出口adds
		transferMapSTCommonAdmin.put("adds", FuncBase::cadds);
		// 新增SceneType.STCommonAdmin场景的转移出口cdp
		transferMapSTCommonAdmin.put("cdp", FuncBase::ccdp);
		// 新增SceneType.STCommonAdmin场景的转移出口cdt
		transferMapSTCommonAdmin.put("cdt", FuncBase::ccdt);
		// 新增SceneType.STCommonAdmin场景的转移出口cds
		transferMapSTCommonAdmin.put("cds", FuncBase::ccds);		
		// 新增SceneType.STCommonAdmin场景的转移出口delp
		transferMapSTCommonAdmin.put("delp", FuncBase::cdelp);
		// 新增SceneType.STCommonAdmin场景的转移出口delt
		transferMapSTCommonAdmin.put("delt", FuncBase::cdelt);
		// 新增SceneType.STCommonAdmin场景的转移出口dels
		transferMapSTCommonAdmin.put("dels", FuncBase::cdels);	
		// 新增SceneType.STCommonAdmin场景的转移出口grant
		transferMapSTCommonAdmin.put("grant", FuncBase::cgrant);


		//所有STCommonAdmin状态下的转移都put到transferMapSTCommonAdmin中，最后把transferMapSTCommonAdmin加入stateMap
		stateMap.put(SceneType.STCommonAdmin, transferMapSTCommonAdmin);
		
		//2018-11-18
		//初始化SceneType.STUser场景的转移出口，包括help、pwd、whoami、attr********************
		HashMap<String, Func<StateStack,String> > transferMapSTUser = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneType.STUser场景的转移出口help
		transferMapSTUser.put("help", FuncBase::help);
		//新增SceneType.STUser场景的转移出口help
		transferMapSTUser.put("pwd", FuncBase::pwd);
		//新增SceneType.STUser场景的转移出口whoami
		transferMapSTUser.put("attr", FuncBase::attr);		
		transferMapSTUser.put("newattr", FuncBase::newattr);		
		//新增SceneType.STUser场景的转移出口whoami
		transferMapSTUser.put("whoami", FuncBase::whoami);	
		//新增SceneType.STUser场景的转移出口dc
		transferMapSTUser.put("dc", FuncBase::dc);
		//新增SceneType.STUser场景的转移出口lsp
		transferMapSTUser.put("lsp", FuncBase::lsp);
		//新增SceneType.STUser场景的转移出口lst
		transferMapSTUser.put("lst", FuncBase::lst);
		// 新增SceneType.STUser场景的转移出口lss
		transferMapSTUser.put("lss", FuncBase::lss);
		// 新增SceneType.STUser场景的转移出口addp
		transferMapSTUser.put("addp", FuncBase::addp);
		// 新增SceneType.STUser场景的转移出口addp
		transferMapSTUser.put("addt", FuncBase::addt);
		// 新增SceneType.STUser场景的转移出口addp
		transferMapSTUser.put("adds", FuncBase::adds);
		// 新增SceneType.STUser场景的转移出口cdp
		transferMapSTUser.put("cdp", FuncBase::cdp);
		// 新增SceneType.STUser场景的转移出口cdp
		transferMapSTUser.put("cdt", FuncBase::cdt);
		// 新增SceneType.STUser场景的转移出口cdp
		transferMapSTUser.put("cds", FuncBase::cds);		
		// 新增SceneType.STUser场景的转移出口delp
		transferMapSTUser.put("delp", FuncBase::delp);
		// 新增SceneType.STUser场景的转移出口delp
		transferMapSTUser.put("delt", FuncBase::delt);
		// 新增SceneType.STUser场景的转移出口delp
		transferMapSTUser.put("dels", FuncBase::dels);	
		// 新增SceneType.STUser场景的转移出口grant
		transferMapSTUser.put("grant", FuncBase::grant);
		// 新增SceneType.STUser场景的转移出口common
		transferMapSTUser.put("common", FuncBase::common);
		//所有STUser状态下的转移都put到transferMapSTUser中，最后把transferMapSTUser加入stateMap
		stateMap.put(SceneType.STUser, transferMapSTUser);
		
		//2018-12-03
		//初始化SceneType.STStruct场景的转移出口，包括help、pwd、whoami、attr********************
		HashMap<String, Func<StateStack,String> > transferMapSTStruct = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneType.STStruct场景的转移出口help
		transferMapSTStruct.put("help", FuncBase::help);
		//新增SceneType.STStruct场景的转移出口help
		transferMapSTStruct.put("pwd", FuncBase::pwd);
		//新增SceneType.STStruct场景的转移出口whoami
		transferMapSTStruct.put("attr", FuncBase::attr);	
		transferMapSTStruct.put("newattr", FuncBase::newattr);
		//新增SceneType.STStruct场景的转移出口whoami
		transferMapSTStruct.put("whoami", FuncBase::whoami);	
		//新增SceneType.STStruct场景的转移出口dc
		transferMapSTStruct.put("dc", FuncBase::dc);
		//新增SceneType.STStruct场景的转移出口lssi
		transferMapSTStruct.put("lssi", FuncBase::lssi);
		//新增SceneType.STStruct场景的转移出口cdsi
		transferMapSTStruct.put("cdsi", FuncBase::cdsi);
		//新增SceneType.STStruct场景的转移出口addsi
		transferMapSTStruct.put("addsi", FuncBase::addsi);
		//新增SceneType.STStruct场景的转移出口delsi
		transferMapSTStruct.put("delsi", FuncBase::delsi);
		//所有STStruct状态下的转移都put到transferMapSTStruct中，最后把transferMapSTStruct加入stateMap
		stateMap.put(SceneType.STStruct, transferMapSTStruct);
		
		//2018-12-03
		//初始化SceneType.STStructItem场景的转移出口，包括help、pwd、whoami、attr********************
		HashMap<String, Func<StateStack,String> > transferMapSTStructItem = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneType.STStructItem场景的转移出口help
		transferMapSTStructItem.put("help", FuncBase::help);
		//新增SceneType.STStructItem场景的转移出口help
		transferMapSTStructItem.put("pwd", FuncBase::pwd);
		//新增SceneType.STStructItem场景的转移出口whoami
		transferMapSTStructItem.put("attr", FuncBase::attr);	
		transferMapSTStructItem.put("newattr", FuncBase::newattr);	
		//新增SceneType.STStructItem场景的转移出口whoami
		transferMapSTStructItem.put("whoami", FuncBase::whoami);	
		//新增SceneType.STStructItem场景的转移出口dc
		transferMapSTStructItem.put("dc", FuncBase::dc);
		//所有STStructItem状态下的转移都put到transferMapSTStructItem中，最后把transferMapSTStructItem加入stateMap
		stateMap.put(SceneType.STStructItem, transferMapSTStructItem);
		
		//2018-12-03
		//初始化SceneType.STType场景的转移出口，包括help、pwd、whoami、attr********************
		HashMap<String, Func<StateStack,String> > transferMapSTType = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneType.STType场景的转移出口help
		transferMapSTType.put("help", FuncBase::help);
		//新增SceneType.STType场景的转移出口help
		transferMapSTType.put("pwd", FuncBase::pwd);
		//新增SceneType.STType场景的转移出口whoami
		transferMapSTType.put("attr", FuncBase::attr);	
		transferMapSTType.put("newattr", FuncBase::newattr);	
		//新增SceneType.STType场景的转移出口whoami
		transferMapSTType.put("whoami", FuncBase::whoami);	
		//新增SceneType.STType场景的转移出口dc
		transferMapSTType.put("dc", FuncBase::dc);
		//所有STType状态下的转移都put到transferMapSTType中，最后把transferMapSTType加入stateMap
		stateMap.put(SceneType.STType, transferMapSTType);
	
		//2018-12-03
		//初始化SceneType.STProject场景的转移出口，包括help、pwd、whoami、attr********************
		HashMap<String, Func<StateStack,String> > transferMapSTProject = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneType.STProject场景的转移出口help
		transferMapSTProject.put("help", FuncBase::help);
		//新增SceneType.STProject场景的转移出口help
		transferMapSTProject.put("pwd", FuncBase::pwd);
		//新增SceneType.STProject场景的转移出口whoami
		transferMapSTProject.put("attr", FuncBase::attr);	
		transferMapSTProject.put("newattr", FuncBase::newattr);
		//新增SceneType.STProject场景的转移出口whoami
		transferMapSTProject.put("whoami", FuncBase::whoami);	
		//新增SceneType.STProject场景的转移出口dc
		transferMapSTProject.put("dc", FuncBase::dc);
		//新增SceneType.STProject场景的转移出口lsf
		transferMapSTProject.put("lsf", FuncBase::lsf);
		//新增SceneType.STProject场景的转移出口lsv
		transferMapSTProject.put("lsv", FuncBase::lsv);
		//新增SceneType.STProject场景的转移出口cdf
		transferMapSTProject.put("cdf", FuncBase::cdf);
		//新增SceneType.STProject场景的转移出口cdv
		transferMapSTProject.put("cdv", FuncBase::cdv);
		//新增SceneType.STProject场景的转移出口addf
		transferMapSTProject.put("addf", FuncBase::addf);
		//新增SceneType.STProject场景的转移出口addv
		transferMapSTProject.put("addv", FuncBase::addv);
		//新增SceneType.STProject场景的转移出口delf
		transferMapSTProject.put("delf", FuncBase::delf);
		//新增SceneType.STProject场景的转移出口delv
		transferMapSTProject.put("delv", FuncBase::delv);
		//所有STProject状态下的转移都put到transferMapSTProject中，最后把transferMapSTProject加入stateMap
		stateMap.put(SceneType.STProject, transferMapSTProject);
		
		
		//2018-12-03
		//初始化SceneType.STFunc场景的转移出口，包括help、pwd、whoami、attr********************
		HashMap<String, Func<StateStack,String> > transferMapSTFunc = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneType.STFunc场景的转移出口help
		transferMapSTFunc.put("help", FuncBase::help);
		//新增SceneType.STFunc场景的转移出口help
		transferMapSTFunc.put("pwd", FuncBase::pwd);
		//新增SceneType.STFunc场景的转移出口whoami
		transferMapSTFunc.put("attr", FuncBase::attr);	
		transferMapSTFunc.put("newattr", FuncBase::newattr);
		//新增SceneType.STFunc场景的转移出口whoami
		transferMapSTFunc.put("whoami", FuncBase::whoami);	
		//新增SceneType.STFunc场景的转移出口dc
		transferMapSTFunc.put("dc", FuncBase::dc);
		//新增SceneType.STFunc场景的转移出口lsf
		transferMapSTFunc.put("lsfs", FuncBase::lsfs);
		//新增SceneType.STFunc场景的转移出口lsv
		transferMapSTFunc.put("lsfv", FuncBase::lsfv);
		//新增SceneType.STFunc场景的转移出口cdf
		transferMapSTFunc.put("cdfs", FuncBase::cdfs);
		//新增SceneType.STFunc场景的转移出口cdv
		transferMapSTFunc.put("cdfv", FuncBase::cdfv);
		//新增SceneType.STFunc场景的转移出口addf
		transferMapSTFunc.put("addfs", FuncBase::addfs);
		transferMapSTFunc.put("newaddfs", FuncBase::newaddfs);
		//新增SceneType.STFunc场景的转移出口addv
		transferMapSTFunc.put("addfv", FuncBase::addfv);
		//新增SceneType.STFunc场景的转移出口delf
		transferMapSTFunc.put("delfs", FuncBase::delfs);
		//新增SceneType.STFunc场景的转移出口delv
		transferMapSTFunc.put("delfv", FuncBase::delfv);
		//所有STFunc状态下的转移都put到transferMapSTFunc中，最后把transferMapSTFunc加入stateMap
		stateMap.put(SceneType.STFunc, transferMapSTFunc);
		
		//2018-12-03
		//初始化SceneFuncStatement.STFuncStatement场景的转移出口，包括help、pwd、whoami、attr********************
		HashMap<String, Func<StateStack,String> > transferMapSTFuncStatement = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneFuncStatement.STFuncStatement场景的转移出口help
		transferMapSTFuncStatement.put("help", FuncBase::help);
		//新增SceneFuncStatement.STFuncStatement场景的转移出口help
		transferMapSTFuncStatement.put("pwd", FuncBase::pwd);
		//新增SceneFuncStatement.STFuncStatement场景的转移出口whoami
		transferMapSTFuncStatement.put("attr", FuncBase::attr);	
		transferMapSTFuncStatement.put("newattr", FuncBase::newattr);	
		//新增SceneFuncStatement.STFuncStatement场景的转移出口whoami
		transferMapSTFuncStatement.put("whoami", FuncBase::whoami);	
		//新增SceneFuncStatement.STFuncStatement场景的转移出口dc
		transferMapSTFuncStatement.put("dc", FuncBase::dc);
		//所有FuncStatement状态下的转移都put到transferMapSTFuncStatement中，最后把transferMapSTFuncStatement加入stateMap
		stateMap.put(SceneType.STFuncStatement, transferMapSTFuncStatement);
		
		
		//2018-12-03
		//初始化SceneType.STFuncVar场景的转移出口，包括help、pwd、whoami、attr********************
		HashMap<String, Func<StateStack,String> > transferMapSTFuncVar = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneType.STFuncVar场景的转移出口help
		transferMapSTFuncVar.put("help", FuncBase::help);
		//新增SceneType.STFuncVar场景的转移出口help
		transferMapSTFuncVar.put("pwd", FuncBase::pwd);
		//新增SceneType.STFuncVar场景的转移出口whoami
		transferMapSTFuncVar.put("attr", FuncBase::attr);	
		transferMapSTFuncVar.put("newattr", FuncBase::newattr);	
		//新增SceneType.STFuncVar场景的转移出口whoami
		transferMapSTFuncVar.put("whoami", FuncBase::whoami);	
		//新增SceneType.STFuncVar场景的转移出口dc
		transferMapSTFuncVar.put("dc", FuncBase::dc);
		//新增SceneType.STFuncVar场景的转移出口lssi
		transferMapSTFuncVar.put("lsfvi", FuncBase::lsfvi);
		//新增SceneType.STFuncVar场景的转移出口cdsi
		transferMapSTFuncVar.put("cdfvi", FuncBase::cdfvi);
		//新增SceneType.STFuncVar场景的转移出口addsi
		transferMapSTFuncVar.put("addfvi", FuncBase::addfvi);
		//新增SceneType.STFuncVar场景的转移出口delsi
		transferMapSTFuncVar.put("delfvi", FuncBase::delfvi);
		//所有STFuncVar状态下的转移都put到transferMapSTFuncVar中，最后把transferMapSTFuncVar加入stateMap
		stateMap.put(SceneType.STFuncVar, transferMapSTFuncVar);
		
		// 2018-12-03
		// 初始化SceneFuncVarItem场景的转移出口，包括help、pwd、whoami、attr********************
		HashMap<String, Func<StateStack, String>> transferMapSTFuncVarItem = new HashMap<String, Func<StateStack, String>>();
		// 新增SceneFuncVarItem.STFuncVarItem场景的转移出口help
		transferMapSTFuncVarItem.put("help", FuncBase::help);
		// 新增SceneFuncVarItem.STFuncVarItem场景的转移出口help
		transferMapSTFuncVarItem.put("pwd", FuncBase::pwd);
		// 新增SceneFuncVarItem.STFuncVarItem场景的转移出口whoami
		transferMapSTFuncVarItem.put("attr", FuncBase::attr);
		transferMapSTFuncVarItem.put("newattr", FuncBase::newattr);
		// 新增SceneFuncVarItem.STFuncVarItem场景的转移出口whoami
		transferMapSTFuncVarItem.put("whoami", FuncBase::whoami);
		// 新增SceneFuncVarItem.STFuncVarItem场景的转移出口dc
		transferMapSTFuncVarItem.put("dc", FuncBase::dc);
		// 所有STFuncVarItem状态下的转移都put到transferMapSTFuncVarItem中，最后把transferMapSTFuncVarItem加入stateMap
		stateMap.put(SceneType.STFuncVarItem, transferMapSTFuncVarItem);
		
		//2018-12-03
		//初始化SceneType.STVar场景的转移出口，包括help、pwd、whoami、attr********************
		HashMap<String, Func<StateStack,String> > transferMapSTVar = new HashMap<String, Func<StateStack,String>>();   
		//新增SceneType.STVar场景的转移出口help
		transferMapSTVar.put("help", FuncBase::help);
		//新增SceneType.STVar场景的转移出口help
		transferMapSTVar.put("pwd", FuncBase::pwd);
		//新增SceneType.STVar场景的转移出口whoami
		transferMapSTVar.put("attr", FuncBase::attr);		
		transferMapSTVar.put("newattr", FuncBase::newattr);
		//新增SceneType.STVar场景的转移出口whoami
		transferMapSTVar.put("whoami", FuncBase::whoami);	
		//新增SceneType.STVar场景的转移出口dc
		transferMapSTVar.put("dc", FuncBase::dc);
		//新增SceneType.STVar场景的转移出口lssi
		transferMapSTVar.put("lsvi", FuncBase::lsvi);
		//新增SceneType.STVar场景的转移出口cdsi
		transferMapSTVar.put("cdvi", FuncBase::cdvi);
		//新增SceneType.STVar场景的转移出口addsi
		transferMapSTVar.put("addvi", FuncBase::addvi);
		//新增SceneType.STVar场景的转移出口delsi
		transferMapSTVar.put("delvi", FuncBase::delvi);
		//所有STVar状态下的转移都put到transferMapSTVar中，最后把transferMapSTVar加入stateMap
		stateMap.put(SceneType.STVar, transferMapSTVar);
		
		// 2018-12-03
		// 初始化SceneVarItem.STVarItem场景的转移出口，包括help、pwd、whoami、attr********************
		HashMap<String, Func<StateStack, String>> transferMapSTVarItem = new HashMap<String, Func<StateStack, String>>();
		// 新增SceneVarItem.STVarItem场景的转移出口help
		transferMapSTVarItem.put("help", FuncBase::help);
		// 新增SceneVarItem.STVarItem场景的转移出口help
		transferMapSTVarItem.put("pwd", FuncBase::pwd);
		// 新增SceneVarItem.STVarItem场景的转移出口whoami
		transferMapSTVarItem.put("attr", FuncBase::attr);
		transferMapSTVarItem.put("newattr", FuncBase::newattr);
		// 新增SceneVarItem.STVarItem场景的转移出口whoami
		transferMapSTVarItem.put("whoami", FuncBase::whoami);
		// 新增SceneVarItem.STVarItem场景的转移出口dc
		transferMapSTVarItem.put("dc", FuncBase::dc);
		// 所有STVarItem状态下的转移都put到transferMapSTVarItem中，最后把transferMapSTVarItem加入stateMap
		stateMap.put(SceneType.STVarItem, transferMapSTVarItem);
*/		
				
		/////////////////////////////////////////////////////////////////////////
		//2018-12-03 新增此注释 以下无用
		
		//2018-11-17注释掉以下2018-11-12和2018-11-11新增的所有内容
/*		//初始化SceneType.STUser场景的转移出口，包括cd********************
		//2018-11-12
		//新增SceneType.STUser场景的转移出口cd（可进SceneType.STProject，可进SceneType.STVar，可进SceneType.STStruct，可进SceneType.STType。根据第一个参数arg1决定进哪一类）
		HashMap<String, Func<StateStack,String> > transferMapSTUserCd = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTUserCd.put("cd", FuncBase::cd);
		stateMap.put(SceneType.STUser, transferMapSTUserCd);
		
		//初始化SceneType.STUser场景的转移出口，包括cd********************
		//以下是初始化SceneType.STProject场景的转移出口,包括cd/dc/list/add/del********************
		
		//2018-11-12
		//新增SceneType.STProject场景的转移出口cd（可进project编辑，可进根据第一个参数arg1决定进哪一个project）
		HashMap<String, Func<StateStack,String> > transferMapSTProjectCd = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTProjectCd.put("cd", FuncBase::cd);
		stateMap.put(SceneType.STProject, transferMapSTProjectCd);
		
		//2018-11-12
		//新增SceneType.STProject状态的转移出口list（可列出当前用户所有Project）
		HashMap<String, Func<StateStack,String> > transferMapSTProjectLs = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTProjectLs.put("ls", FuncBase::ls);
		stateMap.put(SceneType.STProject, transferMapSTProjectLs);
		
		//2018-11-12
		//新增SceneType.STProject状态的转移出口add（可新增Project，根据第一个参数arg1决定新增的project名，状态不变）
		HashMap<String, Func<StateStack,String> > transferMapSTProjectAdd = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTProjectAdd.put("add", FuncBase::add);
		stateMap.put(SceneType.STProject, transferMapSTProjectAdd);
		
		//2018-11-12
		//新增SceneType.STProject状态的转移出口del（可删除Project，根据第一个参数arg1决定删除哪一个project）
		HashMap<String, Func<StateStack,String> > transferMapSTProjectDel = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTProjectDel.put("del", FuncBase::del);
		stateMap.put(SceneType.STProject, transferMapSTProjectDel);
			
		//2018-11-11
		//新增SceneType.STProject状态的转移出口dc（可退至SceneType.STUser）
		HashMap<String, Func<StateStack,String> > transferMapSTProjectDc = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTProjectDc.put("dc", FuncBase::dc);
		stateMap.put(SceneType.STProject, transferMapSTProjectDc);
	
		
		
		
		
		//+++++++++++++++++++++++++++
		//初始化SceneType.STUser状态的转移出口，包括cd/list/add/del********************
		//2018-11-11
		//新增SceneType.STUser状态的转移出口cd（可进SceneType.STProject，可进SceneType.STVar，可进SceneType.STFunc，可进SceneType.STStruct，可进SceneType.STType。根据第一个参数arg1决定进哪一类，根据第二个参数arg2决定进相应类的哪一个）
		HashMap<String, Func<StateStack,String> > transferMapSTUserCd = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTUserCd.put("cd", FuncBase::cd);
		stateMap.put(SceneType.STUser, transferMapSTUserCd);
		
		//2018-11-11
		//新增SceneType.STUser状态的转移出口list（可列出Struct、Project、Var、Func根据第一个参数arg1决定列出哪一类，状态不变）
		HashMap<String, Func<StateStack,String> > transferMapSTUserLs = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTUserLs.put("ls", FuncBase::ls);
		stateMap.put(SceneType.STUser, transferMapSTUserLs);
		
		//2018-11-11
		//新增SceneType.STUser状态的转移出口add（可新增Struct、Project、Var、Func根据第一个参数arg1决定列出哪一类，状态不变）
		HashMap<String, Func<StateStack,String> > transferMapSTUserAdd = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTUserAdd.put("add", FuncBase::add);
		stateMap.put(SceneType.STUser, transferMapSTUserAdd);
		
		//2018-11-11
		//新增SceneType.STUser状态的转移出口del（可删除Struct、Project、Var、Func根据第一个参数arg1决定列出哪一类，根据第二个参数arg2决定删除相应类的哪一个，状态不变）
		HashMap<String, Func<StateStack,String> > transferMapSTUserDel = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTUserDel.put("del", FuncBase::del);
		stateMap.put(SceneType.STUser, transferMapSTUserDel);
		
				
		//以上是初始化SceneType.STUser状态的转移出口,包括cd/list/add/del********************
		//以下是初始化SceneType.STProject状态的转移出口,包括cd/dc/list/add/del********************
		
		//2018-11-11
		//新增SceneType.STProject状态的转移出口cd（可进SceneType.STProject，可进SceneType.STVar，可进SceneType.STFunc，可进根据第一个参数arg1决定进哪一类，根据第二个参数arg2决定进相应类的哪一个）
		HashMap<String, Func<StateStack,String> > transferMapSTProjectCd = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTProjectCd.put("cd", FuncBase::cd);
		stateMap.put(SceneType.STProject, transferMapSTProjectCd);
		
		//2018-11-11
		//新增SceneType.STProject状态的转移出口list（可列出Project所属的Var、Func根据第一个参数arg1决定列出哪一类，状态不变）
		HashMap<String, Func<StateStack,String> > transferMapSTProjectLs = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTProjectLs.put("ls", FuncBase::ls);
		stateMap.put(SceneType.STProject, transferMapSTProjectLs);
		
		//2018-11-11
		//新增SceneType.STProject状态的转移出口add（可新增Var、Func根据第一个参数arg1决定列出哪一类，状态不变）
		HashMap<String, Func<StateStack,String> > transferMapSTProjectAdd = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTProjectAdd.put("add", FuncBase::add);
		stateMap.put(SceneType.STProject, transferMapSTProjectAdd);
		
		//2018-11-11
		//新增SceneType.STProject状态的转移出口del（可删除Var、Func根据第一个参数arg1决定列出哪一类，根据第二个参数arg2决定删除相应类的哪一个，状态不变）
		HashMap<String, Func<StateStack,String> > transferMapSTProjectDel = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTProjectDel.put("del", FuncBase::del);
		stateMap.put(SceneType.STProject, transferMapSTProjectDel);
			
		//2018-11-11
		//新增SceneType.STProject状态的转移出口dc（可退至SceneType.STUser）
		HashMap<String, Func<StateStack,String> > transferMapSTProjectDc = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTProjectDc.put("dc", FuncBase::dc);
		stateMap.put(SceneType.STProject, transferMapSTProjectDc);
		
		//以上是初始化SceneType.STProject状态的转移出口,包括cd/list/add/del********************
		//以下是初始化SceneType.STFunc状态的转移出口,包括cd/dc/list/add/del********************
		
		//2018-11-11
		//新增SceneType.STFunc状态的转移出口cd（可进SceneType.STFunc，可进SceneType.STVar，可进SceneType.STFunc，可进根据第一个参数arg1决定进哪一类，根据第二个参数arg2决定进相应类的哪一个）
		HashMap<String, Func<StateStack,String> > transferMapSTFuncCd = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTFuncCd.put("cd", FuncBase::cd);
		stateMap.put(SceneType.STFunc, transferMapSTFuncCd);
		
		//2018-11-11
		//新增SceneType.STFunc状态的转移出口list（可列出Project所属的Var、Func根据第一个参数arg1决定列出哪一类，状态不变）
		HashMap<String, Func<StateStack,String> > transferMapSTFuncLs = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTFuncLs.put("ls", FuncBase::ls);
		stateMap.put(SceneType.STFunc, transferMapSTFuncLs);
		
		//2018-11-11
		//新增SceneType.STFunc状态的转移出口add（可新增Var、Func根据第一个参数arg1决定列出哪一类，状态不变）
		HashMap<String, Func<StateStack,String> > transferMapSTFuncAdd = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTFuncAdd.put("add", FuncBase::add);
		stateMap.put(SceneType.STFunc, transferMapSTFuncAdd);
		
		//2018-11-11
		//新增SceneType.STFunc状态的转移出口del（可删除Var、Func根据第一个参数arg1决定列出哪一类，根据第二个参数arg2决定删除相应类的哪一个，状态不变）
		HashMap<String, Func<StateStack,String> > transferMapSTFuncDel = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTFuncDel.put("del", FuncBase::del);
		stateMap.put(SceneType.STFunc, transferMapSTFuncDel);
			
		//2018-11-11
		//新增SceneType.STFunc状态的转移出口dc（可退至SceneType.STUser）
		HashMap<String, Func<StateStack,String> > transferMapSTFuncDc = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTFuncDc.put("dc", FuncBase::dc);
		stateMap.put(SceneType.STFunc, transferMapSTFuncDc);
		
		//以上是初始化SceneType.STFunc状态的转移出口,包括cd/list/add/del********************
		//以下是初始化SceneType.STFuncStatement状态的转移出口,包括dc/vi/more********************
		
		//2018-11-11
		//新增SceneType.STFuncStatement状态的转移出口vi（可编辑当前行、Func根据第一个参数arg1决定此行的新内容，状态不变）
		HashMap<String, Func<StateStack,String> > transferMapSTFuncStatementVi = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTFuncStatementVi.put("vi", FuncBase::vi);
		stateMap.put(SceneType.STFuncStatement, transferMapSTFuncStatementVi);
		
		//2018-11-11
		//新增SceneType.STFuncStatement状态的转移出口more（可显示当前行，状态不变）
		HashMap<String, Func<StateStack,String> > transferMapSTFuncStatementMore = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTFuncStatementMore.put("more", FuncBase::more);
		stateMap.put(SceneType.STFuncStatement, transferMapSTFuncStatementMore);
		
		//2018-11-11
		//新增SceneType.STFuncStatement状态的转移出口dc（可退至SceneType.STUser）
		HashMap<String, Func<StateStack,String> > transferMapSTFuncStatementDc = new HashMap<String, Func<StateStack,String>>();   
		transferMapSTFuncStatementDc.put("dc", FuncBase::dc);
		stateMap.put(SceneType.STFuncStatement, transferMapSTFuncStatementDc);	
*/
		//2018-11-11注释掉以下内容
		/*		
 		//插入state0状态的转移出口cd（可进state1，可进state2，根据第一个参数arg1） 		
		HashMap<String, Func<StateStack,String> > transferMap0 = new HashMap<String, Func<StateStack,String>>();   
		transferMap0.put("cd", FuncBase::cd);
		stateMap.put(SceneType.STUser, transferMap0);

  		//插入state1状态的转移出口dc（可进state2，根据第一个参数arg1；可退至state0）
		
		HashMap<String, Func<StateStack,String> > transferMap1 = new HashMap<String, Func<StateStack,String>>();   
		transferMap1.put("cd", FuncBase::cd);
		transferMap1.put("dc", FuncBase::dc);
		stateMap.put("state1", transferMap1);
		
		//插入state2状态的转移出口（可进state1，根据第一个参数arg1；可退至state0）
		HashMap<String, Func<StateStack,String> > transferMap2 = new HashMap<String, Func<StateStack,String>>();   
		transferMap2.put("cd", FuncBase::cd);
		transferMap2.put("dc", FuncBase::dc);
		stateMap.put("state2", transferMap2);*/
		
	}
	
	
	/**
	 * 进行状态转移
	 * @param strOrder
	 * @param strArg1
	 * @param strArg2
	 */
	//2018-11-18 取消参数String reqContent，将String strArg1, String strArg2合并为String strArgs
	//2018-11-17 在参数中，增加一项String reqContent
	//public String transferState(String reqContent, String strOrder, String strArg1, String strArg2) {
	//2018-12-07 增加参数int idUser
	//public String transferState(String strOrder, String strArgs) {
	public String transferState(int idUser, String strOrder, String strArgs) {
		
		String respContent = null;
		State nowState = stateStacks[idUser].getCurrentState();
		Func<StateStack,String> func = stateMap.get(nowState.getSceneType()).get(strOrder);
		
		
		//如果找到转移项就调用转移方法进行状态转移，否则状态不变
		if (null != func) {
			//2018-11-18 取消对nowState中reqContent属性的设置，
			//2018-11-7 增加对nowState的reqContent属性的设置
			//nowState.setReqContent(reqContent);
			respContent = func.apply(stateStacks[idUser],strArgs);
		}else {
			System.out.println("找不到对应的状态转移项");
			respContent = "很抱歉，小牛无法处理你的命令。\n\n";
			respContent += FuncBase.help(stateStacks[idUser], strArgs);
			return respContent;
		}
		
		//2018-11-18 取消transferState（）中的状态转移操作
/*		//如果返回非空状态，则更新当前状态nowState
		if(null != nextState) {
			this.nowState = nextState;
		}*/
		
		return respContent;

	}
	
	//TODO
	
	String getOrder(SceneType ST,String strOrder) {
		
		strOrder = strOrder.toLowerCase();
	    if (strOrder != null && !"".equals(strOrder.trim()))
	        if(strOrder.matches("^[0-9]*$")) {
	        	int index = Integer.parseInt(strOrder);
	        }
	    else
	        return "";
		
		return strOrder;
		
	}
	
	
}

