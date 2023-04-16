package com.bank.accounts.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@ConfigurationProperties("accounts-config")
@Component
public class Version {
	private String version;
	
	public Version() {}
	
	public Version(String version) {
		this.version = version;
	}
	
	public String getVersion() {
		return this.version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
}
