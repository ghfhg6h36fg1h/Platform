package com.liangxin.platform.common.tools;

import com.liangxin.platform.common.entity.sys.mail.MailSet;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class JavaMail {
    public void send(MailSet pMailSet) throws Exception {
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.transport.protocol", pMailSet.getSendType());
        props.put("mail.smtp.host", pMailSet.getServerAddress());// smtp服务器地址
        Session session = Session.getInstance(props);
        session.setDebug(true);
        Message msg = new MimeMessage(session);
        msg.setSubject(pMailSet.getMailSubject());
        //msg.setText(pMailSet.getMailText());
        MimeMultipart mMine = new MimeMultipart("mixed");
        String body = pMailSet.getMailText().replace("\n", "<br/>");
        MimeBodyPart mContentPart = (MimeBodyPart) createContent(body, pMailSet.getFontSize(), pMailSet.getImageBodyList());
        mMine.addBodyPart(mContentPart);

        //增加附件。
        //MimeBodyPart mMimeBodyPart=(MimeBodyPart) createAttachment("attachmentFilePath");
        //mMine.addBodyPart(mMimeBodyPart);
        msg.setContent(mMine);
        msg.setFrom(new InternetAddress(pMailSet.getSendFromAddress()));//发件人邮箱(我的163邮箱)
        if (null != pMailSet.getSendToAddress() && pMailSet.getSendToAddress().size() > 0) {
            msg.setRecipients(Message.RecipientType.TO,
                    getMailList(pMailSet.getSendToAddress())); //收件人邮箱(我的QQ邮箱)
        }
        if (null != pMailSet.getCopyToAddress() && pMailSet.getCopyToAddress().size() > 0) {
            msg.setRecipients(Message.RecipientType.CC,
                    getMailList(pMailSet.getCopyToAddress())); //抄送人邮箱(我的QQ邮箱)
        }
        msg.saveChanges();
        Transport transport = session.getTransport();
        transport.connect(pMailSet.getUserName(), pMailSet.getUserPassWord());//发件人邮箱,授权码(可以在邮箱设置中获取到授权码的信息)
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
    }

    public Address[] getMailList(List<String> pMailArray) throws AddressException {
        Address[] mAddresses = new InternetAddress[pMailArray.size()];
        for (int i = 0; i < pMailArray.size(); i++) {
            mAddresses[i] = new InternetAddress(pMailArray.get(i));
        }
        return mAddresses;
    }

    private Part createContent(String pContent, Integer pFontSize, List<String> pImageBodyLIst) {
        MimeBodyPart mContentPart = null;
        MimeMultipart contentMultipart = new MimeMultipart("related");
        try {
            if (null != pFontSize) {
                pContent = "<font size =\"5\" face=\"arial\" >" + pContent + "</font>";
            }
            if (null != pImageBodyLIst && pImageBodyLIst.size() > 0) {
                for (Integer i = 0; i < pImageBodyLIst.size(); i++) {
                    String mCid = "mailImg" + String.valueOf(i);
                    pContent += "<br/>" + "<img src=\"cid:" + mCid + "\">";
                    MimeBodyPart mGifBodyPart = new MimeBodyPart();
                    FileDataSource fds = new FileDataSource(ResourceUtils.getFile(pImageBodyLIst.get(i)));
                    mGifBodyPart.setDataHandler(new DataHandler(fds));
                    mGifBodyPart.setFileName(fds.getName());
                    mGifBodyPart.setContentID(mCid);

                    contentMultipart.addBodyPart(mGifBodyPart);
                }
            }
            mContentPart = new MimeBodyPart();
            MimeBodyPart mHtmlPart = new MimeBodyPart();
            mHtmlPart.setContent(pContent, "text/html;charset=gb2312");
            contentMultipart.addBodyPart(mHtmlPart);
            mContentPart.setContent(contentMultipart);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mContentPart;
    }


    private Part createAttachment(String fileName) {
        Part part = new MimeBodyPart();
        FileDataSource fds = new FileDataSource(new File(fileName));
        try {
            part.setDataHandler(new DataHandler(fds));
            part.setFileName(fds.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return part;
    }

}
