/**   
 *    
 */
package com.vip.leona.util;

import com.vip.leona.exception.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * @author hyson.han
 */
public class ResultUtils {
	private static final Logger logger = LoggerFactory.getLogger(ResultUtils.class);
	private static final Properties pros;

	private ResultUtils() {
	}

	static {
		InputStream inputStream = ResultUtils.class.getClassLoader()
				.getResourceAsStream("config/returninfo.properties");
		pros = new Properties();
		try (InputStreamReader is = new InputStreamReader(inputStream, "utf-8");) {
			pros.load(new BufferedReader(is));
		} catch (IOException e1) {
			logger.error("ResultInfo load resource", e1);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.error("get exception", e);
				}
			}
		}
	}



    /**
     *
     * @param success
     * @param statusCode
     * @param key
     * @return
     */
    public static Object getInstance(boolean success, int statusCode, String key) {
        return new Result(success, getMessage(statusCode, key), statusCode, key);
    }

    /**
     *
     * @param success
     * @param statusCode
     * @param key
     * @param content
     * @return
     */
	public static Object getInstance(boolean success, int statusCode, String key, Object content) {
		return 	new Result(success, getMessage(statusCode, key), statusCode, key, content);

	}

    /**
     *
     * @param success
     * @param statusCode
     * @param key
     * @param content
     * @param param
     * @return
     */
    public static Object getInstance(boolean success, int statusCode, String key, Object content, Object... param) {
        return new Result(success, getMessage(statusCode, key, param), statusCode, key, content);
    }


	private static String getMessage(int statusCode, String key, Object... param) {
		String rawMsg = pros.getProperty(Integer.toString(statusCode));
		String msg;
		if (rawMsg == null || rawMsg.isEmpty()) {
			if (param != null && param.length > 0) {
				msg = (String) param[0];
			} else {
				logger.error("get statusCode as " + key + " but detailed msg is not defined!");
				msg = "";
			}
		} else {
			msg = MessageFormat.format(rawMsg, param);
		}
		return msg;
	}
}
