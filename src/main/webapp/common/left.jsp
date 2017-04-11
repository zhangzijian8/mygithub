<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8" isELIgnored="false"%>

<!--布局容器 -->
<div class="container">
			<div class="row clearfix">
        		<div class="col-xs-12 col-sm-12 col-md-2 col-lg-2" >
        			<h2>SL会员商城</h2>
        		</div>
        		<div class="col-xs-12 col-sm-12 col-md-10 col-lg-10" >
        			<ul class="nav nav-pills">
        				<li><a href="javascript:void(0);">你好【${sessionScope.userinfo.loginCode}】，角色：【系统管理员】</a></li>
					    <li><a href="common/welcome.jsp">【首页】<span class="badge">42</span></a></li>
					    <li><a href="uploadTest.jsp">【测试文件上传】</a></li>
					    <li><a href="testJqueryAjax.jsp">【测试级联】<span class="badge">3</span></a></li>
					    <li><a href="testtable.jsp">【测试table】</a></li>
					    <li><a href="loginout.action">【注销】</a></li>
					</ul>
        		</div>
        	</div>
    
    <div class="row">
        	<!-- 左边导航菜单-->
            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2 ">
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default" >
                        <div class="panel-heading" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                            <h4 class="panel-title">
                                <a >
                                    <span class="glyphicon glyphicon-play-circle"></span>
                                    <span>后台管理</span>
                                </a>
                            </h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse in">
                            <div class="panel-body">
                                <ul>
                                    <li><a href="admin/userManager.jsp">用户管理</a></li>
                                    <li><a href="admin/juese.jsp">角色管理</a></li>
                                    <li><a href="admin/quanxian.jsp">权限管理</a></li>
                                    <li><a href="admin/goodsManagement.jsp">商品管理</a></li>
                                    <li><a href="admin/goodsPackage.jsp">商品套餐管理</a></li>
                                    <li><a href="admin/Basic information.jsp">基础信息</a></li>
                                    <li><a href="admin/data dictionary.jsp">数据字典</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                            <h4 class="panel-title">
                                <a >
                                    <span class="glyphicon glyphicon-play-circle"></span>
                                    <span>会员管理</span>
                                </a>
                            </h4>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse">
                            <div class="panel-body">
                                <ul>
                                    <li><a href="vip/vipRegister.jsp">注册新会员</a></li>
                                    <li><a href="vip/vipManage.jsp">新会员管理</a></li>
                                    <li><a href="vip/updateMyInfo.jsp">修改本人资料</a></li>
                                    <li><a href="vip/vipPassword.jsp">修改本人密码</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                            <h4 class="panel-title">
                                <a >
                                    <span class="glyphicon glyphicon-play-circle"></span>
                                    <span>电子银行</span>
                                </a></h4>
                        </div>
                        <div id="collapseThree" class="panel-collapse collapse">
                            <div class="panel-body">
                                <ul>
                                    <li><a href="bank/transfer.jsp">汇款充值</a></li>
                                    <li><a href="bank/basicAccount.jsp">基本账户</a></li>
                                    <li><a href="bank/consumerAccount.jsp">消费账户</a></li>
                                    <li><a href="bank/internalTransfer.jsp">内部转账</a></li>
                                    <li><a href="bank/applyForCash.jsp">申请提现</a></li>
                                    <li><a href="bank/cashInfo.jsp">提现明细</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
                            <h4 class="panel-title">
                                <a >
                                    <span class="glyphicon glyphicon-play-circle"></span>
                                    <span>购物管理</span></a></h4>
                        </div>
                        <div id="collapseFour" class="panel-collapse collapse">
                            <div class="panel-body">
                                <ul>
                                    <li><a href="shop/purchaseOrder.jsp" style="color: black">报单购货</a></li>
                                    <li><a href="shop/confirmactivation.jsp" >确认激活</a></li>
                                    <li><a href="shop/rePurchase.jsp" style="color: black">重消购货</a></li>
                                    <li><a href="shop/purchaseAssistant.jsp" style="color: black">辅消购货</a></li>
                                    <li><a href="shop/purchaseManagement.jsp" style="color: black">购货管理</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" data-toggle="collapse" data-parent="#accordion" href="#collapseFive">
                            <h4 class="panel-title">
                                <a >
                                    <span class="glyphicon glyphicon-play-circle"></span>
                                    <span>信息查询</span></a></h4>
                        </div>
                        <div id="collapseFive" class="panel-collapse collapse">
                            <div class="panel-body">
                                <ul>
                                    <li><a href="information/rewardQuery.jsp" style="color: black">奖励查询</a></li>
                                    <li><a href="information/recommendationQuery.jsp" style="color: black">推荐查询</a></li>
                                    <li><a href="information/areaQuery.jsp" >区域查询</a></li>
                                    <li><a href="information/operatingInstruction.jsp" style="color: black">操作须知</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" data-toggle="collapse" data-parent="#accordion" href="#collapseSix">
                            <h4 class="panel-title">
                                <a >
                                    <span class="glyphicon glyphicon-play-circle"></span>
                                    <span>资讯管理</span></a></h4>
                        </div>
                        <div id="collapseSix" class="panel-collapse collapse">
                            <div class="panel-body">
                                <ul>
                                    <li><a href="message/publicInfo.jsp">公告管理</a></li>
                                    <li><a href="message/message2.jsp">资讯管理</a></li>
                                    <li><a href="message/dowloadcenter1.jsp">下载中心</a></li>
                                    <li><a href="message/mainDemo.jsp">留言管理</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 右边主体内容-->
            