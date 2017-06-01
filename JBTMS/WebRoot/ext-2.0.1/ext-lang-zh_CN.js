/*
 * Ext JS Library 2.0 Dev 5
 * Copyright(c) 2006-2007, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * This code has not yet been licensed for use.
 */
/*
 * Ext JS Library 1.1
 * Copyright(c) 2006-2007, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://www.extjs.com/license
 */

/*
 * Simplified Chinese translation
 * By DavidHu
 * 09 April 2007
 */

Ext.UpdateManager.defaults.indicatorText = '<div class="loading-indicator">加载中...</div>';

if(Ext.View){
   Ext.View.prototype.emptyText = "";
}

if(Ext.grid.Grid){
   Ext.grid.Grid.prototype.ddText = "{0} 选择行";
}

if(Ext.TabPanelItem){
   Ext.TabPanelItem.prototype.closeText = "关闭";
}

if(Ext.form.Field){
   Ext.form.Field.prototype.invalidText = "输入值非法";
}

Date.monthNames = [
   "一月",
   "二月",
   "三月",
   "四月",
   "五月",
   "六月",
   "七月",
   "八月",
   "九月",
   "十月",
   "十一月",
   "十二月"
];

Date.dayNames = [
   "日",
   "一",
   "二",
   "三",
   "四",
   "五",
   "六"
];

if(Ext.MessageBox){
   Ext.MessageBox.buttonText = {
      ok     : "确定",
      cancel : "取消",
      yes    : "是",
      no     : "否"
   };
}

if(Ext.util.Format){
   Ext.util.Format.date = function(v, format){
      if(!v) return "";
      if(!(v instanceof Date)) v = new Date(Date.parse(v));
      return v.dateFormat(format || "y年m月d日");
   };
}

if(Ext.DatePicker){
   Ext.apply(Ext.DatePicker.prototype, {
      todayText         : "今天",
      minText           : "日期在最小日期之前",
      maxText           : "日期在最大日期之后",
      disabledDaysText  : "",
      disabledDatesText : "",
      monthNames	: Date.monthNames,
      dayNames		: Date.dayNames,      
      nextText          : '下月 (Control+Right)',
      prevText          : '上月 (Control+Left)',
      monthYearText     : '选择一个月 (Control+Up/Down 来改变年)',
      todayTip          : "{0} (Spacebar)",
      okText            : "确定",
      cancelText        : "取消",
      format            : "y年m月d日"
   });
}

if(Ext.form.TimeField){
   Ext.apply(Ext.form.TimeField.prototype, {
   	format:'G:i:s',
   	minText : "该输入项的时间必须大于或等于： {0}",
   	maxText : "该输入项的时间必须小于或等于： {0}",
   	invalidText : "{0}不是有效的时间",
	});
}

if(Ext.PagingToolbar){
   Ext.apply(Ext.PagingToolbar.prototype, {
      beforePageText : "页",
      afterPageText  : "of {0}",
      firstText      : "第一页",
      prevText       : "前一页",
      nextText       : "下一页",
      lastText       : "最后页",
      refreshText    : "刷新",
      displayMsg     : "显示 {0} - {1} of {2}",
      emptyMsg       : '没有数据需要显示'
   });
}

if(Ext.form.TextField){
   Ext.apply(Ext.form.TextField.prototype, {
      minLengthText : "该输入项的最小长度是 {0}",
      maxLengthText : "该输入项的最大长度是 {0}",
      blankText     : "该输入项为必输项",
      regexText     : "",
      emptyText     : null
   });
}

if(Ext.form.NumberField){
   Ext.apply(Ext.form.NumberField.prototype, {
      minText : "该输入项的最小值是 {0}",
      maxText : "该输入项的最大值是 {0}",
      nanText : "{0} 不是有效数值"
   });
}

if(Ext.form.DateField){
   Ext.apply(Ext.form.DateField.prototype, {
      disabledDaysText  : "禁用",
      disabledDatesText : "禁用",
      minText           : "该输入项的日期必须在 {0} 之后",
      maxText           : "该输入项的日期必须在 {0} 之前",
      invalidText       : "{0} 是无效的日期 - 必须符合格式： {1}",
      format            : "Y-m-d"
   });
}


if(Ext.form.ComboBox){
   Ext.apply(Ext.form.ComboBox.prototype, {
      loadingText       : "加载...",
      valueNotFoundText : undefined
   });
}

if(Ext.form.VTypes){
   Ext.apply(Ext.form.VTypes, {
      emailText    : '该输入项必须是电子邮件地址，格式如： "user@domain.com"',
      urlText      : '该输入项必须是URL地址，格式如： "http:/'+'/www.domain.com"',
      alphaText    : '该输入项只能包含字符和_',
      alphanumText : '该输入项只能包含字符,数字和_'
   });
}

if(Ext.grid.GridView){
   Ext.apply(Ext.grid.GridView.prototype, {
      sortAscText  : "升序",
      sortDescText : "降序",
      lockText     : "锁列",
      unlockText   : "解锁列",
      columnsText  : "列"
   });
}

if(Ext.grid.PropertyColumnModel){
   Ext.apply(Ext.grid.PropertyColumnModel.prototype, {
      nameText   : "名称",
      valueText  : "值",
      dateFormat : "Y-m-d"
   });
}

if(Ext.SplitLayoutRegion){
   Ext.apply(Ext.SplitLayoutRegion.prototype, {
      splitTip            : "拖动来改变尺寸.",
      collapsibleSplitTip : "拖动来改变尺寸. 双击隐藏."
   });
}

if(Ext.form.HtmlEditor){
   Ext.apply(Ext.form.HtmlEditor.prototype, {
    buttonTips : {
        bold : {
            title: '粗体 (Ctrl+B)',
            text: '将选择文本字体改变为粗体。',
            cls: 'x-html-editor-tip'
        },
        italic : {
            title: '斜体 (Ctrl+I)',
            text: '将选择文本字体修改为斜体。',
            cls: 'x-html-editor-tip'
        },
        underline : {
            title: '下划线 (Ctrl+U)',
            text: '为选择文本加下划线。',
            cls: 'x-html-editor-tip'
        },
        increasefontsize : {
            title: '放大文本',
            text: '加大字体大小。',
            cls: 'x-html-editor-tip'
        },
        decreasefontsize : {
            title: '缩小文本',
            text: '减少字体大小。',
            cls: 'x-html-editor-tip'
        },
        backcolor : {
            title: '突出显示',
            text: '改变选择文本的背景颜色。',
            cls: 'x-html-editor-tip'
        },
        forecolor : {
            title: '字体颜色',
            text: '改变选择文本的字体颜色。',
            cls: 'x-html-editor-tip'
        },
        justifyleft : {
            title: '左对齐',
            text: '文本左对齐。',
            cls: 'x-html-editor-tip'
        },
        justifycenter : {
            title: '居中',
            text: '文本居中。',
            cls: 'x-html-editor-tip'
        },
        justifyright : {
            title: '右对齐',
            text: '文本右对齐。',
            cls: 'x-html-editor-tip'
        },
        insertunorderedlist : {
            title: '项目符号',
            text: '开始一个项目符号。',
            cls: 'x-html-editor-tip'
        },
        insertorderedlist : {
            title: '编号',
            text: '开始编号。',
            cls: 'x-html-editor-tip'
        },
        createlink : {
            title: '超链接',
            text: '修改文本为一个超链接。',
            cls: 'x-html-editor-tip'
        },
        sourceedit : {
            title: '源代码编辑',
            text: '切换到源代码编辑模式。',
            cls: 'x-html-editor-tip'
        }
    }
   });
}
