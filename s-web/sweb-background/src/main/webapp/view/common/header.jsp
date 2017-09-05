
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="common-tags.jsp"%>
    <link rel="stylesheet" href="${basePath}/plugins/font-awesome-4.7.0/css/font-awesome.min.css">
    <link href="${basePath}/plugins/iconfont/iconfont.css" rel="stylesheet">
    <link rel="stylesheet" href="${basePath}/css/controlpanel/panel.css">

<div id="feedback" class="modal fade Noprint" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">用户反馈</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-sm-5"><span class="text-danger">*</span>反馈内容：</label>
                        <div class="col-sm-1"></div>
                        <div class="col-sm-15">
                            <textarea class="form-control" rows="5" id="feedbackcontent" ></textarea>
                        </div>
                    </div>
					<div class="form-group">
					   <label class="control-label col-sm-5"></label>
                        <div class="col-sm-1"></div>
                        <div class="col-sm-10">
                             <p class="text-muted">限定输入250字</p>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="fankui();">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->



<div id="goout" class="modal fade Noprint" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">退出系统</h4>
            </div>
               <form class="form-horizontal" method="post" action="loginout.htm">
		            <div class="modal-body">
		                    <div class="form-group">
		                        <div class="col-sm-2"></div>
		                        <div class="col-sm-7">
		                            <p class="text-muted">您确定要退出系统吗？</p>
		                        </div>
		                    </div>

		            </div>
		            <div class="modal-footer">
		                <input type="submit" class="btn btn-primary"/>
		                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		            </div>
            	</form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->






<div id="dalog-send-sms" class="modal fade Noprint" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">密码验证</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="sendCodeForm" method="post">
                    <div class="form-group">
                        <label class="control-label col-sm-5">手机号码：</label>
                        <div class="col-sm-1"></div>
                        <div class="col-sm-5">
                            <label class="radio-inline" style="padding-left:0px;"> <span id="viewmobile"></span></label>
                        </div>
                         <div class="col-sm-1"></div>
                         <div class="col-sm-4"><input id="sendCodeButton" value="发送验证码" type="button" onclick="sendCode();"/></div>
                         <div class="col-sm-4"><label class="radio-inline"><span id="sendCodeButtonTip"></span></label></div>
                    </div>

                     <div class="form-group">
                        <label class="control-label col-sm-5"><span class="text-danger">*</span>验证码：</label>
                        <div class="col-sm-1"></div>
                        <div class="col-sm-5">
                           <input class="form-control required" rows="5" id="mcode"/>
                           <span id="errorCode"></span>
                        </div>
                    </div>


                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="checkCode();">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->







<div id="dalog-updatepass-sms" class="modal fade Noprint" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改密码</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal"  method="post" id="updatePassForm">
               		 <div class="form-group">
                        <label class="control-label col-sm-5"><span class="text-danger">*</span>原始密码：</label>
                    	 <div class="col-sm-1"></div>
	                        <div class="col-sm-10">
	                           <input class="form-control required" rows="5" name="userkey" id="userkey" type="password"/><span id="oldpass"></span>
	                        </div>
                     </div>
                    <div class="form-group">
                        <label class="control-label col-sm-5"><span class="text-danger">*</span>新密码：</label>
                    	 <div class="col-sm-1"></div>
	                        <div class="col-sm-10">
	                           <input class="form-control required" rows="5" name="newuserkey" id="newuserkey" type="password"/>
	                        </div>
                     </div>

                     <div class="form-group">
                        <label class="control-label col-sm-5 required"><span class="text-danger">*</span>重复新密码：</label>
                        <div class="col-sm-1"></div>
                        <div class="col-sm-10">
                           <input class="form-control" rows="5"  equalTo="#newuserkey" name="renewuserkey" id="renewuserkey" type="password"/>
                        </div>
                    </div>


                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="updatepass();">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->






