<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<div class="login-box-body">
	<p class="login-box-msg">Sign in to start your session</p>
	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>
	<form name='loginForm' action="direct-outlet" method='POST'>
		<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />
		<div class="form-group has-feedback">
			<select id="outletId" name="outletId">
				<option value="">= Pilih Outlet =</option>
				<c:forEach var="outlet" items="${outletList}">
					<option value="${outlet.id}"> ${outlet.name} </option>
				</c:forEach>
			</select>
		</div>
		<div class="row">
			<!-- /.col -->
			<div class="col-xs-offset-8 col-xs-4">
				<button type="submit" class="btn btn-primary btn-block btn-flat">Select Outlet</button>
			</div>
			<!-- /.col -->
		</div>
		
	</form>

</div>
<!-- /.login-box-body -->