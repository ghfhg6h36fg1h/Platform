var imgSrc = []; //图片路径
var imgFile = []; //文件流
var imgName = []; //图片名字
var PrintImg = [];   //详情显示图片地址
var PrintImgTem = [];//详情显示缩略图片地址
var ImgDEV="https://portal.sh-liangxin.com/Advice_MANAGEFILEDEV/";
//选择图片
function imgUpload() {
    var oInput = '#file';   //#file
    var imgBox = '#imgBox';   //#imgBox
    $(oInput).off("change").on("change", function () {

        if (imgFile.length < 2) {
            var fileList = $(oInput)[0].files;
            var imgSrcI = getObjectURL(fileList[0]);
            //  imgSrcI="http://192.168.1.161/Advice_MANAGEFILEDEV/img/02_1552628437180_25354_1.jpg";
            imgName.push(fileList[0].name);
            imgSrc.push(imgSrcI);
            imgFile.push(fileList[0]);
            addNewContent(imgBox);

        }
    })
}

//初始展示  没有删除按钮
var dfPrint = function (temp) {

    var imgBox = '#imgBox';   //#imgBox
    imgSrcI = temp;
    imgSrc.push(imgSrcI);
    addNewContent2(imgBox);
}

//详情展示
function addNewContent2(obj) {
    var html = "";
    for (var a = 0; a < imgSrc.length; a++) {
        html += '<div class="imgContainer"><img title=' + imgName[a] + ' alt=' + imgName[a] + ' src=' + imgSrc[a] + '' +
            ' onclick="imgDisplay(this)" alt=""></div>';
    }
    $(obj).html(html);
}



//图片灯箱
function imgDisplay(obj) {

    var src = $(obj).attr("src");

    if (src === PrintImgTem[0])
        src = PrintImg[0];
    else if (src === PrintImgTem[1])
        src = PrintImg[1];

    var imgHtml = '<div style="width: 100%;height: 100vh;overflow: auto;background: rgba(0,0,0,0.5);text-align: center;position: fixed;top: 0;left: 0;z-index: 1000;"><img style="margin-top:20px; width: 50%; margin-bottom: 100px;" src=' + src + '  alt=""/ alt="" alt=""><p style="font-size: 50px;position: fixed;top: 30px;right: 30px;color: white;cursor: pointer;" onclick="closePicture(this)">×</p></div>';
    $('body').append(imgHtml);
}

//关闭
function closePicture(obj) {
    $(obj).parent("div").remove();
}

//图片预览路径
function getObjectURL(file) {
    var url = null;
    if (window.createObjectURL !== undefined) { // basic
        url = window.createObjectURL(file);
    } else if (window.URL !== undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file);
    } else if (window.webkitURL !== undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file);
    }
    return url;
}