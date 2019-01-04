package org.iscas.tj2.pyt.springboot_mybatis.scene_state;

import org.iscas.tj2.pyt.springboot_mybatis.SceneType;

public class StateStack {

	private int max_size;
	private int top;
	private State[ ] stack;
	
	//为按场景的枚举类型返回中文，定义如下数组
/*	private String[] STCNAME = {
			"用户","结构","结构字段","类型","工程","函数","函数语句","函数变量","函数变量字段","全局变量","全局变量字段","共用对象","共用对象(管理员模式)"
	};*/
	//2018-12-27改为
	private String[] STCNAME = {
			"","","Func","","Type","Type","Macro","","Var",""
	};

	
	public StateStack(int size) {
		// TODO Auto-generated constructor stub
		this.max_size = size;
		this.top = 0;
		this.stack = new State[max_size];
		
	}
	
	public int push(State state) {
		stack[top++] = state;
		return top;
	}	
	
	public State pop() {
		return stack[top--];
	}
	
	public int sizeof() {
		return top;
	}
	
	public void clean() {
		top = 0;
	}
	
	//增加一个返回当前上下文提示字符串的方法
	public String getContext() {
		String strTmp = "";
		for(int i = 0;i<top; i++) {
			strTmp += stack[i].getStrComment();
			strTmp += "/";
		}
		strTmp += ":>";
		return strTmp;		
	}
	
	
	//2018-11-18 增加一个返回当前场景的函数	
/*	public String getPwd() {
		String strTmp = "";
		for(int i = 0;i<top; i++) {
			//strTmp += stack[i].getSceneType().toString();
			strTmp += STCNAME[stack[i].getSceneType().ordinal()]+stack[i].getIntId();
			strTmp += "/";
		}
		strTmp += ":>";
		return strTmp;		
	}*/
/*	//2018-12-12 如果没有第1层栈，或第1层栈不是STUser那么把第0层栈（即共用对象显示出来），否则不显示。
	public String getPwd() {
		String strTmp = "";
		int begin = 0;
		if(top>1?stack[1].getSceneType().equals(SceneType.STUser):false) {
			begin = 1;
		}
		for(int i = begin;i<top; i++) {
			//strTmp += stack[i].getSceneType().toString();
			strTmp += STCNAME[stack[i].getSceneType().ordinal()]+(i==0?"":stack[i].getIntId());
			strTmp += "/";
		}
		strTmp += ":>";
		return strTmp;		
	}*/
	//2018-12-24 修改getPwd函数，不使用增加了Common/Home两个空间后的pwd，在2018-11-18的版本的基础上做改动，当在“STXXList”（根据id是否为0进行判断）一类场景时，不显示id号，
	//2018-12-24
	//
	//	跳过根空间，只输出/
	//	有对应对象的场景只输出id号
	//	对象列表场景如MacroList，只输出简写Macro，不输出state的id字段/
	public String getPwd() {
		
		//2018-12-27 不再输出root场景下的用户Id
		//String strTmp = "";
		//for(int i = 0;i<top; i++) {
		String strTmp = "/";
		for(int i = 1;i<top; i++) {			
			//strTmp += stack[i].getSceneType().toString();
			String tmp = STCNAME[stack[i].getSceneType().ordinal()];
			//20190104
			//改为输出对象名，如果没有在输出id
			//strTmp += tmp+(tmp==""?stack[i].getIntId():"");
			String nameOrId = (stack[i].getStrName() == null?stack[i].getIntId()+"":stack[i].getStrName());		
			strTmp += tmp+(tmp==""?nameOrId:"");
			strTmp += "/";
		}
		strTmp += ":>";
		return strTmp;	
	}

	/**
	 * 返回当前状态栈的用户id
	 * @return
	 * -1:当前用户栈为空或指定深度超出了范围
	 * 其它：当前栈的第depth层的id
	 */
	public int getWhoseId(int depth) {
		if(top>=depth && depth>=0) {
			return stack[depth].getIntId();
		}else
			return -1;
	}
	
	
	/**
	 * 取当前状态
	 * @return
	 */
	public State getCurrentState() {
		return stack[top-1];
	}



}
