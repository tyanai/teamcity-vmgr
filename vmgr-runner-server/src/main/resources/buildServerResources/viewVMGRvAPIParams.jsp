<%@ page import="jetbrains.buildServer.vmgr.common.VMGRRunnerConstants" %>
<%@ taglib prefix="props" tagdir="/WEB-INF/tags/props" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="runnerConst" scope="request" class="jetbrains.buildServer.vmgr.common.VMGRRunnerConstants"/>
<jsp:useBean id="propertiesBean" scope="request" type="jetbrains.buildServer.controllers.BasePropertiesBean"/>

<div class="parameter">
  vManager Server Url:: <strong><props:displayValue name="<%=VMGRRunnerConstants.PARAM_TARGET_URL%>" emptyValue="default"/></strong>
</div>

<div class="parameter">
  Authentication: <strong><props:displayValue name="<%=VMGRRunnerConstants.AUTH_REQUIRED%>" emptyValue="default"/></strong>
</div>

<div class="parameter">
  Username: <strong><props:displayValue name="<%=VMGRRunnerConstants.PARAM_USERNAME%>" emptyValue="none"/></strong>
</div>
