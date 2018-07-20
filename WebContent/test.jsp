<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>
<script type="text/javascript" src="/TemplateFile/htmllayout/js/ld.js"></script>
<style>
.tables
{
	border-color:#616161; border-width:1px; border-style:solid;
	}
.tds
{
	border:#999; border-width:1px 1px 1px 1px; border-style:solid;
	}
	.tdsts
{
	border:#999; border-width:1px 1px 1px 1px; border-style:solid;    background-color:#eff6ff;
	}

.mingxiTable {
	width:98%;
	background-color:#fff;
}
.mingxiTable, .mingxiTable td {
	border-spacing:0;
	border-collapse:collapse;
	border:1px #c0c0c0 solid;
}
.mingxitd {
	background-color:#fff;
	text-align:center;
	height:28px;
	padding:0;
}
.mingxitd table, .mingxitd td {
	background-color:#FFF;
	border-spacing:0;
	border-collapse:collapse;
	border-left:0;
	border-top:0;
	border-right:0;
	border-bottom:0;
}
.mingxitd .detailAddTd {
	background-color:#FFF;
	text-align:left;
	height:28px;
	border-bottom:#c0c0c0 solid 1px;
}
.mingxitd .inputstyle {
	margin-left:5px;
}
.mingxitd .field {
	background-color:#FFF;
	text-align:left;
	height:28px;
	border-top:#c0c0c0 solid 1px;
}
.mingxitd .header td {
	text-align:left;
	border-top:#c0c0c0 solid 1px;
	text-align:left;
	height:28px;
}
.mingxitdC1 {
}
.fujian table, .fujian td {
	border:0;
	text-align:left;
	height:28px;

}
input
{
 border:0px none;
}
</style>
<body>
    <div align="center">
    <!--2行一列的表格里嵌套了一个20行13列的表格-->
    <table width="90%" height="439" border="0" style="font-family:'宋体'; font-size:12px;">
      <tr>
        <td height="26" align="center" style="font-family:'宋体'; font-size:22px; FONT-WEIGHT: bold;">岗位工资制月度考核平衡记分卡</td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="1" cellpadding="2" class="tables">
          <tr>
            <td class="tds" width="4%">被考核人</td>
            <td colspan="2" class="tds"> </td>
            <td class="tds" width="6%">部门</td>
            <td colspan="4" class="tds"> </td>
            <td width="6%" class="tds">考核周期</td>
            <td colspan="4" class="tds"> </td>
          </tr>
          <tr>
            <td class="tdsts" width="4%">类型</td>
            <td colspan="12" align="center" class="tdsts"><b>A财务类10%</b></td>
          </tr>
          <tr>
            <td colspan="11" > </td>
            <td width="12%" ><div id="div0button"><button class="BtnFlow" id="$addbutton0$" accesskey="A" name="addbutton0" onclick="addRow0(0)"><u>A</u>-添加</button></div></td>
            <td width="28%" ><div><button class="BtnFlow" id="$delbutton0$" accesskey="E" name="delbutton0" onclick="if(isdel()){deleteRow0(0);}"><u>E</u>-删除</button></div></td>
          </tr>
          <tr>
            <td colspan="13">
             <table class="mingxiTable" width="100%">
             <tr>
                <td class="tds" width="4%">序号</td>
            <td width="4%" class="tds">具体指标</td>
            <td width="5%"    class="tds">权重</td>
            <td    class="tds">指标说明</td>
            <td width="6%"    class="tds">基本目标</td>
            <td width="6%"    class="tds">最高目标</td>
            <td width="7%"    class="tds">基本权分</td>
            <td width="6%"    class="tds">最高权分</td>
            <td    class="tds">计分方法</td>
            <td width="5%"    class="tds">数据来源</td>
            <td width="5%"    class="tds">完成情况</td>
            <td    class="tds">评分</td>
            <td    class="tds">支持文件</td>
          </tr>
          <tr>
            <td width="4%"  > </td>
            <td class="mingxitd"   > </td>
            <td class="mingxitd"   > </td>
            <td class="mingxitd"   > </td>
            <td class="mingxitd"   > </td>
            <td class="mingxitd"   > </td>
            <td class="mingxitd"  > </td>
            <td class="mingxitd"   > </td>
            <td class="mingxitd"   > </td>
            <td class="mingxitd"   > </td>
            <td class="mingxitd"   > </td>
            <td class="mingxitd"   > </td>
            <td class="mingxitd"  > </td>
             </tr>
             </table>
            </td>
          </tr>
          <tr>
            <td class="tdsts"   >类型</td>
            <td colspan="12" align="center" class="tdsts"><b>B类内部营运类70</b>%</td>
          </tr>
          <tr>
            <td colspan="11" > </td>
            <td width="12%" ><div id="div0button2"><button class="BtnFlow" id="$addbutton2$" accesskey="A" name="addbutton2" onclick="addRow2(2)"><u>A</u>-添加</button></div></td>
            <td width="28%" ><div><button class="BtnFlow" id="$delbutton2$" accesskey="E" name="delbutton2" onclick="if(isdel()){deleteRow2(2);}"><u>E</u>-删除</button></div></td>
          </tr>
          <tr>
          <td colspan="13" >
            <table class="mingxiTable" width="100%">
            <tr>
                <td class="tds">序号</td>
                <td class="tds">具体指标</td>
                <td class="tds">权重</td>
                <td class="tds">指标说明</td>
                <td class="tds">基本目标</td>
                <td class="tds">最高目标</td>
                <td class="tds">基本权分</td>
                <td class="tds">最高权分</td>
                <td class="tds">计分方法</td>
                <td class="tds">数据来源</td>
                <td class="tds">完成情况</td>
                <td class="tds">评分</td>
                <td class="tds">支持文件</td>
              </tr>
              <tr>
                <td> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
            </tr>
            </table>
            </td>
          </tr>
          <tr>
            <td class="tdsts">类型</td>
            <td colspan="12" align="center" class="tdsts"><b>C客户类10%</b></td>
          </tr>
          <tr>
            <td colspan="11" > </td>
            <td width="12%" ><div id="div0button3"><button class="BtnFlow" id="$addbutton3$" accesskey="A" name="addbutton3" onclick="addRow3(3)"><u>A</u>-添加</button></div></td>
            <td width="28%" ><div><button class="BtnFlow" id="$delbutton3$" accesskey="E" name="delbutton3" onclick="if(isdel()){deleteRow3(3);}"><u>E</u>-删除</button></div></td>
          </tr>
          <tr>
            <td colspan="13">
             <table class="mingxiTable" width="100%">
              <tr>
                <td class="tds">序号</td>
                <td class="tds">具体指标</td>
                <td class="tds">权重</td>
                <td class="tds">指标说明</td>
                <td class="tds">基本目标</td>
                <td class="tds">最高目标</td>
                <td class="tds">基本权分</td>
                <td class="tds">最高权分</td>
                <td class="tds">计分方法</td>
                <td class="tds">数据来源</td>
                <td class="tds">完成情况</td>
                <td class="tds">评分</td>
                <td class="tds">支持文件</td>
              </tr>
              <tr>
                <td> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
                <td class="mingxitd"> </td>
              </tr>
             </table>
            </td>
          </tr>
          <tr>
            <td class="tdsts">类型</td>
            <td colspan="12" align="center" class="tdsts"><b>D创新成长类10</b>%</td>
          </tr>

    </div>
</body>
</html>

