package com.whjbsoft.www.util;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 * <p>Title: 系统</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: zznode</p>
 * @author 
 * @CreatedTime: 2007-10-31
 * @version 1.0
 */
public class EncodingFilter implements Filter {

    private FilterConfig filterCfg;

    /**
     * 
     */
    public EncodingFilter() {
        super();
        // TODO 自动生成构造函数存根
    }

    /* （非 Javadoc）
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig arg0) throws ServletException {
        this.filterCfg = arg0;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filterChain) {
        try {
            String encoding = filterCfg.getInitParameter("encoding");
            if (encoding == null || "".equals(encoding)) {
                HttpServletRequest hreq = (HttpServletRequest) request;
                String clientEn = hreq.getHeader("accept-language");
                if ("zh-tw".equals(clientEn)) {
                    encoding = "Big5";
                } else if ("zh-cn".equals(clientEn)) {
                    encoding = "UTF-8";
                } else {
                    encoding = "ISO8859_1";
                }
            }
            request.setCharacterEncoding(encoding);
            filterChain.doFilter(request, response);
        } catch (Exception e) {
          e.printStackTrace();
        }

    }
    public void destroy() {

    }

}
