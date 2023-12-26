package com.ws.export.service;

import java.util.List;

import com.ws.Container;
import com.ws.Util;
import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.service.WiseSayingService;

public class ExportService {

	private WiseSayingService wiseSayingService;

	public ExportService() {
		wiseSayingService = Container.wiseSayingService;
	}

	public void makeHtml() {
		List<WiseSaying> wiseSayings = wiseSayingService.findAll();

		for (WiseSaying wiseSaying : wiseSayings) {

			String fileName = wiseSaying.getId() + ".html";
			String html = "<meta charset=\"UTF-8\">";
			html += "<div>번호 : " + wiseSaying.getId() + "</div>";
			html += "<div>작성자 : " + wiseSaying.getAuthor() + "</div>";
			html += "<div>내용 : " + wiseSaying.getContent() + "</div>";
			if (wiseSaying.getId() > 1) {
				html += "<div><a href=\"" + (wiseSaying.getId() - 1) + ".html\">이전글</a></div>";
			}

			html += "<div><a href=\"" + (wiseSaying.getId() + 1) + ".html\">다음글</a></div>";

			Util.writeFileContents("exportHtml/" + fileName, html);
		}

	}

}