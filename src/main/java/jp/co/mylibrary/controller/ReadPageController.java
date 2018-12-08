package jp.co.mylibrary.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.mylibrary.entity.ReadPageEntity;
import jp.co.mylibrary.entity.UsersEntity;
import jp.co.mylibrary.service.ReadPageService;

@Controller
public class ReadPageController {
	private static final Logger logger = LoggerFactory.getLogger(ReadPageController.class);

	/** 日付フォーマット */
	static public final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

	@RequestMapping(value = { "/readPage" }, method = RequestMethod.POST)
	@ResponseBody
	public List<ReadPageEntity> doget(Locale locale, Model model, Principal principal, HttpServletRequest request) {
		int userId;
		Date startDate;

		try {
			// セッションからユーザーIDを取得
			Authentication authentication = (Authentication) principal;
			UsersEntity user = (UsersEntity) authentication.getPrincipal();
			userId = user.getUserId();
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}

		String date = request.getParameter("data");
		JSONObject jsonObject = new JSONObject(date);

		if (jsonObject.getString("date") != null) {
			String startDateString = jsonObject.getString("date");
			startDate = stringToDate(startDateString, DATE_PATTERN);
		} else
			return null;

		// エンティティに検索条件を詰める
		ReadPageEntity readPageEntity = new ReadPageEntity();
		readPageEntity.setUserId(userId);
		readPageEntity.setCreateDate(startDate);

		ReadPageService readPageService = new ReadPageService();
		List<ReadPageEntity> readPageEntities = readPageService.getReadPageByDate(readPageEntity);
		return readPageEntities;
	}

	/**
	 * StringをDate型に変換
	 * 
	 * @param dateStr
	 *            変換したい日付の文字列 (例) 2018/01/07
	 * @param format
	 *            フォーマット
	 */
	public static Date stringToDate(String dateStr, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.JAPAN);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return date;
		}
		// sql.date型へ変換
		java.sql.Date startDate = new java.sql.Date(date.getTime());
		return startDate;
	}

}
