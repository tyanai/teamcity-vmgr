package jetbrains.buildServer.vmgr.common;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Tal Yanai
 * Date: 7/12/14
 */

public class VMGRRunnerConstants {

    public static final String VMGR_SESSION_LAUNCH_RUN_TYPE = "vmgr-session-launch-runner";
    public static final String VMGR_VAPI_RUN_TYPE = "vmgr-vapi-runner";

    public static final String PARAM_USERNAME = "jetbrains.buildServer.vmgr.username";
    public static final String PARAM_PLAIN_PASSWORD = "jetbrains.buildServer.vmgr.password";
   
    public static final String PARAM_TARGET_URL = "jetbrains.buildServer.vmgr.targetUrl";
    public static final String DYNAMIC_USER = "jetbrains.buildServer.vmgr.dynamic.user";
    

    public static final String VAPI_REQUEST_METHOD = "jetbrains.buildServer.vmgr.vapi.request.method";
    public static final String VAPI_REQUEST_METHOD_POST = "POST";
    public static final String VAPI_REQUEST_METHOD_GET = "GET";
    public static final String VAPI_REQUEST_METHOD_DELETE = "DELETE";
    public static final String VAPI_REQUEST_METHOD_PUT = "PUT";
    
        
    public static final String AUTH_REQUIRED = "jetbrains.buildServer.vmgr.authRequired";
    public static final String AUTH_REQUIRED_NO = "NOT_REQUIRED";
    public static final String AUTH_REQUIRED_YES = "REQUIRED";
    
    //VSIF
    public static final String VSIF_TYPE = "jetbrains.buildServer.vmgr.vsifType";
    public static final String DYNAMIC_VSIF_TYPE = "DYNAMIC_VSIF";
    public static final String STATIC_VSIF_TYPE = "STATIC_VSIF";
    public static final String STATIC_VSIF_FILE_NAME = "jetbrains.buildServer.vmgr.vsif.static.filename";
    public static final String DYNAMIC_VSIF_FILE_NAME = "jetbrains.buildServer.vmgr.vsif.dynamic.filename";
    
    //VAPI
    public static final String VAPI_STATIC_INPUT = "jetbrains.buildServer.vmgr.api.input.static";
    public static final String VAPI_TYPE = "jetbrains.buildServer.vmgr.vapiType";
    public static final String DYNAMIC_VAPI_TYPE = "DYNAMIC_VAPI";
    public static final String STATIC_VAPI_TYPE = "STATIC_VAPI";
    public static final String DYNAMIC_VAPI_FILE_NAME = "jetbrains.buildServer.vmgr.vapi.dynamic.filename";
    public static final String VAPI_URL = "jetbrains.buildServer.vmgr.vapi.url.api";
    
    

    public String getVAPIRequestMethod() {
        return VAPI_REQUEST_METHOD;
    }
    
    

    public Map<String, String> getVapiRequestMethodValues() {
        final Map<String, String> result = new LinkedHashMap<String, String>();
        result.put(VAPI_REQUEST_METHOD_POST, "POST");
        result.put(VAPI_REQUEST_METHOD_GET, "GET");
        result.put(VAPI_REQUEST_METHOD_PUT, "PUT");
        result.put(VAPI_REQUEST_METHOD_DELETE, "DELETE");
        return result;
    }



}
