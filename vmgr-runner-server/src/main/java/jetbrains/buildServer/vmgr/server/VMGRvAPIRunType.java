package jetbrains.buildServer.vmgr.server;

import com.intellij.openapi.util.text.StringUtil;

import jetbrains.buildServer.serverSide.PropertiesProcessor;
import jetbrains.buildServer.serverSide.RunType;
import jetbrains.buildServer.serverSide.RunTypeRegistry;
import jetbrains.buildServer.vmgr.common.VMGRRunnerConstants;
import jetbrains.buildServer.web.openapi.PluginDescriptor;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
/**
* Created by Tal.Yanai
* date: 07.12.14.
*/
public class VMGRvAPIRunType extends RunType {

    private final PluginDescriptor myDescriptor;

    public VMGRvAPIRunType(@NotNull final RunTypeRegistry registry,
                              @NotNull final PluginDescriptor descriptor) {
        myDescriptor = descriptor;
        registry.registerRunType(this);
    }

    @NotNull
    @Override
    public String getType() {
        return VMGRRunnerConstants.VMGR_VAPI_RUN_TYPE;
    }

    @Override
    public String getDisplayName() {
        return "Cadence vManager vAPI";
    }

    @Override
    public String getDescription() {
        return " Adds an ability to call Cadence vManager vAPI REST API dynamically as a step in your build.";
    }

    @Override
    public PropertiesProcessor getRunnerPropertiesProcessor() {
        return new VMGRvAPIPropertiesProcessor();
    }

    @Override
    public String getEditRunnerParamsJspFilePath() {
        return myDescriptor.getPluginResourcesPath() + "editVMGRvAPIParams.jsp";
    }

    @Override
    public String getViewRunnerParamsJspFilePath() {
        return  myDescriptor.getPluginResourcesPath() + "viewVMGRvAPIParams.jsp";
    }

    @Override
    public Map<String, String> getDefaultRunnerProperties() {
        return new HashMap<String, String>();
    }

    @NotNull
    @Override
    public String describeParameters(@NotNull Map<String, String> parameters) {
        StringBuilder sb = new StringBuilder();
        sb.append("Target: ").append(parameters.get(VMGRRunnerConstants.PARAM_TARGET_URL));
        
        if (VMGRRunnerConstants.AUTH_REQUIRED_YES.equals(parameters.get(VMGRRunnerConstants.AUTH_REQUIRED))) {
            sb.append('\n').append(" Athentication: ").append("Required");
        } else {
        	sb.append('\n').append(" Athentication: ").append("Not required");
        }
        
        if (VMGRRunnerConstants.DYNAMIC_VAPI_TYPE.equals(parameters.get(VMGRRunnerConstants.VAPI_TYPE))) {
            sb.append('\n').append(" Type of API: ").append("Dynamic");
        } else {
        	sb.append('\n').append(" Type of API: ").append("Static");
        }
        return sb.toString();
    }

}
