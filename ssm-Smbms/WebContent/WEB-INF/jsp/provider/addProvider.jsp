<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 供应商添加页面</span>
        </div>
        <div class="providerAdd">
            <form id="addForm" name="providerForm" method="post"  action="${rootPath }/pro/addProvder">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="procode">供应商编码：</label>
                    <input type="text" name="procode" onblur="checkUserCode($(this))" id="procode" value=""> 
					
					<!-- 放置提示信息 -->
					<font color="red"></font>
                </div>
                <div>
                    <label for="proname">供应商名称：</label>
                    <input type="text" name="proname" id="proname" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="procontact">联系人名称：</label>
                    <input type="text" name="procontact" id="procontact" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="prophone">联系人电话：</label>
                    <input type="number" name="prophone" id="prophone" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="profax">供应商电话：</label>
                    <input type="number" name="profax" id="profax" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="proaddress">供应商地址：</label>
                   <input name="proaddress" id="proaddress" type="text" value="">
                </div>
                <div>
                    <label for="prodesc">供应商信息：</label>
                   <textarea rows="3" cols="36" name="prodesc" id="prodesc" >
                   </textarea>
                </div>
                <!-- 上传 头像个 工作照 -->
                <div>
                    <label for="headImg">工商执照：</label>
                   <input name="pro01" id="headImg"   onchange="submitImgSize1Upload('#picPath1','pro01')"  type="file">
                   <input type="hidden" value=""    id="picPath1" name="companylicpicpath"/>
                </div>                
                <div>
                    <label for="workImg">营业执照：</label>
                   <input name="pro02" id="workImg" onchange="submitImgSize1Upload('#picPath2','pro02')"   type="file">
                   <input type="hidden" name="orgcodepicpath"  value="" id="picPath2"/>
                </div>  
                  
                
                
                               
                <div class="providerAddBtn">
                    <input type="submit" name="add" id="add" value="保存" >
					<input type="button" id="back" name="back" value="返回" >
                </div>
                <input type="hidden" id="err" value="${requestScope.err}"/>
            </form>
        </div>
</div>
</section>

<%@include file="/WEB-INF/jsp/common/foot.jsp"%>


<script type="text/javascript">
<!--

//-->


$(function(){
	var err = $("#err").val();
	if(err != ""){
		alert(err);
	}
});


</script>


