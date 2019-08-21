package bimingliang.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class DeclareAspect {
	
	/*
	 *  配置 ForExtendImplement 实现了 Extend 接口，具体实现类是 ExtendImplement。
	 *  value="bimingliang.aop.ForExtendImplement" 也可以改为 value="bimingliang.aop.ForExtend+"
	 *  表示所有 bimingliang.aop.ForExtend 子类，而不是 bimingliang.aop.ForExtend 本身。
	 */
	@DeclareParents(value="bimingliang.aop.ForExtendImplement",defaultImpl=ExtendImplement.class)
	public Extend extend;
	
}
