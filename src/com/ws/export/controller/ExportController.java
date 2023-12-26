package com.ws.export.controller;

import com.ws.Rq;
import com.ws.export.service.ExportService;

public class ExportController {

	private ExportService exportService;

	public ExportController() {
		exportService = new ExportService();
	}

	public void makeHtml(Rq rq) {
		System.out.println("==Html 파일 추출 시작==");
		exportService.makeHtml();
	}

}