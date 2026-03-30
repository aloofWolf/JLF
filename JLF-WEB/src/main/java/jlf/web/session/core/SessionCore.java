package jlf.web.session.core;

import jlf.plus.snowflake.SnowFlakePlus;
import jlf.plus.threadLocal.ThreadLocalPlus;
import jlf.web.exception.BusinessException;
import jlf.web.session.bean.UserSession;
import jlf.web.session.dao.SessionDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName: SessionService
 * @Description: SessionService
 * @author Lone Wolf
 * @date 2019年9月10日
 */
@Slf4j
@Service
public class SessionCore {

	@Autowired
	private SessionDao dao;

	/**
	 * 
	 * @Title: createSession
	 * @Description: 生成session
	 * @param userId
	 * @param userName
	 * @param obj
	 * @param response
	 * @return
	 */
	public <T> String createSession(Long userId, String userName, T obj, HttpServletResponse response) {
		String token = SnowFlakePlus.getSerialNumber("SESSION-");
		UserSession<T> session = new UserSession<T>(userId, userName, obj);
		long begin = System.currentTimeMillis();
		dao.saveSession(token, session);
		long end = System.currentTimeMillis();
		long time = end - begin;
		log.info("createSession-redis耗时："+time);
		response.setHeader("token", token);
		return token;
	}

	/**
	 * 
	 * @Title: validateSession
	 * @Description: 校验session
	 * @param request
	 * @return
	 */
	public <T> UserSession<T> validateSession(HttpServletRequest request) {
		String token = request.getHeader("token");
		if (token == null) {
			throw new BusinessException("请重新登录");
		}
		UserSession<T> session = dao.getSession(token);
		if (session == null) {
			throw new BusinessException("请重新登录");
		}
		dao.resetSessionPeriod(token);
		ThreadLocalPlus.put("userSession", session);
		return session;
	}

	/**
	 * 
	 * @Title: deleteSession
	 * @Description: 删除session
	 * @param response
	 */
	public <T> void deleteSession(HttpServletResponse response) {
		String token = response.getHeader("token");
		UserSession<T> session = dao.getSession(token);
		Long userId = null;
		if (session != null) {
			userId = session.getUserId();
		}
		dao.deleteSession(userId, token);
	}

	/**
	 * 
	 * @Title: getUserOnlineCount
	 * @Description: 获取在线用户数
	 * @param response
	 * @return
	 */
	public Integer getUserOnlineCount(HttpServletResponse response) {
		return dao.userOnlineCount();
	}

}