<div id="dalog-checkPass-sms" class="modal fade Noprint" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">密码验证</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal"  method="post" id="checkPassForm">
               		 <div class="form-group">
                        <label class="control-label col-sm-5"><span class="text-danger">*</span>原始密码：</label>
                    	 <div class="col-sm-1"></div>
	                        <div class="col-sm-10">
	                           <input class="form-control required" rows="5"  id="userkeyold" type="password"/><span id="oldpassuse"></span>
	                        </div>
                     </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="checkPass();">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->






<div id="dalog-Info-sms" class="modal fade Noprint" role="dialog" style="z-index:1700;" >
    <div class="modal-dialog" style="z-index:1800;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改资料</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal"  method="post" id="InfoForm" action="modifymanager.htm?CSRFToken=${token }" enctype="multipart/form-data">
               		 <div class="form-group">
                        <label class="control-label col-sm-5"><span class="text-danger">*</span>用户名：</label>
                    	 <div class="col-sm-1"></div>
	                        <div class="col-sm-10">
	                        	<input id="manaid" name="id" type="hidden" value="${loginUserId }">
	                           <label class="radio-inline"> <span class="usernamen">${name }</span></label>
	                        </div>
                     </div>
                     <div class="form-group">
                        <label class="control-label col-sm-5">头像：</label>
                    	 <div class="col-sm-1"></div>
	                        <div class="col-sm-1">
	                           <input name="photoImg" id="photoImg1" type="hidden" value="${photoImg }">
	                           <%--<img src="${photoImg }" height="30" height="30" id="headImgs"/>--%>
	                        </div>
	                        <div class="col-sm-1"></div>
	                        <div class="col-sm-2"><input id="chooseAdminImg" type="button" value="选择"/></div>
                     </div>
                     <div class="form-group">
                        <label class="control-label col-sm-5">手机号：</label>
                    	 <div class="col-sm-1"></div>
	                        <div class="col-sm-10">
	                           <input class="form-control mobile" rows="5"  id="mobileupdate" name="mobile"/>
	                        </div>
                     </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="subInfoForm();">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script type="text/javascript" src="${basePath}/js/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${basePath}/js/jquery/jquery.validate.js"></script>
