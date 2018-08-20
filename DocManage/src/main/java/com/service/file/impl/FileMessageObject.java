package com.service.file.impl;

public class FileMessageObject {
	private String owner = "";
	private String filename = "";
	private String path = "";
	private String accessdate = "";
	private String modifydate = "";

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getAccessdate() {
		return accessdate;
	}

	public void setAccessdate(String accessdate) {
		this.accessdate = accessdate;
	}

	public String getModifydate() {
		return modifydate;
	}

	public void setModifydate(String modifydate) {
		this.modifydate = modifydate;
	}
}
