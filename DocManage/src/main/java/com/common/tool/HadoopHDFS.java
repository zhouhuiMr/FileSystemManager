package com.common.tool;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import com.resources.init.CommonResources;
import com.service.file.impl.FileMessageObject;
import com.service.file.impl.FileSerchCondition;

/**
 * 用户的根目录根据用户
 * 
 * */
public class HadoopHDFS {
	private Configuration configuration = null;
	private FileSystem fs = null;

	public HadoopHDFS() {
		configuration = new Configuration();
		configInit();
	}

	private void configInit() {
		// configuration.set("fs.hdfs.impl",org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
		configuration.set("fs.defaultFS", CommonResources.HADOOP_HDFS_ADDRESS);
		try {
			fs = FileSystem.get(new URI(CommonResources.HADOOP_HDFS_ADDRESS), configuration);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取当前用户的文件列表
	 * 通过Hadoop的hdfs获取文件列表
	 * 
	 * @param FileSerchCondition
	 * @return ArrayList<FileMessageObject>
	 * 
	 * @author zhouhui
	 * @since 2018.08.20
	 * */
	public ArrayList<FileMessageObject> getFileList(FileSerchCondition condition) {
		ArrayList<FileMessageObject> fileListOfUser = null;
		try {
			FileStatus[] fileStatus = fs.listStatus(new Path(condition.getPath()));
			fileListOfUser = new ArrayList<FileMessageObject>(fileStatus.length);
			for (FileStatus file : fileStatus) {
				FileMessageObject fileMessage = new FileMessageObject();
				fileMessage.setOwner(file.getOwner());

				fileMessage.setFilename(file.getPath().getName());

				SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm");

				String modifydate = dateFormat.format(new Date(file.getModificationTime()));
				fileMessage.setModifydate(modifydate);

				String accessdate = dateFormat.format(new Date(file.getAccessTime()));
				fileMessage.setAccessdate(accessdate);

				fileListOfUser.add(fileMessage);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileListOfUser;
	}
}