<script type="text/javascript" src="${basePath}/plugins/artDialog4.1.7/artDialog.source.js?skin=default"></script>
<script type="text/javascript" src="${basePath}/plugins/artDialog4.1.7/plugins/iframeTools.js"></script>
<script type="text/javascript" src="${basePath}/js/jquery/jquery.cookie.js"></script>


    <script type="text/javascript">

	$(function(){

        // popover
        $('#customerPopover').popover({
            html: true,
            content: $('#popoverContent').html(),
            trigger: 'hover',
            placement: 'bottom'
        });

	    $("#InfoForm").validate();
	    $("#sendCodeForm").validate();
	    $("#updatePassForm").validate();
	    $("#checkPassForm").validate();

		$("#chooseAdminImg").click(function(){
	          i=1;
	          art.dialog.open('queryImageManageByPbAndCidForChoose.htm?location=Head&CSRFToken=${token}&size=10000', {
	              lock: true,
	              opacity:0.3,
	              width: '900px',
	              height: '400px',
	              title: '选择图片'
	          });
	      });

		  /* 导航弹出菜单 */

		  	 $('.nav ul li').each(function(){
		 	    $(this).mouseenter(function(e){
		 	        var positionX =$(this).width()/2 - 200;
		 	        $(this).append('<div class="menu_down popover bottom" style="position:absolute;top: 32px; left: ' + positionX + 'px; display: block;"><div class="arrow" style="left: 44%;"></div><div class="popover-content">' + $(this).next().html() + '</div></div>');
		 	        $(this).mouseleave(function(){
		 	            $(this).find(".menu_down").remove();
		 	        });
		 	    });

			 });

	});


	function setNumToTen(data){
		if(data<10){
			return "0"+data;
		}else{
			return data;
		}

	}


	function goOut(){
	    $('#goout').modal('show');
	}

	var uurl='getmobile.htm?CSRFToken=${token}';

	function fankui(){
	    if($("#feedbackcontent").val()!=''){
	        $("#feedbackcontent").removeClass('error');
	        jQuery.ajax({
	            url : "sendemailusersite.htm?CSRFToken=${token}&feedbackname=${name }&feedbackcontent="+$("#feedbackcontent").val(),
	            success : function(html) {
	                if (html == 1) {
	                    $('#feedback').modal('hide');
	                    $("#feedbackcontent").val('');
	                    showNoAlert('反馈成功');
	                } else {
	                    $('#feedback').modal('hide');
	                    showNoAlert('反馈失败');

	                }
	            }
	        });
	    }else{
	        $("#feedbackcontent").addClass('error');
	    }

	}

	/**
	 * 删除单个记录的确认框
	 * @param deleteUrl 删除链接。
	 */
	function showNoAlert(tips) {
	    $("#ViewmodalDialog").remove();
	    var confirmDialog =
	    '<div class="modal fade" id="ViewmodalDialog"  role="dialog">'+
	    '    <div class="modal-dialog">'+
	    '        <div class="modal-content">'+
	    '            <div class="modal-header">'+
	    '                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>'+
	    '               <h4 class="modal-title">系统提示</h4>'+
	    '           </div>'+
	    '           <div class="modal-body">'+tips+
	    '           </div>'+
	    '           <div class="modal-footer">'+
	    '               <button type="button" class="btn btn-default" data-dismiss="modal" onclick="$(\'#ViewmodalDialog\').modal(\'hide\');">确定</button>'+
	    '           </div>'+
	    '       </div>'+
	    '   </div>'+
	    '</div>';
	    $(document.body).append(confirmDialog);
	    $('#ViewmodalDialog').modal('show');
	}

	var updateFlag = '';
	function modifyPwd(){
	    $('#mcode').val('');
	    $('#userkeyold').val('');
	    //修改密码
	    updateFlag = '0';
		$.ajax({
			type : 'post',
			url : uurl,
			success : function(data) {
				if(data.mobile == null || data.mobile.trim().length == 0){
				    $("#dalog-checkPass-sms").modal('show');
				}else{
					$("#viewmobile").text(data.mobile);
					$("#dalog-send-sms").modal("show");
				}
			}
		});
	}


	function modifyInfo(){
	    $('#mcode').val('');
	    $('#userkeyold').val('');
	    //修改资料
	    updateFlag = '1';
	    $.ajax({
			type : 'post',
			url : uurl,
			success : function(data) {
				if(data.mobile == null || data.mobile.trim().length == 0){
				    $("#dalog-checkPass-sms").modal("show");
				}else{
				    $("#viewmobile").text(data.mobile);
					$("#dalog-send-sms").modal("show");
				}
			}
		});
	}

	function sendCode(){
	   // var url = 'getcodecore.htm?code='+code+"&CSRFToken="+$("#hi_token").val();
	   var url = 'sendcodecore.htm?mobile='+$(".mobile").text()+"&CSRFToken=${token}";
		$.ajax({
			type : 'post',
			url : url,
			async : false,
			success : function(data) {
			    if (data > 0) {

			        time($("#sendCodeButton"));
					$("#sendCodeButtonTip").text('发送成功');
				} else if(data == 0) {
				    $("#sendCodeButtonTip").text('发送失败');
				}else if(data == -1){
				    $("#sendCodeButtonTip").text('60秒内只能发送一次!');
				}
			}
		});
	}

	var wait = 60;
	function time(o) {
        if (wait == 0) {
            o.attr("disabled", false);
            o.val('发送验证码');
            wait = 60;
        } else {
            o.attr("disabled", true);
            o.val("重新发送(" + wait + ")");
            wait--;
            setTimeout(function() {
                time(o);
            },
            1000);
        }
    }


	function checkCode(){
	     if( $("#sendCodeForm").valid()){
	        var url = 'getcodecore.htm?code='+$("#mcode").val()+"&CSRFToken=${token}";
			$.ajax({
				type : 'post',
				url : url,
				async : false,
				success : function(data) {
					if (data > 0) {

					    if(updateFlag=='0'){
					        $("#dalog-send-sms").modal("hide");
						    $("#dalog-updatepass-sms").modal('show');
		        	     }else{
		        	         getMobileForm();
		        	         $("#dalog-send-sms").modal("hide");
		        	         $("#dalog-Info-sms").modal('show');
		        	     }


					} else if(data == 0) {
					  $("#mcode").addClass('error');
					  $("#errorCode").html("<label class='error'>验证码不正确</label>");

					}else if(data == -1){
					    $("#mcode").addClass('error');
						  $("#errorCode").html("<label class='error'>验证码已过期</label>");


					}
				}
			});
	    }


	}

	function checkPass(){
	    if($("#checkPassForm").valid()){
	        var userkey=$("#userkeyold");
			var url="checkUserKeyMain.htm?userKey="+userkey.val()+"&CSRFToken=${token}";
			$.ajax({
		         type: 'post',
		         url:url,
		         async:false,
		         success: function(data) {
		        	 if (data > 0){
		        	     $("#dalog-checkPass-sms").modal('hide');
		        	     if(updateFlag=='0'){
		        	         $("#dalog-updatepass-sms").modal('show');
		        	     }else{
		        	         getMobileForm();
		        	         $("#dalog-Info-sms").modal('show');
		        	     }
				      } else {
				         $("#userkeyold").addClass('error');
				    	 $("#oldpassuse").html('<label class="error">原始密码不正确</label>');
			          }
		         }
			 });
	    }

	}

	function getMobileForm(){
	    $.ajax({
			type : 'post',
			url : 'getmobile.htm?CSRFToken=${token}',
			success : function(data) {
				if(data.mobile != null && data.mobile.trim().length != 0){
				    $("#mobileupdate").val(data.mobile);
				}

			}
		});
	}
	function updatepass(){
	    if($("#updatePassForm").valid()){
	        var bValid = true;
		    var userkey=$("#userkey"),
		    newuserkey=$("#newuserkey");
			var url="checkUserKey.htm?userKey="+userkey.val()+"&CSRFToken=${token}";
			$.ajax({
		         type: 'post',
		         url:url,
		         async:false,
		         success: function(data) {
		        	 if (data > 0){
		        		 bValid=true&&bValid;
				      } else {
				         $("#userkey").addClass('error');
				    	 $("#oldpass").html('<label class="error">原始密码不正确</label>');
				    	  bValid=false&&bValid;
			          }
		         }
			 });

			if(bValid){
			    var url="modifiedUserKey.htm?userKey="+userkey.val()+"&newuserkey="+newuserkey.val()+"&CSRFToken=${token}";
				$.ajax({
			         type: 'post',
			         url:url,
			         async:false,
			         success: function(data) {
			        	 if (data > 0){
			        		 $("#dalog-updatepass-sms").modal('hide');
			        		  showNoAlert('修改成功');
					      } else {
					          $("#dalog-updatepass-sms").modal('hide');
					          $("#mcode").val('');
					          showNoAlert('修改失败');
				          }
			         }
				 });
			}


	    }


	}




      //图片回调
      function saveChoooseImageHead(url,id) {
        if(typeof (url) != 'string') {
            url = url[0];
        }
        if(url.indexOf(',')!=-1){
            url=url.substring(0,url.indexOf(','));
        }

        $("#headImgs").attr("src",url);
        $("#photoImg1").val(url);

    }

    function subInfoForm(){
        if($("#InfoForm").valid()){
            $("#InfoForm").submit();
        }
    }




    var ckey = 'guide_step';
    var path = '/';
    $(document).ready(function() {
      $(".shop-guide-wrapper").hide();
      continueLastStep();
    });
    //根据cookie判断跳转的页面
    function continueLastStep(){
      var step = $.cookie(ckey);
      if(step==null||step=='0'){
        // 记录向导的步骤
        $.cookie(ckey, '0', { expires: 365, path: path });
        $("#step-0").show();
      }else{
        $("#step-"+step).show();
      }
    }
    // 跳转到某个步骤
    function nextStep(step){
      if(step=='1'){  //开始向导
         $.cookie('guideSidebar', null);
         $.cookie('closeAutoGuide', 'true', { expires: 1 });  //关闭自动弹出开店向导
         $("#guideSidebar").removeClass("hide-i");
      }
      // cookie值修改
      $.cookie(ckey, step, { expires: 365, path: path });
      $(".shop-guide-wrapper").hide();
      $("#step-"+step).show();
    }
    //完成
    function completeStep(){
      //隐藏向导侧栏
      $('#kdxd').modal('hide');
      nextStep('1');
    }
    //跳转到相应的页面
    function toSetPage(url){
      closeDialog();
      if(url!=null && url.indexOf("/store")==0){
        unfoldMenu(url, '2');
      }else{
        unfoldMenu(url, '1');
      }
    }

      function toB2c(furl, extended, cssTargetUrl,subUrl){
          unfoldMenu(furl, extended, cssTargetUrl,subUrl);
          closeDialog();
      }
    //点击“应用市场”，判断
    function appMarket() {
        $.ajax({
            url:'queryAppMarketKeyState.htm?CSRFToken=${token}',
            async:false,
            success:function(result) {
                if(result==-1) {
//                    showSimpleConfirmAlert("初次访问应用市场，需要获取秘钥，点击“确定”获取","goAppMarket()");
                    $("#appProtocalModal").modal("show");
                    return;
                }
                if(result==-2) {
                    showSimpleConfirmAlert("您的秘钥已过期，点击“确定”重新获取秘钥","goAppMarket()");
                    return;
                }
                window.location='app.htm?CSRFToken=${token}';
            }
        });
    }
    //应用市场协议中，点击“同意”，判断基本信息
    function goAppMarket() {
        $.ajax({
            url:'newgetLoginPatcha.htm?CSRFToken=${token}',
            success:function(data) {
                var tip = '请在系统→基本信息中填写您网站的';
                var errorName = '';
                if(data.bsetName=='') {
                    errorName += '名称、';
                }
                if(data.bsetAddress=='') {
                    errorName += '地址、';
                }
                if(data.bsetAdmin=='') {
                    errorName += '联系人、';
                }
                if(data.bsetPhone=='') {
                    errorName += '联系电话、';
                }
                if(data.bsetEmail=='') {
                    errorName += '联系邮箱、';
                }
                if(errorName!='') {
                    errorName = errorName.substr(0,errorName.lastIndexOf(''));
                    showSimpleConfirmAlert(errorName,'goBasicset()');
                    return;
                }
                window.location='app.htm?CSRFToken=${token}';
            }
        });
    }

    function goBasicset() {
        window.location = 'basicset.htm';
    }

    /**
     * 简单的确认框，返回true或false
     */
    function showSimpleConfirmAlert(tips,functionName) {
        $('#modalDialog').remove();
        var confirmDialog =
                '<div class="modal fade" id="modalDialog" tabindex="-1" role="dialog">'+
                '    <div class="modal-dialog">'+
                '        <div class="modal-content">'+
                '            <div class="modal-header">'+
                '                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>'+
                '               <h4 class="modal-title">确认提示</h4>'+
                '           </div>'+
                '           <div class="modal-body">'
                +tips+
                '           </div>'+
                '           <div class="modal-footer">'+
                '             <button type="button" class="btn btn-primary" onclick="'+functionName+'">确定</button>'+
                '               <button type="button" class="btn btn-default" data-dismiss="modal" onclick="$(\'#modalDialog\').modal(\'hide\');">取消</button>'+
                '           </div>'+
                '       </div>'+
                '   </div>'+
                '</div>';
        $(document.body).append(confirmDialog);
        $('#modalDialog').modal('show');
    }

    function goToLogin() {
        window.location.href = "${basePath}/login.htm";
    }

    </script>

