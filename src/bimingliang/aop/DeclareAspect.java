package bimingliang.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class DeclareAspect {
	
	// 配置 ForExtendImplement 实现了 Extend 接口，具体实现类是 ExtendImplement
	@DeclareParents(value="bimingliang.aop.ForExtendImplement",defaultImpl=ExtendImplement.class)
	public Extend extend;
	
}
