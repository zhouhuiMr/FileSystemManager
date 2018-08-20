package com.service.file.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.common.tool.HadoopHDFS;
import com.common.tool.ResultJson;

@Service
public class FileOperateServiceImpl {
	
	public ResultJson uploadToHadoop(MultipartFile file){
		ResultJson json = new ResultJson();
		return json;
	}
	
	public ResultJson fileListToHadoop(FileSerchCondition condition){
		ResultJson json = new ResultJson();
		HadoopHDFS hdfs = new HadoopHDFS();
		ArrayList<FileMessageObject> fileList = hdfs.getFileList(condition);
		return json;
	}
}
