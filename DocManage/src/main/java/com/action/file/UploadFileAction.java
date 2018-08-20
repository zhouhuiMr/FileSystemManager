package com.action.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.common.tool.ResultJson;
import com.service.file.impl.FileOperateServiceImpl;
import com.service.file.impl.FileSerchCondition;

@Controller
@RequestMapping(path="/action/file")
public class UploadFileAction {
	
	@Autowired
	private FileOperateServiceImpl fileoperate;
	
	@RequestMapping(path="/upload",method=RequestMethod.GET)
	@ResponseBody
	public ResultJson fileUpload(@RequestParam("file") MultipartFile multipartFile){
		ResultJson json = new ResultJson();
		json = fileoperate.uploadToHadoop(multipartFile);
		return json;
	}
	
	@RequestMapping(path="/filelist",method=RequestMethod.GET)
	@ResponseBody
	public ResultJson fileList(@RequestParam("") String path){
		ResultJson json = new ResultJson();
		FileSerchCondition condition = new FileSerchCondition();
		fileoperate.fileListToHadoop(condition);
		return json;
	}
}
