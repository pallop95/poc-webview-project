package com.ktb.app.pms.commonlibrary.util.service.constants;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

public class LookupConst {

	public static final Map<String , MediaType> FILE_TYPE_MAP = new HashMap<String , MediaType>() {{
        put("png", MediaType.IMAGE_PNG);
        put("jpeg", MediaType.IMAGE_JPEG);
        put("jpg", MediaType.IMAGE_JPEG);
        put("gif", MediaType.IMAGE_GIF);
        put("pdf", MediaType.APPLICATION_PDF);
    }};
}
