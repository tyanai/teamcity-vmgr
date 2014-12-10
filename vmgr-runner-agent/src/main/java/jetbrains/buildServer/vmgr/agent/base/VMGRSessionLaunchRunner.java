package jetbrains.buildServer.vmgr.agent.base;

import jetbrains.buildServer.ExtensionHolder;
import jetbrains.buildServer.RunBuildException;
import jetbrains.buildServer.agent.AgentBuildRunnerInfo;
import jetbrains.buildServer.agent.BuildProcess;
import jetbrains.buildServer.agent.BuildRunnerContext;
import jetbrains.buildServer.agent.InternalPropertiesHolder;
import jetbrains.buildServer.agent.impl.artifacts.ArtifactsCollection;
import jetbrains.buildServer.vmgr.agent.launch.SessionLaunchProcessAdapter;
import jetbrains.buildServer.vmgr.common.PluginParams;


import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by Tal Yanai
 * Date: 7/12/14
 */

public class VMGRSessionLaunchRunner extends BaseVMGRRunner {


    @NotNull
    private final InternalPropertiesHolder myInternalProperties;

    public VMGRSessionLaunchRunner(@NotNull final ExtensionHolder extensionHolder,
                             @NotNull final InternalPropertiesHolder holder) {
        super(extensionHolder);
        myInternalProperties = holder;
    }

    @Override
    protected BuildProcess getDeployerProcess(@NotNull final BuildRunnerContext context,
                                              @NotNull final String username,
                                              @NotNull final String password,
                                              @NotNull final String target,
                                              @NotNull final List<ArtifactsCollection> artifactsCollections) throws RunBuildException {

        
    	PluginParams pluginParams = new PluginParams(context.getRunnerParameters());
    	
    	
    	
        return new SessionLaunchProcessAdapter(context, artifactsCollections, pluginParams);
        
       
    }

    @NotNull
    @Override
    public AgentBuildRunnerInfo getRunnerInfo() {
        return new VMGRSessionLaunchRunnerInfo();
    }


}
