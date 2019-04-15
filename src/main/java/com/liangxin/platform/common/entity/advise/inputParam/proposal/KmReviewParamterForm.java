package com.liangxin.platform.common.entity.advise.inputParam.proposal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "KmReviewParamterForm")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "docSubject",
        "fdTemplateId",
        "docContent",
        "formValues",
        "docStatus",
        "docCreator",
        "fdKeyword",
        "docProperty",
        "flowParam",
        "attachmentForms"
})
public class KmReviewParamterForm {

    // 文档标题
    private String docSubject;

    // 文档模板id
    private String fdTemplateId;

    // 文档内容文本
    private String docContent;

    // 表单数据参数
    private String formValues;

    // 文档状态
    private String docStatus;

    // 流程发起人
    private String docCreator;

    // 文档关键字
    private String fdKeyword;

    // 辅类别ID
    private String docProperty;

    // 流程参数
    private String flowParam;

    // 附件
    private List<AttachmentForm> attachmentForms = new ArrayList<AttachmentForm>();

    public List<AttachmentForm> getAttachmentForms() {
        return attachmentForms;
    }

    public void setAttachmentForms(List<AttachmentForm> attachmentForms) {
        this.attachmentForms = attachmentForms;
    }

    public String getDocSubject() {
        return docSubject;
    }

    public void setDocSubject(String docSubject) {
        this.docSubject = docSubject;
    }

    public String getFdTemplateId() {
        return fdTemplateId;
    }

    public void setFdTemplateId(String fdTemplateId) {
        this.fdTemplateId = fdTemplateId;
    }

    public String getDocContent() {
        return docContent;
    }

    public void setDocContent(String docContent) {
        this.docContent = docContent;
    }

    public String getFormValues() {
        return formValues;
    }

    public void setFormValues(String formValues) {
        this.formValues = formValues;
    }

    public String getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
    }

    public String getDocCreator() {
        return docCreator;
    }

    public void setDocCreator(String docCreator) {
        this.docCreator = docCreator;
    }

    public String getFdKeyword() {
        return fdKeyword;
    }

    public void setFdKeyword(String fdKeyword) {
        this.fdKeyword = fdKeyword;
    }

    public String getDocProperty() {
        return docProperty;
    }

    public void setDocProperty(String docProperty) {
        this.docProperty = docProperty;
    }

    public String getFlowParam() {
        return flowParam;
    }

    public void setFlowParam(String flowParam) {
        this.flowParam = flowParam;
    }

}
