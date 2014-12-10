package jetbrains.buildServer.vmgr.agent.base;

import jetbrains.buildServer.agent.AgentBuildRunnerInfo;
import jetbrains.buildServer.agent.BuildAgentConfiguration;
import jetbrains.buildServer.vmgr.common.VMGRRunnerConstants;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Tal Yanai
 * Date: 7/12/14
 */

class VMGRvAPIRunnerInfo implements AgentBuildRunnerInfo {
    @NotNull
    @Override
    public String getType() {
        return VMGRRunnerConstants.VMGR_VAPI_RUN_TYPE;
    }

    @Override
    public boolean canRun(@NotNull BuildAgentConfiguration agentConfiguration) {
        return true;
    }
}
