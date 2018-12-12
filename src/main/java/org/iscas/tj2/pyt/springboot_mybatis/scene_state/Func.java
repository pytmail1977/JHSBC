package org.iscas.tj2.pyt.springboot_mybatis.scene_state;


@FunctionalInterface
public interface Func<S, T> {
	public String apply(S s, T t);

}
