package io;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class PrintUtils {
	
	public static void obj2String(HttpServletResponse resp,Object obj){
		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(JSON.toJSONString(obj));
	}

}
