package com.jiameng.jingxuan.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;


public class FileUploadUtil {

    /**
     * 连接sftp服务器
     * 
     * @param host 主机
     * @param port 端口
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public ChannelSftp connect(String host, int port, String username, String password) {
        ChannelSftp sftp = null;
        try {
            JSch jsch = new JSch();
            jsch.getSession(username, host, port);
            Session sshSession = jsch.getSession(username, host, port);
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            Channel channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
        } catch (Exception e) {
        	e.printStackTrace();
        	return null;
        }
        return sftp;
    }

    /**
     * 关闭sftp连接
     */
    public void closeMySFTP(ChannelSftp channelSftp) {
        try {
            if (channelSftp != null) {
                Session session = channelSftp.getSession();
                if (session != null) {
                    session.disconnect();
                    channelSftp.disconnect();
                }
            }
        } catch (JSchException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 上传文件
     * 
     * @param directory 上传的目录
     * @param uploadFile 要上传的文件
     * @param sftp
     */
    public void upload(String directory, String uploadFile, ChannelSftp sftp) {
        try {
            sftp.cd(directory);
            File file = new File(uploadFile);
            sftp.put(new FileInputStream(file), file.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int upload(String directory, InputStream fileInputStream, String fileName, ChannelSftp sftp) {
        try {
            File file = new File(directory);
            if (file.isDirectory()) {
                sftp.cd(directory);
            } else {
                file.mkdir();
            }
            sftp.put(fileInputStream, fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        
        return 0;
    }

    /**
     * 下载文件
     * 
     * @param directory 下载目录
     * @param downloadFile 下载的文件
     * @param saveFile 存在本地的路径
     * @param sftp
     */
    public void download(String directory, String downloadFile, String saveFile, ChannelSftp sftp) {
        try {
            sftp.cd(directory);
            File file = new File(saveFile);
            sftp.get(downloadFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件
     * 
     * @param directory 要删除文件所在目录
     * @param deleteFile 要删除的文件
     * @param sftp
     */
    public void delete(String directory, String deleteFile, ChannelSftp sftp) {
        try {
            sftp.cd(directory);
            sftp.rm(deleteFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sshSftp(String ip, String user, String psw, int port) throws Exception {
        Session session = null;
        Channel channel = null;

        JSch jsch = new JSch();

        if (port <= 0) {
            // 连接服务器，采用默认端口
            session = jsch.getSession(user, ip);
        } else {
            // 采用指定的端口连接服务器
            session = jsch.getSession(user, ip, port);
        }

        // 如果服务器连接不上，则抛出异常
        if (session == null) {
            throw new Exception("session is null");
        }

        // 设置登陆主机的密码
        session.setPassword(psw);// 设置密码
        // 设置第一次登陆的时候提示，可选值：(ask | yes | no)
        session.setConfig("StrictHostKeyChecking", "no");
        // 设置登陆超时时间
        session.connect(30000);

        try {
            // 创建sftp通信通道
            channel = (Channel) session.openChannel("sftp");
            channel.connect(1000);
            ChannelSftp sftp = (ChannelSftp) channel;

            // 进入服务器指定的文件夹
            sftp.cd("/home/ibus/img/");

            // 以下代码实现从本地上传一个文件到服务器，如果要实现下载，对换以下流就可以了
            InputStream is = sftp.get("logo120160426145329965.jpg");
            OutputStream outstream = sftp.put("D:/uploadImg/logo120160426145329965.jpg");

            byte b[] = new byte[1024];
            int n;
            while ((n = is.read(b)) != -1) {
                outstream.write(b, 0, n);
            }

            outstream.flush();
            outstream.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.disconnect();
            channel.disconnect();
        }
    }

}
