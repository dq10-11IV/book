package com.turtledove.bookdrift.web.interceptors;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.turtledove.bookdrift.common.agent.LogServiceAgent;

/**
 * 异常拦截器：将action中可能抛出的异常在拦截器里面统一处理，这样减少action里面重复代码
 * @author ws
 *
 */
public class ExceptionInterceptor implements Interceptor {

    private static final long serialVersionUID = 1L;
    public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init() {
		// TODO Auto-generated method stub

	}
	public String intercept(ActionInvocation invocation) throws Exception {
		//TODO 如果有新的异常，可以分别处理
		
		LogServiceAgent.info("start",invocation.getAction().getClass().toString() );
		String result = Action.ERROR;
		try{
			 result = invocation.invoke();	
		}catch(Exception e){
		    e.printStackTrace();
			//LogServiceAgent.error(Action.ERROR, e);
			/*HttpServletResponse response = ServletActionContext.getResponse();
			JSONObject json = new JSONObject();
			json.put("code", "500");
			json.put("msg","error");
			response.setContentType("text/plain; charset=UTF-8");
            response.getWriter().print(json.toJSONString());
            return "success";*/
		}
		return result;
	}

}
