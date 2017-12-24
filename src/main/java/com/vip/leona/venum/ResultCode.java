package com.vip.leona.venum;

/**
 * 
 * @author hyson.han
 *
 */
public enum ResultCode {

	EXCEPTION(-1),

	SUCCEED(0),

	FAIL(1),

	INFO(2),

	UPDATE_SUCCESS(3),

	ADD_SUCCESS(4),

	QUERY_SUCCESS(5),

	TEST_PARAM(6),;

	private int code;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	ResultCode(int code) {
		this.code = code;
	}
}
