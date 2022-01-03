package cn.itcast.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */

@Component
public class LoginFilter extends ZuulFilter {

    /**
     * 定义过滤器类型
     *  pre
     *  routing
     *  post
     *  error
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 指定过滤器的执行顺序
     *   返回值越小，执行顺序越高
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     *
     * 当前过滤器是否生效
     *  true: 使用此过滤器
     *  false: 不是用此过滤器
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }


    /**
       指定过滤器中的业务逻辑
       身份认证:
          1.所有的请求需要携带一个参数: access-token
          2.获取request请求
          3.通过request获取参数access-token
          4.判断token是否为空
            4.1 token==null 身份验证失败
            4.2 token!=null 执行后续操作
     在zuul网关中，通过RequestContext的上下文对象，可以获取对象request对象
     */
    @Override
    public Object run() throws ZuulException {
//        System.out.println("执行了过滤器");

        // 1.获取zuul提供的上下文对象RequestContext
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 2.从RequestContext中获取request
        HttpServletRequest request = currentContext.getRequest();
        // 3.获取请求参数access-token
        String token = request.getParameter("token");
        // 4.判断
        // 4.1 如果token==null , 拦截请求，返回认证失败
        if (token == null){
           currentContext.setSendZuulResponse(false);
           currentContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
        }
        // 4.2 如果token!=null , 继续后续操作
        return null;

    }



}
