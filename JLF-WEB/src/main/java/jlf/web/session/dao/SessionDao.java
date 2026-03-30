package jlf.web.session.dao;

import com.alibaba.fastjson.JSONObject;
import jlf.web.config.WebConfig;
import jlf.web.session.bean.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @ClassName: UserSessionDao
 * @Description: 用户session的DAO
 * @author Lone Wolf
 * @date 2019年9月10日
 */
@Slf4j
@Component
public class SessionDao {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Autowired
	private WebConfig webConfig;

	/**
	 * 
	 * @Title: saveSession
	 * @Description: 保存session
	 * @param token
	 * @param session
	 */
	public <T> void saveSession(String token, UserSession<T> session) {
		long begin = System.currentTimeMillis();
		redisTemplate.opsForHash().put("userOnline", String.valueOf(session.getUserId()), token);
		long end = System.currentTimeMillis();
		long time = end - begin;
		log.info("saveSessionUserOnline-redis耗时："+time);
		begin = System.currentTimeMillis();
		redisTemplate.opsForValue().set(token, JSONObject.toJSONString(session), webConfig.getSessionPeriod(),
				TimeUnit.MINUTES);
	    end = System.currentTimeMillis();
		time = end - begin;
		log.info("createSessionToken-redis耗时："+time);
	}

	/**
	 * 
	 * @Title: getSession
	 * @Description: 获取session
	 * @param token
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> UserSession<T> getSession(String token) {
		long begin = System.currentTimeMillis();
		String redisValue = redisTemplate.opsForValue().get(token);
		long end = System.currentTimeMillis();
		long time = end - begin;
		log.info("getSession-redis耗时："+time);
		
		if (redisValue == null) {
			return null;
		}
		return JSONObject.parseObject(redisValue, UserSession.class);
	}

	/**
	 * 
	 * @Title: resetSessionPeriod
	 * @Description: 重置session有效期
	 * @param token
	 */
	public void resetSessionPeriod(String token) {
		long begin = System.currentTimeMillis();
		redisTemplate.expire(token, webConfig.getSessionPeriod(), TimeUnit.MINUTES);
		long end = System.currentTimeMillis();
		long time = end - begin;
		log.info("resetSessionPeriod-redis耗时："+time);
		
	}

	/**
	 * 
	 * @Title: deleteSession
	 * @Description: 删除session
	 * @param userId
	 * @param token
	 */
	public void deleteSession(Long userId, String token) {
		redisTemplate.delete(token);
		redisTemplate.opsForHash().delete("userOnline", String.valueOf(userId));
	}

	/**
	 * 
	 * @Title: userOnlineCount
	 * @Description: 获取userOnline的size
	 * @return
	 */
	public Integer userOnlineCount() {
		return (int) redisTemplate.opsForHash().size("userOnline").longValue();
	}

}
