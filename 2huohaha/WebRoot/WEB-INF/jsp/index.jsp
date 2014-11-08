<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="header.jsp" flush="true" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pages" uri="/WEB-INF/pages.tld" %>


<div class="container-fluid hero-unit_div" >
  <div class="row-fluid">
	    <div class="span8">
	    	<c:forEach items="${LIST}" var="joke">
	    		<div class="row">
			    		<div class="span12 hero-unit_div" style="background:white">
			    			<c:if test="${joke.title!=null}">
								<B><c:out value="${joke.title}"></c:out></B><BR/><BR/>
							</c:if>
							<c:out value="${joke.content}" escapeXml="false"></c:out>
							<br/>
							<br/>
							<div>
								<ul style="display:inline;margin-left:0px">
									<li style="display:inline;">
										<a class="btn btn-small" href="javascript:good(${joke.id})">
											<i class="icon-thumbs-up"></i>
											<span id="good${joke.id}">${joke.good}</span>顶
										</a>
									</li>
									<li style="display:inline;margin-left:20px">
										<a class="btn btn-small" href="javascript:bad(${joke.id})"><i class="icon-thumbs-down" ></i><span id="bad${joke.id}">${joke.bad}</span>踩</a>
									</li>
								</ul>
							</div>
						</div>
				</div>	
			</c:forEach>
			
			<div class="row">
	    		<div class="pagination" style="height:0">
		    		<c:if test="${pager!=null}">
						<pages:pager pager="${pager}" urlend="" urlstart="${url}?curpager="></pages:pager>
					</c:if>
				</div>
			</div>
			
	    </div>
	    <div class="span4">
	    	<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
				<!-- 两侧摩天大楼 -->
				<ins class="adsbygoogle"
				     style="display:inline-block;width:120px;height:600px"
				     data-ad-client="ca-pub-5079052844587731"
				     data-ad-slot="6878090363"></ins>
				<script>
				(adsbygoogle = window.adsbygoogle || []).push({});
			</script>
		</div>
  </div>
  
</div>

<jsp:include page="footer.jsp" flush="true" /> 