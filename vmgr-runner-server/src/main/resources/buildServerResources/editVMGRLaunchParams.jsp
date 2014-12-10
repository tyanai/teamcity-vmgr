<%@ page import="jetbrains.buildServer.vmgr.common.VMGRRunnerConstants" %>
<%@ taglib prefix="props" tagdir="/WEB-INF/tags/props" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forms" tagdir="/WEB-INF/tags/forms" %>
<%@ taglib prefix="bs" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="runnerConst" scope="request" class="jetbrains.buildServer.vmgr.common.VMGRRunnerConstants"/>

<l:settingsGroup title="vManager Server Target">
    <tr>
        <th><label for="jetbrains.buildServer.vmgr.targetUrl">vManager Server API Url: <l:star/></label></th>
        <td><props:textProperty name="<%=VMGRRunnerConstants.PARAM_TARGET_URL%>"  className="longField" maxlength="256"/>
            <span class="smallNote">Enter vManager server url in form https://[VMANAGER_HOST:PORT]/vmgr/vapi</span><span class="error" id="error_jetbrains.buildServer.vmgr.targetUrl"></span>
        </td>
    </tr>

   
</l:settingsGroup>


<%@include file="vmgrAuth.jspf" %>
<%@include file="vsifType.jspf" %>


