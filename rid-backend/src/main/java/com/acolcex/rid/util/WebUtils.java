package com.acolcex.rid.util;

import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class WebUtils {
	
	private static final Logger LOG = LoggerFactory.getLogger(WebUtils.class);

	private WebUtils() {

	}
	
	public static String getDomain(String url) {
        try {
            if (!url.startsWith("http") && !url.startsWith("https")) {
                url = "http://" + url;
            }
            URL netUrl = null;
            netUrl = new URL(url);
            String host = netUrl.getHost();
            if (host.startsWith("www")) {
                host = host.substring("www".length() + 1);
            }
            return host;
        } catch (MalformedURLException e) {
            LOG.error(e.getMessage());
            return "";
        }

    }
}
