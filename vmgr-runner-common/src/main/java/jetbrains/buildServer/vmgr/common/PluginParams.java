package jetbrains.buildServer.vmgr.common;

import java.util.Map;

/**
 * Created by Tal Yanai
 * Date: 7/12/14
 */

public class PluginParams {
	
	public  String PARAM_USERNAME = null;
    public  String PARAM_PLAIN_PASSWORD = null;
   
    public  String PARAM_TARGET_URL = null;
    public  String DYNAMIC_USER = null;
    
    public  String VAPI_REQUEST_METHOD = null;
   
    
        
    public  String AUTH_REQUIRED = null;
       
    //VSIF
    public  String VSIF_TYPE= null;
    public  String STATIC_VSIF_FILE_NAME = null;
    public  String DYNAMIC_VSIF_FILE_NAME = null;
    
    //VAPI
    public  String VAPI_STATIC_INPUT = null;
    public  String VAPI_TYPE = null;
    public  String DYNAMIC_VAPI_FILE_NAME = null;
    public  String VAPI_URL = null;
    
    public PluginParams(Map<String,String> input){
    	
    	PARAM_TARGET_URL = input.get(VMGRRunnerConstants.PARAM_TARGET_URL);
    	PARAM_USERNAME = input.get(VMGRRunnerConstants.PARAM_USERNAME);
    	PARAM_PLAIN_PASSWORD = input.get(VMGRRunnerConstants.PARAM_PLAIN_PASSWORD);
    	DYNAMIC_USER = input.get(VMGRRunnerConstants.DYNAMIC_USER);
    	VAPI_REQUEST_METHOD = input.get(VMGRRunnerConstants.VAPI_REQUEST_METHOD);
    	AUTH_REQUIRED = input.get(VMGRRunnerConstants.AUTH_REQUIRED);
    	VSIF_TYPE = input.get(VMGRRunnerConstants.VSIF_TYPE);
    	STATIC_VSIF_FILE_NAME = input.get(VMGRRunnerConstants.STATIC_VSIF_FILE_NAME);
    	DYNAMIC_VSIF_FILE_NAME = input.get(VMGRRunnerConstants.DYNAMIC_VSIF_FILE_NAME);
    	VAPI_TYPE = input.get(VMGRRunnerConstants.VAPI_TYPE);
    	VAPI_STATIC_INPUT = input.get(VMGRRunnerConstants.VAPI_STATIC_INPUT);
    	DYNAMIC_VAPI_FILE_NAME = input.get(VMGRRunnerConstants.DYNAMIC_VAPI_FILE_NAME);
    	VAPI_URL = input.get(VMGRRunnerConstants.VAPI_URL);
    	    	
    	
    }
    
    public String toString(){
    	
    	String output = "";
    	output = output + "vManager Server URL: " + PARAM_TARGET_URL + "\n";
    	output = output + "Is auth required: " + AUTH_REQUIRED + "\n";
    	output = output + "User name: " + PARAM_USERNAME + "\n";
    	output = output + "Passworde: ******** \n";
    	output = output + "User Dynamic: " + DYNAMIC_USER + "\n";
    	output = output + "VSIF Type: " + VSIF_TYPE + "\n";
    	output = output + "Static VSIF file: " + STATIC_VSIF_FILE_NAME + "\n";
    	output = output + "Dynamic VSIF file: " + DYNAMIC_VSIF_FILE_NAME + "\n";
    	output = output + "VAPI Type: " + VAPI_TYPE + "\n";
    	output = output + "Static VAPI Input: " + VAPI_STATIC_INPUT + "\n";
    	output = output + "Dynamic VAPI file input: " + DYNAMIC_VAPI_FILE_NAME + "\n";
    	output = output + "VAPI request method: " + VAPI_REQUEST_METHOD + "\n";
    	output = output + "VAPI URL: " + VAPI_URL + "\n";
    	
    	return output;
    }

}
