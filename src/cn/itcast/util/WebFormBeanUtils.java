package cn.itcast.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebFormBeanUtils {
	/**
	 * 把请求对象中的参数封装到FormBean中
	 * 
	 * @param request
	 * @return 封装好的FormBean
	 * @message 映射的过程就是将页面中的内容先用request获得，然后再将之转换为Map(这里用request.getParameterMap
	 *          ()） 最后使用BeanUtils.populate(info，map)方法将页面各个属性映射到bean中。
	 *          之后我们就可以这样使用bean.getXxxx()来取值了。
	 */

	public static <T> T fillFormBean(HttpServletRequest request, Class<T> clazz) {
		try {
			T bean = clazz.newInstance(); // 这是一个javabean
			// 将一些 key-value 的值（例如 hashmap）映射到 bean 中的属性
			BeanUtils.populate(bean, request.getParameterMap());
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
