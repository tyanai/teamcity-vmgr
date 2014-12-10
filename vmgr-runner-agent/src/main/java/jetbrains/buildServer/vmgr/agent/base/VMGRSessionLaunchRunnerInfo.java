package jetbrains.buildServer.vmgr.agent.base;

import jetbrains.buildServer.agent.AgentBuildRunnerInfo;
import jetbrains.buildServer.agent.BuildAgentConfiguration;
import jetbrains.buildServer.vmgr.common.VMGRRunnerConstants;

import org.jetbrains.annotations.NotNull;

/**
* Created by Kit
* Date: 24.03.12 - 17:31
*/
class VMGRSessionLaunchRunnerInfo implements AgentBuildRunnerInfo {
    @NotNull
    @Override
    public String getType() {
        return VMGRRunnerConstants.VMGR_SESSION_LAUNCH_RUN_TYPE;
    }

    @Override
    public boolean canRun(@NotNull BuildAgentConfiguration agentConfiguration) {
        return true;
    }
}
