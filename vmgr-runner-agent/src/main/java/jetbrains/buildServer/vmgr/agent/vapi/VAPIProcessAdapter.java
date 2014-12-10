package jetbrains.buildServer.vmgr.agent.vapi;

import java.io.File;
import java.util.List;

import jetbrains.buildServer.RunBuildException;
import jetbrains.buildServer.agent.BuildRunnerContext;
import jetbrains.buildServer.agent.impl.artifacts.ArtifactsCollection;
import jetbrains.buildServer.util.StringUtil;
import jetbrains.buildServer.vmgr.agent.SyncBuildProcessAdapter;
import jetbrains.buildServer.vmgr.agent.Utils;
import jetbrains.buildServer.vmgr.common.PluginParams;
import jetbrains.buildServer.vmgr.common.VMGRRunnerConstants;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Tal Yanai
 * Date: 7/12/14
 */


public class VAPIProcessAdapter extends SyncBuildProcessAdapter {

   


    private PluginParams myPluginParams;
    private String checkoutDir;
    private String buildId;

    public VAPIProcessAdapter(@NotNull final BuildRunnerContext context,
                             @NotNull final List<ArtifactsCollection> artifactsCollections,
                             @NotNull final PluginParams pluginParams) {
        super(context.getBuild().getBuildLogger());
       
        myPluginParams = pluginParams;
        checkoutDir = context.getBuild().getCheckoutDirectory()
				.getAbsolutePath();
        buildId = context.getBuild().getBuildId() + "";
       

    }

    @Override
    public void runProcess() throws RunBuildException {
        
        try {
        	
        	myLogger.message("Listing the runner parameters:");
        	myLogger.message(myPluginParams.toString());
        	 myLogger.message("Build working directory: " + checkoutDir);
     		myLogger.message("Build id: " + buildId);
     		myLogger.message("Dynamic input and out will be placed into: "
     				+ checkoutDir + File.separator + buildId);
        	
        	
        
    			Utils utils = new Utils();
    			// Get the jSON query string
    			String jSonInput = null;

    			if (myPluginParams.VAPI_TYPE.equals(VMGRRunnerConstants.STATIC_VAPI_TYPE)) {
    				myLogger.message("The vAPI query string input chosen is static. jSON input is: '" + myPluginParams.VAPI_STATIC_INPUT + "'");
    				jSonInput = myPluginParams.VAPI_STATIC_INPUT;
    				if (jSonInput == null ) jSonInput = "";
    			} else {
    				if (myPluginParams.DYNAMIC_VAPI_FILE_NAME == null || myPluginParams.DYNAMIC_VAPI_FILE_NAME.trim().equals("")) {
    					myLogger.message("The vAPI query string chosen is dynamic. jSON input file dynamic workspace directory: '" + checkoutDir + "'");
    				} else {
    					myLogger.message(
    							"The vAPI query string chosen is dynamic. jSON input file dynamic target: '" + myPluginParams.DYNAMIC_VAPI_FILE_NAME + "'");
    				}
    				jSonInput = utils.loadJSONFromFile(buildId,  checkoutDir, myPluginParams.DYNAMIC_VAPI_FILE_NAME, myLogger, false);

    			}

    			// Now call the actual launch
    			// ----------------------------------------------------------------------------------------------------------------
    			boolean dynamicUser = false;
    			if ("true".equals(myPluginParams.DYNAMIC_USER)) {
    				dynamicUser = true;
    			}

    			boolean authRequired = false;
    			if (myPluginParams.AUTH_REQUIRED
    					.equals(VMGRRunnerConstants.AUTH_REQUIRED_YES)) {
    				authRequired = true;
    			}
    			
    			String output = utils.executeAPI(jSonInput, myPluginParams.VAPI_URL, myPluginParams.PARAM_TARGET_URL, authRequired, myPluginParams.PARAM_USERNAME, myPluginParams.PARAM_PLAIN_PASSWORD,myPluginParams.VAPI_REQUEST_METHOD, myLogger, dynamicUser, buildId, checkoutDir);
    			if (!"success".equals(output)) {
    				myLogger.message(output);
    				throw new Exception(output);
    			}
    			// ----------------------------------------------------------------------------------------------------------------

    		

        	
        	
        	
        	myLogger.message("Finished success"); 
        } catch (Exception e) {
        	myLogger.buildFailureDescription(e.getMessage());
        	myLogger.logTestFailed("Failed to call vAPI for build " + buildId, e);
        	myLogger.message("Failed to call vAPI for build " + buildId);
            throw new RunBuildException(e);
        } finally {
            
        }
    }

    
}
