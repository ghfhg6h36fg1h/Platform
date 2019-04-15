function replaceNIL(pStr) {
    if (pStr != null) {
        pStr = pStr.toString().replace("NUL", "");
        pStr = pStr.toString().replace("NIL", "");
    } else {
        pStr = "";
    }
    return pStr;
}

function getQueryVariable(variable) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        if (pair[0] == variable) {
            return pair[1];
        }
    }
    return (false);
}

// endWith
String.prototype.endsWith = function (str) {
    if (str == null || str == "" || this.length == 0 || str.length > this.length)
        return false;
    if (this.substring(this.length - str.length) == str)
        return true;
    else
        return false;
    return true;
}

function pageStartIndex(pPageIndex, pPageSize) {
    return (pPageIndex - 1) * pPageSize + 1;
}

function stringLengthRestrict(obj, pLimitLength) {
    if (obj.value == null)
        return false;
    if (obj.value == "") {
        if (obj.value.length > pLimitLength) {
            alert("长度不不能超过：" + pLimitLength);
            obj.value = "";
            return false;
        }
    }
}

function checkEmail(obj) {
    var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"); //正则表达式
    // if (obj.value === "") { //输入不能为空
    //     alert("输入不能为空!");
    //     return false;
    // }
    if (obj.value != "") {
        if (!reg.test(obj.value)) { //正则验证不通过，格式不对
            alert("请输入正确的email");
            obj.value = "";
            return false;
        }
    }
}

function IsTelephone(obj)// 正则判断
{
    // if (obj.value === "") { //输入不能为空
    //     alert("输入不能为空!");
    //     return false;
    // }
    if (obj.value != "") {
        var pattern = /(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/;
        if (!pattern.test(obj.value)) {
            alert("请输入正确的手机号码!");
            obj.value = "";
            return false;
        }
    }
}


function testIdCard(obj) {
    // 1 "验证通过!", 0 //校验不通过
    var format = /^(([1][1-5])|([2][1-3])|([3][1-7])|([4][1-6])|([5][0-4])|([6][1-5])|([7][1])|([8][1-2]))\d{4}(([1][9]\d{2})|([2]\d{3}))(([0][1-9])|([1][0-2]))(([0][1-9])|([1-2][0-9])|([3][0-1]))\d{3}[0-9xX]$/;
    //号码规则校验
    var id = obj.value;
    if (id != "") {
        if (!format.test(id)) {
            alert("身份证号码格式错误")
            obj.value = "";
            return false;
        }
        //区位码校验
        //出生年月日校验   前正则限制起始年份为1900;
        var year = id.substr(6, 4),//身份证年
            month = id.substr(10, 2),//身份证月
            date = id.substr(12, 2),//身份证日
            time = Date.parse(month + '-' + date + '-' + year),//身份证日期时间戳date
            now_time = Date.parse(new Date()),//当前时间戳
            dates = (new Date(year, month, 0)).getDate();//身份证当月天数
        if (time > now_time || date > dates) {
            return {'status': 0, 'msg': '出生日期不合规'}
        }
        //校验码判断
        var c = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);   //系数
        var b = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');  //校验码对照表
        var id_array = id.split("");
        var sum = 0;
        for (var k = 0; k < 17; k++) {
            sum += parseInt(id_array[k]) * parseInt(c[k]);
        }
        if (id_array[17].toUpperCase() != b[sum % 11].toUpperCase()) {
            alert("身份证校验码不合规");
            obj.value = "";
            return false;
        }
    }
}

function isNumber(obj) {
    if (obj.value != "") {
        if (/^[0-9]+$/.test(obj.value)) {//这是用正则表达是检查
        } else {
            alert("必须全部是数字")
            return false;
        }
    }
}

function getNormalDate() {
    var mDate = new Date();
    var mYear = mDate.getFullYear().toString();
    var mMomth = (mDate.getMonth() + 1).toString();
    var mDay = mDate.getDate().toString();
    if (mMomth.length == 1) {
        mMomth = "0" + mMomth;
    }
    if (mDay.length == 1) {
        mDay = "0" + mDay;
    }
    return mYear + "-" + mMomth + "-" + mDay;
}

//去掉时间后缀
function NormalTime(time) {
    var result1 = format(time, 'yyyy-MM-dd:HH:mm:ss');
    return result1;
}

function format(time) {

    if (time === null) {
        return "";
    }
    var date = new Date(time);
    var y = 1900 + date.getYear();
    var m = "0" + (date.getMonth() + 1);
    var d = "0" + date.getDate();
    var h = "0" + date.getHours();
    var mm = "0" + date.getMinutes();
    return y + "-" + m.substring(m.length - 2, m.length) + "-" + d.substring(d.length - 2, d.length) + " " + h.substring(h.length - 2, h.length) + ":" + mm.substring(mm.length - 2, mm.length) ;


}