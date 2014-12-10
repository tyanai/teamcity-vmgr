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

public class VMGRSessionLaunchRunType extends RunType {

    private final PluginDescriptor myDescriptor;

    public VMGRSessionLaunchRunType(@NotNull final RunTypeRegistry registry,
                              @NotNull final PluginDescriptor descriptor) {
        myDescriptor = descriptor;
        registry.registerRunType(this);
    }

    @NotNull
    @Override
    public String getType() {
        return VMGRRunnerConstants.VMGR_SESSION_LAUNCH_RUN_TYPE;
    }

    @Override
    public String getDisplayName() {
        return "Cadence vManager Launcher";
    }

    @Override
    public String getDescription() {
        return " Adds an ability to performe launch of vsif files dynamically as a step in your build, using Cadence vManager.";
    }

    @Override
    public PropertiesProcessor getRunnerPropertiesProcessor() {
        return new VMGRSessionLaunchPropertiesProcessor();
    }

    @Override
    public String getEditRunnerParamsJspFilePath() {
        return myDescriptor.getPluginResourcesPath() + "editVMGRLaunchParams.jsp";
    }

    @Override
    public String getViewRunnerParamsJspFilePath() {
        return  myDescriptor.getPluginResourcesPath() + "viewVMGRLaunchParams.jsp";
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
        
        if (VMGRRunnerConstants.DYNAMIC_VSIF_TYPE.equals(parameters.get(VMGRRunnerConstants.VSIF_TYPE))) {
            sb.append('\n').append(" Type of VSIF: ").append("Dynamic");
        } else {
        	sb.append('\n').append(" Type of VSIF: ").append("Static");
        }
        return sb.toString();
    }

}
